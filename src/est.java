/**
 * Created by Thi on 30.05.2016.
 */
public class est {
        public static void main(String[] args) {
            Graph g  = new Graph();
            Graphnode a = new Graphnode("A");
            Graphnode b = new Graphnode("B");
            Graphnode c = new Graphnode("C");
            Graphnode d = new Graphnode("D");
            Graphnode e = new Graphnode("E");
            //Sandohrgraph
            g.add(a,b,2);
            g.add(a,c,1);
            g.add(a,d, 3);
            g.add(a,e,6);
            g.add(c,d,1);
            g.add(b,e,1);
            
            //g.delete(new Edge(d,e,2));
            
            //boolean bool = ReverseDelete.dfs(g, null, d, e);
            if(ReverseDelete.dfs(g, null, d, e)) {System.out.println("Hallo");}
            
            //Edge BE = new Edge(b,e,2);
            //g.delete(BE);
            /*for(Graphnode n : g.getAdjacentNodes(a)) {
                System.out.println(n.toString());
            }
            System.out.println();

            for(Graphnode n : g.getAdjacentNodes(b)) {
                System.out.println(n.toString());
            }
            System.out.println();

            for(Graphnode n : g.getAdjacentNodes(c)) {
                System.out.println(n.toString());
            }
            System.out.println();

            for(Graphnode n : g.getAdjacentNodes(d)) {
                System.out.println(n.toString());
            }
            System.out.println();

            for(Graphnode n : g.getAdjacentNodes(e)) {
                System.out.println(n.toString());
            }
            System.out.println();

            System.out.println();
            System.out.println(g.toString());

            System.out.println();

            System.out.println();

            if (ReverseDelete.dfs(g,null,a,b)) {
                System.out.println("Hallo");
            }*/
            System.out.println(ReverseDelete.reverseDelete(g).toString());

            System.out.println();

            System.out.println(ReverseDelete.reverseDelete(g));
        }
}
