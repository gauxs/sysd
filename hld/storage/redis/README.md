# Redis

Redis is a realtime, robust in-memory NoSQL database platform. Shared-nothing cluster architecture, redis Enterprise delivers **infinite linear scaling** without imposing non-linear overhead in a scale-out architecture

## Quick summary
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

### Sharding
automatic re-sharding and rebalancing
fully uses your infrastructure by splitting loads across multiple cores on every compute node

### Active-Active Geo-Distribution
- guarantees four-nines (99.99%) uptime and five-nines (99.999%) in **Active-Active deployments**
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

1. RediSearch: adds a secondary index, a query engine, and a full-text search to Redis
   - data model: index, query, and search in Redis Hashes
   - use Cases: Real-time indexes | Product catalogue search | Site search

2. RedisJSON: adds native support for storing and retrieving JSON documents at the speed of Redis
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

## References

1. [Redis Advantages](https://redis.com/redis-enterprise/advantages/)
2. [Redis Datatypes](https://redis.io/docs/manual/data-types/)
