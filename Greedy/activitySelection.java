//Classical question to understand Greedy.
// Problem statement: Our task is to find the maximum number of works which can be done by a single person given that a person can do single task in single time frame.
// Approach: This  problem can be solved using greedy algorithm. We will sort the tasks based on their deadlines and then assign  the tasks to the person one by one. If the deadline of the task is less than or  equal to the current time, we assign the task to the person. If the deadline of the task is greater then we will skip that task.
// Time complexity: O(n log n) due to sorting.
// Space complexity: O(n) for sorting in place.


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
