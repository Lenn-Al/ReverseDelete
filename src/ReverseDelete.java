import java.util.Stack;

/**
 * Created by Thi on 31.05.2016.
 */
public class ReverseDelete {
    public static boolean dfs(Graph graph, Stack<Graphnode> stack, Graphnode node, Graphnode goal) {
        //System.out.println(graph.toString());
        boolean isFound = false;
        if (stack == null) {
            stack = new Stack<>();
        }
        node.visit();
        for(Graphnode n : graph.getAdjacentNodes(node)) {
            if (n.equals(goal)) {
                isFound = true;
            }
            else if(!n.isVisited()) {
                isFound = dfs(graph,stack, n, goal);
            }
            
            if(isFound) break;
        }
        return isFound;
    }

    public static Graph reverseDelete(Graph Zahl) {
        int i = 0;
        /*while (i<=Zahl.length()) {
            Edge edge = Zahl.getEdge(i);
            Zahl.delete(edge);
            if (!Zahl.areVerticesConnected(edge)) {
                Zahl.add(edge);
            } else {
                i--;
            }
            i++;
        }*/
        
        Edge[] edges = new Edge[Zahl.length()];
        for (int j = 0; j < edges.length; j++) {
            edges[j] = Zahl.getEdge(j+1);
        }
        
        while (i < edges.length) {
            Graphnode a = edges[i].getA();
            Graphnode b = edges[i].getB();
            int weight = edges[i].getWeight();
            
            Zahl.delete(edges[i]);
            //Graoh nicht mehr zusammenhaengend
            if(!Zahl.areVerticesConnected(a,b)) {
                Zahl.add(new Edge(a,b,weight));
            }
            i++;
        }
        return Zahl;
    }

}
