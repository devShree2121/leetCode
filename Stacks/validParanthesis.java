package leetCode.Stacks;
import java.util.Stack;
public class validParanthesis {
  
        public static boolean isValid(String s) {
            Stack<Character> myStack=new Stack<>();
    
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
    
                if(ch=='(' || ch=='[' || ch=='{'){
                    myStack.push(ch);
                }
                else{
                    if(myStack.isEmpty()){
                        return false;
                    }
    
                    if( myStack.peek()=='(' && ch==')' || 
                        myStack.peek()=='[' && ch==']' || 
                        myStack.peek()=='{' && ch=='}' 
                    ){
                        myStack.pop();
                    }
                    else{return false;}
                }
            
            }
    
            if(myStack.isEmpty()){return true;}
    
            return false;
    
        }

        public static boolean isDuplicateParanthesis(String s){

            Stack<Character> myStack=new Stack<>();

            for(int i=0;i<s.length();i++){

                char ch=s.charAt(i);

                if(ch==')'){
                    int count=0;
                    
                    while(!myStack.isEmpty() && myStack.peek()!='(' ){

                        myStack.pop();
                        count++;
                    }
                   if(!myStack.isEmpty()){ myStack.pop();}
                    if(count<=1){return true;}

                }
                else{
                    myStack.push(ch);
                }
            } 
            return false;
        }
        public static void main(String[] args) {
            String s1="((a+b))";
            String s2="([{})";
            System.out.println(isDuplicateParanthesis(s1));
            // System.out.println(isValid(s2));
        }
    }

