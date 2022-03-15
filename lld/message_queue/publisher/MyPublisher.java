package lld.message_queue.publisher;

import lld.message_queue.Queue.QueueManager;
import lld.message_queue.message.Message;

public class MyPublisher implements Publisher {
    private String name;

    public MyPublisher(String publisherName) {
        this.name = publisherName;
    }

    public String getName() {
        return name;
    }

    @Override
    public void publish(String topicName, Message message, QueueManager qm) {
        qm.publish(topicName, message);
    }
}
