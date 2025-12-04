// CSD feb 2013 Juansa Sendra
 
package prct1;


public class Kid extends Swimmer {
    public Kid(int id, Pool p) {super(id,p);}
    void swims() throws InterruptedException {pool.kidSwims();}
    void rests() throws InterruptedException {pool.kidRests();}
}
