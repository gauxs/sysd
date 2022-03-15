package lld.message_queue.Queue;

import java.util.*;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import lld.message_queue.message.Message;
import lld.message_queue.subscriber.Subscriber;

public class QueueManager implements Runnable {
    private ConcurrentHashMap<String, Queue> topics = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Vector<Subscriber>> subscribers = new ConcurrentHashMap<>();

    public QueueManager() {
        this.topics = new ConcurrentHashMap<>();
        this.subscribers = new ConcurrentHashMap<>();
    }

    public void registerTopic(String topicName) {
        this.topics.put(topicName, new Queue(topicName));
    }

    public void addSubscriber(String topicName, Subscriber subscriber) {
        Vector<Subscriber> subs = this.subscribers.get(topicName);
        if (subs == null) {
            subs = new Vector<>();
            this.subscribers.put(topicName, subs);
        }

        subscriber.setOffset(this.topics.get(topicName).size());
        subs.add(subscriber);
    }

    public void publish(String topicName, Message msg) {
        Queue q = topics.get(topicName);
        q.storeMessage(msg);
    }

    private void dispatch() {
        for (Map.Entry<String, Queue> entry : this.topics.entrySet()) {
            Queue topic = entry.getValue();
            Integer topicCurOffset = topic.size();

            if (topicCurOffset == 0)
                continue;

            Vector<Subscriber> subs = this.subscribers.get(entry.getKey());
            for (Subscriber sub : subs) {
                Integer subscriberCurOffset = sub.getOffset();
                Integer subscriberBatchSize = sub.getBatchSize();
                if ((topicCurOffset - subscriberCurOffset) >= subscriberBatchSize) {
                    List<Message> topicMsgs = topic.getMessages(subscriberCurOffset, topicCurOffset);
                    for (Message m : topicMsgs) {
                        sub.callback(m);
                    }
                    sub.setOffset(subscriberCurOffset + subscriberBatchSize);
                }
            }
        }
    }

    public void run() {
        System.out.println("Starting dispatch process");
        while (true) {
            try {
                dispatch();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
