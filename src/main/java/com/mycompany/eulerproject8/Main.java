package com.mycompany.eulerproject8;

/**
 *
 * @author johnf
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;


public class Main {
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
            int total = 0;
            for (int j=0; j<bigArray[i].length; j++) {
                total += bigArray[i][j];
            }

            totals[i] = total;
        }
    }

    public static void greatestTotal(int[][] bigArray, int[] totals){
        int greatest = 0;
        
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

            
            /*for (int i=0; i<bigArray.length; i++) {
                for(int j=0; j<bigArray[i].length; j++) {
                    System.out.print(bigArray[i][j] + " ");
                }
                System.out.println();
            }*/
            
            sc.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


