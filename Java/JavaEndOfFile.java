
import java.io.*;
import java.util.*;

public class JavaEndOfFile {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        String line = null;
        int i = 1;
        while (scan.hasNextLine()) {
            line = scan.nextLine();
            System.out.println(i+" "+line);
            i++;
        }
    }
}

