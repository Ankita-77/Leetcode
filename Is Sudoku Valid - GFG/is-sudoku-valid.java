// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int isValid(int mat[][]){
        // code here
        int row[][]= new int[9][9];
        int col[][]= new int[9][9];
        int box[][]= new int[9][9];

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(mat[i][j]!=0){
                row[i][mat[i][j]-1]++;
                col[j][mat[i][j]-1]++;
                box[(i/3)*3 + j/3][mat[i][j]-1]++;
                if(row[i][mat[i][j]-1]>1 || col[j][mat[i][j]-1]>1 || box[(i/3)*3 + j/3][mat[i][j]-1]>1)
                return 0;
                }
                
            }
        }
        return 1;
    }
}