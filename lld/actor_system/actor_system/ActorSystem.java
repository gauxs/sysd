package lld.actor_system.actor_system;

import java.util.concurrent.ConcurrentHashMap;

import lld.actor_system.actor.Actor;
import lld.actor_system.message.Message;

public class ActorSystem {
    private ConcurrentHashMap<String, Actor> actors;

    public ActorSystem() {
        this.actors = new ConcurrentHashMap<>();
    }

    public void addActor(String actorName) {
        this.actors.put(actorName, new Actor(actorName, this));
    }

    public Actor getActor(String actorName) {
        return this.actors.get(actorName);
    }

    public void deliverMessage(String actorName, Message msg) {
        Actor a = this.actors.get(actorName);
        if (a == null) {
            System.err.println("[ERROR] cannot deliver message,actor " + actorName + " doesn't exist!");
            return;
        }

        a.addMessage(msg);
    }

    public void shutdown() {
    }
}
