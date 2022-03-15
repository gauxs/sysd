package lld.message_queue.message;

public class Message {
    private String message;

    public Message(String msg) {
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
