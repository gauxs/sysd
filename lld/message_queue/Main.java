package lld.message_queue;

import java.util.Scanner;

import lld.message_queue.Queue.QueueManager;
import lld.message_queue.message.Message;
import lld.message_queue.publisher.MyPublisher;
import lld.message_queue.publisher.Publisher;
import lld.message_queue.publisher.PublisherManager;
import lld.message_queue.subscriber.Subscriber;

public class Main {
    public static void main(String[] args) {
        System.out.println("Message Queue 1.0");

        QueueManager qm = new QueueManager();
        Thread qmTHread = new Thread(qm);
        qmTHread.start();

        PublisherManager pm = new PublisherManager();
        Scanner in = new Scanner(System.in);
        while (true) {
            switch (in.next()) {
                case "TOPIC": {
                    qm.registerTopic(in.next());
                    break;
                }
                case "SUBSCRIBER": {
                    qm.addSubscriber(in.next(), new Subscriber(in.next(), in.nextInt()));
                    break;
                }
                case "PUBLISHER": {
                    pm.registerPublisher(in.next());
                    break;
                }
                case "PUBLISH": {
                    Publisher pub = pm.getPublisher(in.next());
                    pub.publish(in.next(), new Message(in.next()), qm);
                    break;
                }
            }
        }
    }
}
