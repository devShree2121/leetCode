package BinaryTrees;

public class treeMethods {
    
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

public static int findHeight(Node root){
        if(root==null){return 0;}
    int leftHeight=findHeight(root.leftTreeNode);
    int rightHeight=findHeight(root.rightTreeNode);
    return Math.max(leftHeight,rightHeight)+1;
}
public static int totalNodes(Node root){
    if(root==null){return 0;}
int leftNodes=totalNodes(root.leftTreeNode);
int rightNodes=totalNodes(root.rightTreeNode);
return leftNodes+rightNodes+1;
}

public static int sumOfNodes(Node root){
    if(root==null){return 0;}

    int leftSum=sumOfNodes(root.leftTreeNode);
    int rightSum=sumOfNodes(root.rightTreeNode);
    return root.data +leftSum+rightSum;

}

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; // tree given in preorder  form

        BinaryTree tree=new BinaryTree();
        Node  root=tree.preOrderTree(nodes);
        System.out.println("Height of this tree is "+findHeight(root));
        System.out.println("Total Number of nodes are :" + totalNodes(root));
        System.out.println("sum of all Nodes is " + sumOfNodes(root));

    }
}
