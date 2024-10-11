
package BinaryTrees;
import java.util.*;


public class topView {
    static class Node{
        int data;
        Node leftTreeNode;
        Node rightTreeNode;
    
        Node(int data){
            this.data=data;
            this.leftTreeNode=null;
            this.rightTreeNode=null;
        }
    }

    static class NodeInfo{
        int horizontalDistance;
        Node node;

        NodeInfo(Node node,int horizontalDistance){
            this.node=node;
            this.horizontalDistance=horizontalDistance;
        }

    }
    public static void topViewTree(Node root){

       Queue<NodeInfo> q= new LinkedList<>();
       Map<Integer,Node> map=new HashMap<>();

       q.add(new NodeInfo(root, 0));
       q.add(null);
       int hd=0;
       int min=0;
       int max=0;



       while(!q.isEmpty()){

        NodeInfo curr=q.remove();

        if(curr==null){

            if(q.isEmpty()){break;}
            else{
                q.add(null);
            }
        }
        else{

            if(!map.containsKey(curr.horizontalDistance)){
                map.put(curr.horizontalDistance, curr.node);
            }
            if(curr.node.leftTreeNode!=null){
                q.add(new NodeInfo(curr.node.leftTreeNode,curr.horizontalDistance-1));
                min=Math.min(min,curr.horizontalDistance-1);
            }
            if(curr.node.rightTreeNode!=null){
                q.add(new NodeInfo(curr.node.rightTreeNode,curr.horizontalDistance+1));
                max=Math.max(min,curr.horizontalDistance+1);
            }
        }
       }

       for(int i=0;i<=max;i++){
        System.out.print(map.get(i).data+" ");
       }

       

    }
    public static void printTree(Node  root,int level,int k) { // function to print tree at a given level

        if(root==null){return  ;
        }
        printTree(root.leftTreeNode,level+1,k);
        if(level==k){
        
        System.out.println(root.data);
        return;
    }
        printTree(root.rightTreeNode,level+1,k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.leftTreeNode=new Node(2);
        root.rightTreeNode=new Node(3);
        root.leftTreeNode.leftTreeNode=new Node(4);
        root.leftTreeNode.rightTreeNode=new Node(5);
        root.rightTreeNode.rightTreeNode=new Node(6);

        printTree(root,1,3); // printing tree  at level 3
        topViewTree(root);

      

        

    }
}
