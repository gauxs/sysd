package lld.actor_system.message;

import lld.actor_system.actor.ActorOperation;

public class Message {
    private String logMessage;
    private String destActorName; // message intended for another actor
    private String actorToCreateName; // message to create actor
    private Message msgToDeliver; // msg to deliver in case of destActorName
    private ActorOperation operation;

    public Message(ActorOperation op) {
        this.operation = op;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public Message getMsgToDeliver() {
        return msgToDeliver;
    }

    public String getActorToCreateName() {
        return actorToCreateName;
    }

    public String getDestActorName() {
        return destActorName;
    }

    public ActorOperation getOperation() {
        return operation;
    }
}
