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
     * Multiply two matricies and return the output.
     *
     * @param a Matrix A
     * @param b Matrix B
     * @return AxB
     */
    public static double[][] multiply(double[][] a, double[][] b) {
        int m = a.length; //rows of output matrix
        int n = b[0].length;  //columns of output matrix
        int N = a[0].length; //inner dimensions of multiplication ( for MxN * NxJ matricies)
        double[][] ab = new double[m][n]; // creat an a_m x b_n matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j]; //summation formula for each element
                }
                ab[i][j] = sum;
            }
        }
        return ab;
    }

    /**
     *
     * Returns the transpose of matrix A
     *
     * @param a Matrix A
     * @return A Transpose
     */
    public static double[][] transpose(double[][] a) {
        int m = a.length;
        int n = a[0].length;
        double[][] b = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[j][i];
            }
        }
        return b;
    }

    /**
     *
     * Returns the scalar multiple of a matrix A times some scalar c.
     *
     * @param a Matrix A
     * @param c Scalar C
     * @return c[A]
     */
    public static double[][] scalarmult(double[][] a, double c) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = c * a[i][j];
            }
        }
        return a;
    }

    /**
     *
     * Print the matrix A
     *
     * @param a The matrix to print
     */
    public static void print(double[][] a) {
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int m = a.length; //rows of output matrix
        int n = b[0].length;  //columns of output matrix
        int N = a[0].length; //inner dimensions of multiplication ( for MxN * NxJ matricies)
        int[][] ab = new int[m][n]; // creat an a_m x b_n matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += a[i][k] * b[k][j]; //summation formula for each element
                }
                ab[i][j] = sum;
            }
        }
        return ab;
    }

    /**
     *
     * Returns the transpose of matrix A
     *
     * @param a Matrix A
     * @return A Transpose
     */
    public static int[][] transpose(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] b = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[j][i];
            }
        }
        return b;
    }

    /**
     *
     * Returns the scalar multiple of a matrix A times some scalar c.
     *
     * @param a Matrix A
     * @param c Scalar C
     * @return c[A]
     */
    public static int[][] scalarmult(int[][] a, int c) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = c * a[i][j];
            }
        }
        return a;
    }

    /**
     *
     * Print the matrix A
     *
     * @param a The matrix to print
     */
    public static void print(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
