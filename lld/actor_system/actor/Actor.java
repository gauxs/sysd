package lld.actor_system.actor;

import java.util.concurrent.ConcurrentLinkedQueue;

import lld.actor_system.actor_system.ActorSystem;
import lld.actor_system.message.Message;

public class Actor {
    private String name;
    private ActorSystem actorSystem;
    private ConcurrentLinkedQueue<Message> mailBox;

    public Actor(String name, ActorSystem actorSystem) {
        this.name = name;
        this.actorSystem = actorSystem;
        this.mailBox = new ConcurrentLinkedQueue<>();
    }

    public String getName() {
        return name;
    }

    // called on main thread and by other actors on scheduler thread
    public void addMessage(Message msg) {
        this.mailBox.add(msg);
    }

    // called on scheduler thread
    public void readMailBox() {
        if (this.mailBox.isEmpty())
            return;

        Message msg = this.mailBox.poll();
        switch (msg.getOperation()) {
            case SEND: {
                Actor destActor = this.actorSystem.getActor(msg.getDestActorName());
                if (destActor == null) {
                    System.err
                            .println("actor " + this.name + " unable to send message to actor " + msg.getDestActorName()
                                    + ", actor does not exist!");
                    return;
                }

                destActor.addMessage(msg.getMsgToDeliver());
                break;
            }
            case CHANGE: {
                System.out.println("actor " + this.name + " performing some change operation!!");
                break;
            }
            case CREATE: {
                this.actorSystem.addActor(msg.getActorToCreateName());
                System.out.println("actor " + this.name + " successfully created actor " + msg.getActorToCreateName());
                break;
            }
            case LOG: {
                System.out.println("actor " + this.name + " received log message: " + msg.getLogMessage());
                break;
            }
        }
    }
}
