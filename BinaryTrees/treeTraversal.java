package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class treeTraversal {

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

    static class  BinaryTree{
             static int idx=-1;
        public static  Node preOrderTree(int nodes[]){ // building tree using preOrder traversal (root->left->right)
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.leftTreeNode=preOrderTree(nodes);
            newNode.rightTreeNode=preOrderTree(nodes);
            return newNode;
        }
    }
        public static void inOrder(Node root){
            
            if(root==null){
                return;
            }
            inOrder(root.leftTreeNode);
            System.out.print(root.data+" ");
            inOrder(root.rightTreeNode);
        }

        public static void postOrder(Node  root){
            
            if(root==null){
                return;
            }
            postOrder(root.leftTreeNode);
postOrder(root.rightTreeNode);
System.out.print(root.data + " ");
        }

        public static void levelOrderTraversal(Node root){ // level order traversal using  queue's first in first out property to track the level of tree.



Queue<Node> q= new LinkedList<>();
q.add(root);
q.add(null);

while(!q.isEmpty()){

	Node currNode= q.remove();

	if(currNode==null){
		
	System.out.println(" ");

		if(q.isEmpty()){ break;}
		
		else{q.add(null);}

}
else{

System.out.print(currNode.data);
if(currNode.leftTreeNode!=null){
q.add(currNode.leftTreeNode);}
if(currNode.rightTreeNode!=null){
q.add(currNode.rightTreeNode);
}
}


}


}

    
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; // tree given in preorder  form

        BinaryTree tree=new BinaryTree();
        Node  root=tree.preOrderTree(nodes);
        // System.out.println(root.data); // if one is printed then when have successfully created the tree.
        //     inOrder(root);
        // System.out.println();
        // postOrder(root);

        levelOrderTraversal(root);
    }
}
