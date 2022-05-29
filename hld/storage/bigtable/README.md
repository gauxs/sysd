# BigTable
Bigtable does not support a full relational data model; instead, it provides clients with a simple data model that supports dynamic control over data layout and format, and allows clients to reason about the locality properties of the data represented in the underlying storage.

Data is indexed using row and column names that can be arbitrary strings. Clients can control the locality of their data through careful choices in their schemas.

Bigtable schema parameters let clients dynamically control whether to serve data out of memory or from disk

## Reference
1. [Google - BigTable paper](https://www.read.seas.harvard.edu/~kohler/class/cs239-w08/chang06bigtable.pdf)
