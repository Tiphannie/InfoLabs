package funwithcalculators3;

public class QueueAsList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node front;
    private Node rear;

    public QueueAsList() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void empty() {
        front = null;
        rear = null;
    }

    public void enqueue(Integer obj) {
        Node newNode = new Node(obj);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("QueueUnderFlow");
        }
//        int data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }

    public Integer front() {
        if (isEmpty()) {
            throw new RuntimeException("QueueUnderFlow");
        }
        return front.data;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node tmp = front;
        while (tmp != null) {
            sb.append(tmp.data);
            tmp = tmp.next;
            if (tmp != null) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
