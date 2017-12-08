import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        Scanner kb = new Scanner(System.in);
        //EngineKruskals kruskals = new EngineKruskals(10, 1);
        //EngineKruskals kruskals = new EngineKruskals(50, 2);
        EnginePrim prim = new EnginePrim(10,1);
        //System.out.println("Format of result: {node, weight, node}");
        //System.out.println(kruskals.edgesSortedByWeight());
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
            System.out.println(kruskals.weightOfEdgeBetweenTwoNodes(node1, node2));
            System.out.println("Exit by entering -1 into Node1");
        } while (node1 != -1);*/
    }
}
