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
   - 2PC is a CA - it is not partition tolerant, there is no safe way to promote a new coordinator if one fails; rather a manual intervention is required. 2PC is also fairly latency-sensitive, since it is a write N-of-N approach in which writes cannot proceed until the slowest node acknowledges them
   - use this if we have structured data and if we need ACID properties

### [Key-value store](https://db-engines.com/en/ranking/key-value+store)

1. Common features: `primary database model - key-value store` | `schema free` | `secondary indexing` | `multi-source & source-replica replication` | `eventual consistency` | `partitioning - sharding` | `concurrent` | `durable`

2. [Amazon DynamoDB vs Redis](https://db-engines.com/en/system/Amazon+DynamoDB%3BRedis)

3. Thoughts:
   - both dynamo and redis provides eventual consistency but dynamo provides immediate consistency for read operations and redis can provide strong consistency with redis raft
   - dynamo has no in-memory capabilities
   - dynamo follows ACID properties
   - both are schema free
   - prefer redis because its widely used in scaled scenarios and is stable
   - redis is generally used as a cache solution

### [Document store](https://db-engines.com/en/ranking/document+store)

Document-oriented databases are inherently a subclass of the key-value store, another NoSQL database concept. The difference lies in the way the data is processed; in a key-value store, the data is considered to be inherently opaque to the database, whereas a document-oriented system relies on internal structure in the document in order to extract metadata that the database engine uses for further optimization. Although the difference is often negligible due to tools in the systems, conceptually the document-store is designed to offer a richer experience with modern programming techniques.

The central concept of a document-oriented database is the notion of a document. While each document-oriented database implementation differs on the details of this definition, in general, they all assume documents encapsulate and encode data (or information) in some standard format or encoding. Encodings in use include XML, YAML, JSON, as well as binary forms like BSON.

#### Keys

Documents are addressed in the database via a unique key that represents that document. This key is a simple identifier (or ID), typically a string, a URI, or a path. The key can be used to retrieve the document from the database. Typically the database retains an index on the key to speed up document retrieval, and in some cases the key is required to create or insert the document into the database.

1. Common features: `primary database model - document store` | `schema free` | `secondary indexing` | `partitioning - sharding` | `source-replica replication` | `concurrent` | `durable` | `eventual consistency`
2. [Amazon DynamoDB vs MongoDB](https://db-engines.com/en/system/Amazon+DynamoDB%3BMongoDB)
3. Thoughts:

   - MongoDB uses asynchronous primary/backup replication
   - dynamoDB doesn't support map reduce
   - dynamo follows ACID properties where as mongo follows multi-document ACID transactions with snapshot isolation
   - mongo has in-memory capabilities
   - both dynamo and mogo provides eventual consistency but dynamo provides immediate consistency for read operations and mongo provides for write operations
   - use document store DB if we have lot of structures in the data and lot of queries needs to be built on the data we can use this. Example: catalog system of amazon
   - inshort, MongoDB and CouchDB provide a SQL-like language to perform complex queries. DynamoDB supports both key-values and documents. Document stores provide high flexibility and are often used for working with occasionally changing data.

### [Search Engines](https://db-engines.com/en/ranking/search+engine)

A search-engine database is a type of nonrelational database that is dedicated to the search of data content. Search-engine databases use indexes to categorize the similar characteristics among data and facilitate search capability. Search-engine databases are optimized for dealing with data that may be long, semistructured, or unstructured, and they typically offer specialized methods such as full-text search, complex search expressions, and ranking of search results.

1. Common features: `primary database model - search engine` | `schema free` | `secondary indexing` | `partitioning - sharding` | `eventual consistency` | `no transaction concept` | `concurrent` | `durable`
2. [Elasticsearch - A distributed, RESTful modern search and analytics engine based on Apache Lucene info](https://db-engines.com/en/system/Elasticsearch)
3. Thoughts:
   - can be used in autofill
   - text search engine which also supports **fuzzy search**
   - search engines are not data stores which gives 100% data durability, data could be lost
   - search engines should not be kept as primary source of truth

### [Wide-column stores](https://db-engines.com/en/ranking/wide+column+store)

A [wide-column database](https://www.scylladb.com/glossary/wide-column-database/) is a type of NoSQL database in which the names and format of the columns can vary across rows, even within the same table. Wide-column databases are also known as column family databases. Because data is stored in columns, queries for a particular value in a column are very fast, as the entire column can be loaded and searched quickly. Related columns can be modeled as part of the same column family.

1. Common features: `primary database model - wide column store` | `schema free` | `restricted secondary indexing` | `partitioning - sharding` | `selectable replication` | `no map-reduce` | `no transaction concepts` | `concurrent` | `durable` | `in-memory capabilities`
2. [Cassandra - wide-column store based on ideas of BigTable and DynamoDB](https://db-engines.com/en/system/Cassandra)
3. Thoughts:
   - its an AP system with eventual consistency
   - use wide-column store DB if we have ever increasing data and finite number of queries needs to be built on the data. Example: location records of uber drivers

### [Time series stores](https://db-engines.com/en/ranking/time+series+dbms)

A time series database (TSDB) is a database optimized for time-stamped or time series data. Time series data are simply measurements or events that are tracked, monitored, downsampled, and aggregated over time. This could be server metrics, application performance monitoring, network data, sensor data, events, clicks, trades in a market, and many other types of analytics data.

1. Common features: `primary database model - time series` | `schema free` | `no secondary indexing` | `partitioning - sharding` | `selectable replication` | `supports map-reduce` | `eventual consistency` | `no transaction concepts` | `concurrent` | `durable` | `no in-memory capabilities`
2. [InfluxDB - DBMS for storing time series, events and metrics](https://db-engines.com/en/system/InfluxDBa)
3. Thoughts:
   - time series updates generally are not performed randomally
   - time series updates are done mostly in append only mode and time series database are optimised to perform these append only update operation
   - bulk read query in ranges

### Blob/File/object store

1. [Amazon simple storage service(S3)](https://aws.amazon.com/s3/)
2. [Content delivery network](https://www.akamai.com/solutions/content-delivery-network)
3. Thoughts:
   - S3 is widely used to store raw files like photos and videos
   - whereas CDN is used to store blobs near geo location of users to improve performance

### Data warehouse

Efficiently store and process large datasets ranging in size from gigabytes to petabytes of data.

1. [Apache Hadoop](https://aws.amazon.com/emr/details/hadoop/what-is-hadoop/)
2. Thoughts:
   - if we need to perform analytics on the data of the whole company we might need a data warehouse
   - large database which can store huge amount of data
   - generally used for offline reporting

### Can we use combination of these databases?

Consider a scenario for amazon where orders are placed everyday, these order are additive and are ever increasing, intuition tells to uses wide-column database but we also need ACID property which is not provided by wide-column databases.

In such case we store current unfinished orders in an RDBMS and leverage ACID properties. Once the orders are fullfiled we can move the data to a wide-column database.

But if we need to perform multiple complex query on this data then a document DB makes more sense, what we can do is after order is fulfilled we can move query related attribute to a document DB to support complex query and all the data to wide-column DB.

## Reference

1. [Youtube - Choosing the Best Database in a System Design Interview](https://www.youtube.com/watch?v=cODCpXtPHbQ)
