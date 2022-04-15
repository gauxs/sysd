# System Design

Things i learned while reading about distributed programming[^1].

## Low Level Design

These are part of system design questions and requires actual implementation. Some learnings:

1. Never generate id's of entities which needs to be identified via console i.e. say userID, this is to have easier testcase generation.
2. A enitity will have its manager, both entity and its manager can be seen as one **microservice** along with its own **database** (internal datastructure in this case).
3. Always start with bruteforce algorithm first and attempt optimization ONLY when the code is running.

## High Level Design

High level design is also known as system design. System Design is the process of designing the architecture, components, and interfaces for a system so that it meets the end-user requirements. I have tried to document most common topics but there are more detailed resources available, some of which are:

1. [An awesome book by mikito takada on basics of system design](http://book.mixu.net/distsys/single-page.html)
2. [System Design Primer - A github repo on system design](https://github.com/donnemartin/system-design-primer)

[^1]: Distributed programming is the art of solving the same problem that you can solve on a single computer using multiple computers.
