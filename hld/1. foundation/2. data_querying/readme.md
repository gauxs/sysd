# Data Querying

### Imperative Query Language

1. An **imperative query language** tells the computer to perform certain operations in a certain order.

2. Imperative code is very hard to parallelize across multiple cores and multiple machines, because it specifies instructions that must be performed in a particular order.

### Declarative Query Language

1. In a **declarative query language**, like SQL or relational algebra, you just specify the pattern of the data you want—what conditions the results must meet, and how you want the data to be transformed (e.g., sorted, grouped, and aggregated)—but not how to achieve that goal. It is up to the database system’s query optimizer to decide which indexes and which join methods to use, and in which order to execute various parts of the query.

2. Hides implementation details of the database engine, which makes it possible for the database system to introduce performance improvements without requiring any changes to queries.

3. Declarative languages often lend themselves to parallel execution because they specify only the pattern of the results, not the algorithm that is used to determine the results. The database is free to use a parallel implementation of the query language, if appropriate.

### MapReduce Querying

1. MapReduce is a programming model for processing large amounts of data in bulk across many machines, popularized by Google.
2. MapReduce is neither a declarative query language nor a fully imperative query API, but somewhere in between: the logic of the query is expressed with snippets of code, which are called repeatedly by the processing framework.

```go
db.observations.mapReduce(
 function map() {
    var year = this.observationTimestamp.getFullYear();
    var month = this.observationTimestamp.getMonth() + 1;
    emit(year + "-" + month, this.numAnimals);
 },

 function reduce(key, values) {
    return Array.sum(values);
 },

 {
    query: { family: "Sharks" },
    out: "monthlySharkReport"
 }
);
```

### Cypher Query Language

1. Cypher is a declarative query language for property graphs, created for the Neo4j graph database

2. As is typical for a declarative query language, you don’t need to specify such execution details when writing the query: the query optimizer automatically chooses the strategy that is predicted to be the most efficient, so you can get on with writing the rest of your application.
