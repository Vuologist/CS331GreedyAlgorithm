public class EnginePrim {
    /*
    // Prim-Jarník's algorithm to find MST rooted at s
    public static int [] prim (WeightedGraph G, int s) {
        final int [] dist = new int [G.size()];  // shortest known distance to MST
        final int [] pred = new int [G.size()];  // preceeding node in tree
        final boolean [] visited = new boolean [G.size()]; // all false initially

        for (int i=0; i<dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;

        for (int i=0; i<dist.length; i++) {
            final int next = minVertex (dist, visited);
            visited[next] = true;
            // The edge from pred[next] to next is in the MST (if next!=s)
            final int [] n = G.neighbors (next);
           for (int j=0; j<n.length; j++) {
            final int v = n[j];
                23             final int d = G.getWeight(next,v);
                24             if (dist[v] > d) {
                    25                dist[v] = d;
                    26                pred[v] = next;
                    27             }
                28          }
            29       }
        30       return pred;  // (ignore pred[s]==0!)
        31    }
 32
         33    private static int minVertex (int [] dist, boolean [] v) {
        34       int x = Integer.MAX_VALUE;
        35       int y = -1;   // graph not connected, or no unvisited vertices
        36       for (int i=0; i<dist.length; i++) {
            37          if (!v[i] && dist[i]<x) {y=i; x=dist[i];}
            38       }
        39       return y;
        40    }
        */
}
