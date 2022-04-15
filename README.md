# System Design

Things i learned while reading about distributed programming[^1].

## Low Level Design

Each component of a system can be a design challenge in itself. Design questions on these component can be vaguly categorized under LLD. Skeleton code of some of these LLD designs can be implemented in a reasonable amount of time and are often asked in interviews. I have documented my approach of solving various LLD design along with the problem statement, do try it out.

Following are some of the learnings for LLD design questions:

1. Never generate id's of entities instead ask user to provide them via console i.e. userID, this is to have easier testcase generation.
2. An entity will have its manager, both entity and its manager can be seen as one **microservice** along with its own **database** (internal datastructure of the entity class in this case).
3. Always start with bruteforce algorithm first and attempt optimization ONLY after the code is giving expected result.

## High Level Design

High level design is also known as system design. System Design is the process of designing the architecture, components, and interfaces for a system so that it meets the end-user requirements. I have tried to document most common topics but there are more detailed resources available, some of which are:

1. [An awesome book by mikito takada on basics of system design](http://book.mixu.net/distsys/single-page.html)
2. [System Design Primer - A github repo on system design](https://github.com/donnemartin/system-design-primer)
3. [Highscalability](http://highscalability.com/)
4. [Amazon builders library](https://aws.amazon.com/builders-library/?cards-body.sort-by=item.additionalFields.sortDate&cards-body.sort-order=desc&awsf.filter-content-category=*all&awsf.filter-content-type=*all&awsf.filter-content-level=*all) and [AWS architecture center](https://aws.amazon.com/architecture/?intClick=dev-center-2021_main)
5. [Handwritten notes on system design](https://github.com/gauxs/sysd/blob/master/resource/system_design_basics_handbook.pdf)

**Note**: [Grokking the System Design Interview](https://www.educative.io/courses/grokking-the-system-design-interview) by educative is also good, its a paid course though. I have also heard there is a free PDF of this course available on internet :smirk:.

[^1]: Distributed programming is the art of solving the same problem that you can solve on a single computer using multiple computers.
