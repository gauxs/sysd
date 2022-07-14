package webcrawler_test

import (
	"sync"
	webcrawler "sysd/lld/synchronization/web_crawler"
	crawl "sysd/lld/synchronization/web_crawler/crawl"
	dedup "sysd/lld/synchronization/web_crawler/dedup"
	parser "sysd/lld/synchronization/web_crawler/parser"
	"testing"
)

func TestWebCrawler(t *testing.T) {
	htmlParser := parser.HTMLParser{}
	crawlManager := crawl.NewCrawlerManager(100, 10000, htmlParser)
	dedupManager := dedup.NewDeduplicatorManager(100)

	var wtGrp sync.WaitGroup
	wtGrp.Add(2)
	crawlManager.Manage()
	dedupManager.Manage()

	webcrawler.JobChan <- webcrawler.CrawlJob{
		URL: "google.com",
	}

	wtGrp.Wait()
}
