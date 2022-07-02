# System Design

Things i learned while reading about distributed programming[^1].

## Checklist
- [ ] OOPs concepts (SOLID priciples)
- [ ] Operating system concepts (multithreading, concurrency and deadlock)
- [ ] Networking concepts (Layers and their internals)
- [ ] Actual implementation of concurrency based LLD questions like Dining philosopher

## Low Level Design

Each component of a system can be a design challenge in itself. Design questions on these component can be vaguly categorized under LLD. Skeleton code of some of these LLD designs can be implemented in a reasonable amount of time and are often asked in interviews. I have documented my approach of solving various LLD design along with the problem statement, do try it out.

Following are some of the learnings for LLD design questions:

1. Never generate id's of entities instead ask user to provide them via console i.e. userID, this is to have easier testcase generation.
2. An entity will have its manager, both entity and its manager can be seen as one **microservice** along with its own **database** (internal datastructure of the entity class in this case).
3. Always start with bruteforce algorithm first and attempt optimization ONLY after the code is giving expected result.

## High Level Design

High level design is also known as system design. System Design is the process of designing the architecture, components, and interfaces for a system so that it meets the end-user requirements. I have tried to document most common topics but there are more detailed resources available, some of which are:

1. [Designing data intensive applications by Martin Kleppmann](https://www.amazon.in/Designing-Data-Intensive-Applications-Reliable-Maintainable/dp/9352135245/ref=sr_1_2?adgrpid=58563655643&ext_vrnc=hi&gclid=Cj0KCQjwpcOTBhCZARIsAEAYLuUSfHwV3-7i3tvemw-oCjK8Of4E6Tv0Ug8f7EIFmMwTIZJGEspx3_YaArP2EALw_wcB&hvadid=294119043831&hvdev=c&hvlocphy=9061996&hvnetw=g&hvqmt=b&hvrand=17260569075925717915&hvtargid=kwd-340293264171&hydadcr=25367_1900683&keywords=data+intensive+application&qid=1651596791&sr=8-2) - CLRS of system design
2. [Basics of system design by Mikito Takada](http://book.mixu.net/distsys/single-page.html) - Notice the terminologies used by the author towards different component of distributed system, understanding this will give a broader perspective.
3. [System Design Primer - A github repo on system design](https://github.com/donnemartin/system-design-primer) - This is filled with a lot of content and it's not expected to finish this in one sitting.
4. [System Design Algorithms](https://github.com/resumejob/system-design-algorithms) - Polpular algorithms which can be used while designing a system
5. [Highscalability](http://highscalability.com/)
6. [Amazon builders library](https://aws.amazon.com/builders-library/?cards-body.sort-by=item.additionalFields.sortDate&cards-body.sort-order=desc&awsf.filter-content-category=*all&awsf.filter-content-type=*all&awsf.filter-content-level=*all) and [AWS architecture center](https://aws.amazon.com/architecture/?intClick=dev-center-2021_main)
7. [Handwritten notes on system design](https://github.com/gauxs/sysd/blob/master/resource/system_design_basics_handbook.pdf)
8. [Distributed System - Paul Krzyzanowski](https://people.cs.rutgers.edu/~pxk/417/notes/index.html) - Good reference to know the name of all the terms related to distributed system

**Note**: [Grokking the System Design Interview](https://www.educative.io/courses/grokking-the-system-design-interview) by educative is also good, its a paid course though. I have also heard there is a free PDF of this course available on internet :smirk:.

[^1]: Distributed programming is the art of solving the same problem that you can solve on a single computer using multiple computers.
