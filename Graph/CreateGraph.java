package Graph;

import java.util.ArrayList;

public class CreateGraph {
    static class Edge {
        int size;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.size = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0-vertex
        graph[0].add(new Edge(0, 1, 5));
        // 1-vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2-vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));
        // 3-vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(4, 2, 2));
        // 4-vertex
        graph[4].add(new Edge(4, 2, 2));

        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            // src,dest,wt
            System.out.print(e.dest);
        }

    }
}
