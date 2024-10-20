package Heaps;
import java.util.*;
public class myHeap {
 
    static class heap{
        ArrayList<Integer> list=new ArrayList<>();

        public void add(int data){ // time complexity of add/inserting in heap is logn.

            list.add(data); // data added next thing is to fix the heap

            int childIndex=list.size()-1;
            int parentIndex=(childIndex-1)/2;

            while(list.get(childIndex)<list.get(parentIndex)){

                int temp=list.get(parentIndex);
                list.set(parentIndex, list.get(childIndex));
                list.set(childIndex,temp);

                childIndex=parentIndex;
                parentIndex=(childIndex-1)/2;

            }
        }

        public int peek(){
            return list.get(0);
        }

        public boolean isEmpty(){
            return list.size()==0;
        }

        private void heapify(int i){ //o(logn)

            int minIdx=i;
            int left=2*i+1;
            int right=2*i+2;

            if(left<list.size()-1 && list.get(left)<list.get(minIdx)){
                minIdx=left;
            }

            if(right<list.size()-1 && list.get(right)<list.get(minIdx)){
                minIdx=right;
            }

            if(i!=minIdx){
                int temp=list.get(i);
                list.set(i,list.get(minIdx));
                list.set(minIdx,temp);
                heapify(minIdx);
            }
        }
        public int remove(){ // o(logn)
            int data=list.get(0);
            // swap it to last index
            int temp=list.get(0);
            list.set(0, list.get(list.size()-1));
            list.set(list.size()-1,temp);

            // now delete the last index value

            list.remove(list.size()-1);

            heapify(0);

            return data;

        }
        
    }
    public static void main(String[] args) {
        
        heap hp=new heap();
        hp.add(4);
        hp.add(2);
        hp.add(3);
        hp.add(1);

        while(!hp.isEmpty()){
            System.out.println(hp.peek());
            hp.remove();
        }
    }
}
