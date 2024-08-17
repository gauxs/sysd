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

### What are CA systems? Do they exist?
No, CA sysems in a distribued setting cannot exist. As often mentioned, the CAP theorem in its original form is a little misleading. It can be restated as:
> in the presence of the network partition, a distributed system is either available or consistent

Generally, systems **cannot** be classified as CA but CP or AP only, since partition tolerance is a property of the system, which describes what to choose in case of a network partition. 

Another interesting part is that RDBMS databases are often at the CA side of the triangle. **This is only the case in a single node setup**. Even with master (write) - slave (read) setup, the system is not CA (or if it is termed "CA" for some reason, and cannot recover from network partitions, then a split-bran scenario may happen, a new master is elected for the partition, and chaos ensues, possibly breaking the consistency of the system).

### What are CP systems?
A CP system prevents divergence (e.g. maintains single-copy consistency) by forcing asymmetric behavior on the two sides of the partition. It only keeps the majority partition around, and requires the minority partition to become unavailable (e.g. stop accepting writes), which **retains a degree of availability (the majority partition)** and still ensures single-copy consistency. Example:
1. Paxos algorithm - It is used in many of Google's systems, including the Chubby lock manager used by BigTable/Megastore, the Google File System as well as Spanner.
2. ZAB - the Zookeeper Atomic Broadcast protocol is used in Apache Zookeeper which is base in Hadoop-centric distributed systems for coordination (e.g. HBase, Storm, Kafka)
3. Raft algorithm - used in etcd inspired by ZooKeeper.

### What are AP systems?
An AP system allows nodes do diverge while providing high availability and that nodes can for some time diverge from each other, but eventually they will agree on the value, this is called **eventual consistency**. Example: 
1. Amazon's Dynamo system design (2007) is probably the best-known system that offers weak consistency guarantees but high availability. It is the basis for many other real world systems, including LinkedIn's Voldemort, Facebook's Cassandra and Basho's Riak.

### Takeaways from CAP theorem
1. Many system designs used in early distributed relational database systems did not take into account partition tolerance (e.g. they were CA designs).
2. There is a tension between strong consistency and high availability during network partitions.
3. There is a tension between strong consistency and performance in normal operation.
4. If we do not want to give up availability during a network partition, then we need to explore whether consistency models other than strong consistency are workable for our purposes.

## Reference
1. [Stackoverflow - How CA distributed system according to CAP theorem can exist?](https://stackoverflow.com/questions/47539213/how-ca-distributed-system-according-to-cap-theorem-can-exist)
