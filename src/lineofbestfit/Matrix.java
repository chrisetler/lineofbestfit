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
     * Find the determinant of the matrix by first reducing it to a triangular matrix and then finally multiplying along the diagnol
     * @return the determinant as a double.
     */
    public double determinant() {
        //triangular matrix method
        
        boolean lastRowHasZero;
        double det = 1;
        Row[] row = new Row[M];
        //temp rows
        Row tempRow1 = new Row();
        Row tempRow2 = new Row();
        double val1, val2,val3;
        //get each row
        for(int i=0; i<M; i++) {
            row[i] = new Row(i);
        }

        //in order for the code to work as we want it to, the last row has to have no zeros in it
        //technically it can have some zeros in it in many cases but by having no zeros we ensure there will be no divide-by-0 errors
        //this can be done by checking if the last row has any zeros in it with the has zeros class
        //if it does, add every row to the last row to create one "super row" that can't have any zeros
        //if this super row has zeros, then the matrix is singular, and we can return 0
        if(row[M-1].hasZero()){
            tempRow1 = row[M-1];
            System.out.println("Last row: " +tempRow1.rowStr());
            for(int i=0; i<M-1; i++){
                tempRow2 = tempRow1.add(row[i]);
                tempRow1.setRow(tempRow2);
               // System.out.println(tempRow2.rowStr());
            }
            
            row[M-1].setRow(tempRow1);
            System.out.println("New Last Row: " + row[M-1].rowStr());
            if(row[M-1].hasZero()) return 0;
        }
        
        
        
        //we are going to make the upper diagnol set to 0, one column at a time
        //start with the right-most column and keep going left until reached the second to first column, which begins the diagnol
        for (int i=(M-1); i>0; i--) {
            int numberOfZeros = i; //number of zeros in the column is equal to that column num-1
            //start with first row (0), go to the numberOfZeros-1 row
            for(int j=0; j<numberOfZeros; j++) {
                //i is the column
                //j is the row
                //use the last row as the row to add all other rows
                //get the ratio of the current row and the row to add to it, such that the element we are tyring to get to 0 will be zero when subtraction occurs
                /*
                    Consider the two rows R1 [1 3 -4]
                                          R2 [7 8 3 ]
                    val1=-4, val2=3, val3 thus = -4/3
                    Thus R1 becomes [1+4/3(7) 3+4/3(8) -4+4/3(3)] = [31/3 41/3 0]
                */
                int currRow = j;
                int nexRow = j+1;
                
                while(row[nexRow].row[i] == 0){
                    nexRow++;
                    if(nexRow == M-1) break;
                }
                System.out.println("Next Row: " + row[nexRow].rowStr() + " Lst:" + row[M-1].rowStr());
                val2 = row[nexRow].row[i];
                val1 = row[currRow].row[i];
                val3 = val1/val2;
                
                tempRow1 = (row[nexRow].scalarMult(val3));
                tempRow2 = (row[currRow].subtract(tempRow1));
                //System.out.println(row[M-1].rowStr() + "*"+val3+"= " + tempRow1.rowStr());
                row[currRow].setRow(tempRow2);
                //System.out.println(j+" "+i+" "+row[j].rowStr());
                
            }
        }
        //now that the matrix is triangular, we simply multiply across the diagnol and recover the determinant
        for (int i=0; i<M; i++){
            System.out.println(row[i].row[i]);
            det *= row[i].row[i];
        }
        return det;
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
        
        private Row() {}
        
        private Row(int rowNum) {
            row = matrix[rowNum];
            length = row.length;
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
                rowOut[i] = row[i]*scalar;
            }
            return new Row(rowOut);
        }
        
        private boolean hasZero() {
            for(int i=0; i<length; i++){
                if (row[i] == 0) return true;
            }
            return false;
        }
        
        /**
         * only for debugging
         * @deprecated @return a String of the Row
         */
        private String rowStr() {
            String out = "";
            for (int i = 0; i < length; i++) {
                out += row[i] + ", ";
            }
            return out;
        }
    }
}
