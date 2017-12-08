import java.util.Random;

public class AdjacencyMatrix {

    private int[][] sparseGraph;
    private int[][] denseGraph;

    public AdjacencyMatrix(int nodes, int graphType){
        if(graphType == 1) {
            sparseGraphGenerator(nodes);
        } else
            denseGraphGenerator(nodes);
    }

    public int[][] getGraph(int graphType){
        if(graphType == 1)
            return sparseGraph;
        else
            return denseGraph;
    }

    //creates a sparse graph with a limit of 3 connections per node max
    private void sparseGraphGenerator(int nodes){
        sparseGraph = new int[nodes+1][nodes+1];
        Random rand = new Random();
        int connectionDeterminer;
        int weight;
        int linkLimiter;
        //adjacency matrix
        //weight 0 is infinity
        for(int i=1; i<=nodes; i++){
            linkLimiter = 0;
            for(int j=1; j<=nodes; j++){
                connectionDeterminer = rand.nextInt(100);
                weight = rand.nextInt(1000)+1;
                //control amount of links to element
                if(connectionDeterminer%2==0 && linkLimiter < 3){
                    sparseGraph[i][j] = weight;
                    sparseGraph[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    sparseGraph[i][j] = 0;
                    continue;
                }
            }
        }
        //printMatrix(sparseGraph);
    }

    //copied from sparse no edits yet
    private void denseGraphGenerator(int nodes){sparseGraph = new int[nodes+1][nodes+1];
        Random rand = new Random();
        int connectionDeterminer;
        int weight;
        int linkLimiter;
        //adjacency matrix
        //weight 0 is infinity
        for(int i=1; i<=nodes; i++){
            linkLimiter = 0;
            for(int j=1; j<=nodes; j++){
                connectionDeterminer = rand.nextInt(100);
                weight = rand.nextInt(1000)+1;
                //control amount of links to element
                if(connectionDeterminer%2==0 && linkLimiter < 3){
                    sparseGraph[i][j] = weight;
                    sparseGraph[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    sparseGraph[i][j] = 0;
                    continue;
                }
            }
        }
        //printMatrix(sparseGraph);
    }

    //prints graph
    private void printMatrix(int[][] graph){
        for (int i = 1; i <= graph.length-1; i++)
            System.out.print("\t" + i);
        System.out.println();
        for (int source = 1; source <= graph.length-1; source++) {
            System.out.print(source + "\t");
            for (int destination = 1; destination <= graph.length-1; destination++) {
                System.out.print(graph[source][destination] + "\t");
            }
            System.out.println();
        }
    }
}
