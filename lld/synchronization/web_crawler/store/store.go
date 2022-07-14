package webcrawler

import (
	"errors"
	"sync"
)

func NewDataStore() *DataStore {
	return &DataStore{
		data: make(map[string]string),
	}
}

type DataStore struct {
	lock sync.RWMutex
	data map[string]string
}

func (ds *DataStore) Set(key string, value string) {
	defer ds.lock.Unlock()

	ds.lock.Lock()
	ds.data[key] = value
}

func (ds *DataStore) SetElseError(key string, value string) error {
	defer ds.lock.Unlock()

	var ok bool
	ds.lock.Lock()
	if _, ok = ds.data[key]; ok {
		return errors.New("value already present")
	}
	ds.data[key] = value

	return nil
}

func (ds *DataStore) Get(key string) (string, error) {
	defer ds.lock.RUnlock()

	var ok bool
	var value string
	ds.lock.RLock()
	if value, ok = ds.data[key]; !ok {
		return "", errors.New("no value")
	}

	return value, nil
}
