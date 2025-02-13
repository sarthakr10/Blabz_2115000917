import java.util.*;

public class StackSort {

    // sortStack
    public static void sortStack(Stack<Integer> stack){
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack,temp);
        }
    }

    // insertSorted
    public static void insertSorted(Stack<Integer> stack , int element){
        if (stack.isEmpty() || stack.peek()<= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, temp);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stackk" + stack);
    }
}