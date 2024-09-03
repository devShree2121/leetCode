package leetCode.LinkedList;


// here i am implementing the linked list from scratch along with all methods

/**
 * scratchItn
 */
public class scratchImplementationLL{

    class Node{ // Creating the Node with some data and another reference Node. Initially Node points to null.

        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    public static Node head;
    public static Node tail;

    void printLinkedList(Node tempHead){

        Node temp=tempHead;

        while(temp!=null){
            System.out.print(temp.data + " -->");
            temp=temp.next;
        }
        System.out.print("null");
        System.out.println("");
    }
   
    // ADDING 

  void addFirst(int data){ // O(1)

    Node newNode= new Node(data); // to add a node in a list, we need to create the Node at first

    if(head==null){ // if there is no existing list, this new node is going to be added as head only
        head=newNode;
        return;
    }  
        newNode.next=head;
        head=newNode;

        }

        void addLast(int data){  //O(n)

            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
            }

            Node currNode=head;
           while(currNode.next!=null){ // traverse to last node to add newNode at end
            currNode=currNode.next;
           }
           currNode.next=newNode;
        //    newNode.next=null;

        }

        void addMiddle(int data,int index){   // adding a node at given index 

            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            int currIndex=0;
           Node currNode=head;

            while(currIndex!=index-1){
                currNode=currNode.next;
                currIndex++;
            }
            newNode.next=currNode.next;
            currNode.next=newNode;
     
        }

        // DELETING

        void deleteFirst(){
            if(head==null){
                System.out.print("List is empty");
                return;
            }
            
            head=head.next;

        }
        void deleteLast(){

            Node currNode=head;

            while(currNode.next.next!=null){

                currNode=currNode.next;
            }
            currNode.next=null;
        }

        

     public static void main(String[] args) {
        scratchImplementationLL list=new scratchImplementationLL();

        list.addFirst(3);
        list.addFirst(4);
        list.addLast(2);
        list.printLinkedList(head);

        list.addMiddle(5,2);

list.printLinkedList(head);

    //  list.deleteLast();
    list.deleteFirst();
    list.printLinkedList(head);
     }
}