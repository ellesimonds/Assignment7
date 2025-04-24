import java.util.*;

//Question 5
public class PathLength7Finder {

    static class Edge {
        int to;
        int weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static Map<Integer, List<Edge>> graph = new HashMap<>();
    static List<List<Integer>> resultPaths = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Input the number of vertices and edges
        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int edges = sc.nextInt();

        System.out.println("Enter edges in the format: from to weight");
        for (int i = 0; i < edges; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new Edge(to, weight));
        }

        System.out.print("Enter start vertex (u): ");
        int u = sc.nextInt();
        System.out.print("Enter end vertex (w): ");
        int w = sc.nextInt();

        findPaths(u, w, new ArrayList<>(), 0);

        System.out.println("Paths from " + u + " to " + w + " with length 7:");
        for (List<Integer> path : resultPaths) {
            System.out.println(path);
        }

        sc.close();
    }

    //DFS to find paths with exact length 7
    private static void findPaths(int current, int target, List<Integer> path, int currentLength) {
        path.add(current);

        if (current == target && currentLength == 7) {
            resultPaths.add(new ArrayList<>(path));
        } else if (currentLength < 7) {
            List<Edge> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (Edge edge : neighbors) {
                if (!path.contains(edge.to)) { //Ensure simple path
                    findPaths(edge.to, target, path, currentLength + edge.weight);
                }
            }
        }

        path.remove(path.size() - 1);
    }
}

