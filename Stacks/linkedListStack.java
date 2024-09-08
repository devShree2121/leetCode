package leetCode.Stacks;

public class linkedListStack {
    
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head=null;
    public static class stack{
       
         static boolean isEmpty(){
            return head==null;
        }

         static void push(int data){
            Node newNode=new Node(data);
            if(isEmpty()){
                head=newNode;
            }
            else{
                newNode.next=head;
                head=newNode;
            }
        
        }

        static int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            Node deletedNode=head;
            head=head.next;
            return deletedNode.data;
        }

        static int peek(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            return head.data;
        }

        static void printStack(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data + " ->");
                temp=temp.next;
            }
            System.out.println("Null");
        }
    }

    public static void main(String[] args) {
        stack llStack=new stack();
        llStack.push(1);
        llStack.push(2);
        llStack.push(3);
        llStack.push(4);

        System.out.println(llStack.peek()); // returns 4 as it is on the top of stack

        llStack.pop(); // now deletes that same 4 to follow LIFO- Last in First Out

        System.out.println(llStack.peek());      // returns 3  
       
        // llStack.printStack();  
    }
}
