package Graphs;
import java.util.*;

public class implementation {
    


// Class to represent an edge
 static class Edge {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Edge from " + src + " to " + dest + " with weight " + weight;
    }
}
public static void bfs(ArrayList<Edge>[] graph) {

    Queue<Integer> q = new LinkedList<>();
    boolean isVisited[] = new boolean[graph.length];

    // Start with the first node (0)
    q.add(0);
    isVisited[0] = true; // Mark as visited when adding to the queue

    while (!q.isEmpty()) {

        int curr = q.remove();
        System.out.print(curr + " ");

        // Visit all neighbors of the current node
        for (int i = 0; i < graph[curr].size(); i++) {
            int neighbor = graph[curr].get(i).dest;
            if (!isVisited[neighbor]) {
                q.add(neighbor);
                isVisited[neighbor] = true; // Mark as visited when enqueuing
            }
        }
    }
}
public static void dfs(ArrayList<Edge>[] graph, boolean[] isVisited, int vertex) {
    // Mark the current vertex as visited and print it
    isVisited[vertex] = true;
    System.out.print(vertex + " ");

    // Recur for all the vertices adjacent to this vertex
    for (Edge edge : graph[vertex]) {
        int neighbor = edge.dest;
        if (!isVisited[neighbor]) {
            dfs(graph, isVisited, neighbor);
        }
    }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge>[] graph = new ArrayList[V]; // Array of ArrayLists to hold edges

        // Initialize each vertex's adjacency list
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        /*
         * Simplified Graph Diagram:
         *
         *     (0)
         *    /   \
         *  5 /     \ 3
         *  /         \
         * (1)---2---(2)
         *     \
         *      4
         *       \
         *        (3)
         *
         * Description:
         * - Vertex 0 is connected to Vertex 1 (weight 5) and Vertex 2 (weight 3).
         * - Vertex 1 is connected to Vertex 0 (weight 5), Vertex 2 (weight 2), and Vertex 3 (weight 4).
         * - Vertex 2 is connected to Vertex 0 (weight 3) and Vertex 1 (weight 2).
         * - Vertex 3 is connected to Vertex 1 (weight 4).
         */

        // Adding edges to the graph
        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 3));

        // 1 - vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 2));
        graph[1].add(new Edge(1, 3, 4));

        // 2 - vertex
        graph[2].add(new Edge(2, 0, 3));
        graph[2].add(new Edge(2, 1, 2));

        // 3 - vertex
        graph[3].add(new Edge(3, 1, 4));

        // Display the adjacency list representation of the graph
        // for (int i = 0; i < V; i++) {
        //     System.out.println("Edges from vertex " + i + ":");
        //     for (Edge edge : graph[i]) {
        //         System.out.println("  -> " + edge);
        //     }
        //     System.out.println();
        // }

        bfs(graph);
        System.out.println(" ");
        dfs(graph, new boolean[graph.length], 0);
    }
}


