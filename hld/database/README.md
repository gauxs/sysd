# Databases and their characteristics

1. [Secondary indexing](https://stackoverflow.com/questions/1108/how-does-database-indexing-work#:~:text=Indexing%20is%20a%20way%20of,to%20be%20performed%20on%20it.)
2. Multi source replication - one server has many primaries from which it replicates
3. Durability - making data persistent
4. Concurrent - concurrent manipulation of data
5. In-memory capabilities - option to define some or all structure in-memory only
6. Data scheme - skeleton structure that represents the logical view of the entire database, if structure is not uniform then the database is schema free
7. Map-reduce - offers an API for user-defined [Map/Reduce](https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm) methods

### [RDBMS](https://db-engines.com/en/ranking/relational+dbms)

1. Common features: `multi-source & source-replica replication` | `strong consistency` | `ACID transaction` | `concurrent` | `durable` | `in-memory capabilities` | `secondary indexing` | `data scheme exist` | `no map-reduce` | `primary database model - rdbms` | `secondary database model - document store & spatial dbms` | `horizontal partitioning`

2. [MySQL cluster vs Oracle](https://db-engines.com/en/system/MySQL%3BOracle)

3. Thoughts:

   - MySQL cluster etc. provides strong consistency, can be used where transaction properties are needed
   - by default, MySQL(stores data at single node) uses asynchronous primary/backup replication which provides weak consistency guarantees.
   - MySQL cluster(stores data in multiple nodes) provides synchronous replication via two phase commit(2PC) protocol
   - 2PC is a CA - it is not partition tolerant, there is no safe way to promote a new coordinator if one fails; rather a manual intervention is required. 2PC is also fairly latency-sensitive, since it is a write N-of-N approach in which writes cannot proceed until the slowest node acknowledges them.

### [Key-value store](https://db-engines.com/en/ranking/key-value+store)

1. Common features: `primary database model - key-value store` | `schema free` | `secondary indexing` | `multi-source & source-replica replication` | `eventual consistency` | `partitioning - sharding` | `concurrent` | `durable`

2. [Amazon DynamoDB vs Redis](https://db-engines.com/en/system/Amazon+DynamoDB%3BRedis)

3. Thoughts:
   - Both dynamo and redis provides eventual consistency but dynamo provides immediate consistency for read operations and redis can provide strong consistency with redis raft
   - dynamo has no in-memory capabilities
   - both are schema free

### [Document store](https://db-engines.com/en/ranking/document+store)

Document-oriented databases are inherently a subclass of the key-value store, another NoSQL database concept. The difference lies in the way the data is processed; in a key-value store, the data is considered to be inherently opaque to the database, whereas a document-oriented system relies on internal structure in the document in order to extract metadata that the database engine uses for further optimization. Although the difference is often negligible due to tools in the systems, conceptually the document-store is designed to offer a richer experience with modern programming techniques.

The central concept of a document-oriented database is the notion of a document. While each document-oriented database implementation differs on the details of this definition, in general, they all assume documents encapsulate and encode data (or information) in some standard format or encoding. Encodings in use include XML, YAML, JSON, as well as binary forms like BSON.

1. Common features: `primary database model - document store`
2. [Amazon DynamoDB vs MongoDB](https://db-engines.com/en/system/Amazon+DynamoDB%3BMongoDB)
3. Thoughts:
   - MongoDB uses asynchronous primary/backup replication
