package webcrawler

var JobChan chan CrawlJob
var CrawlResultChannel chan string

type CrawlJob struct {
	URL string
}

func init() {
	JobChan = make(chan CrawlJob, 100000)
	CrawlResultChannel = make(chan string, 100000)
}
