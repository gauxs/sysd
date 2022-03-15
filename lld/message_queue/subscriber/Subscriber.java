package lld.message_queue.subscriber;

import lld.message_queue.message.Message;

public class Subscriber {
    String name;
    Integer offset;
    Integer batchSize;

    public Subscriber(String subscriberName, Integer batchSize) {
        this.name = subscriberName;
        this.offset = 0; // index from where next unread message will be read
        this.batchSize = batchSize;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getBatchSize() {
        return batchSize;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void callback(Message msg) {
        System.out.println(this.name + ": " + msg.getMessage());
    }
}
