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

/* 
    public static void stringToInt(String[] strArr, int[] arr){
        char[] charArr = new char[1000];
        int k = 0;
            for (int i=0; i < strArr.length; i++) {
                for (int j=0; j < strArr[i].length(); j++) {
                    charArr[k] = strArr[i].charAt(j);
                    k++; 
                }
            }

            for(int i=0; i < arr.length; i++){
                arr[i] = Integer.parseInt(String.valueOf(charArr[i]));
            }
    }

    public static void loadBigArray(int[][] bigArray, int[] array){
        int k = 0;
        for (int i=0; i<bigArray.length; i++){
            for (int j=0; j<bigArray[i].length; j++){
                bigArray[i][j] = array[k];
                k++;
            }
        }
    }

    public static void getTotals(int[][] bigArray, int[] totals){
        for (int i=0; i<bigArray.length; i++){
            int total = 1;
            for (int j=0; j<bigArray[i].length; j++) {
                total *= bigArray[i][j];
            }

            totals[i] = total;
        }
    }

    public static void greatestTotal(int[][] bigArray, int[] totals){
        int greatest = totals[0];
        int[] greatestArr = new int[4];
        int greatestIndex = 0;

        for (int i=0; i<totals.length; i++){
            if (greatest < totals[i]) {
                greatest = totals[i];
                greatestIndex = i;
                for (int j=0; j<bigArray[i].length; j++){
                    greatestArr[j] = bigArray[i][j];
                }
            }
        }

        System.out.println("Displaying greatest 4 number sequence: ");
        for (int i=0; i<greatestArr.length-1; i++){
            System.out.print(greatestArr[i] + " ");

        }
        System.out.println(greatestArr[greatestArr.length-1]);
        System.out.println("Total: " + totals[greatestIndex]);
        
    }
    public static void main(String[] args) {
        try {
            File nums = new File("C:/Users/johnf/Desktop/projects/euler8/euler8.txt");
            Scanner sc = new Scanner(nums);

            int[] array = new int[1000];
            String[] strArr = new String[20];
              
            int count = 0;
            while (sc.hasNext()){
                strArr[count] = sc.next();
                count++;
            }

            stringToInt(strArr, array);

            int[][] bigArray = new int[array.length/4][];
        
            for (int i=0; i<bigArray.length; i++){
                bigArray[i] = new int[4];
            }
        
            loadBigArray(bigArray, array);

            int[] totalArr = new int[bigArray.length];
            
            getTotals(bigArray, totalArr);

            greatestTotal(bigArray, totalArr);
            for (int i=0; i<bigArray.length; i++) {
                for(int j=0; j<bigArray[i].length; j++) {
                    System.out.print(bigArray[i][j] + " ");
                }
                System.out.println();
            }
            
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
*/


