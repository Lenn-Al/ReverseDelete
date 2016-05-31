public class Graphnode implements Comparable<Graphnode>{
    public final String caption;
    private boolean isVisited = false;

    public Graphnode(String caption) {
        this.caption = caption;
    }

    @Override
    public int compareTo(Graphnode anotherGraphnode) {
        return caption.compareTo(anotherGraphnode.caption);
    }

    @Override
    public String toString() {
        String ret = "";
        ret += caption;
        return ret;
    }

    public void visit() {
        isVisited = true;
    }
    
    public void unvisit() {
        isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Graphnode)) {
            return false;
        }
        
        Graphnode n = (Graphnode)o;
        
        return this.caption.equals(n.caption);
    }
}