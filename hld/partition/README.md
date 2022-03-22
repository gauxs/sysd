# Partition
### Why partition?
The manner in which a data set is distributed between multiple nodes is very important. In order for any computation to happen, we need to locate the data and then act on it.

There are two basic techniques that can be applied to a data set. It can be split over multiple nodes (partitioning) to allow for more parallel processing. It can also be copied or cached on different nodes to reduce the distance between the client and the server and for greater fault tolerance (replication).

<img src="https://github.com/gauxs/sysd/blob/master/media/image/part-repl.png?raw=true" width="600" height="400">

## Reference
1. [Awesome book on basics of system design](http://book.mixu.net/distsys/single-page.html)
