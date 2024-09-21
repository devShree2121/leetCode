package Greedy;

public class activitySelection {
    public static void main(String[] args) {
        int []  start = {1, 3, 0, 5, 8, 5};
        int [] end={2,4,6,7,9,9};

        int count=1;
        int prevEndtime=end[0];
        for(int i=1;i<start.length;i++){

            if(start[i]>=prevEndtime){
                count++;
                prevEndtime=end[i];
            }
        }
        System.out.println(count);

    }
}
