public class Main {
    public static void main(String args[]){
        EngineKruskals kruskals = new EngineKruskals(10, 1);
        System.out.println("Format of result: {node, weight, node}");
        System.out.println(kruskals.edgesSortedByWeight());
    }
}
