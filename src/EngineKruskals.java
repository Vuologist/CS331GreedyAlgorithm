import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EngineKruskals {
    private List<Edge> edges;
    private int infinity = 0;
    private int[] visited;
    private int[][] spanningTree;
    private int[][] adjacencyMatrix;
    private int[][] storeMST;
    private int numberOfVertices;

    //might throw an error because of +1 in original program
    public EngineKruskals(int nodes, int graphType){
        this.numberOfVertices = nodes;
        edges = new LinkedList<Edge>();
        visited = new int[this.numberOfVertices + 1];
        spanningTree = new int[numberOfVertices + 1][numberOfVertices + 1];
        AdjacencyMatrix graph = new AdjacencyMatrix(nodes, graphType);
        adjacencyMatrix = graph.getGraph(graphType);
        kruskalAlgorithm(adjacencyMatrix);
        storeMST();
    }

    private void kruskalAlgorithm(int adjacencyMatrix[][]) {
        boolean finished = false;
        for (int source = 1; source <= numberOfVertices; source++) {
            for (int destination = 1; destination <= numberOfVertices; destination++) {
                if (adjacencyMatrix[source][destination] != infinity && source != destination) {
                    Edge edge = new Edge();
                    edge.sourcevertex = source;
                    edge.destinationvertex = destination;
                    edge.weight = adjacencyMatrix[source][destination];
                    adjacencyMatrix[destination][source] = infinity;
                    edges.add(edge);
                }
            }
        }
        Collections.sort(edges, new EdgeComparator());
        CheckCycle checkCycle = new CheckCycle();
        for (Edge edge : edges) {
            spanningTree[edge.sourcevertex][edge.destinationvertex] = edge.weight;
            spanningTree[edge.destinationvertex][edge.sourcevertex] = edge.weight;
            if (checkCycle.getCheckCyle(spanningTree, edge.sourcevertex)) {
                spanningTree[edge.sourcevertex][edge.destinationvertex] = 0;
                spanningTree[edge.destinationvertex][edge.sourcevertex] = 0;
                edge.weight = -1;
                continue;
            }
            visited[edge.sourcevertex] = 1;
            visited[edge.destinationvertex] = 1;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 0) {
                    finished = false;
                    break;
                } else {
                    finished = true;
                }
            }
            if (finished)
                break;
        }
    }
    private void storeMST(){
        storeMST = new int[numberOfVertices+1][numberOfVertices+1];
        for(int source = 1; source <= numberOfVertices; source++){
            for(int destination =1; destination <= numberOfVertices; destination++){
                storeMST[source][destination] = spanningTree[source][destination];
            }
        }
        printMatrix(storeMST);
    }

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