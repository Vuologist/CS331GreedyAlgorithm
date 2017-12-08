
public class EnginePrim {
    private boolean unsettled[];
    private boolean settled[];
    private int numberOfNodes;
    private int adjacencyMatrix[][];
    private int key[];
    private int INFINITE = 0;
    private int parent[];

    public EnginePrim(int numberOfNodes, int graphType)
    {
        this.numberOfNodes = numberOfNodes;
        unsettled = new boolean[numberOfNodes + 1];
        settled = new boolean[numberOfNodes + 1];
        AdjacencyMatrix graph = new AdjacencyMatrix(numberOfNodes, graphType);
        adjacencyMatrix = graph.getGraph(graphType);
        key = new int[numberOfNodes + 1];
        parent = new int[numberOfNodes + 1];
        primsAlgorithm(adjacencyMatrix);
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
        for (int source = 1; source <= numberOfNodes; source++) {
            for (int destination = 1; destination <= numberOfNodes; destination++) {
                this.adjacencyMatrix[source][destination] = adjacencyMatrix[source][destination];
            }
        }

        for (int index = 1; index <= numberOfNodes; index++) {
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
        for (int vertex = 1; vertex <= numberOfNodes; vertex++) {
            if (unsettled[vertex] == true && key[vertex] < min) {
                node = vertex;
                min = key[vertex];
            }
        }
        return node;
    }

    public void evaluateNeighbours(int evaluationVertex) {
        for (int destinationvertex = 1; destinationvertex <= numberOfNodes; destinationvertex++) {
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

    public void printMST() {
        System.out.println("SOURCE  : DESTINATION = WEIGHT");
        for (int vertex = 2; vertex <= numberOfNodes; vertex++) {
            System.out.println(parent[vertex] + "\t:\t" + vertex +"\t=\t"+ adjacencyMatrix[parent[vertex]][vertex]);
        }
    }
}