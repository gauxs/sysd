# Data Storage

> Database’s point of view: how we can store the data that we’re given, and how we can find it again when we’re asked for it.

In order to tune a storage engine to perform well on your kind of workload, you need to have a rough idea of what the storage engine is doing under the hood. There are mainly two types of storage engines:

1. Log-structured storage engines: Many databases internally use a log[^1], which is an append-only data file. Appending to a file(write operation) is generally very efficient.

2. Page-oriented storage engines: Break the database down into fixed-size blocks or pages, traditionally 4 KB in size (sometimes bigger), and read or write one page at a time. This design corresponds more closely to the underlying hardware, as disks are also arranged in fixed-size blocks.

## What is an Index

1. An index is an additional structure that is derived from the primary data.

2. Any kind of index usually slows down writes, because the index also needs to be updated every time data is written. Well-chosen indexes speed up read queries, but every index slows down writes.

## Indexes and storage engines

Indexes are built on top of storage engines to optimize data retrieval. The type of index used depends on the underlying storage engine:

1. Indexes on Log-Structured Storage Engines
   - Hash Index: Suitable for simple key-value lookups, where each key maps to a specific location in the log.
   - SSTables and LSM-Trees:
     - SSTables (Sorted String Tables): Sequentially store sorted key-value pairs in files, making range queries and merging efficient.
     - LSM-Trees (Log-Structured Merge Trees): Efficiently manage and merge SSTables, offering high write throughput and compact storage.
2. Indexes on Page-Oriented Storage Engines
   - B-Trees: Organize data into a balanced tree structure, allowing quick reads and efficient updates by modifying only the necessary pages. B-trees are commonly used for traditional database indexing due to their ability to handle both point queries and range scans efficiently.

## Conclusion

As an application developer, if you’re armed with this knowledge about the internals of storage engines, you are in a much better position to know which tool is best suited for your particular application. If you need to adjust a database’s tuning parameters, this understanding allows you to imagine what effect a higher or a lower value may have.

Although this chapter couldn’t make you an expert in tuning any one particular storage engine, it has hopefully equipped you with enough vocabulary and ideas that you can make sense of the documentation for the database of your choice.

[^1]: an append-only sequence of records.
