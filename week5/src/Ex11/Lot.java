package Ex11;

public class Lot {

    private volatile int cost;
    private volatile String name = "";
    private final int endTime;

    public Lot(int startCost, int endTime) {
        this.endTime = endTime;
        this.cost = startCost;
    }

    public void bid(String name, int cost, int time) {
            if (cost > this.cost && time < this.endTime) {
                synchronized (this) {
                    if (cost > this.cost) {
                        this.cost = cost;
                        this.name = name;
                    }
                }
            }
    }

    public String nowWin(int time) {
        if(time < endTime) {
            return this.name;
        }
        else {
            return "Lot in active";
        }
    }
}
