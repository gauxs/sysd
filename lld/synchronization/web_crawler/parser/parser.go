package webcrawler

type HTMLParser struct{}

func NewHTMLParser() HTMLParser {
	return HTMLParser{}
}

func (p HTMLParser) Parse(url string) []string {
	// does http call
	return []string{""}
}
