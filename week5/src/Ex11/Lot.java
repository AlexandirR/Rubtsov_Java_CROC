package Ex11;

public class Lot {

    private volatile int cost;
    private volatile String name = "";
    private final long endTime;

    public Lot(int startCost, long endTime) {
        this.endTime = endTime;
        this.cost = startCost;
    }

    public void bid(String name, int cost, long time) {
            if (cost > this.cost && time < this.endTime) {
                synchronized (this) {
                    if (cost > this.cost) {
                        this.cost = cost;
                        this.name = name;
                    }
                }
            }
    }

    public String nowWin(long time) {
        if(time >= endTime) {
            return this.name;
        }
        else {
            return "Lot in active";
        }
    }
}
