package lld.message_queue;

import java.util.Scanner;

import lld.message_queue.QueueManager.QueueManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Message Queue 1.0");

        QueueManager qm = new QueueManager();
        Scanner in = new Scanner(System.in);

        while (true) {
            switch (in.next()) {
                case "ADDQ": {
                    qm.addQueue(in.next(), in.nextInt(), in.nextInt());
                    break;
                }
                case "ADDSUB": {
                    qm.addSubscriber(in.next(), in.next(), in.next(), in.nextInt());
                    break;
                }
                case "PUSH": {
                    qm.push(in.next(), in.next());
                    break;
                }
                case "SIZE": {
                    qm.getQueueSize(in.next());
                    break;
                }
            }
        }
    }
}
