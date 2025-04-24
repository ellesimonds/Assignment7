import java.util.Scanner;

//Question 4
public class DirectedGraphChecker {

    public static boolean isDirected(int[][] matrix) {
        int n = matrix.length;

        //Check for asymmetry in the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return true; //Not symmetric => directed
                }
            }
        }
        return false; //Symmetric => undirected
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the matrix (n): ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        if (isDirected(matrix)) {
            System.out.println("The matrix represents a directed graph.");
        } else {
            System.out.println("The matrix represents an undirected graph.");
        }

        sc.close();
    }
}
