import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    //int numVertices;
    Map<Integer, List<Integer>> adjList;
    public Graph(){
        //numVertices = 0;
        adjList = new HashMap<>();
    }
    public void addVertex(int v){
        adjList.put(v, new ArrayList<>());
    }
    public void addEdge(int v1, int v2){
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }
    public void printGraph(){
        for (int v : adjList.keySet()){
            System.out.print(v + ": ");
            for (int n : adjList.get(v)){
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

}
