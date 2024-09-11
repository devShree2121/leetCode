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
        public static void main(String[] args) {
            String s="(()))))";
            System.out.println(isValid(s));
        }
    }

