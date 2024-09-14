package leetCode.Stacks;

import java.util.*;

public class twoQueueStack {

    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        return top;
                    }
                    q2.add(top);
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        return top;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        public static int peek() {
            int top = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);  // Add it back to q2 to preserve the stack
                }
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);  // Add it back to q1 to preserve the stack
                }
            }
            return top; // Return the top element without removing it
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(5);
        s.push(6);
        s.push(7);
        System.out.println(s.peek()); // This will print the top element, 7
        System.out.println(s.pop());  // This will remove and return 7
        System.out.println(s.peek()); // This will print the new top element, 6
    }
}

