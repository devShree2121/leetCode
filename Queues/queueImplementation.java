package leetCode.Queues;

public class queueImplementation {
    
    //This queue is implemented by using the Array but there is small constraint with array which is it's constant size, due to which the length of queue is also constant.And also the complexity for removing an element is also O(n) which is not desired complexity. 
    static class Arrayqueue{

        static int [] arr;
         static int size;
         static int rear;

         Arrayqueue(int n){
            arr=new int[n];
            rear=-1;
            size=n;
         }

         public  static boolean isEmpty(){
            return rear==-1;
         }
         //Adding operation O(1)
         public static void add(int data){
            if(rear==size-1){
                System.out.println("Queue is empty");
                return;
            }
            rear=rear+1;
            arr[rear]=data;
         }
            //remove operation O(n)

         public static int remove(){
            if(Arrayqueue.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int deletedElement=arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear=rear-1;
           return deletedElement;
         }
          
         // peeking or searching operation O(1)
         public static int peek(){
            if(Arrayqueue.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return arr[0];
         }



    }

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
        
        Arrayqueue q=new Arrayqueue(5);
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
