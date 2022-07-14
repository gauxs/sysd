package webcrawler

import (
	webcrawler "sysd/lld/synchronization/web_crawler"
	store "sysd/lld/synchronization/web_crawler/store"
)

// Deduplicator
type Deduplicator struct {
	jobChan      chan webcrawler.CrawlJob
	dedupChannel chan struct{}
	dataStore    *store.DataStore
}

func NewDeduplicator(jobChan chan webcrawler.CrawlJob, dedupChannel chan struct{}, dataStore *store.DataStore) *Deduplicator {
	return &Deduplicator{
		jobChan:      jobChan,
		dedupChannel: dedupChannel,
		dataStore:    dataStore,
	}
}

func deduplicate(url string, jobChan chan webcrawler.CrawlJob, dedupChannel chan struct{}, dataStore *store.DataStore) {
	err := dataStore.SetElseError(url, "")
	if err == nil {
		jobChan <- webcrawler.CrawlJob{
			URL: url,
		}
	}

	<-dedupChannel
}

func (dd *Deduplicator) Deduplicate(url string) {
	go deduplicate(url, dd.jobChan, dd.dedupChannel, dd.dataStore)
}
