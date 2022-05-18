# Redis

Redis is a realtime, robust in-memory NoSQL database platform. Shared-nothing cluster architecture, redis Enterprise delivers **infinite linear scaling** without imposing non-linear overhead in a scale-out architecture

## Quick summary
1. open source redis is a single threaded process and is bound by the CPU core that it is running on and available memory on the server
2. to remove this limitation we can run multiple redis instance on multipe machine like a **cluser** named Redis Enterprise Software (RS) cluster
3. a redis database can be deployed on multiple machines, but this is abstracted from client/application point of view. An application accessing its database can have its database distributed between multiple single threaded redis processess(master shards)
5. shard - redis process that is part of the Redis clustered database
6. a single machine or node can run multiple redis instance i.e. shards
7. Tag or Hash Tag - A part of the key that is used in the hash calculation.
8. Slot or Hash Slot - The result of the hash calculation.

### Replication
- diskless replication, instant failure detection, and single-digit-seconds failover across racks, zones, and geographies
- guarantees four-nines (99.99%) uptime and five-nines (99.999%) in **Active-Active deployments**

### Sharding
automatic re-sharding and rebalancing
fully uses your infrastructure by splitting loads across multiple cores on every compute node

### Active-Active Geo-Distribution
- using academically proven **conflict-free replicated data types (CRDTs)** technology, redis Enterprise automatically resolves conflicting writes, without changing the way your application uses Redis

## Data Types

1. Strings
2. Lists
3. Sets
4. Hashes
5. Sorted Sets
6. Bitmaps and HyperLogLogs
7. Streams
8. Geospatial indexes

## Redis Modules and Usecases

1. RediSearch

- RediSearch adds a secondary index, a query engine, and a full-text search to Redis
- Data Model: Index, query, and search in Redis Hashes
- Use Cases:
  - Real-time indexes
  - Product catalogue search
  - Site search

2. RedisJSON

- RedisJSON adds native support for storing and retrieving JSON documents at the speed of Redis.
- Data Model: JSON Document
- Use Cases:
  - Content management
  - Hierarchical data
  - Personalization

3. RedisGraph

- RedisGraph is a queryable property graph data structure designed for real-time use cases.
- Data Model: Sparse Adjacency Matrix
- Use Cases:
  - Resource Management (Identity, Access Management)
  - Payment management
  - Assets management

4. RedisTimeSeries

- RedisTimeSeries adds native time-series database capabilities to Redis.
- Data Model: Redis Radix Tree
- Use Cases:
  - Application monitoring
  - Anomaly detection
  - Telemetry

5. RedisBloom

- RedisBloom adds Bloom filter, Cuckoo filter, Count-Min Sketch, and Top-K capabilities to Redis.
- Use Cases:
  - Fraud mitigation
  - Leaderboards
  - Advertising

6. RedisAI

- RedisAI is a real-time AI inferencing/serving engine in Redis.
- Use Cases:
  - Fraud detection/transaction scoring
  - Recommendation engines
  - Ads serving

7. RedisGears

- RedisGears is a distributed programmable engine in Redis. It makes it simple to execute server side logic using functions, triggers and control workflows across data-models/data-structures and shards
- Use Cases:
  - Write behind/through
  - Real-time data processing
  - Reliable stream and events processing

## Internals
Open source Redis is a **single-threaded** process to provide speed and simplicity. A single Redis process is bound by the CPU core that it is running on and available memory on the server.

A database cluster is a set of Redis processes where **each process** manages a **subset** of the database keyspace. In an redis cluster, the keyspace is partitioned into database shards. At any moment a shard resides on a single node and is managed by that node.

Each node in a Redis database cluster can manage multiple shards. The key space in the shards is divided into hash slots. The slot of a key is determined by a hash of the key name or part of the key name.

Database clustering is transparent to the Redis client that connects to the database. The Redis client accesses the database through a single endpoint that automatically routes all operations to the relevant shards. You can connect an application to a single Redis process or a clustered database without any difference in the application logic.

## References

1. [Redis Advantages](https://redis.com/redis-enterprise/advantages/)
2. [Redis Datatypes](https://redis.io/docs/manual/data-types/)
