# Databases and their characteristics

1. [Secondary indexing](https://stackoverflow.com/questions/1108/how-does-database-indexing-work#:~:text=Indexing%20is%20a%20way%20of,to%20be%20performed%20on%20it.)
2. Multi source replication - one server has many primaries from which it replicates
3. Durability - making data persistent
4. Concurrent - concurrent manipulation of data
5. In-memory capabilities - option to define some or all structure in-memory only
6. Data scheme - skeleton structure that represents the logical view of the entire database, if structure is not uniform then the database is schema free
7. Map-reduce - offers an API for user-defined [Map/Reduce](https://www.tutorialspoint.com/hadoop/hadoop_mapreduce.htm) methods

### RDBMS systems

1. MySQL, Oracle

- Features: `multi-source replication` | `strong consistency` | `ACID transaction` | `concurrent` | `durable` | `in-memory capabilities` | `secondary indexing` | `data scheme exist` | `no map-reduce`

### Key value stores

1. Redis
