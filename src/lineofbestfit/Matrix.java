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

    private final int M; //rows
    private final int N; //columns
    private final double[][] matrix;  //the array of values for the Matrix

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

        double[][] a = matrix; //array for matrix A;
        double[][] b = B.matrix;
        int m = M; //rows of output matrix from rows of matrix A
        int n = B.N; //colunms of output matrix from columns of matrix B
        int innerDimension = N;
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
     * Adds a matrix B to some matrix A
     *
     * @param B Matrix to add
     * @return A + B
     */
    public Matrix add(Matrix B) {
        double[][] a = matrix;
        double[][] b = B.matrix;

        int m = M;
        int n = N;
        double[][] c = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return new Matrix(c);
    }

    /**
     * Given Matrix A and param Matrix B return A-B
     *
     * @param B matrix to subtract
     * @return A-B
     */
    public Matrix subtract(Matrix B) {
        double[][] a = matrix;
        double[][] b = B.scalarmult(-1).matrix;

        int m = M;
        int n = N;
        double[][] c = new double[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return new Matrix(c);
    }

    /**
     *
     * Returns the transpose of matrix A
     *
     * @return A Transpose
     */
    public Matrix transpose() {
        double[][] a = matrix;
        int m = M;
        int n = N;
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
        double[][] a = matrix;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
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
     * @deprecated
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
     *
     * @deprecated
     */
    public void print() {
        double[][] a = matrix;
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
     *
     * @return the Matrix in a (semi)readable format
     */
    @Override
    public String toString() {
        String out = "";
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                out += matrix[i][j] + " ";
            }
            if (i < M - 1) {
                out += "\n"; //don't print a newline after the last row
            }
        }
        return out;
    }

    /**
     * For debugging purposes only
     *
     * @deprecated
     * @param rowNum the number of the row (0- N-1)
     * @return the string of the Row
     *
     */
    public String printRow(int rowNum) {
        Row rowA = new Row(rowNum);
        return (rowA.rowStr());

    }

    //subclass for Elementary Row Ops
    private class Row {

        double[] row;
        int length;

        private Row(int rowNum) {
            row = matrix[rowNum];
            length = M;
        }

        private Row(double[] rowIn) {
            length = rowIn.length;
            row = rowIn;
        }

        /**
         * set the row to a value defined by a double array
         *
         * @param rowIn
         */
        private void setRow(double[] rowIn) {
            row = rowIn;
        }

        /**
         * set the row to a value defined by another row.
         *
         * @param rowIn
         */
        private void setRow(Row rowIn) {
            row = rowIn.getArray();
        }

        /**
         * Add two rows and return as another Row
         *
         * @param rowIn row to add
         * @return the addition of the two rows
         */
        private Row add(Row rowIn) {
            double[] rowOut = new double[length];
            for (int i = 0; i < length; i++) {
                rowOut[i] = row[i] + rowIn.row[i];
            }
            return new Row(rowOut);
        }
        
        /**
         * Subtract two rows and return as another Row
         * @param rowIn the row to subtract from the first row
         * @return the row minus rowIn
         */
        private Row subtract(Row rowIn) {
            double[] rowOut = new double[length];
            for (int i = 0; i < length; i++) {
                rowOut[i] = row[i] - rowIn.row[i];
            }
            return new Row(rowOut);
        }

        private double[] getArray() {
            return row;
        }
        /**
         * 
         * @param scalar the scalar to multiply each value in the row by
         * @return a row that is the scalar multiple of the input row and scalar
         */
        private Row scalarMult(double scalar) {
            double[] rowOut = new double[length];
            for (int i=0; i < length; i++) {
                rowOut[i] *= scalar;
            }
            return new Row(rowOut);
        }
        /**
         * only for debugging
         * @deprecated @return a String of the Row
         */
        private String rowStr() {
            String out = "";
            for (int i = 0; i < M; i++) {
                out += row[i] + ", ";
            }
            return out;
        }
    }
}
