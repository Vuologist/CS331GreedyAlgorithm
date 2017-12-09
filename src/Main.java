import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        final long startTime = System.currentTimeMillis();
        //EngineKruskals kruskalsSparse = new EngineKruskals(100, 1);
        //EngineKruskals kruskalsSparse = new EngineKruskals(500, 1);
        //EngineKruskals kruskalsSparse = new EngineKruskals(1000, 1);
        //EngineKruskals kruskalsSparse = new EngineKruskals(5000, 1);
        //EngineKruskals kruskalsSparse = new EngineKruskals(10000, 1);
        //kruskalsSparse.edgesSortedByWeight();
        //System.out.println("Format of result: {node, weight, node}");
        //System.out.println(kruskalsSparse.edgesSortedByWeight());
        /*
        int node1;
        int node2;
        do {
            System.out.print("Node1: ");
            node1 = kb.nextInt();
            if(node1 == -1)
                continue;
            System.out.print("Node2: ");
            node2 = kb.nextInt();
            System.out.print("Weight between two requested nodes: ");
            System.out.println(kruskalsSparse.weightOfEdgeBetweenTwoNodes(node1, node2));
            System.out.println("Exit by entering -1 into Node1");
        } while (node1 != -1);*/


        //EngineKruskals kruskalsDense = new EngineKruskals(100, 2);
        //EngineKruskals kruskalsDense = new EngineKruskals(500, 2);
        EngineKruskals kruskalsDense = new EngineKruskals(1000, 2);
        //EngineKruskals kruskalsDense = new EngineKruskals(5000, 2);
        //EngineKruskals kruskalsDense = new EngineKruskals(10000, 2);
        kruskalsDense.edgesSortedByWeight();
        //System.out.println("Format of result: {node, weight, node}");
        //System.out.println(kruskalsDense.edgesSortedByWeight());
        /*
        int node1;
        int node2;
        do {
            System.out.print("Node1: ");
            node1 = kb.nextInt();
            if(node1 == -1)
                continue;
            System.out.print("Node2: ");
            node2 = kb.nextInt();
            System.out.print("Weight between two requested nodes: ");
            System.out.println(kruskalsDense.weightOfEdgeBetweenTwoNodes(node1, node2));
            System.out.println("Exit by entering -1 into Node1");
        } while (node1 != -1);*/


        //EnginePrim primsSparse = new EnginePrim(100,1);
        //EnginePrim primsSparse = new EnginePrim(500,1);
        //EnginePrim primsSparse = new EnginePrim(1000,1);
        //EnginePrim primsSparse = new EnginePrim(5000,1);
        //EnginePrim primsSparse = new EnginePrim(10000,1);
        //primsSparse.edgesSortedByWeight();
        //System.out.println("Format of result: {node, weight, node}");
        //System.out.println(primsSparse.edgesSortedByWeight());
        /*
        int node1;
        int node2;
        do {
            System.out.print("Node1: ");
            node1 = kb.nextInt();
            if(node1 == -1)
                continue;
            System.out.print("Node2: ");
            node2 = kb.nextInt();
            System.out.print("Weight between two requested nodes: ");
            System.out.println(primsSparse.weightOfEdgeBetweenTwoNodes(node1, node2));
            System.out.println("Exit by entering -1 into Node1");
        } while (node1 != -1);*/


        //EnginePrim primsDense = new EnginePrim(100,2);
        //EnginePrim primsDense = new EnginePrim(500,2);
        //EnginePrim primsDense = new EnginePrim(1000,2);
        //EnginePrim primsDense = new EnginePrim(5000,2);
        //EnginePrim primsDense = new EnginePrim(10000,2);
        //primsDense.edgesSortedByWeight();
        //System.out.println("Format of result: {node, weight, node}");
        //System.out.println(primsDense.edgesSortedByWeight());
        /*
        int node1;
        int node2;
        do {
            System.out.print("Node1: ");
            node1 = kb.nextInt();
            if(node1 == -1)
                continue;
            System.out.print("Node2: ");
            node2 = kb.nextInt();
            System.out.print("Weight between two requested nodes: ");
            System.out.println(primsDense.weightOfEdgeBetweenTwoNodes(node1, node2));
            System.out.println("Exit by entering -1 into Node1");
        } while (node1 != -1);*/

        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) );
    }
}
