import java.util.Random;

public class AdjacencyMatrix {

    private int[][] sparseGraph;
    private int[][] denseGraph;
    private int[][] sparseGraphPrim;

    public AdjacencyMatrix(int nodes, int graphType, String graph){
        if(graphType == 1 && graph.equals("prims")) {
            //sparseGraphGenerator(nodes);
            sparseGraphGeneratorPrim(nodes);
            // graphType 2
        } else
            denseGraphGenerator(nodes);
    }

    public int[][] getGraph(int graphType){
        if(graphType == 1)
            return sparseGraphPrim;
            // graphType 2
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
    //creates a sparse graph with a limit of 3 connections per node max
    private void sparseGraphGeneratorPrim(int nodes){
        sparseGraphPrim = new int[nodes+1][nodes+1];
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
                    sparseGraphPrim[i][j] = weight;
                    sparseGraphPrim[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    sparseGraphPrim[i][j] = 0;
                    continue;
                } else if(sparseGraphPrim[i][j] == 0){
                    sparseGraphPrim[i][j] = 2000;
                }
            }
        }
        //printMatrix(sparseGraphPrim);
    }

    //creates a dense graph with a limit of (nodes*(nodes-1))/2
    //connections per node max
    private void denseGraphGenerator(int nodes){
        denseGraph = new int[nodes+1][nodes+1];
        Random rand = new Random();
        int connectionDeterminer;
        int weight;
        int linkLimiter;
        int edgesCount = (nodes*(nodes-1))/2;
        //adjacency matrix
        //weight 0 is infinity
        for(int i=1; i<=nodes; i++){
            linkLimiter = 0;
            for(int j=1; j<=nodes; j++){
                connectionDeterminer = rand.nextInt(100);
                weight = rand.nextInt(1000)+1;
                //control amount of links to element
                if(connectionDeterminer%2==0 && linkLimiter < edgesCount){
                    denseGraph[i][j] = weight;
                    denseGraph[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    denseGraph[i][j] = 0;
                    continue;
                }
            }
        }
        //printMatrix(denseGraph);
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
