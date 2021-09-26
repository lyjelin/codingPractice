import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        // us
        java.text.NumberFormat numUS = java.text.NumberFormat.getCurrencyInstance(Locale.US);
        String us = numUS.format(payment);
        // india
        java.text.NumberFormat numIndia = java.text.NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = numIndia.format(payment);
        // china
        java.text.NumberFormat numChina = java.text.NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = numChina.format(payment);
        // france
        java.text.NumberFormat numFrance = java.text.NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = numFrance.format(payment);
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}