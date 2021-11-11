package Ex11;

public class Lot {

    private volatile int cost;
    private volatile String name = "";
    private final int endTime;
    private static final Object lock = new Object();

    public Lot(int startCost, int endTime) {
        this.endTime = endTime;
        this.cost = startCost;
    }

    public void bid(String name, int cost, int time) {
        synchronized (lock) {
            if (cost > this.cost && time < this.endTime) {
                this.cost = cost;
                this.name = name;
            }
        }
    }

    public synchronized String nowWin() {
        return this.name;
    }
}
