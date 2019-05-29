//import org.omg.IOP.TAG_RMI_CUSTOM_MAX_STREAM_FORMAT;

public class Participations4 {
    // Objects of class 'Participations3' contain participations from
    // several races.  The implementation uses a hash table as follows:
    //   - the tuple ('racer','race') is the key (i.e., what the 'equals'
    //     method of 'Participation' implements);
    //   - the values of the hash table are 'Participations' objects.
    // However, the array of the hash table contains 'Participations1'
    // objects.  'Participation' objects with the same index in the
    // array are inserted in the same 'Participations1' object.
    // This variant of hash table implementation is known as separate chaining.

    // This implementation does not use classes from the Collections
    // Framework (e.g., HashMap)
    // <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

    // Assignment 5.2

    // TODO: Introduce (private) object variables, methods and classes as needed.

    private Participations1[] par;
    public Participations4Iter iterator;

    // Creates an empty hash table with room for n 'Participation1' objects
    public Participations4(int n) {
        // TODO: implement this constructor
        par = new Participations1[n];
        iterator = new Participations4Iter(par);
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        if (p==null) return;
        if (par[p.hashCode()%par.length]==null) {
            par[p.hashCode()%par.length]=new Participations1();
        } else {
            par[p.hashCode()].add(p);
        }
    }
    
    // returns a string that contains the participations in arbitrary
    // order, each participation in the format produced by print() in
    // Participation, followed by a newline.
    @Override
    public String toString() {
        String bigString="";
        for (int i = 0; i < par.length ; i++) {
            bigString += par[i].toString();
        }
        return bigString;
    }

    // Print the participations in the format produced by 'toString()'.
    public void print() {
        System.out.println(toString());
    }

    public Participations1[] getArr(){
        return par;
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' that equals() 'p'.  If there is no such
    // participation, return null.
    public Participation lookupRacer(Participation p) {
        int key = p.hashCode();
        if (par[key]!= null) return par[key].first();
        return null;
    }

//    public StringIterable copyRaces() {
//        Part4StringIter iter = new Part4StringIter(this.par);
//        while (iter.hasNext()){
//            iter.next();
//        }
//        return iter.h
//    }

    // Fragen:

    // 1) Wenn in so eine Hash-Tabelle mit n 'Participations1'-Listen
    // m unterschiedliche Participation-Einträge eingefügt werden, wie
    // gross ist die durchschnittliche Länge l der Listen?  Warum kann
    // der durchschnittliche Zugriff deutlich länger dauern als ein
    // durchschnittlicher Zugriff auf eine Liste der Länge l plus der
    // Aufwand, bis die Liste erreicht ist?  Überlegen Sie sich einen
    // besonders langsamen Fall, und wann der garantiert auftritt.
    // Worauf sollte man daher bei der Verwendung von Hash-Tabellen
    // achten?
    
    // 2) Vergleichen Sie diese Art der Kollisionsbehandlung mit der im
    // Skriptum gezeigten. Was sind die Vor- und Nachteile der Methoden?

    // 3) Vergleichen Sie die Klassen
    // 'Participations' bis 'Participations4'.  Was sind die
    // Gemeinsamkeiten und Unterschiede im Verhalten (nicht in der
    // Implementierung). Überlegen Sie sich, wie Sie diese drei
    // Klassen in einer Typhierarchie organisieren würden; welche
    // Typen übernehmen welche Eigenschaften von den übergeordneten
    // Typen, und welche fügen sie hinzu?


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
        Participations4 part4 = new Participations4(18



        );
        Participation p = new Participation("race", "racer", 50 );
        Participation p1 = new Participation("race1", "racer1", 60);
        Participation p2 = new Participation("race", "racer", 55);
        part4.add(p1);
        part4.add(p2);
        part4.add(p);

        Participations4Iter peck = new Participations4Iter(part4.par);
        while (peck.hasNext()) {
            peck.next().print();
        }

    }
}
