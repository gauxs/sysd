package lld.message_queue.Queue;

import java.util.*;

public class Queue {
    String name;
    Integer capacity;
    List<String> store;
    Integer defaultBatchSize;
    Integer queueFront, queueEnd;
    HashMap<String, Subscriber> subscribers;
}
