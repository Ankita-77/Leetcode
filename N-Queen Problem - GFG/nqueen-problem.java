// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
   static ArrayList<ArrayList<Integer>> nQueen(int n) {
      
       int[][] chess = new int[n][n];
       ArrayList<ArrayList<Integer>>  ans = new ArrayList<>() ;
       
       printNQueens(chess , n , 0 ,  new ArrayList<Integer>() , ans ) ;
       return ans ;
       
       
   }
   static void printNQueens( int[][] chess ,int  n , int row , ArrayList<Integer> ds  , ArrayList<ArrayList<Integer>>  ans ){
       if(row == chess.length ){
           ans.add(new ArrayList<>(ds)) ;
           return ;
       }
       
       for(int col = 0 ; col < chess.length; col++ ){
           if(isSafePlace(chess , row , col ) == true ){
               chess[row][col] = 1 ;
               ds.add(col+1);
                printNQueens(chess , n , row + 1  ,ds , ans ) ;
                chess[row][col] = 0 ;
                ds.remove(ds.size() -1 ) ;
           }
       }
   }
   public static boolean isSafePlace(int[][] chess , int row , int col ) {
         // for Vertical Direction 
       for(int i =  row - 1 , j = col ; i >= 0 ; i-- ){
           if(chess[i][j] == 1 ){
               return false ;
               
           }
       }
       
       // for left diogonal up 
       for(int i = row - 1, j = col - 1 ; i >= 0 && j >= 0 ; i-- , j--){
           if(chess[i][j] == 1 ) return false ;
           
       }
       // for right diogonal up
       for(int  i = row -1 , j = col + 1 ; i>=0 && j < chess.length ; i-- , j++ ){
           if(chess[i][j] == 1 ) return false ;
           
       }
       
       
       return true ;
   }
}