# Ports
There are 65,536 ports. The ports from 0 to 1023 are considered **system ports** and are generally where you will find common services like DNS, SMTP and HTTP. Higher number ports are considered **dynamic** and will be assigned on an as needed basis (or are assigned by the program needing network services).

## Difference between socket and ports?
Both Socket and Port are the terms used in Transport Layer.
A port is a logical construct assigned to network processes so that they can be identified within the system. 
A socket is a combination of port and IP address.
An incoming packet has a port number which is used to identify the process that needs to consume the packet

# Transmission Control Protocol
The Transmission Control Protocol (TCP) is a transport protocol that is used on top of IP to ensure reliable transmission of packets. TCP includes mechanisms to solve many of the problems that arise from packet-based messaging, such as lost packets, out of order packets, duplicate packets, and corrupted packets. 

Since TCP is the protocol used most commonly on top of IP, the Internet protocol stack is sometimes referred to as TCP/IP. TCP guarantees the delivery of data and packets in the same order as they were sent. Either computer can close the connection when they no longer want to send or receive data.
Reference: Transmission Control Protocol (TCP) (article) 


## Hypertext Transfer Protocol
What is HTTP?
HTTP is unidirectional where the client sends the request and the server sends the response.
Let’s take an example when a user sends a request to the server this request goes in the form of HTTP or HTTPS, after receiving a request server send the response to the client, each request is associated with a corresponding response, after sending the response the connection gets closed, each HTTP or HTTPS request establish the new connection to the server every time and after getting the response the connection gets terminated by itself. 
HTTP is stateless protocol runs on the top of TCP which is a connection-oriented protocol that guarantees the delivery of data packet transfer using the three-way handshaking methods and re-transmit the lost packets. 
HTTP can run on the top of any reliable connection-oriented protocol such as TCP, SCTP. 
When a client sends HTTP request to the server, a TCP connection is open between the client and server and after getting the response the TCP connection gets terminated, each HTTP request open separate TCP connection to the server, for e.g. if client send 10 requests to the server the 10 separate TCP connection will be opened. and get closed after getting the response/fallback. 
HTTP is a protocol which allows the fetching of resources, such as HTML documents.
Designed in the early 1990s, HTTP is an extensible protocol which has evolved over time.
It is an application layer protocol that is sent over TCP, or over a TLS-encrypted TCP connection, though any reliable transport protocol could theoretically be used.
Due to its extensibility, it is used to not only fetch hypertext documents, but also images and videos or to post content to servers, like with HTML form results.
Good article on http - An overview of HTTP - HTTP
HTTP RFC standard - rfc2616 
PUT Vs POST
PUT vs. POST 
MIME Types - rfc6838 
A media type (also known as a Multipurpose Internet Mail Extensions or MIME type) is a standard that indicates the nature and format of a document, file, or assortment of bytes. 
MIME types (IANA media types) - HTTP 
CORS
Cross-Origin Resource Sharing (CORS) is an HTTP-header based mechanism that allows a server to indicate any other origins (domain, scheme, or port) than its own from which a browser should permit loading of resources. 
CORS also relies on a mechanism by which browsers make a “preflight” request to the server hosting the cross-origin resource, in order to check that the server will permit the actual request.
In that preflight, the browser sends headers that indicate the HTTP method and headers that will be used in the actual request.
Reference - Cross-Origin Resource Sharing (CORS) - HTTP 
HTTP Cookies
An HTTP cookie (web cookie, browser cookie) is a small piece of data that a server sends to the user's web browser. The browser may store it and send it back with later requests to the same server. Typically, it's used to tell if two requests came from the same browser — keeping a user logged-in, for example. It remembers stateful information for the stateless HTTP protocol.
Cookie is just a http header, just like Authorization or Content-Type
used in session management, personalization, tracking
consists of name, value, and (optional) attributes / flags
set with Set-Cookie by server, appended with Cookie by browser
HTTP/1.1 200 OK
Content-type: text/html
Set-Cookie: SESS_ID=9vKnWqiZvuvVsIV1zmzJQeYUgINqXYeS; Domain=example.com; Path=/
Security
signed (HMAC) with a secret to mitigate tampering
rarely encrypted (AES) to protected from being read
no security concern if read by 3rd party
carries no meaningful data (random string)
even if encrypted, still a 1-1 match
encoded (URL) - not for security, but compat
Attributes
Domain and Path (can only be used on a given site & route)
Expiration (can only be used until expiry)
when omitted, becomes a session cookie
gets deleted when browser is closed
Flags
HttpOnly (cannot be read with JS on the client-side)
Secure (can only sent over encrypted HTTPS channel), and
SameSite (can only be sent from the same domain, i.e. no CORS sharing)
CSRF
unauthorized actions on behalf of the authenticated user
mitigated with a CSRF token (e.g. sent in a separate X-CSRF-TOKEN cookie) 

Read more at Using HTTP cookies - HTTP especially Define where cookies are sent  and Security part.


WebSockets
When a client sends HTTP request to the server, a TCP connection is open between the client and server and after getting the response the TCP connection gets terminated, each HTTP request open separate TCP connection to the server, this is non-optimal and thus websockets protocol can be used.
WebSocket is bidirectional, a full-duplex protocol that is used in the same scenario of client-server communication, unlike HTTP it starts from ws:// or wss://.
It is a stateful protocol, which means the connection between client and server will keep alive until it is terminated by either party (client or server). After closing the connection by either of the client and server, the connection is terminated from both ends.
The protocol consists of an opening handshake followed by basic message framing, layered over TCP. Thus websocket works on top of TCP and is comparable to HTTP.
Applications of websocket:
Real-time web application
Gaming application
Chat application

## References
- [Khanacademy - TCP](https://www.khanacademy.org/computing/computers-and-internet/xcae6f4a7ff015e7d:the-internet/xcae6f4a7ff015e7d:transporting-packets/a/transmission-control-protocol--tcp)
