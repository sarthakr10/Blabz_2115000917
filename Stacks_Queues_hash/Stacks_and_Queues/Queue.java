import java.util.*;

class QueueUsingStacks{
    private Stack<Integer> pushstack;
    private Stack<Integer> popstack;

    public QueueUsingStacks(){
        pushstack = new Stack<>();
        popstack = new Stack<>();
    }

    public void enqueue(int data){
        pushstack.push(data);
    }

    public int dequeue(){
        if (popstack.isEmpty()) {
            if (pushstack.isEmpty()) {
                throw new RuntimeException("Queue is Empty");
            }
            else{
                while (!pushstack.isEmpty()) {
                    popstack.push(pushstack.pop());
                }
            }
        }
        return popstack.pop();
    }
    public boolean isEmpty(){
        return pushstack.isEmpty() && popstack.isEmpty();
    }
}

public class Queue {


    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        System.out.println("Enter Data is the Queue");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        
        System.out.println("Dequeue : ");
        while (!queue.isEmpty()) {
            System.out.print(queue.dequeue() + "  ");
        }
    }    
}