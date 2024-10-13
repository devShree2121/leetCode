package BinaryTrees;

import java.util.ArrayList;

public class LowestCommonAncesstor {
    
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }
    static public int idx=-1;
    public static Node insert(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode= new Node(nodes[idx]);
        newNode.left=insert(nodes);
        newNode.right=insert(nodes);
        return newNode;
    }


    public static boolean findPath(Node root,int n,ArrayList<Node> path){
        if(root==null){return false;}
        path.add(root);

        if(root.data==n){
          
            return true;
        }

        boolean foundLeft=findPath(root.left, n, path);
        boolean foundRight=findPath(root.right, n, path);

        if(foundLeft || foundRight){
            return true;
        }
        path.remove(root);
        return false;
    }
    
    public static Node lowestCA(Node root,int n1,int n2){


        ArrayList<Node> path1= new ArrayList<>();
        ArrayList<Node> path2= new ArrayList<>();

        findPath(root,n1,path1);
        findPath(root,n2,path2);
        int i=0;
        for(;i<path1.size() && i<path2.size();i++){

            if(path1.get(i)!=path2.get(i)){
           
                break;
            }
        }

        return      path1.get(i-1);

    }

    public static Node lcaOptimal(Node root,int n1,int n2){

        if(root==null || root.data==n1 || root.data==n2){
            return root;
        }

        Node leftLca=lcaOptimal(root.left, n1, n2);
        Node rightLca=lcaOptimal(root.right, n1, n2);

        if(leftLca==null){
            return rightLca;
        }
        if(rightLca==null){
            return leftLca;
        }

        return root;

    }
    public static void main(String[] args) {

        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

      
        Node base=insert(nodes);
     
            Node bruteForceLca=lowestCA(base,4,5);
            System.out.println(bruteForceLca.data); // 2
      Node Optimallca=lcaOptimal(base, 4, 5);
      System.out.println(Optimallca.data); // 2



    }
}
