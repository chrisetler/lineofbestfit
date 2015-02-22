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

        int[][] a = {{1,2,0,1},{8,7,0,2},{1,0,3,1},{0,1,3,0}};
        int[][] b = {{1,8},{6,2}};
        Matrix A = new Matrix(a);
        Matrix B = new Matrix(b);
        
        
//        System.out.println("A\n"+A);
//       
//        System.out.println("B\n"+B);
//       
//        System.out.println("A+B\n"+A.add(B));
//      
//        System.out.println("A-B\n"+A.subtract(B));
//        
//        System.out.println("Row 1 of A: \n" + A.printRow(1));
        System.out.println(A+"\n");
        System.out.println(A.determinant());
        
      
        
    }
    
}
