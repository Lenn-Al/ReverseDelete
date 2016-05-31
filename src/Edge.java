/**
 * Kanten-Klasse
 */
public class Edge implements Comparable<Edge>{
    Graphnode a;
    Graphnode b;
    int weight;

    public Edge(Graphnode a, Graphnode b, int weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Edge)){
            return false;
        }
        Edge edge = (Edge) o;

        boolean equals = this.a.equals(edge.a) && this.b.equals(edge.b);
        boolean equalsReverse = this.a.equals(edge.b) && this.b.equals(edge.a);
        return equals || equalsReverse;
    }

    @Override
    public int compareTo(Edge localEdge) {
        return weight-localEdge.weight; //TODO soll compareTo nicht -1,0,1 liefern?
    }

    @Override
    public String toString() {
        String ret = "";
        ret += a.toString() + ';' + b.toString() + ';' + weight + "\n";

        return ret;
    }

    public Graphnode getA() {
        return a;
    }
    
    public Graphnode getB() {
        return b;
    }
    
    public int getWeight() {
        return weight;
    }
    
}