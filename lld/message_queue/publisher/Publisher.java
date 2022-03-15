package lld.message_queue.publisher;

import lld.message_queue.Queue.QueueManager;
import lld.message_queue.message.Message;

public interface Publisher {
    void publish(String topicName, Message message, QueueManager qm);
}
