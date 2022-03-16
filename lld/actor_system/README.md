# Actor System

Implement an actor system that contains a set of actors.

### Functional requirements

An actor is a lightweight execution context. An actor system is a collection of actors that can execute concurrently in a shared nothing fashion. In an actor system each actor has a mailbox with an address where it receives messages. On receiving a message from its mailbox an actor can:

1. Send messages to other actors in the system
2. Create a finite number of new actors in the system
3. Change its own state
4. Have side effects (print something, log something, change external durable state)

An actor can process only one message at a time. The lightweight nature of actors means one can create millions of actors that execute concurrently even on systems with modest hardware capacity.

#### Actor Description

1. Actor has a unique address in an ActorSystem
2. Actor has a finite sized mailbox to receive messages in FIFO order
3. Actor can be shut down, after which it doesn't accept/receive any messages in its mailbox

#### Actor System Description

1. Is initialized with a finite threadpool size
2. Receives messages for actors that it contains
3. Executes actors that have messages to process using fair scheduling (actors don't starve)
4. Can be shut down, after which the actor system doesn't accept/relay any new messages
5. Shut down all it's actors once they have processed all their remaining messages
6. Throws appropriate exception if a message cannot be delivered
7. All actors should execute concurrently in a thread safe manner

### Guidelines

1. The code should be modular and testable
2. Provide at least one test case and demonstrate the working of your code
3. State any assumptions you make
4. Thread Safe code

## References

1. [Leetcode - Flipkart machine coding](https://leetcode.com/discuss/interview-question/1344241/Flipkart-Machine-coding-round)
