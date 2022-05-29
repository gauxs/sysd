# MySQL
## Schema

## ACID

## Query Engine - Advantages etc

## Replication
It is not trivial making MySQL totally reliable and available in cases of high load. Database replication and clustering can help you achieve this goal. Types of mysql replication:
#### Master-Slave Replication
Master-slave replication was the very first replication option for MySQL database. It assumes that you have a single Master server that accepts both reads and writes and one or more read-only Slave servers. Data from the master server are **asynchronously** replicated to Slave servers.

Uses asynchronous primary/backup algorithm which requires 1N message for replication i.e. update, whereas synchronous primary/backup algorithm requires 2N messages i.e. update + ack receipt.

Pros: 
1. It is very fast as doesn’t impose any restrictions on performance.
2. You can split read and write requests to different servers. For example, all analytics queries can be made on Slave nodes.

Cons:
1. It is not very reliable because of asynchronous replication. It means that some committed on master transactions may be not available on slave if the master fails.
2. Write requests can hardly be scaled. The only option to scale write requests is to increase compute capacity (RAM and CPU) of the Master node.
Failover process is manual in a general case. You should take care of promotion replica node to master one.

## Scaling
   - Read - MS
   - Write - MS || MM
   - Data - Sharding via mySQL cluster
## Application and usecases

# MySQL Cluster

## Reference
1. [DB Engines - MySQL](https://db-engines.com/en/system/MySQL)
2. [DZone - MySQL replication types](https://dzone.com/articles/pros-and-cons-of-mysql-replication-types)
