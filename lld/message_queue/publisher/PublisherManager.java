package lld.message_queue.publisher;

import java.util.concurrent.ConcurrentHashMap;

public class PublisherManager {
    private ConcurrentHashMap<String, Publisher> publishers;

    public PublisherManager() {
        this.publishers = new ConcurrentHashMap<>();
    }

    public void registerPublisher(String publisherName) {
        this.publishers.put(publisherName, new MyPublisher(publisherName));
    }

    public Publisher getPublisher(String publisherName) {
        return this.publishers.get(publisherName);
    }
}
