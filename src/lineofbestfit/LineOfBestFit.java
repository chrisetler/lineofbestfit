/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineofbestfit;

import lineofbestfit.Matrix;
/**
 *
 * @author Chris
 */
public class LineOfBestFit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[][] a = {{4,2},{8,7}};
        int[][] b = {{1,8,7},{6,2,-1}};
        Matrix A = new Matrix(a);
        Matrix B = new Matrix(b);
        
        Matrix.print((A.multiply(B)));
        System.out.println();
        (A.multiply(B)).print();
        
        
      
        
    }
    
}
