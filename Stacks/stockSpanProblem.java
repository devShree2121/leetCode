package leetCode.Stacks;
import java.util.Stack;

// So here, the problem statement is we are given array with prices of stock for each day so our job is to find the span which means you have to return the numbers of days for which price of stock is less than or equal for consecutive days.

public class stockSpanProblem {
    
    public static void main(String[] args) {
        int [] stock={100,80,60,70,60,85,100};
        int [] span=new int[stock.length];
        Stack <Integer> myStack=new Stack<>();

        span[0]=1;  // for the first day span is always 1.
        myStack.push(0); // pushing the index of the first day.
        

        for(int i=1;i<stock.length;i++){

            
            while(!myStack.isEmpty() && stock[i]>=stock[myStack.peek()]){ // searching for the previous high price day 
                myStack.pop();
            }
            if(myStack.empty()){ // if stack is empty then it means there is no higher price before that day.
                span[i]=i+1;
            }

            else{ 
            span[i]=i-myStack.peek();  // calculate the span for that day 


            }
                myStack.push(i); // push the current index 
        }

        for(int i:span){
            System.out.print(i + " ");
        }

    }
}
