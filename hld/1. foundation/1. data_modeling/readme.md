# Data Modeling

> The format in which application devloper give the database his data.

Data models are perhaps the **_most important part of developing software_**, because they have such a profound effect: not only on how the software is written, but also on how we think about the problem that we are solving. Most applications are built by layering one data model on top of another. Example:

1. An application developer looks at the real world (in which there are people, organizations, goods, actions, money flows, sensors, etc.) and model it in terms of objects or data structures, and APIs that manipulate those data structures. Those structures are often specific to your application.
2. When you want to store those data structures, you express them in terms of a general-purpose data model, such as JSON or XML documents, tables in a relational database, or a graph model.
3. The engineers who built your database software decided on a way of representing that JSON/XML/relational/graph data in terms of bytes in memory, on disk, or on a network. The representation may allow the data to be queried, searched, manipulated, and processed in various ways.
4. On yet lower levels, hardware engineers have figured out how to represent bytes in terms of electrical currents, pulses of light, magnetic fields, and more.

In a complex application there may be more intermediary levels, such as APIs built upon APIs, but the basic idea is still the same: **each layer hides the complexity of the layers below it by providing a clean data model**.

## Relational Model

As computers became vastly more powerful and networked, they started being used for increasingly diverse purposes. And remarkably, relational model turned out to generalize very well, beyond their original scope of business data processing, to a broad variety of use cases.

Relational model laid out all the data in the open: a relation (table) is simply a collection of tuples (rows). There are no labyrinthine nested structures, no complicated access paths(like in case of graph model) to follow if you want to look at the data.

### Advantages

1. In a relational database, the query optimizer automatically decides which parts of the query to execute in which order, and which indexes to use. Those choices are effectively the “access path,” but the big difference is that they are made automatically by the query optimizer, not by the application developer, so we rarely need to think about them. If we want to query your data in new ways, we can just declare a new index, and queries will automatically use whichever indexes are most appropriate. The relational model thus made it much easier to add new features to applications.

2. Supports one-to-many, many-to-one and many-to-many relationships.

3. Good support for joins(one-to-many).

### Disadvantages

1. Most application development today is done in object-oriented programming languages: if data is stored in relational tables, an awkward translation layer is required between the objects in the application code and the database model of tables, rows, and columns. The disconnect between the models is sometimes called an **impedance mismatch**.

2. Locality of data[^3] [^4] is not good in relational model which supports multi-table schema.

3. Although many-to-many relationships are supported they are not easy to work with and are not very intuitive with relational model (compared to graph model).

4. If there are many entities then defining table for each entity will bloat the model. Here schemaless model will be advantageous.

## Document (Hierarchial) Model

Document models target use cases where data comes in self-contained documents and relationships between one document and another are rare. Because of the limitations of relational model DBs document model gained traction. Limitation of relational model DBs are:

1. Scalability: SQL databases can be difficult to scale horizontally, especially for write-heavy systems. For example, you can provision multiple read-only replicas for read-heavy systems, but for write-heavy systems, you usually need to vertically scale the database, which can be expensive.

2. Data modeling: SQL databases require a predefined schema and rigid data structure, which can make it difficult to adapt to changing data models and requirements.

3. Performance: SQL databases can be slower than NoSQL databases, especially for complex queries and large data volumes.

4. Efficiency: SQL databases can be inefficient with large volumes of data and may not be great for huge user loads or multiple concurrent operations.

5. Unstructured data: SQL databases are not effective for storing and querying unstructured data where the format is unknown.

### Advantages

1. Schema flexibility [^3] [^4]

2. Better performance due to locality [^1] [^2]

3. For some applications document model is closer to data structures used by the application.

### Disadvantages

1. No support for query optimizer, it’s easier to handcode the access paths for a particular query than to write a general-purpose optimizer—but the general-purpose solution wins in the long run.

2. Doesn't support joins and joins will have to be impemented at application layer making the application code difficult.

3. Difficult to represent many-to-one and many-to-many relationships.

## Graph (Network) Model

If your application has mostly one-to-many relationships (tree-structured data) or no relationships between records, the document model is appropriate. But what if many-to-many relationships are very common in your data? The relational model can handle simple cases of many-to-many relationships, but as the connections within your data become more complex, it becomes more natural to start modeling your data as a graph. Graph model targets use cases where anything
is potentially related to everything.

### Advantages

1. Graphs are good for evolvability: as you add features to your application, a graph can easily be extended to accommodate changes in your application’s data structures.

### Disadvantages

## Which data model leads to simpler application code?

It’s not possible to say in general which data model leads to simpler application code; it depends on the kinds of relationships that exist between data items. For highly interconnected data, the document model is awkward, the relational model is acceptable, and graph models are the most natural.

## Conclusion

All three models (document, relational, and graph) are widely used today, and each is good in its respective domain. One model can be emulated in terms of another model—for example, graph data can be represented in a relational database—but the result is often awkward. That’s why we have different systems for different purposes, not a single one-size-fits-all solution.

[^1]: A document is usually stored as a single continuous string, encoded as JSON, XML, or a binary variant thereof (such as MongoDB’s BSON). If your application often needs to access the entire document (for example, to render it on a web page), there is a performance advantage to this storage locality. If data is split across multiple tables multiple index lookups are required to retrieve it all, which may require more disk seeks and take more time.
[^2]: The locality advantage only applies if you need large parts of the document at the same time. The database typically needs to load the entire document, even if you access only a small portion of it, which can be wasteful on large documents. On updates to a document, the entire document usually needs to be rewritten—only modifications that don’t change the encoded size of a document can easily be performed in place. For these reasons, it is generally recommended that you keep documents fairly small and avoid writes that increase the size of a document. These performance limitations significantly reduce the set of situations in which document databases are useful.
[^3]: Document databases are sometimes called schemaless, but that’s misleading. A more accurate term is schema-on-read (the structure of the data is implicit, and only interpreted when the data is read), in contrast with schema-on-write (the traditional approach of relational databases, where the schema is explicit and the database ensures all written data conforms to it)
[^4]: Schema-on-read is similar to dynamic (runtime) type checking in programming languages, whereas schema-on-write is similar to static (compile-time) type checking.
