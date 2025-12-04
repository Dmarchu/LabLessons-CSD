package prct3;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Native monitor based Terrain
 * 
 * @author CSD Juansa Sendra
 * @version 2021
 */
public class Terrain1 implements Terrain {
    Viewer v;
    ReentrantLock lock = new ReentrantLock();

    public Terrain1(int t, int ants, int movs, String msg) {
        v=new Viewer(t,ants,movs,msg);
    }

    public synchronized void     hi      (int a) {v.hi(a);    }
    public synchronized void     bye     (int a) {notifyAll();v.bye(a);    }
    public synchronized void     move    (int a) throws InterruptedException {
        v.turn(a); Pos dest=v.dest(a); 
        while (v.occupied(dest)) {wait(); v.retry(a);}
        v.go(a); notifyAll();
    }
}