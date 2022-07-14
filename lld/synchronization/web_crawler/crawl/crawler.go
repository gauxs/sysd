package webcrawler

import (
	webcrawler "sysd/lld/synchronization/web_crawler"
	parser "sysd/lld/synchronization/web_crawler/parser"
)

/*
	crawls the specified url
	returns the extracted urls on the reply channel
*/
type Crawler struct {
	job        webcrawler.CrawlJob
	result     chan string
	maxCrawler chan struct{}
}

func NewCrawler(job webcrawler.CrawlJob, result chan string, maxCrawler chan struct{}) Crawler {
	return Crawler{
		job:        job,
		result:     result,
		maxCrawler: maxCrawler,
	}
}

func crawl(url string, parser parser.HTMLParser, result chan string, maxCrawler chan struct{}) {
	// parse HTML
	newURLs := parser.Parse(url)

	// send the extracted URL to be processed
	for _, extractedURL := range newURLs {
		result <- extractedURL
	}

	<-maxCrawler
}

func (c Crawler) Crawl(parser parser.HTMLParser) {
	go crawl(c.job.URL, parser, c.result, c.maxCrawler)
}
