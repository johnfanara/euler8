package com.mycompany.eulerproject8;

/**
 *
 * @author johnf
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static String createNumString(File file){
        String numString = "";
        try{
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                numString = numString + sc.nextLine();
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return numString;
    }
    public static long getGreatestProduct(String str, long length){
        long lrgProd = 0;
        for (int i=0; i<str.length() - length+1; i++){
            long prod = 1;
            for (int j=i; j<i+length;j++){
                prod *= Integer.parseInt(str.substring(j, j+1));
            }

            if (prod > lrgProd) {
                lrgProd = prod;
            }
        }
        return lrgProd;
    }

    public static long getGreatestProductLoopless(String str, int length){
        long prod = 1;
        long lrgProd = 0;
        int nums = 0;
        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i)-'0';

            if (num==0){
                prod = 1;
                nums = 0;
            }
            else {
                if (nums == length) {
                    prod /= str.charAt(i - length) - '0';
                }
                else {
                    nums += 1;
                }

                prod *= num;

                if (prod > lrgProd) {
                    lrgProd = prod;
                } 
            }
        }
        return lrgProd;
    }
    public static void main (String[] args) {
        
            File nums = new File("C:/Users/johnf/Desktop/projects/euler8/euler8.txt");
        
            String number = createNumString(nums);
            
            int length = 13;
            long greatestProd = 0;
            long looplessProd = 0;

            greatestProd = getGreatestProduct(number, length);
            looplessProd = getGreatestProductLoopless(number, length);
            System.out.println("Displaying greatest product of " + length
                                + " sequential numbers: " + greatestProd);
            System.out.println("Displaying greatest product of " + length
            + " sequential numbers without nested loops: " + looplessProd);
            
    }
}


