# Problem

Given a url startUrl and an interface HtmlParser, implement a Multi-threaded web crawler to crawl all links that are under the same hostname as startUrl. Return all urls obtained by your web crawler in any order.

Your crawler should:

1. Start from the page: startUrl
2. Call HtmlParser.getUrls(url) to get all urls from a webpage of given url.
3. Do not crawl the same link twice.
4. Explore only the links that are under the same hostname as startUrl.

Complete Problem: https://leetcode.ca/all/1242.html
