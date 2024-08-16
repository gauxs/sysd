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
**Load** on a system can be described via *load paramenters*. The best choice of parameters depends on the architecture of the system. Example: requests/second of a web server, ratio of reads to writes in a database, number of simultaneous users in a chat room.

### Describing performance of a system

## Maintainability
