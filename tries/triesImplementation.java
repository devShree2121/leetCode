package tries;

public class triesImplementation {
    static class Node{
        Node children[]=new Node[26];
        boolean endOfWord=false;

        Node(){

            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    public static Node root = new Node();


    public static void insert(String letter){
        Node currNode=root;

        for(int i=0;i<letter.length();i++){

            int idx=letter.charAt(i)-'a';
            if(currNode.children[idx]==null){
                currNode.children[idx]=new Node();
            }
            currNode=currNode.children[idx];
        }
        currNode.endOfWord=true;
    }

    public static boolean search(String word){

        Node currNode=root;

            for(int i=0;i<word.length();i++){

                int idx=word.charAt(i)-'a';

                if(currNode.children[idx]==null){
                    return false;
                }
                currNode=currNode.children[idx];
            }
            return currNode.endOfWord==true;
    }
    public static void main(String[] args) {
        String[] fruits = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};

        for(int i=0;i<fruits.length;i++){
            insert(fruits[i]);
        }
      System.out.println(  search("apple"));// returns true
      System.out.println(  search("applee")); // returns false
    }
}


