# Column-Oriented Storage: Key Concepts

## Overview

- **Fact Tables and Dimension Tables**:

  - Fact tables often contain trillions of rows and petabytes of data, making efficient storage and querying a challenge.
  - Dimension tables are usually smaller, with millions of rows.

- **Query Optimization**:
  - Although fact tables can be over 100 columns wide, typical data warehouse queries only access 4 or 5 columns at a time.
  - Example: A query accessing sales data might only need `date_key`, `product_sk`, and `quantity` columns from a `fact_sales` table.

## Row-Oriented vs. Column-Oriented Storage

- **Row-Oriented Storage**:

  - Common in OLTP databases and document stores.
  - Stores all values from a single row together, which can be inefficient for analytical queries that only need a few columns.

- **Column-Oriented Storage**:
  - Stores all values from each column together.
  - A query only needs to read the specific columns involved, improving efficiency.
  - Columns are stored in separate files, maintaining the order of rows across these files.

## Column Compression

- **Efficiency**:

  - Column-oriented storage is well-suited for compression, often resulting in highly repetitive data sequences that are ideal for various compression techniques.

- **Bitmap Encoding**:

  - Converts a column with `n` distinct values into `n` separate bitmaps (one per value), where each bitmap has one bit per row.
  - If `n` is small, bitmaps are stored with one bit per row; if large, they are run-length encoded to optimize storage.

- **Query Performance**:
  - Bitmap indexes are efficient for common data warehouse queries:
    - `WHERE product_sk IN (30, 68, 69)`: Load the bitmaps for these product keys and compute their bitwise OR.
    - `WHERE product_sk = 31 AND store_sk = 3`: Load the respective bitmaps and compute their bitwise AND.

## Column-Oriented Storage and Column Families

- **Misconception**:
  - Systems like Cassandra and HBase use the concept of column families but are still mostly row-oriented since they store all columns from a row together.

## Memory Bandwidth and Vectorized Processing

- **Data Transfer Bottlenecks**:

  - Bandwidth between disk and memory is a major bottleneck for data warehouse queries.
  - Efficient use of memory-to-CPU bandwidth is also crucial, considering factors like CPU cache, branch mispredictions, and SIMD (Single Instruction, Multiple Data) instructions.

- **Vectorized Processing**:
  - Allows compressed column data to fit in CPU’s L1 cache, enabling faster execution through tight loops without function calls.
  - Operators like bitwise AND and OR can work directly on compressed column data, enhancing processing efficiency.

# Sort Order in Column-Oriented Storage

## Overview

- **Row Storage in Column Stores**:
  - Rows in a column store can be stored in any order, but it's common to store them in the order they were inserted for simplicity.
  - However, imposing a specific sort order can be advantageous for indexing and query optimization.

## Sorting Considerations

- **Sorting Entire Rows**:

  - Sorting columns independently would make it impossible to reconstruct rows since the association between columns would be lost.
  - Instead, the data is sorted based on entire rows, allowing for efficient reconstruction and querying.

- **Choosing Sort Keys**:

  - The database administrator can select columns to sort based on common query patterns.
  - Example: If queries often target date ranges, making `date_key` the primary sort key allows faster access to relevant rows.

- **Multi-Level Sorting**:
  - A second sort key (e.g., `product_sk`) can be used to organize rows that have the same value in the first sort key, further optimizing query performance.
  - Sorting helps with compression, particularly if the first sort key has many repeated values.

## Multiple Sort Orders

- **Redundant Data for Performance**:
  - Systems like C-Store and Vertica replicate data and store it in multiple sort orders.
  - This allows the system to use the most appropriate sort order for a given query, similar to how row-oriented stores use secondary indexes.

## Writing to Column-Oriented Storage

- **Challenges with Writes**:

  - Writes are more complex in column stores due to compression and sorting.
  - Updating or inserting rows can require rewriting entire column files, which is resource-intensive.

- **LSM-Trees for Efficient Writes**:
  - Writes are first handled by an in-memory store (using a sorted structure) before being merged with on-disk column files.
  - This approach, used by systems like Vertica, optimizes the write process while maintaining efficient query performance.

## Aggregation: Data Cubes and Materialized Views

- **Materialized Aggregates**:

  - Data warehouses often use aggregate functions (e.g., `COUNT`, `SUM`) in queries.
  - To optimize performance, frequently used aggregates can be cached using materialized views, which store the results of a query on disk.

- **Data Cubes (OLAP Cubes)**:

  - A special type of materialized view, a data cube, organizes aggregates by different dimensions (e.g., date, product).
  - This precomputation allows for very fast query responses for certain types of queries.

- **Trade-offs**:
  - While data cubes improve query speed, they lack the flexibility of querying raw data and may not support all query types.
  - As a result, data warehouses often balance between using raw data and materialized aggregates based on performance needs.
