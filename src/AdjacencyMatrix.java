import java.util.Random;

public class AdjacencyMatrix {

    private int[][] sparseGraphKruskals;
    private int[][] denseGraphKruskals;
    private int[][] sparseGraphPrims;
    private int[][] denseGraphPrims;

    //graph type 1 is sparse
    //graph type 2 is dense
    public AdjacencyMatrix(int nodes, int graphType, String graphName){
        if(graphType == 1 && graphName.equals("prims")) {
            sparseGraphGeneratorPrims(nodes);
        } else if (graphType == 1 && graphName.equals("kruskals")) {
            sparseGraphGeneratorKruskals(nodes);
        } else if (graphType == 2 && graphName.equals("prims")) {
            denseGraphGeneratorPrims(nodes);
        } else if (graphType == 1 && graphName.equals("kruskals")){
            denseGraphGeneratorKruskals(nodes);
        }
    }

    public int[][] getGraph(int graphType, String graphName){
        if(graphType == 1 && graphName.equals("prims")) {
            return  sparseGraphPrims;
        } else if (graphType == 1 && graphName.equals("kruskals")) {
            return sparseGraphKruskals;
        } else if (graphType == 2 && graphName.equals("prims")) {
            return denseGraphPrims;
        } else if (graphType == 1 && graphName.equals("kruskals")){
            return  denseGraphKruskals;
        } else
            return null;
    }

    //creates a sparse graph with a limit of 3 connections per node max
    private void sparseGraphGeneratorKruskals(int nodes){
        sparseGraphKruskals = new int[nodes+1][nodes+1];
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
                    sparseGraphKruskals[i][j] = weight;
                    sparseGraphKruskals[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    sparseGraphKruskals[i][j] = 0;
                    continue;
                }
            }
        }
        //printMatrix(sparseGraphKruskals);
    }
    //creates a sparse graph with a limit of 3 connections per node max
    private void sparseGraphGeneratorPrims(int nodes){
        sparseGraphPrims = new int[nodes+1][nodes+1];
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
                    sparseGraphPrims[i][j] = weight;
                    sparseGraphPrims[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    sparseGraphPrims[i][j] = 0;
                    continue;
                } else if(sparseGraphPrims[i][j] == 0){
                    sparseGraphPrims[i][j] = 2000;
                }
            }
        }
        //printMatrix(sparseGraphPrims);
    }

    //creates a dense graph with a limit of (nodes*(nodes-1))/2
    //connections per node max
    private void denseGraphGeneratorKruskals(int nodes){
        denseGraphKruskals = new int[nodes+1][nodes+1];
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
                    denseGraphKruskals[i][j] = weight;
                    denseGraphKruskals[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    denseGraphKruskals[i][j] = 0;
                    continue;
                }
            }
        }
        //printMatrix(denseGraphKruskals);
    }

    //creates a dense graph with a limit of (nodes*(nodes-1))/2
    //connections per node max
    private void denseGraphGeneratorPrims(int nodes){
        denseGraphPrims = new int[nodes+1][nodes+1];
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
                    denseGraphPrims[i][j] = weight;
                    denseGraphPrims[j][i] = weight;
                    linkLimiter++;
                }
                if(i == j){
                    denseGraphPrims[i][j] = 0;
                    continue;
                } else if(denseGraphPrims[i][j] == 0){
                    denseGraphPrims[i][j] = 2000;
                }
            }
        }
        //printMatrix(denseGraphPrims);
    }

//    //prints graph
//    private void printMatrix(int[][] graph){
//        for (int i = 1; i <= graph.length-1; i++)
//            System.out.print("\t" + i);
//        System.out.println();
//        for (int source = 1; source <= graph.length-1; source++) {
//            System.out.print(source + "\t");
//            for (int destination = 1; destination <= graph.length-1; destination++) {
//                System.out.print(graph[source][destination] + "\t");
//            }
//            System.out.println();
//        }
//    }
}
