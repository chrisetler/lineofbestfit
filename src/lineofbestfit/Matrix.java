/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineofbestfit;

/**
 *
 * @author Chris
 */

//Static matrix functions that can be performed on double arrays (of double type)

public class Matrix {
    public Matrix() {
        
    }
    /**
     * 
     * @param a Matrix A
     * @param b Matrix B
     * @return AxB
     */
    public static double[][] multiply(double[][] a, double[][] b){
        int m = a.length;
        int n = b[0].length;
        double[][] ab = new double[m][n]; // creat an a_m x b_n matrix
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += a[i][k]*b[k][j]; //summation formula for each element
                }
                ab[i][j] = sum;
            }
        }
        return ab;
    }
    /**
     * 
     * @param a Matrix A
     * @return A Transpose
     */
    public static double[][] transpose(double[][]a){
        int m = a.length;
        int n = a[0].length;
        double[][] b = new double[m][n];
        
        for ( int i = 0; i<m; i++ ) {
            for ( int j = 0; j<n; j++ ) {
                b[i][j] = a[j][i];
            }
        }
        return b;
    }
    /**
     * 
     * @param a The matrix to print 
     */
    public static void print(double[][] a) {
        int m = a.length;
        int n = a[0].length;
        for ( int i = 0; i < m; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
