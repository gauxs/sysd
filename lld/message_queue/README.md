# Message Queuing System

Developing a message queueing system.

### Functional requirements

1. Create your own queue that will hold messages in the form of JSON(Standard library with queue implementation were not allowed).
2. There can be more than one queue at any given point of time.
3. There will be one publisher that can generate messages to a queue.
4. There are multiple subscribers that will listen to queues for messages.
5. Subscribers should not be tightly coupled to the system and can be added or removed at runtime.
6. When a subscriber is added to the system, It registers a callback function which makes an API call to the given end point with the json
   payload, this callback function will be invoked in case some message arrives.
7. Subscriber can consume the messages in batches if the queue has more than one message and it should be configurable.
8. There must be a retry mechanism for handling error cases when some exception occurs in listening/processing a message, that must be retried.

### Expectations

1. Make sure that you can execute the code and show that in a working state
2. Use an in-memory store for now. No need to use any database to store data
3. Make sure code functionality is correct, and edge cases are covered
4. Code should be easily testable
5. Exceptions are raised and handled appropriately.
6. Separation of concerns is addressed.

### Learnings

There are two major differences between Observer/Observable and Publisher/Subscriber patterns:

1. Observer/Observable pattern is mostly implemented in a synchronous way, i.e. the observable calls the appropriate method of all its observers when some event occurs(direct communication). The Publisher/Subscriber pattern is mostly implemented in an asynchronous way (using message queue, intermediary handles filtering and routing).

2. In the Observer/Observable pattern, the observers are aware of the observable. Whereas, in Publisher/Subscriber, publishers and subscribers don't need to know each other. They simply communicate with the help of message queues.

3. Further improvements: Handle exceptions, use native arrays instead of vectors and implement resize.

### Testcases

1. > TOPIC FOOD <br>
   > SUBSCRIBER FOOD RAM 2 <br>
   > SUBSCRIBER FOOD SHYAM 3 <br>
   > PUBLISHER DOMINOS <br>
   > PUBLISHER SUBWAY <br>
   > PUBLISH DOMINOS FOOD PIZZA1 <br>
   > PUBLISH SUBWAY FOOD SANDWICH1 <br>
   > PUBLISH DOMINOS FOOD PIZZA2 <br>
   > PUBLISH SUBWAY FOOD SANDWICH2 <br>
   > PUBLISH DOMINOS FOOD PIZZA3 <br>
   > PUBLISH SUBWAY FOOD SANDWICH3 <br>

2. > TOPIC FOOD <br>
   > TOPIC GAMES <br>
   > SUBSCRIBER GAMES GAUX 2 <br>
   > SUBSCRIBER FOOD SHYAM 1 <br>
   > SUBSCRIBER FOOD DHYAM 3 <br>
   > PUBLISHER DOMINOS <br>
   > PUBLISHER ACTIVISON <br>
   > PUBLISH DOMINOS FOOD PIZZA1 <br>
   > PUBLISH ACTIVISON GAMES GOD_OF_WAR <br>
   > PUBLISH DOMINOS FOOD PIZZA2 <br>
   > PUBLISH ACTIVISON GAMES ASSASSIN <br>
   > PUBLISH DOMINOS FOOD PIZZA3 <br>
   > PUBLISH ACTIVISON GAMES ELDEN_RING <br>

## References

1. [Leetcode - Navi machine coding round](https://leetcode.com/discuss/interview-question/1276596/Navi-or-SDE2-or-Machine-coding-round)
