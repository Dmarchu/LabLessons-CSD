// CSD feb 2013 Juansa Sendra
 package prct1;


public class Instructor extends Swimmer {
    public Instructor(int id, Pool p) {super(id,p);}
    void swims() throws InterruptedException {pool.instructorSwims();}
    void rests() throws InterruptedException {pool.instructorRests();}
}
