import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int a = obj.nextInt();
        int b = obj.nextInt();
        int t = obj.nextInt();
        if(t == 0) System.out.print("YES");
        if(t%(gcd(a,b)) == 0) System.out.print("YES");
        else System.out.print("NO");
    }
    
    private static int gcd(int a , int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
}

