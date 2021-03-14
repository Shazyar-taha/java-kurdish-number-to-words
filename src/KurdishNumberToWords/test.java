/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KurdishNumberToWords;

import java.util.Scanner;

/**
 *
 * @author Click
 */
public class NumberToWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Create object to Scanner
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter  Number ");
        
        long number = s.nextLong();
        
        System.out.println(NumberToKurdishWords.convert(number));
        
    }
    
}
