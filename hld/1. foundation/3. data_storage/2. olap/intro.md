# Data Warehousing: Key Concepts

## Purpose and Structure

- Large enterprises often have multiple OLTP (Online Transaction Processing) systems managing different aspects of the business, such as customer-facing websites, point-of-sale systems, inventory tracking, etc.
- OLTP systems are optimized for high availability and low latency, crucial for daily business operations.
- Running complex analytical queries on OLTP systems can hinder performance; hence, data warehouses are used for analytics.

## Role of a Data Warehouse

- A data warehouse is a separate, read-only database designed specifically for running analytic queries without affecting the OLTP systems.
- It aggregates data from various OLTP systems, cleans it, transforms it into an analysis-friendly schema, and loads it into the warehouse—a process known as Extract–Transform–Load (ETL).

## Data Model and Optimization

- The data model in a data warehouse is typically relational, allowing SQL-based queries.
- Unlike OLTP systems, data warehouses are optimized for analytic queries rather than transactional processing, using different storage engines and indexing mechanisms.

## Separation from OLTP Systems

- Data warehouses allow business analysts to run ad hoc queries freely without impacting the performance of OLTP systems.
- The divergence in optimization between OLTP databases and data warehouses has led to specialized systems, with some vendors offering separate engines for each within the same product.

## Commercial and Open-Source Solutions

- Commercial data warehouse solutions include systems like Teradata, Vertica, SAP HANA, and ParAccel, with Amazon Redshift as a hosted version of ParAccel.
- Open-source alternatives such as Apache Hive, Spark SQL, Cloudera Impala, Facebook Presto, Apache Tajo, and Apache Drill have emerged, offering SQL-on-Hadoop capabilities and competing with commercial data warehouses.

## Schemas for Analytics

- **Star Schema:** The most common schema used in data warehouses, featuring a central fact table surrounded by dimension tables. The fact table records events (e.g., sales transactions), while dimension tables capture the context (e.g., product details, time, location).
- **Snowflake Schema:** A variation of the star schema that further normalizes dimensions into sub-dimensions. While more normalized, star schemas are often preferred for simplicity.
- **Wide Tables:** Fact tables and dimension tables in data warehouses tend to be very wide, with hundreds of columns, capturing all relevant data for comprehensive analysis.
