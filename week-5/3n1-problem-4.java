import java.io.*;
import java.util.*;

public class Solution {

    private static int find(int a){
        int c  =1;
        int j = a;
        while(j != 1){
        if(j%2 == 0) j/=2;
        else{
            j = 3*j+1;
        }
        c++;
       }
       return c;
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int i = sc.nextInt();
       int j = sc.nextInt();
       int start = Math.min(i,j);
       int end = Math.max(i,j);
       int max = 0;
       for(int k = start ; k< end;k++){
        int len = find(k);
        max = Math.max(max,len);
       }
       System.out.print(i + " " + j + " " + max); 
    }
}

