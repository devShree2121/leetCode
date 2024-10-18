package BST;

public class binarySearchTree {

    static class Node{

        int data;
        Node left;
        Node right;

        Node(int data){
            this.data=data;
        }
    }

    public static Node insert(Node root,int val){

        if(root==null){
            return new Node(val);
        }

        if(val>root.data){
            root.right=insert(root.right, val);
        }
        else{
            root.left=insert(root.left, val);
        }
        return root;

    }
    public static void search(Node root,int key){
            if(root==null){
                System.out.println("Not found in tree");
                return;
            }
        if(root.data==key){
            System.out.println("Found the key :" + key);
            return;
        }
        if(key>root.data){
            search(root.right, key);
        }else{
            search(root.left, key);
        }
    }
    public static void inOrder(Node root){

        if(root==null){return;}

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void printInRange(Node root, int m, int n) {
        if (root == null) {
            return;
        }
    
        // Check if the current node's value falls within the range [m, n]
        if (root.data >= m && root.data <= n) {
            // Print the left subtree values within the range
            printInRange(root.left, m, n);
            // Print the current node's value
            System.out.print(root.data + " ");
            // Print the right subtree values within the range
            printInRange(root.right, m, n);
        } else if (root.data < m) {
            // If root's data is less than m, skip the left subtree and go to the right subtree
            printInRange(root.right, m, n);
        } else {
            // If root's data is greater than n, skip the right subtree and go to the left subtree
            printInRange(root.left, m, n);
        }
    }
    
    public static void main(String[] args) {
        
        int values[]={2,1,3,5,6,4};
        Node root=null;

        for(int i=0;i<values.length;i++){
            root=insert(root, values[i]);
        }
        // inOrder(root);
        // search(root, 4);
        
        // inOrder(root);
        printInRange(root, 3, 5);

    }
}
