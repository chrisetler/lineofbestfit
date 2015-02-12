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
        int[][] a = {{1,0,2},{3,2,2},{3,0,4}};
        Matrix A = new Matrix(a);
        Matrix.print(A);
        System.out.println();
        
        A = A.transpose();
        
        Matrix.print(A);
        
        
      
        
    }
    
}
