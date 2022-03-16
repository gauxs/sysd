package lld.actor_system.scheduler;

import java.util.LinkedList;
import java.util.Queue;

import lld.actor_system.actor.Actor;

public class Scheduler implements Runnable {
    private Queue<Actor> schedule;

    public Scheduler() {
        this.schedule = new LinkedList<>();
    }

    // round robin based scheduling
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                Actor a = this.schedule.poll();
                a.readMailBox();
                this.schedule.add(a);
            }
        } catch (Exception e) {
            System.err.println("[FATAL] exception in scheduler: " + e.getMessage());
        }
    }
}
