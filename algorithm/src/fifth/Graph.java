package fifth;
import java.util.ArrayList;
import java.util.Arrays;
 import java.util.Scanner;
 import java.util.Stack;
  
 public class Graph {
  private static final int k = 3;
  private static int[] P = new int[k];
  
 public static void MultiGraph(int[][] G,int n)
 {
     int[] COST = new int[n];
 
     Arrays.fill(COST,100);
     int[] D = new int[n];
     int temp = 100;
     COST[0]=0;
     D[0]=0;
     for(int j=1;j<n;j++)
     {
         for(int r = 0;r<j;r++)
         {
 
             if(G[j][r]!=0)
             {
                 if(COST[j]>COST[r] + G[j][r])
                 {
                     COST[j]=COST[r]+G[r][j];
                     temp = r;
 
                 }
             }
 
         }
 
         D[j] = temp;
     }
     P[k-1]=D[n-1];
     P[0]=0;
     for(int j = 2;j>1;j--)
     {
         P[j-1] = D[P[j]];
     }
     for (int te: P
          ) {
         System.out.println(te);
 
     }
 }
 
     public static void main(String[] args)
     {
         //新建一个树
         int[][] G = {
                 {0,2,3,4,0,0,0},
                 {2,0,0,0,6,0,0},
                 {3,0,0,0,5,0,0},
                 {4,0,0,0,0,2,0},
                 {0,6,5,0,0,0,3},
                 {0,0,0,4,0,0,1},
                 {0,0,0,0,3,1,0},
         };
 
         MultiGraph(G,7);
 
     }
 
 }