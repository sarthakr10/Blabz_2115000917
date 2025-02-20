import java.util.Arrays;

class circularbuffer {
    private int[] buffer;
    private int size, front, rear, count;

    public circularbuffer(int size) {
        this.size = size;
        this.buffer = new int[size];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public void enqueue(int value) {
        rear = (rear + 1) % size;  
        buffer[rear] = value;

        if (count < size) {
            count++;
        } else {  
            front = (front + 1) % size;
        }
    }

    public int dequeue() {
        if (count == 0) {
            throw new RuntimeException("Buffer is empty");
        }
        int value = buffer[front];
        front = (front + 1) % size;
        count--;
        return value;
    }

    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            System.out.print(buffer[(front + i) % size] + (i < count - 1 ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        circularbuffer cb = new circularbuffer(3);

        cb.enqueue(1);
        cb.enqueue(2);
        cb.enqueue(3);
        cb.display();

        cb.enqueue(4);
        cb.display(); 

        cb.dequeue();
        cb.display(); 
    }
}