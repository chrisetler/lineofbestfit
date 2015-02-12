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

    private int M; //rows
    private int N; //columns
    private double[][] matrix;  //the array of values for the Matrix

    /**
     *
     * @param a the array that is the matrix
     */
    public Matrix(double[][] a) {
        M = a.length;
        N = a[0].length;
        matrix = a;
    }

    public Matrix(int[][] a) {
        M = a.length;
        N = a[0].length;
        matrix = new double[M][N];

        //cast to double
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (double) a[i][j];
            }
        }
    }

    /**
     *
     * Multiply two matricies and return the output. Multiplies object matrix A
     * by param matrix B AB
     *
     * @param B Matrix B
     * @return AxB
     */
    public Matrix multiply(Matrix B) {

        double[][] a = this.matrix; //array for matrix A;
        double[][] b = B.matrix;
        int m = this.M; //rows of output matrix from rows of matrix A
        int n = B.N; //colunms of output matrix from columns of matrix B
        int innerDimension = this.N;
        double[][] ab = new double[m][n]; //output array
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < innerDimension; k++) {
                    sum += a[i][k] * b[k][j]; //summation formula for each element
                }
                ab[i][j] = sum;
            }
        }
        Matrix AB = new Matrix(ab); //create a matrix from double array ab
        return AB;

    }

    /**
     *
     * Returns the transpose of matrix A
     *
     * @param A matrix A
     * @return A Transpose
     */
    public Matrix transpose() {
        double[][] a = this.matrix;
        int m = this.M;
        int n = this.N;
        double[][] b = new double[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[j][i];
            }
        }
        return new Matrix(b);
    }

    /**
     *
     * Returns the scalar multiple of a matrix A times some scalar c.
     *
     * @param c Scalar C
     * @return c[A]
     */
    public Matrix scalarmult(double c) {
        double[][] a = this.matrix;
        for (int i = 0; i < this.M; i++) {
            for (int j = 0; j < this.N; j++) {
                a[i][j] = c * a[i][j];
            }
        }
        return new Matrix(a);
    }

    /**
     *
     * Print the matrix A
     *
     * @param A Matrix A
     */
    public static void print(Matrix A) {
        double[][] a = A.matrix;
        int m = a.length;
        int n = a[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println();
        }
    }

    /**
     * Print the Matrix.
     */
    public void print() {
        double[][] a = this.matrix;
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
