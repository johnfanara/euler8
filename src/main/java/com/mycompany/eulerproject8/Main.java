package com.mycompany.eulerproject8;

/**
 *
 * @author johnf
 */
public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 
            9, 10, 11, 12, 13, 14, 15, 16};
               
        int[][] bigArray = new int[array.length/4][4];    
        
        int value = array[0];
        for (int i=0; i<array.length; i++){
           
           for (int j=0; j<4; j++){
               bigArray[i][j] = value;
               value = array[i+1];
           }
                
        } 
        
        for (int i = 0; i < array.length/4; i++){
            for (int j = 0; j < 4; j++){
                System.out.print(bigArray[i][j] + " ");
            }
            System.out.println();
        }
    }
}


