import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = count(s);
        System.out.print(res);
    }
    
    private static int count(String s){
        int c = 0 , mc =0;
        int[] frequency = new int[256];
        for(int i = 0 ;i<s.length();i++){
            char ch = s.charAt(i);
            frequency[ch]++;
            if(frequency[ch] > mc) mc = frequency[ch];
        }
        return mc;
    }
}

