# Data Storage

> Database’s point of view: how we can store the data that we’re given, and how we can find it again when we’re asked for it.

In order to tune a storage engine to perform well on your kind of workload, you need to have a rough idea of what the storage engine is doing under the hood. There are mainly two types of storage engines:

1. Log-structured storage engines
2. Page-oriented storage engines

## Log-structured Storage Engines

1. Many databases internally use a log[^1], which is an append-only data file. Appending to a file(write operation) is generally very efficient.

### Hash [Indexes](https://github.com/gauxs/sysd/blob/data_intensive/hld/1.%20foundation/3.%20data_storage/readme.md#index)

## Page-oriented Storage Engines

## Index

1. An index is an additional structure that is derived from the primary data.
2. Any kind of index usually slows down writes, because the index also needs to be updated every time data is written. Well-chosen indexes speed up read
   queries, but every index slows down writes.

[^1]: an append-only sequence of records.
