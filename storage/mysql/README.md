# MySQL
## Schema
Strict schema has its own advantages and disadvantages. Read *Chapter:2 Data Models & Query Languages* of *Designing Data-Intensive Application* for indepth information.

## ACID
Read *Chapter:& Transactions* of *Designing Data-Intensive Application* for indepth information.

## Query Engine
Query engine has its own advantages. Read *Chapter:2 Data Models & Query Languages - Query Languages for Data* of *Designing Data-Intensive Application* for indepth information.

## Replication
It is not trivial making MySQL totally reliable and available in cases of high load. Database replication and clustering can help you achieve this goal. Types of mysql replication:
#### Master-Slave Replication
Master-slave replication was the very first replication option for MySQL database. It assumes that you have a single Master server that accepts both reads and writes and one or more read-only Slave servers. Data from the master server are **asynchronously** replicated to Slave servers.

Uses asynchronous primary/backup algorithm which requires 1N message for replication i.e. update, whereas synchronous primary/backup algorithm requires 2N messages i.e. update + ack receipt.

Pros: 
1. It is very fast as doesn’t impose any restrictions on performance.
2. You can split read and write requests to different servers. For example, all analytics queries can be made on Slave nodes.

Cons:
1. Offers weak guarantees because of asynchronous replication. It means that some committed on master transactions may be lost on slave if the master fails.
2. Write requests can hardly be scaled. The only option to scale write requests is to increase compute capacity (RAM and CPU) of the Master node.
Failover process is manual in a general case. You should take care of promotion replica node to master one.

#### Master-Master Replication
Master-master replication has been evolved from master-slave replication and solves its major issues. This type of replication assumes that you have two or more master nodes that can accept both read and write requests. In addition, you can have multiple slave nodes for each of your masters. The replication between master nodes is asynchronous.

Pros:
1. You have an option to scale write requests not only by increasing the computing capacity of a single master node but via adding additional master nodes.
2. Failover semi-automatic because you have multiple master nodes. The chance that all master nodes fail simultaneously is very low. If any of master nodes fail, there is at least one more master node that can handle its requests.

Cons:
1. Due to asynchronous replication between all master nodes, you can lose some transaction in case one of the master nodes fail.
2. Due to asynchronous replication, you can’t be sure that backups made on each master node contain the same data.
3. Failover is still not fully automated in case you need to promote a Slave node to Master one.

**Note**: Replication can be used for many reasons. Some of the more common reasons include scalibility, server failover, and for backup solutions.

## Scaling
1. Read scaling via MS and MM
2. Write scaling via MS(shifting read load on slaves) and MM(dividing writes among masters)
3. Data scaling can only be done by increasing hardware for larger data storage requirement either mysql cluster solution can be used
 
#### MySQL Cluster
MySQL Cluster is a highly scalable, real-time, ACID-compliant transactional database, shared nothing, distributed, partitioning system that uses synchronous replication in order to maintain high availability and performance.

MySQL Cluster is implemented through a separate storage engine called NDB Cluster. This storage engine will automatically partition data across a number of data nodes. The automatic partitioning of data allows for parallelization of queries that are executed. Both reads and writes can be scaled in this fashion since the writes can be distributed across many nodes.

Internally, MySQL Cluster also uses synchronous replication in order to remove any single point of failure from the system. Since two or more nodes are always guaranteed to have the data fragment, at least one node can fail without any impact on running transactions. Failure detection is automatically handled with the dead node being removed transparent to the application. Upon node restart, it will automatically be re-integrated into the cluster and begin handling requests as soon as possible.

Ensures results from SELECT operations are consistent, regardless of which node they are returned from.

## Application and usecases
1. High volume OLTP (online transaction processing)
2. Real time analytics
3. Ecommerce and financial trading with fraud detection
4. Mobile and micro-payments
5. Session management & caching
6. Feed streaming, analysis and recommendations
7. Content management and delivery
8. Massively Multiplayer Online Games
9. Communications and presence services
10. Subscriber/user profile management and entitlements

## Reference
1. [DB Engines - MySQL](https://db-engines.com/en/system/MySQL)
2. [DZone - MySQL replication types](https://dzone.com/articles/pros-and-cons-of-mysql-replication-types)
3. [MySQL Lab](http://www.mysqlab.net/knowledge/kb/detail/topic/cluster/id/5184)
4. [MySQL cluster](https://www.w3resource.com/mysql/mysql-cluster-overview.php)
