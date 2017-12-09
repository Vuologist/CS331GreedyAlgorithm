import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EnginePrim {
    private boolean unsettled[];
    private boolean settled[];
    private int numOfNodes;
    private int adjacencyMatrix[][];
    private int storeMST[][];
    private int key[];
    private int INFINITE = 2000;
    private int parent[];

    public EnginePrim(int numberOfNodes, int graphType) {
        this.numOfNodes = numberOfNodes;
        unsettled = new boolean[numOfNodes + 1];
        settled = new boolean[numOfNodes + 1];
        key = new int[numOfNodes + 1];
        parent = new int[numOfNodes + 1];
        AdjacencyMatrix graph = new AdjacencyMatrix(numOfNodes, graphType, "prims");
        adjacencyMatrix = graph.getGraph(graphType, "prims");
        printMatrix(adjacencyMatrix);
        primsAlgorithm(adjacencyMatrix);
        //printMatrix(adjacencyMatrix);
        //storeMST();
        printMST();
    }

    public int getUnsettledCount(boolean unsettled[]) {
        int count = 0;
        for (int index = 0; index < unsettled.length; index++) {
            if (unsettled[index])
                count++;
        }
        return count;
    }

    public void primsAlgorithm(int adjacencyMatrix[][]) {
        int evaluationVertex;
//        for (int source = 1; source <= numOfNodes; source++) {
//            for (int destination = 1; destination <= numOfNodes; destination++) {
//                this.adjacencyMatrix[source][destination] = adjacencyMatrix[source][destination];
//            }
//        }

        for (int index = 1; index <= numOfNodes; index++) {
            key[index] = INFINITE;
        }
        key[1] = 0;
        unsettled[1] = true;
        parent[1] = 1;

        while (getUnsettledCount(unsettled) != 0) {
            evaluationVertex = getMimumKeyVertexFromUnsettled(unsettled);
            unsettled[evaluationVertex] = false;
            settled[evaluationVertex] = true;
            evaluateNeighbours(evaluationVertex);
        }
    }

    private int getMimumKeyVertexFromUnsettled(boolean[] unsettled2) {
        int min = Integer.MAX_VALUE;
        int node = 0;
        for (int vertex = 1; vertex <= numOfNodes; vertex++) {
            if (unsettled[vertex] == true && key[vertex] < min) {
                node = vertex;
                min = key[vertex];
            }
        }
        return node;
    }

    public void evaluateNeighbours(int evaluationVertex) {
        for (int destinationvertex = 1; destinationvertex <= numOfNodes; destinationvertex++) {
            if (settled[destinationvertex] == false) {
                if (adjacencyMatrix[evaluationVertex][destinationvertex] != INFINITE) {
                    if (adjacencyMatrix[evaluationVertex][destinationvertex] < key[destinationvertex]) {
                        key[destinationvertex] = adjacencyMatrix[evaluationVertex][destinationvertex];
                        parent[destinationvertex] = evaluationVertex;
                    }
                    unsettled[destinationvertex] = true;
                }
            }
        }
    }

    public String edgesSortedByWeight(){
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>();
        String result = "{";
        //locates each weight and stores within a hashtable
        for(int i = 1; i <= numOfNodes; i++){
            for(int j = 1; j <= numOfNodes; j++){
                if(storeMST[i][j] != 0)
                    tm.put(storeMST[i][j], Integer.toString(i) + Integer.toString(j));
            }
        }

        Set set = tm.entrySet();
        Iterator i = set.iterator();
        while(i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            result = result + "{"
                    + me.getValue().toString().charAt(0)
                    + "," + me.getKey() + ","
                    + me.getValue().toString().charAt(1)
                    + "} ";
        }
        return result + "}";
    }

    public String weightOfEdgeBetweenTwoNodes(int node1, int node2){
        if(storeMST[node1][node2] == 0)
            return "INFINITY";
        else
            return Integer.toString(storeMST[node1][node2]);
    }

    //copied
    private void printMatrix(int[][] graph){
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
        for (int i = 1; i <= graph.length-1; i++){
            System.out.println();
            for(int j = 1; j <= graph.length-1; j++)
                System.out.print(graph[i][j] + "\t");
        }
    }

    public void printMST()
    {   /*
        for(int i=0; i<parent.length;i++){
            System.out.print(parent[i] + " ");
        }*/

        System.out.println("SOURCE  : DESTINATION = WEIGHT");
        for (int vertex = 2; vertex <= numOfNodes; vertex++)
        {
            System.out.println(parent[vertex] + "\t:\t" + vertex +"\t=\t"+ adjacencyMatrix[parent[vertex]][vertex]);
        }
    }

    private void storeMST() {
        storeMST = new int[numOfNodes+1][numOfNodes+1];
        for (int z = 2; z <= numOfNodes; z++) {
            storeMST[parent[z]][z] = adjacencyMatrix[parent[z]][z];
        }
        //printMatrix(storeMST);
    }
}