import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
       Scanner obj = new Scanner(System.in);
int a = obj.nextInt();
int b = obj.nextInt();
int res = GCD(a,b);
System.out.println(res);
}

private static int GCD(int a , int b){
if(b == 0) return a;
return GCD(b,(a%b));
}

}

