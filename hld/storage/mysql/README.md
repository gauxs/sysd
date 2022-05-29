# MySQL
## Schema
## ACID
## Query Engine - Advantages etc
## Replication
It is not trivial making MySQL totally reliable and available in cases of high load. Database replication and clustering can help you achieve this goal. Types of mysql replication:
1. **Master-Slave Replication**: Master-slave replication was the very first replication option for MySQL database. It assumes that you have a single Master server that accepts both reads and writes and one or more read-only Slave servers. Data from the master server are asynchronously replicated to Slave servers.
    - uses asynchronous primary/backup algorithm for replication
    - uses 1N message for replication i.e. update whereas synchronous primary/backup algorithm requires 2N messages i.e. update + ack receipt

## Scaling
   - Read - MS
   - Write - MS || MM
   - Data - Sharding via mySQL cluster
## Application and usecases

# MySQL Cluster

## Reference
1. [DB Engines - MySQL](https://db-engines.com/en/system/MySQL)
2. [DZone - MySQL replication types](https://dzone.com/articles/pros-and-cons-of-mysql-replication-types)
