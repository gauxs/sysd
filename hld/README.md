# Common concepts
Three concerns that are important in most software systems:
1. **Reliability**: Tolerating hardware and software faults and human errors. The system should continue to work correctly (performing the correct function at the desired level of performance) even in the face of adversity (hardware or software faults, and even human error)
2. **Scalability**: Measuring load and performance, latency percentiles & throughput. As the system grows (in data volume, traffic volume, or complexity), there should be reasonable ways of dealing with that growth.
3. **Maintainability**: Operability, simplicity & evolvability. Over time, many different people will work on the system (engineering and operations, both maintaining current behavior and adapting the system to new usecases), and they should all be able to work on it productively.

### Performance
Performance is characterized by the amount of useful work accomplished by a computer system compared to the time and resources used. Depending on the context, this may involve achieving one or more of the following:

1. short response time/low latency for a given piece of work
2. high throughput (rate of processing work)
3. low utilization of computing resource(s)

### Availability
Availability is the proportion of time a system is in a functioning condition. If a user cannot access the system, it is said to be unavailable.

### Fault tolerence
The things that can go wrong are called faults, and systems that anticipate faults and can cope with them are called fault-tolerant or resilient. The former term is slightly misleading: it suggests that we could make a system tolerant of every possible kind of fault, which in reality is not feasible.

Note that a fault is not the same as a failure. A fault is usually defined as one component of the system deviating from its spec, whereas a failure is when the system as a whole stops providing the required service to the user. It is impossible to reduce the probability of a fault to zero; therefore it is usually best to design fault-tolerance mechanisms that prevent faults from causing failures.

### Backward vs Forward compatibility
- Backward compatibility - Newer code can read data that was written by older code
- Forward compatibility - Older code can read data that was written by newer code
