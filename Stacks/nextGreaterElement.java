package leetCode.Stacks;
import java.util.*;
public class nextGreaterElement {
   // This is the classical question asked in interviews which shows the core logic of stacks
    public static void main(String[] args) {
        
    
   int numbers[]={1,4,5,10,8,7};
   int answerArray[]=new int[numbers.length]; // To store next greater element of each index
   Stack<Integer> myStack = new Stack<>(); // creating stack data structure

   for(int i=numbers.length-1;i>=0;i--){

            while(!myStack.isEmpty() && numbers[i]>=myStack.peek()){
                myStack.pop();
            }

            if(myStack.isEmpty()){
                answerArray[i]=-1;
            }else{
                answerArray[i]=myStack.peek();
            }

            myStack.push(numbers[i]);
   }
   System.out.print("[ ");
   for(int j:answerArray){
    System.out.print( j +" ");
   }
   System.out.print("]");
}
}

