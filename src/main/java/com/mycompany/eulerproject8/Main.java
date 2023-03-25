package com.mycompany.eulerproject8;

/**
 *
 * @author johnf
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 
            9, 10, 11, 12, 13, 14, 15, 16};
               
        int[][] bigArray = new int[array.length/4][];
        
        for (int i=0; i<bigArray.length; i++){
            bigArray[i] = new int[4];
        }
        
        int k = 0;
        for (int i=0; i<bigArray.length; i++){
            for (int j=0; j<bigArray[i].length; j++){
                bigArray[i][j] = array[k];
                k++;
            }
        }
        
        for (int i=0; i<bigArray.length; i++) {
            for(int j=0; j<bigArray[i].length; j++) {
                System.out.print(bigArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}


