# Replication
### Why replication?
The manner in which a data set is distributed between multiple nodes is very important. In order for any computation to happen, we need to locate the data and then act on it.

There are two basic techniques that can be applied to a data set. It can be split over multiple nodes (partitioning) to allow for more parallel processing. It can also be copied or cached on different nodes to reduce the distance between the client and the server and for greater fault tolerance (replication).

Caching is most common example of replication. Caching is used to leveage on following attribute of the system:
1. Hardware - storing replica on more performant hardware(e.g. RAM) improves latency.
2. Disance - storing replica near users(e.g. CDN) thus reducing distance improves latency.

### What is replication?
Replication is making copies of the same data on multiple machines; this allows more servers to take part in the computation. Replication - copying or reproducing something - is the primary way in which we can fight latency.

1. Replication improves performance by making additional computing power and bandwidth applicable to a new copy of the data
2. Replication improves availability by creating additional copies of the data, increasing the number of nodes that need to fail before availability is sacrificed

Replication is about providing extra bandwidth, and caching where it counts. It is also about maintaining consistency in some way according to some consistency model.

Replication allows us to achieve scalability, performance and fault tolerance. Afraid of loss of availability or reduced performance? Replicate the data to avoid a bottleneck or single point of failure. Slow computation? Replicate the computation on multiple systems. Slow I/O? Replicate the data to a local cache to reduce latency or onto multiple machines to increase throughput.

Replication is also the source of many of the problems, since there are now independent copies of the data that has to be kept in sync on multiple machines - this means ensuring that the replication follows a consistency model.

The choice of a consistency model is crucial: a good consistency model provides clean semantics for programmers (in other words, the properties it guarantees are easy to reason about) and meets business/design goals such as high availability or strong consistency.

Only one consistency model for replication - strong consistency - allows you to program as-if the underlying data was not replicated. Other consistency models expose some internals of the replication to the programmer. However, weaker consistency models can provide lower latency and higher availability - and are not necessarily harder to understand, just different.

## Reference
1. [Awesome book on basics of system design](http://book.mixu.net/distsys/single-page.html)
