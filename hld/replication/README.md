# Replication
### Why replication?
The manner in which a data set is distributed between multiple nodes is very important. In order for any computation to happen, we need to locate the data and then act on it.

There are two basic techniques that can be applied to a data set. It can be split over multiple nodes (partitioning) to allow for more parallel processing. It can also be copied or cached on different nodes to reduce the distance between the client and the server and for greater fault tolerance (replication).

Caching is most common example of replication. Caching is used to leveage on following attribute of the system:
1. Hardware - storing replica on more performant hardware(e.g. RAM) improves latency.
2. Disance - storing replica near users(e.g. CDN) thus reducing distance improves latency.

## Reference
1. [Awesome book on basics of system design](http://book.mixu.net/distsys/single-page.html)
