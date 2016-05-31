/**
 * Created by Thi on 31.05.2016.
 */
public class Graph {

    /**
     * Kantenliste des Graphen
     */
    private DoubleLinkedList<Edge> edges;

    /**
     * Knotenliste des Graphen
     */
    private DoubleLinkedList<Graphnode> nodes;

    /**
     * Graph-Konstruktor
     */
    public Graph() {
        edges = new DoubleLinkedList<Edge>();
        nodes = new DoubleLinkedList<Graphnode>();
    }

    /**
     *
     * @param graphnode1 "Linker" Knoten des Kante
     * @param graphnode2 "Rechter" Knoten der Kante
     * @param weight Gewicht der Kante
     */
    public void add(Graphnode graphnode1, Graphnode graphnode2, int weight) {
        graphnode1 = nodes.insert(graphnode1);
        graphnode2 = nodes.insert(graphnode2);
        Edge edge =  new Edge(graphnode1,graphnode2,weight);
        edges.insert(edge);
    }

    /**
     * Einfuegen einer Kante
     * @param edge Einzufuegende Kante
     */
    public void add(Edge edge) {
        add(edge.a,edge.b,edge.weight);
    }

    public Graphnode[] getAdjacentNodes(Graphnode node) {
        int count = 0;
        for (int i = 1; i <= edges.length(); i++) {
            if ((edges.get(i).a.equals(node) && !edges.get(i).b.isVisited()) || (edges.get(i).b.equals(node) && !edges.get(i).a.isVisited())) {
                count++;
            }
        }
        int j = 0;
        Graphnode[] retnodes = new Graphnode[count];
        for (int i=1; i<= edges.length();i++) {
            if (edges.get(i).a.equals(node)) {
                if (!edges.get(i).b.isVisited()) {
                    retnodes[j] = edges.get(i).b;
                    j++;
                }
            } else if (edges.get(i).b.equals(node)) {
                if (!edges.get(i).a.isVisited()) {
                    retnodes[j] = edges.get(i).a;
                    j++;
                }
            }
            if (j>count) break;
        }
        return retnodes;
    }

    @Override
    public String toString() {
        String ret = "";
        for (int i=1;i<=edges.length();i++) {
            Edge edge = edges.get(i);
            ret += edge.toString();
        }
        return ret;
    }

    public void delete(Edge edge) {
        edges.delete(edge);
    }

    public int length() {
        return edges.length();
    }

    public Edge getEdge(int index) {
        return edges.get(index);
    }

    public boolean areVerticesConnected(Graphnode a, Graphnode b) {
        boolean ret = ReverseDelete.dfs(this,null,a,b);
        for(int i = 1; i <= nodes.length(); i++) {
            nodes.get(i).unvisit();
        }
        return ret;
    }
}
