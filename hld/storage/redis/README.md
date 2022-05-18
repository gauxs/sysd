# Redis

Redis is a realtime, robust in-memory NoSQL database platform. Shared-nothing cluster architecture, redis Enterprise delivers **infinite linear scaling** without imposing non-linear overhead in a scale-out architecture

**Note**: Salvatore Sanfilippo (creator of Redis) thinks it's a bad idea to use multiple DBs in a single Redis instance. [Reference](https://groups.google.com/g/redis-db/c/vS5wX8X4Cjg?pli=1)

## Overview
1. open source redis is a single threaded process and is bound by the CPU core that it is running on and available memory on the server
2. open source redis allows multiple database(db0...dbN) on a single redis instance whereas only one database(db0) is allowed in redis cluster
3. to remove the limitation of single threaded redis, we can run multiple redis instance on multipe machine like a **cluser**, this is called Redis Enterprise Software (RS) cluster
4. an application accessing its database can have its key-data distributed between multiple single threaded redis processess i.e. master shards
5. **shard** is a redis process that is part of the Redis clustered database
6. a single machine or node can run multiple redis instance i.e. shards
7. Tag or Hash Tag - A part of the key that is used in the hash calculation
8. Slot or Hash Slot - The result of the hash calculation

### Replication
1. redis does diskless replication, instant failure detection, and single-digit-seconds failover across racks, zones, and geographies
2. redis replication can be done in two ways
   - weak consistency: replication occurs asynchronously
   - strong consistency: replication occurs synchronously
3. more details at: [Redis: Consistency & Durability](https://docs.redis.com/latest/rs/concepts/data-access/consistency-durability/)

### Service Discovery
Redis also uses service discovery to keep up with the topology changes. In case of a node failure, the Discovery Service is updated by the cluster manager(which runs on each node/machine) with the new endpoint and clients unable to connect to the database endpoint due to the failover, can re-query the discovery service for the new endpoint for the database. More details: [Redis: Discovery service](https://docs.redis.com/latest/rs/concepts/data-access/discovery-service/)

### Clustering
Redis Enterprise Software (RS) supports database clustering to allow customers to spread the load of a Redis process over multiple cores and the RAM of multiple servers. A database cluster is a set of Redis processes where each process manages a subset of the database keyspace.

The key space in the shards is divided into hash slots. The slot of a key is determined by a hash of the key name or part of the key name. Automatic re-sharding and rebalancing, fully uses your infrastructure by splitting loads across multiple cores on every compute node. More details: [Redis: Clustering](https://docs.redis.com/latest/rs/concepts/high-availability/clustering/)

### Active-Active Geo-Distribution
Each Active-Active database can have many Active-Active database instances that come with added smarts for handling globally distributed writes using the proven CRDT approach.

Guarantees four-nines (99.99%) uptime and five-nines (99.999%) in **Active-Active deployments** using academically proven **conflict-free replicated data types (CRDTs)** technology, redis Enterprise automatically resolves conflicting writes, without changing the way your application uses Redis. More details: [Redis: Intercluster replication](https://docs.redis.com/latest/rs/concepts/intercluster-replication/)

## Data Types

1. Strings
2. Lists
3. Sets
4. Hashes
5. Sorted Sets
6. Bitmaps and HyperLogLogs
7. Streams
8. Geospatial indexes

## Redis Modules

1. **RediSearch**: adds a secondary index, a query engine, and a full-text search to Redis
   - data model: index, query, and search in Redis Hashes
   - use Cases: real-time indexes | product catalogue search | site search

2. **RedisJSON**: adds native support for storing and retrieving JSON documents at the speed of Redis
   - data model: JSON Document
   - use cases: content management | hierarchical data | Personalization

3. **RedisGraph**: is a queryable property graph data structure designed for real-time use cases
   - data model: sparse adjacency matrix
   - use cases: resource management (identity, access management) | payment management | assets management

4. **RedisTimeSeries**: adds native time-series database capabilities to Redis.
   - data model: redis radix tree
   - use cases: application monitoring | anomaly detection | telemetry

5. **RedisBloom**: adds bloom filter, cuckoo filter, count-min Sketch, and top-K capabilities to Redis
   - use cases: fraud mitigation | leaderboards | advertising

6. **RedisAI**: is a real-time AI inferencing/serving engine in Redis
   - use cases: fraud detection/transaction scoring | recommendation engines | ads serving

7. **RedisGears**: is a distributed programmable engine in Redis. It makes it simple to execute server side logic using functions, triggers and control workflows across data-models/data-structures and shards
   - Use Cases: write behind/through | real-time data processing | reliable stream and events processing

## References

1. [Redis: Technical Overview](https://docs.redis.com/latest/rs/technology-behind-redis-enterprise/)
2. [Redis: Reference](https://redis.io/docs/reference/)
