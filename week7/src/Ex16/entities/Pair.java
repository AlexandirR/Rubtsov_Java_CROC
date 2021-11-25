package Ex16.entities;

public class Pair<T1 extends Comparable, T2 extends Comparable> implements Comparable {
    private T1 first = null;
    private T2 second = null;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        if(this.first == null && this.second == null)
            return "Empty";
        if(this.first == null)
            return "-" + this.second.toString();
        if(this.second == null)
            return this.first.toString() + "+";
        return this.first.toString() + "-" + this.second.toString();
    }

    @Override
    public int hashCode() {
        return this.first.hashCode() + this.second.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Pair))
            return false;
        return this.first.equals(((Pair<?, ?>) obj).first) && this.second.equals(((Pair<?, ?>) obj).second);
    }

    @Override
    public int compareTo(Object o) {
        return this.first.compareTo(((Pair<?, ?>) o).first);
    }
}
