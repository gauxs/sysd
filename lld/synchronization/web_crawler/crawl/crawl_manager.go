package webcrawler

import (
	webcrawler "sysd/lld/synchronization/web_crawler"
	parser "sysd/lld/synchronization/web_crawler/parser"
)

// CrawlerManager
type CrawlerManager struct {
	// max number of crawler allowed
	numOfMaxCrawlers int
	// max number of crawl job
	numOfMaxCrawlJobs int
	// crawl job are fed into this channel
	crawlJobChannel chan webcrawler.CrawlJob
	// channel to bound number of crawler routines
	crawlerChannel chan struct{}
	// parser
	htmlParser parser.HTMLParser
}

func NewCrawlerManager(maxCrawlers int, maxCrawlJobs int, htmlParser parser.HTMLParser) CrawlerManager {
	return CrawlerManager{
		numOfMaxCrawlers:  maxCrawlers,
		numOfMaxCrawlJobs: maxCrawlJobs,
		crawlJobChannel:   make(chan webcrawler.CrawlJob, maxCrawlJobs),
		crawlerChannel:    make(chan struct{}, maxCrawlers),
		htmlParser:        htmlParser,
	}
}

func manage(crawlJobChannel chan webcrawler.CrawlJob, crawlerChannel chan struct{}, htmlParser parser.HTMLParser) {
	for {
		job := <-crawlJobChannel

		// blocks if crawler channel full
		crawlerChannel <- struct{}{}

		// create crawler and crawl
		crawler := NewCrawler(job, webcrawler.CrawlResultChannel, crawlerChannel)
		crawler.Crawl(htmlParser)
	}
}

func (cm CrawlerManager) Manage() {
	go manage(cm.crawlJobChannel, cm.crawlerChannel, cm.htmlParser)
}

// channel to push url to after parsing - push channel

// consolidator to read from push channel and de-duplicate and push to read channel
