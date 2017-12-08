import java.util.Random;

public class AdjacencyMatrix {

    private int[][] sparseGraph;
    private int[][] denseGraph;

    public AdjacencyMatrix(int nodes){
        sparseGraphGenerator(nodes);
        //denseGraphGenerator(nodes);
    }

    //if x = 1, sparseGraph
    //if x = 2, denseGraph
    public int[][] getGraph(int graphType){
        if(graphType == 1)
            return sparseGraph;
        else
            return denseGraph;
    }


    private void sparseGraphGenerator(int nodes){
        int[] linkRowTracker = new int[nodes];
        sparseGraph = new int[nodes][nodes];
        Random rand = new Random();

        //adjacency matrix
        for(int i=0; i<nodes; i++){
            for(int j=0; j<sparseGraph[i].length; j++){
                int connectionDeterminer = rand.nextInt(2);
                int weight = rand.nextInt(1000);
                //control amount of links to element
                if(linkRowTracker[i] < 4 && i != j && connectionDeterminer == 1){
                    sparseGraph[i][j] = weight;
                    sparseGraph[j][i] = weight;
                    linkRowTracker[i]++;
                    System.out.println(linkRowTracker[i]);
                }
            }
        }
        printMatrix(sparseGraph);
    }

    private void denseGraphGenerator(int nodes){

    }

    private void printMatrix(int[][] graph){
        int row = 1;
        int column = 1;
        /*
        for(int i=0; i<graph.length+1; i++){
            for(int j=0; j<graph[i].length+1; j++){
                if(i==0) {
                    if (j == 0)
                        System.out.print("  ");
                    System.out.print(row++ + "  ");
                }else if (j==0)
                    System.out.print(column++ + " ");
                else
                    System.out.print(graph[i-1][j-1] + "  ");
            }
            System.out.println();
        }
        */
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++){
                System.out.print(graph[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
