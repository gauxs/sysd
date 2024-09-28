1. Understand usecase and define data model that best represent your application. Based on the relationship among the data models (one to one, one to many or many to many) we can know which DB can inherently support the model.

2. Understand the storage engine and index

- Log Based(Hash or LSM index are used): LevelDB, RocksDB, Cassandra, HBase, Lucene()
- Page Based(B Trees): RDS
- InMemory: VoltDB, MemSQL, Oracle TimesTen, RAMCloud, Redis

  1. Log-Structured Storage Engines

     - Index Type: Hash or LSM (Log-Structured Merge) Trees
     - Characteristics: Append-only logs, compaction, efficient writes, good for write-heavy workloads.
     - Examples:
       - LevelDB: LSM-based, key-value store.
       - RocksDB: LSM-based, optimized for flash storage, based on LevelDB.
       - Cassandra: Uses LSM trees, distributed, designed for scalability.
       - HBase: Built on Hadoop HDFS, uses LSM trees, designed for large tables.
       - Lucene: Uses an SSTable-like structure, often part of search engines like Elasticsearch.

  2. Page-Oriented Storage Engines

     - Index Type: B-Trees (and variations like B+ Trees)
     - Characteristics: Data is stored in fixed-size pages (e.g., 4KB), good for read-heavy workloads, supports complex queries.
     - Examples:
       - RDS (Relational Database Service): Refers to managed relational databases like MySQL, PostgreSQL, Oracle, etc., which typically use B-trees for indexing.
       - MySQL/InnoDB: Uses B-trees for primary and secondary indexes.
       - PostgreSQL: Uses B-trees for default indexing but supports other index types like GIN, GiST, and more.

  3. In-Memory Databases

     - Index Type: Varies, often custom in-memory structures for speed (e.g., hash tables, skip lists).
     - Characteristics: All data is stored in RAM for fast access, durable through techniques like logging or replication, low-latency operations.
     - Examples:
       - VoltDB: In-memory, uses a relational model with high-performance transactions.
       - MemSQL: In-memory, now called SingleStore, combines in-memory rowstore with disk-based columnstore.
       - Oracle TimesTen: In-memory relational database.
       - RAMCloud: Key-value store, uses in-memory storage with durability via log-structured approach.
       - Redis: In-memory key-value store with various data structures, can write data to disk asynchronously.

  4. Hybrid (In-Memory + Disk-based) Databases

     - Characteristics: Primarily in-memory but use disk for durability or for storing data that exceeds memory.
     - Examples:
       - Redis (with persistence): Stores data in memory but writes snapshots or logs to disk for durability.
       - VoltDB (with anti-caching): Stores hot data in memory, cold data on disk.

  Additional Notes:
  Lucene: Although included under log-based, it's primarily a search engine library and not a database in the traditional sense, but it uses log-structured storage similar to LSM trees.

3.  Understand the replication strategy being used and their implications.

    Leader setup:

    - Sigle Leader replication: PostgreSQL, MySQL, MongoDB, RethinkDB, Espresso, distributed message brokers such as Kafka and RabbitMQ highly available queues
    - Multi Leader replication
      - Clients with offline operation: CouchDB
      - Collaborative editing: Google Docs
    - Leaderless replication: Dynamo, Riak, Cassandra, and Voldemort
      - Sloppy Quorums: Sloppy quorums are particularly useful for increasing write availability. It is optional in all common leaderless implementations. Example: Riak they are enabled by default, and in Cassandra and Voldemort they are disabled by default.

    Conflict Resolution: Implementations of these algorithms in databases are still young

    - Conflict-free replicated datatypes (CRDTs): Riak 2.0
    - Mergeable persistent data structures:
    - Operational transformation: Google Docs
    - Last write wins (discarding concurrent writes)
      - Even though the writes don’t have a natural ordering, we can force an arbitrary order on them.
      - LWW achieves the goal of eventual convergence, but at the cost of durability.
      - LWW may even drop writes that are not concurrent, LWW is a poor choice for conflict resolution.
      - Example: LWW is only supported conflict resolution method in Cassandra, and an optional feature in Riak
      - The only safe way of using a database with LWW is to ensure that a key is only written once and thereafter treated as immutable, thus avoiding any concurrent updates to the same key. For example, a recommended way of using Cassandra is to use a UUID as the key, thus giving each write operation a unique key
    - Version vectors: The collection of version numbers from all the replicas is called a version vector
      - version vectors are sent from the database replicas to clients when values are read, and need to be sent back to the database when a value is subsequently written. (Riak encodes the version vector as a string that it calls causal context.) The version vector allows the database to distinguish between overwrites and concurrent writes.

4. Understanding partitioning and its strategies
   Partitioning of HashKey:

     - For partitioning purposes, the hash function need not be cryptographically strong. Example: Cassandra and MongoDB use MD5, and Voldemort uses the FowlerNoll–Vo function
     - Many programming languages have simple hash functions built in (as they are used for hash tables), but they may not be suitable for partitioning: for example, in Java’s Object.hashCode() and Ruby’s Object#hash, the same key may have a different hash value in different processes
     - By using the hash of the key for partitioning we lose a nice property of key-range partitioning: the ability to do efficient range queries
         - In MongoDB, if you have enabled hash-based sharding mode, any range query has to be sent to all partitions. Range queries on the primary key are not supported by Riak, Couchbase, or Voldemort.
         - Cassandra has compound primary key consisting of several columns. Only the first part of that key is hashed to determine the partition, but the other columns are used as a concatenated index for sorting the data in Cassandra’s SSTables.
