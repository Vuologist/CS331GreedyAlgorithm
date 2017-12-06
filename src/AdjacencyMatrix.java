import java.util.Random;

public class AdjacencyMatrix {

    private int[][] sparseGraph;
    private int[][] denseGraph;

    public AdjacencyMatrix(int nodes){
        sparseGraphGenerator(nodes);
        //denseGraphGenerator(nodes);
    }

    private void sparseGraphGenerator(int nodes){
        int[] linkRowTracker = new int[nodes];
        sparseGraph = new int[nodes][nodes];
        Random rand = new Random();

        //fill each index with 0
        for(int i=0; i<linkRowTracker.length;i++)
            linkRowTracker[i] = 0;

        //adjacency matrix
        for(int i=0; i<nodes; i++){
            for(int j=0; j<nodes; j++){
                int connectionDeterminer = rand.nextInt(2);
                //control amount of links to element
                if(linkRowTracker[i] == 3) {
                    continue;
                //prevent loop back
                } else if(i==j) {
                    sparseGraph[i][j] = 0;
                    //continue;
                //determine if there is a link or not
                } else if (connectionDeterminer == 1){
                    sparseGraph[i][j] = 1;
                    sparseGraph[j][i] = 1;
                    linkRowTracker[i]++;
                    System.out.println(linkRowTracker[i]);
                } else{
                    sparseGraph[i][j] = 0;
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

        for(int i=0; i<graph.length+1; i++){
            for(int j=0; j<graph.length+1; j++){
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

        /*
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph.length; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }**/
    }
}
