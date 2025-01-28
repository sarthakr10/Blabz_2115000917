import java.util.Random;

public class l3q13 {

    public static void main(String[] args) {
        int rows = 3;
        int cols = 3;
        
        int[][] matrix1 = createRandomMatrix(rows, cols);
        int[][] matrix2 = createRandomMatrix(rows, cols);
        
        System.out.println("Matrix 1:");
        displayMatrix(matrix1);
        
        System.out.println("Matrix 2:");
        displayMatrix(matrix2);
        
        System.out.println("Addition:");
        displayMatrix(addMatrices(matrix1, matrix2));
        
        System.out.println("Subtraction:");
        displayMatrix(subtractMatrices(matrix1, matrix2));
        
        System.out.println("Multiplication:");
        displayMatrix(multiplyMatrices(matrix1, matrix2));
        
        System.out.println("Transpose of Matrix 1:");
        displayMatrix(transposeMatrix(matrix1));
        
        System.out.println("Determinant of 2x2 Matrix 1:");
        System.out.println(determinant2x2(matrix1));
        
        System.out.println("Determinant of 3x3 Matrix 1:");
        System.out.println(determinant3x3(matrix1));
        
        System.out.println("Inverse of 2x2 Matrix 1:");
        displayMatrix(inverse2x2(matrix1));
        
        System.out.println("Inverse of 3x3 Matrix 1:");
        displayMatrix(inverse3x3(matrix1));
    }

    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // Random numbers between 0 and 9
            }
        }
        return matrix;
    }

    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length;
        int cols = matrix2[0].length;
        int sumLength = matrix2.length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < sumLength; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int determinant2x2(int[][] matrix) {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    public static int determinant3x3(int[][] matrix) {
        int determinant = 0;
        for (int i = 0; i < 3; i++) {
            determinant += matrix[0][i] * (matrix[1][(i + 1) % 3] * matrix[2][(i + 2) % 3] - matrix[1][(i + 2) % 3] * matrix[2][(i + 1) % 3]);
        }
        return determinant;
    }

    public static int[][] inverse2x2(int[][] matrix) {
        int determinant = determinant2x2(matrix);
        if (determinant == 0) {
            throw new ArithmeticException("Matrix is not invertible");
        }
        int[][] result = {
            {matrix[1][1], -matrix[0][1]},
            {-matrix[1][0], matrix[0][0]}
        };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] /= determinant;
            }
        }
        return result;
    }

    public static int[][] inverse3x3(int[][] matrix) {
        int determinant = determinant3x3(matrix);
        if (determinant == 0) {
            throw new ArithmeticException("Matrix is not invertible");
        }
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = ((matrix[(j + 1) % 3][(i + 1) % 3] * matrix[(j + 2) % 3][(i + 2) % 3]) - (matrix[(j + 1) % 3][(i + 2) % 3] * matrix[(j + 2) % 3][(i + 1) % 3])) / determinant;
            }
        }
        return result;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}