package lld.message_queue.Queue;

public class Subscriber {
    String name;
    String callBack;
    Integer batchSize;
    Integer myQueueFront;

    Subscriber(String subscriberName, String callback, Integer batchSize, Integer queueNextEnd) {
        this.name = subscriberName;
        this.callBack = callback;
        this.batchSize = batchSize;
        this.myQueueFront = queueNextEnd;
    }

    public Integer getQueueFront() {
        return this.myQueueFront;
    }

    private Integer numberOfElements(Integer queueEnd, Integer capacity) {
        if (this.myQueueFront <= queueEnd) {
            return Math.abs(queueEnd - this.myQueueFront + 1);
        } else {
            return Math.abs(capacity - this.myQueueFront) + queueEnd;
        }
    }

    public Integer eligibleForCallback(Integer queueEnd, Integer capacity) {
        if (numberOfElements(queueEnd, capacity) == this.batchSize) {
            Integer oldMyQueueFront = this.myQueueFront;
            this.myQueueFront = (queueEnd + 1) % capacity;
            return oldMyQueueFront;
        }

        return -1;
    }

    public void doCallback(String message) {
        System.out.println(this.name + ": " + this.callBack + message);
    }
}
