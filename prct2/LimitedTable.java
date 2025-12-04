// CSD Mar 2013 Juansa Sendra
package prct2;

public class LimitedTable extends RegularTable { //max 4 in dinning-room
    public int counter = 0;

    public LimitedTable(StateManager state) {super(state);}

    public synchronized void enter(int id) throws InterruptedException {
        while (counter >= 4) wait();
        state.enter(id);
        counter++;
    }
    public synchronized void exit(int id)  {
        state.exit(id);
        counter--;
        notifyAll();
    }
}
