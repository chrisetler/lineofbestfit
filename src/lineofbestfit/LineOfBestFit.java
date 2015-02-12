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
        
//        double[][] a = {{1,2},{3,4}};
//        double[][] b = {{-4,6,3},{7,2,4}};
//        double[][] ab = Matrix.multiply(a, b);
//        
//        Matrix.print(a);
//        System.out.println();
//        Matrix.print(b);
//        System.out.println();
//        Matrix.print(Matrix.multiply(a, b));
        int[][] a = {{2},{1},{3}};
        int[][] b = {{0,1,-2}};
        
        Matrix.print(Matrix.transpose(a));
        
      
        
    }
    
}
