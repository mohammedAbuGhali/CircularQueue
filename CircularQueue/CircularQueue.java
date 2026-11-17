package CircularQueue;

public class CircularQueue<T> {

    private T[] queue; // array
    private int front;
    private int rear;
    private int capacity;// اقصى حد للدائرة
    private int size;

    public CircularQueue(int capacity) {
        this.queue = (T[]) new Object[capacity];
        this.front = 0;
        this.size = 0;
        this.rear = -1;
        this.capacity = capacity;

    }

    public void enqueue(T iteam) {
        if (isFull()) {
            System.out.println("CircularQueue isFull..");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = iteam;
        size++;
    }

    public T dequeue() {
        T iteam = null;
        if (isEmpty()) {
            System.out.println("CircularQueue isEmpty..");
            return null;
        } else {
            iteam = queue[front];
            front = (front + 1) % capacity;
            size--;
        }
        return iteam;
    }

    public T peek() {
        T iteam = null;
        if (isEmpty()) {
            System.out.println("CircularQueue isEmpty");
        } else {

            iteam = queue[front];
        }
        return iteam;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        CircularQueue<String> names = new CircularQueue<>(5);

        System.out.println("size : " + names.size());
        System.out.println("IsEmpty : " + names.isEmpty());
        System.out.println("IsFull : " + names.isFull());

        System.out.println("-----------------------------");
        names.enqueue("Huda");
        names.enqueue("Mohammed");
        names.enqueue("Ghali");
        names.enqueue("Ali");
        names.enqueue("Alaa");
        // names.enqueue("Olla");      result: CircularQueue IsFull
        int namesSize = names.size;
        for (int i = 0; i < namesSize; i++) {
            System.out.println("iteam : " + names.dequeue());
        }
        names.enqueue("Olla");
        System.out.println("-----------------------------");

        System.out.println("size : " + names.size());
        System.out.println("IsEmpty : " + names.isEmpty());
        System.out.println("IsFull : " + names.isFull());
    }

}
