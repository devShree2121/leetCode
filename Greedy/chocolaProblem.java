// This question is leetcode hard question asked in FAANG Interview.

//  Problem Statement:We are given a bar of chocolate composed of m*n square pieces. One should break the chocolate into single squares. Parts of the chocolate may be broken along the vertical and horizontal lines as indicated by the broken lines in the picture. A single break of a part of the chocolate along a chosen vertical or horizontal line divides that part into two smaller ones. Each break of a part of the chocolate is charged a cost expressed by a positive integer. This cost does not depend on the size of the part that is being broken but only depends on the line the break goes along. Let us denote the costs of breaking along consecutive vertical lines with x1, x2, ..., xm-1 and along horizontal lines with y1, y2, ..., yn-1. The cost of breaking the whole bar into single squares is the sum of the successive breaks. One should compute the minimal cost of breaking the whole chocolate into single squares.
package Greedy;
import java.util.*;

public class chocolaProblem {
    public static void main(String[] args) {
        int n=4;
        int m=6;

        Integer verCost[]={2,1,3,1,4};
        Integer horiCost[]={4,1,2};
// sorting the horizontal and vertical prices in descending order to cut the expensive one first to avoid multiple cut.
        Arrays.sort(horiCost,Collections.reverseOrder()); 
        Arrays.sort(verCost,Collections.reverseOrder());
        int minCost=0;
        int h=0,v=0;
        int hp=1;int  vp=1; // initially horizontal and vertical pieces are one as there is single chocolate block

        while(h<horiCost.length &&  v<verCost.length){


            if(verCost[v]<=horiCost[h]){  // if vertical cut is less than horizontal cut then cut the horizontal one first

                minCost+=horiCost[h]*vp;
                hp++;
                h++;
            }
            else{
                minCost+=verCost[v]*hp;  // if vertical cut is more than horizontal cut then cut the vertical one first

                vp++;
                v++;
            }
        }

        while(h<horiCost.length){// if  there are still horizontal cuts left then cut them all as they are already sorted in descending order.

            minCost+=horiCost[h]*vp;
            hp++;
            h++;
        }
        while(v<verCost.length){  // if there are still vertical cuts left then cut them all as they are already sorted in descending order
            minCost+=verCost[v]*hp;
                vp++;
                v++; 
        }
        System.out.println(minCost); //  print the minimum cost to break the chocolate bar into single squares.

    }
}


