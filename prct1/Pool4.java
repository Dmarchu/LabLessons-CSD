// CSD feb 2015 Juansa Sendra

 package prct1;


public class Pool4 extends Pool {   //no kids alone
    private int inSwimming, kiSwimming, ki, cap, insWaiting;
    
    public void init(int ki, int cap) {
        this.ki = ki;
        this.cap = cap;
    }
    
    public synchronized void kidSwims() throws InterruptedException {
        if (inSwimming == 0 || kiSwimming + 1 > inSwimming * (ki / 3) || kiSwimming + inSwimming + 1 > cap || insWaiting > 0) {
            log.waitingToSwim();
            while (inSwimming == 0 || kiSwimming + 1 > inSwimming * (ki / 3) || insWaiting > 0) {
                wait();
            }
        }
        kiSwimming++;
        log.swimming();
        notifyAll();
    }
    
    public synchronized void kidRests() throws InterruptedException {
        kiSwimming--;
        log.resting(); 
        notifyAll();
    }
    
    public synchronized void instructorSwims() throws InterruptedException {
        if (kiSwimming + inSwimming + 1 > cap) {
            log.waitingToSwim();
            while (kiSwimming + inSwimming + 1 > cap) {
                wait();
            }
        }
        inSwimming++;
        log.swimming();
        notifyAll();
    }
    
    public synchronized void instructorRests() throws InterruptedException {
        if ((inSwimming - 1 == 0 && kiSwimming > 0) || kiSwimming > (inSwimming - 1) * (ki / 3)) {
            insWaiting++;
            log.waitingToRest();
            while ((inSwimming - 1 == 0 && kiSwimming > 0) || kiSwimming > (inSwimming - 1) * (ki / 3)) {
                wait();
            }
            insWaiting--;
        }
        inSwimming--;
        log.resting(); 
        notifyAll();
    }
}
