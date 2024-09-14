package leetCode.Queues;

// Here the queue is implemented by using Linked List which gives the desired Complexity of O(1) for add,remove and peek operations.

public class LLqueue {
    
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
   static class LinkedListQueues{

    static Node front=null;
    static Node rear=null;

    public static boolean isEmpty(){
        return front==null;
    }

    public static void add(int data){
        Node newNode=new Node(data);

        if(isEmpty()){

            front=newNode;
            rear=newNode;
            return;
        }   

        rear.next=newNode;
        rear=newNode;

   }

   public static int remove(){
    if(isEmpty()){
    System.out.println("Queue is empty");
        return -1;
    } 
    Node deletedElement=front;
    front=front.next;
    return deletedElement.data;
    
   }

   public static int peek(){
    if(isEmpty()){
        System.out.println("Queue is empty");
            return -1;
        } 
        return front.data;
   }
}

    
    public static void main(String[] args) {
        
        LinkedListQueues q=new LinkedListQueues();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}


