# BigTable
Bigtable does not support a full relational data model; instead, it provides clients with a simple data model that supports dynamic control over data layout and format, and allows clients to reason about the locality properties of the data represented in the underlying storage.

Data is indexed using row and column names that can be arbitrary strings. Clients can control the locality of their data through careful choices in their schemas.

Bigtable schema parameters let clients dynamically control whether to serve data out of memory or from disk

## Data Model
A Bigtable is a sparse, distributed, persistent multidimensional sorted map. The map is indexed by a row key, column key, and a timestamp; each value in the map is an uninterpreted array of bytes.
```
(row:string, column:string, time:int64) → string
```

#### Row
The row keys in a table are arbitrary strings (currently up to 64KB in size, although 10-100 bytes is a typical size for most of our users). Every read or write of data under a single row key is atomic (regardless of the number of different columns being read or written in the row), a design decision that makes it easier for clients to reason about the system’s behavior in the presence of concurrent updates to the same row.

Bigtable maintains data in lexicographic order by row key. The row range for a table is dynamically partitioned. Each row range is called a **tablet**, which is the unit of distribution and load balancing.



## Reference
1. [Google - BigTable paper](https://www.read.seas.harvard.edu/~kohler/class/cs239-w08/chang06bigtable.pdf)
