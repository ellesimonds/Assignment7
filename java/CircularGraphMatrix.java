import java.util.*;

//Question 6
public class CircularGraphMatrix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of nodes: ");
        int n = sc.nextInt();
        sc.nextLine(); //Consume newline

        String[] input = new String[n];
        System.out.println("Enter each pair in the form (V,x) one by one:");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine().trim().replaceAll("[()\\s]", "");
        }

        //Parse vertex labels and their x values
        String[] labels = new String[n];
        int[] steps = new int[n];
        for (int i = 0; i < n; i++) {
            String[] parts = input[i].split(",");
            labels[i] = parts[0];
            steps[i] = Integer.parseInt(parts[1]);
        }

        int[][] matrix = new int[n][n];

        //Create adjacency matrix
        for (int i = 0; i < n; i++) {
            int left = (i - steps[i] + n) % n;
            int right = (i + steps[i]) % n;
            matrix[i][left] = 1;
            matrix[i][right] = 1;
        }

        //Print matrix header
        System.out.print("   ");
        for (String label : labels) {
            System.out.print(label + " ");
        }
        System.out.println();

        //Print adjacency matrix
        for (int i = 0; i < n; i++) {
            System.out.print(labels[i] + ": ");
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
