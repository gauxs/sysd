# CAP Theorem
### What is CAP theorem?
The theorem states that of these three properties:
1. Consistency: all nodes see the same data at the same time.
2. Availability: node failures do not prevent survivors from continuing to operate.
3. Partition tolerance: the system continues to operate despite message loss due to network and/or node failure 

only two can be satisfied simultaneously.

<img src="https://github.com/gauxs/sysd/blob/master/media/image/CAP.png?raw=true" width="500" height="400">

Note that the theorem states that the middle piece (having all three properties) is not achievable. Then we get three different system types:
1. CA (consistency + availability). Examples include full strict quorum protocols, such as two-phase commit.
2. CP (consistency + partition tolerance). Examples include majority quorum protocols in which minority partitions are unavailable such as Paxos.
3. AP (availability + partition tolerance). Examples include protocols using conflict resolution, such as Dynamo.

The CA and CP system designs both offer the same consistency model: strong consistency. 
