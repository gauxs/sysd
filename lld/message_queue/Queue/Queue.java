package lld.message_queue.Queue;

import java.util.*;

public class Queue {
    String name;
    Integer capacity;
    List<String> store;
    Integer defaultBatchSize;
    Integer queueFront, queueEnd;
    HashMap<String, Subscriber> subscribers;

    public Queue(String queueName, Integer capacity, Integer defaultBatchSize) {
        this.name = queueName;
        this.capacity = capacity;
        this.store = new ArrayList<>();
        for (int i = 0; i < this.capacity; i++) {
            this.store.add("");
        }
        this.defaultBatchSize = defaultBatchSize;
        this.subscribers = new HashMap<>();
        this.queueEnd = -1;
        this.queueFront = 0;
    }

    public Integer numberOfElements() {
        if (this.queueEnd >= this.queueFront) {
            return Math.abs(this.queueEnd - this.queueFront) + 1;
        } else {
            return Math.abs(this.capacity - this.queueFront) + this.queueEnd;
        }
    }

    public void addSubscriber(String subscriberName, String callback, Integer batchSize) {
        if (this.capacity <= (batchSize * 2)) {
            this.resize();
        }

        Subscriber s = new Subscriber(subscriberName, callback, batchSize, (this.queueEnd + 1) % this.capacity);
        this.subscribers.put(subscriberName, s);
    }

    public void push(String message) {
        this.queueEnd = (this.queueEnd + 1) % this.capacity;
        this.store.add(this.queueEnd, message);

        invokeCallbacks();
        flushOldEntries();
    }

    private void invokeCallbacks() {
        for (Map.Entry<String, Subscriber> sub : this.subscribers.entrySet()) {
            Subscriber s = sub.getValue();
            Integer subscriberQueueFront = s.eligibleForCallback(this.queueEnd, this.capacity);
            if (subscriberQueueFront != -1) {
                String message = "";
                while (subscriberQueueFront != this.queueEnd) {
                    message += this.store.get(subscriberQueueFront) + " ";
                    subscriberQueueFront = (subscriberQueueFront + 1) % this.capacity;
                }

                message += this.store.get(subscriberQueueFront);
                s.doCallback(message);
            }
        }
    }

    private void flushOldEntries() {
        Integer toFlush = Integer.MAX_VALUE;
        Integer toFlushIndex = 0;
        for (Map.Entry<String, Subscriber> sub : this.subscribers.entrySet()) {
            Subscriber s = sub.getValue();
            Integer subQueueFront = s.getQueueFront();
            if (this.queueEnd >= subQueueFront) {
                if (Math.abs(this.queueEnd - subQueueFront + 1) <= toFlush) {
                    toFlushIndex = subQueueFront;
                }
            } else {
                if ((Math.abs(this.capacity - subQueueFront) + this.queueEnd) <= toFlush) {
                    toFlushIndex = subQueueFront;
                }
            }
        }

        this.queueFront = toFlushIndex;
    }

    private void resize() {

    }

    public void removeSubscribers() {

    }

}
