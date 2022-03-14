package lld.message_queue.QueueManager;

import java.util.HashMap;

import lld.message_queue.Queue.Queue;

public class QueueManager {
    private static HashMap<String, Queue> queues = new HashMap<>();

    public void addQueue(String queueName, Integer capacity, Integer defaultBatchSize) {
        Queue q = new Queue(queueName, capacity, defaultBatchSize);
        this.queues.put(queueName, q);
    }

    public void addSubscriber(String queueName, String subscriberName, String callback, Integer batchSize) {
        Queue q = this.queues.get(queueName);
        q.addSubscriber(subscriberName, callback, batchSize);
    }

    public void push(String queueName, String message) {
        Queue q = this.queues.get(queueName);
        q.push(message);
    }

    public void getQueueSize(String queueName) {
        Queue q = this.queues.get(queueName);
        System.out.println("Number of elements in queue " + queueName + ": " + q.numberOfElements());
    }
}
