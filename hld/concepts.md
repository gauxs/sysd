Three concerns that are important in most software systems:
1. **Reliability**: Tolerating hardware and software faults and human errors. The system should continue to work correctly (performing the correct function at the desired level of performance) even in the face of adversity (hardware or software faults, and even human error)
   
2. **Scalability**: Measuring load and performance, latency percentiles & throughput. As the system grows (in data volume, traffic volume, or complexity), there should be reasonable ways of dealing with that growth.
   
3. **Maintainability**: Operability, simplicity & evolvability. Over time, many different people will work on the system (engineering and operations, both maintaining current behavior and adapting the system to new usecases), and they should all be able to work on it productively.

## Reliability
A *fault* is not the same as *failure*. A fault is usually defined as one component of the system deviating from its spec, whereas a failure is when the system as a whole stops providing the required service to the user.

The system that anticipates faults and can cope with them are called *fault-tolerant* or *resilient*.

1. Hardware Faults: 
2. Software Faults: Bugs
3. Human Faults: Manual configuration error

## Scalability
### Describing load on a system
**Load** on a system can be described via *load paramenters*. The best choice of parameters depends on the architecture of the system. Example: requests/second of a web server, ratio of reads to writes in a database, number of simultaneous users in a chat room. For Twitter, the distribution of followers per user (possibly weighted by how often those users tweet) is a key load parameter for discussing scalability, since it determines the fan-out load.

### Describing performance of a system
1. Batch processing system: Number of records we can process per second or the total time it takes to run a job on a dataset of a certain size
2. Online systems: Service's response time [^1][^2]

The architecture of systems that operate at large scale is usually highly specific to the application—there is no such thing as a generic, one-size-fits-all scalable architecture (informally known as magic scaling sauce). The problem may be the volume of reads, the volume of writes, the volume of data to store, the complexity of the data, the response time requirements, the access patterns, or (usually) some mixture of all of these plus many more issues.

For example, a system that is designed to handle 100,000 requests per second, each 1 kB in size, looks very different from a system that is designed for 3 requests per minute, each 2 GB in size—even though the two systems have the same data throughput.

## Maintainability
Majority of the cost of software is not in its initial development, but in its ongoing maintenance—fixing bugs, keeping its systems operational, investigating failures, adapting it to new platforms, modifying it for new use cases, repaying technical debt, and adding new features.

[^1]: Latency vs Response Time: The **response time** is what the client sees: besides the actual time to process the request (the service time), it includes network delays and queueing delays. **Latency** is the duration that a request is waiting to be handled - during which it is latent, awaiting service.

[^2]: **Queueing delays** often account for large part of the response time at high percentiles. As a server can only process a small number of things in parallel(limited, for example, by its number of CPU cores), it only takes a small number of slow requests to hold up the processing of subsequent requests - an effect sometimes known as *head-of-line blocking*.
