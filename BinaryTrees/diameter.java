package BinaryTrees;

public class diameter {
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

    public static int findHeight(Node  root){

        if(root==null){return 0;}
        int leftHeight=findHeight(root.leftTreeNode);
        int rightHeight=findHeight(root.rightTreeNode);
        
    return Math.max(Math.max(leftHeight,rightHeight),(leftHeight+rightHeight+1));
    }
    public static int findDiameter(Node root) { // this is brute  force approach which time complexity runs to O(n^2)

        // so we can have 3 cases i.e . left subtree is the longest, right subtree is the longest or the longest  path is the one which is root to leaf.


        if(root==null){return 0;}
        int leftHeight=findHeight(root.leftTreeNode);
        int rightHeight=findHeight(root.rightTreeNode);
        int leftDiameter=findDiameter(root.leftTreeNode);
        int rightDiameter=findDiameter(root.rightTreeNode);
        int diamThrougRoot=leftHeight+rightHeight+1;
        return Math.max(diamThrougRoot,Math.max(leftDiameter,rightDiameter));
    }
    public static int diameter=0;
    public static int optimalDiameter(Node root){ // This  is the optimal solution which runs in O(n) time complexity which calculates the height  of the tree in one pass and then calculates the diameter in one pass.




            if(root==null){return 0;}
            int leftHeight=findHeight(root.leftTreeNode);
            int rightHeight=findHeight(root.rightTreeNode);

            diameter=Math.max(diameter,(leftHeight+rightHeight+1));
            return 1+ Math.max(leftHeight,rightHeight);
    }
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1}; // tree given in preorder  form

        BinaryTree tree=new BinaryTree();
        Node  root=tree.preOrderTree(nodes);
        System.out.println("Diameter of the tree is: "+findHeight(root));
        optimalDiameter(root);
        System.out.println("Optimal Diameter of the tree is: "+diameter);
    }
}
