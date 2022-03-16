package lld.message_queue.Queue;

import java.util.*;
import lld.message_queue.message.Message;

public class Queue {
    private String name;
    private Vector<Message> store;

    public Queue(String queueName) {
        this.name = queueName;
        this.store = new Vector<>();
    }

    public String getName() {
        return name;
    }

    public Integer size() {
        synchronized (this.store) {
            return this.store.size();
        }
    }

    public void storeMessage(Message msg) {
        synchronized (this.store) {
            this.store.add(msg);
        }
    }

    public List<Message> getMessages(Integer lOffset, Integer rOffset) {
        return this.store.subList(lOffset, rOffset);
    }
}
