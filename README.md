# System Design

Information i gathered while learning system(high level) and low level designing.

## Low Level Design

These are part of system design questions and requires actual implementation. Some learnings:

1. Never generate id's of entities which needs to be identified via console i.e. say userID, this is to have easier testcase generation.
2. A enitity will have its manager, both entity and its manager can be seen as one **microservice** along with its ow **database** (internal datastructure in this case).
3. Always start with bruteforce algorithm first and attempt optimization ONLY when the code is running.

## High Level Design

These are sysem design. References:

1. [An awesome book](http://book.mixu.net/distsys/single-page.html)
2. [System Design Primer](https://github.com/donnemartin/system-design-primer)
