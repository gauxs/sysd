# BigTable
`primary database model - key-value and wide-column store`|

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

Reads of short row ranges are efficient and typically require communication with only a small number of machines. Clients can exploit this property by selecting their row keys so that they get good locality for their data accesses

#### Column Families
Column keys are grouped into sets called column families, which form the basic unit of access control.

It is our intent that the number of distinct column families in a table be small (in the hundreds at most), and that families rarely change during operation. In contrast, a table may have an unbounded number of columns.

#### Timestamps
Each cell in a Bigtable can contain multiple versions of the same data; these versions are indexed by timestamp. Bigtable timestamps are 64-bit integers.

They can be assigned by Bigtable, in which case they represent “real time” in microseconds, or be explicitly assigned by client applications.

## Reference
1. [Google - BigTable paper](https://www.read.seas.harvard.edu/~kohler/class/cs239-w08/chang06bigtable.pdf)
