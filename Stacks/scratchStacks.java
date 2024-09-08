package leetCode.Stacks ;
import java.util.ArrayList;

public class scratchStacks {

    public class ArrayListstack {
        ArrayList<Integer> arrayList = new ArrayList<>();

        public boolean isEmpty() {
            return arrayList.size() == 0;
        }

        public void pushData(int data) {
            arrayList.add(data);
        }

        public int popData() {
            int size = arrayList.size();
            int deletedData = arrayList.get(size - 1);
            arrayList.remove(size - 1);
            return deletedData;
        }

        public int peekData() {
            int size = arrayList.size();
            return arrayList.get(size - 1);
        }
    }

    public static void main(String[] args) {
        scratchStacks outerInstance = new scratchStacks();
        ArrayListstack stack = outerInstance.new ArrayListstack();

        stack.pushData(10);
        stack.pushData(20);
        stack.pushData(30);

        System.out.println("Top element is: " + stack.peekData());

        int removedElement = stack.popData();
        System.out.println("Removed element: " + removedElement);

        System.out.println("Is the stack empty? " + stack.isEmpty());

        System.out.println("Top element is now: " + stack.peekData());

        stack.popData();
        stack.popData();

        System.out.println("Is the stack empty now? " + stack.isEmpty());
    }
}
