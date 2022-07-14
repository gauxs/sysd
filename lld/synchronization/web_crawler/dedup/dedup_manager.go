package webcrawler

import (
	webcrawler "sysd/lld/synchronization/web_crawler"
	store "sysd/lld/synchronization/web_crawler/store"
)

type DeduplicatorManager struct {
	maxDeduplicator int
	dataStore       *store.DataStore
	dedupChannel    chan struct{}
}

func NewDeduplicatorManager(maxDeduplicator int) *DeduplicatorManager {
	return &DeduplicatorManager{
		maxDeduplicator: maxDeduplicator,
		dataStore:       store.NewDataStore(),
		dedupChannel:    make(chan struct{}, maxDeduplicator),
	}
}

func manage(dedupChannel chan struct{}, dataStore *store.DataStore) {
	for {
		url := <-webcrawler.CrawlResultChannel

		// blocks if dedup channel full
		dedupChannel <- struct{}{}

		// create crawler and crawl
		deduplicator := NewDeduplicator(webcrawler.JobChan, dedupChannel, dataStore)
		deduplicator.Deduplicate(url)
	}
}

func (dm *DeduplicatorManager) Manage() {
	go manage(dm.dedupChannel, dm.dataStore)
}
