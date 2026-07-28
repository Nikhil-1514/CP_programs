import java.io.*;
import java.util.*;

public class check-k-th-bit-1 {

    public static void main(String[] args) {
    Scanner obj = new Scanner(System.in);
    int n = obj.nextInt();
     int k = obj.nextInt();
     int res = (n>>k)&1;
     System.out.print(res);
}
}

