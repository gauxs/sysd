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

### Testcases

1. > ADDQ QUEUE1 5 1 <br>
   > ADDSUB QUEUE1 GAUX GAUX_CALLBACK 2 <br>
   > PUSH QUEUE1 MSG1 <br>
   > PUSH QUEUE1 MSG2 <br>
   > PUSH QUEUE1 MSG3 <br>
   > PUSH QUEUE1 MSG4 <br>
   > PUSH QUEUE1 MSG5 <br>
   > PUSH QUEUE1 MSG6 <br>
   > SIZE QUEUE1 <br>

2. > ADDQ QUEUE1 5 1 <br>
   > ADDSUB QUEUE1 GAUX GAUX_CALLBACK 2 <br>
   > ADDSUB QUEUE1 SHYAM SHYAM_CALLBACK 3 <br>
   > PUSH QUEUE1 MSG1 <br>
   > PUSH QUEUE1 MSG2 <br>
   > PUSH QUEUE1 MSG3 <br>
   > PUSH QUEUE1 MSG4 <br>
   > PUSH QUEUE1 MSG5 <br>
   > PUSH QUEUE1 MSG6 <br>
   > SIZE QUEUE1 <br>

## References

1. [Leetcode - Navi machine coding round](https://leetcode.com/discuss/interview-question/1276596/Navi-or-SDE2-or-Machine-coding-round)
