/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 2.3 and 2.4
*/
// Objects of class 'Participations' contain participations from
// several races.  The implementation uses an array.
public class Participations {

    // Assignment 2.3



    // Introduce (private) object variables as needed.
private Participation[] p;
private ParticipationsIter iterator;

    // Creates an empty object of this class with space for n entries.
    public Participations(int n) {
        p = new Participation[n];
        iterator = new ParticipationsIter(this);

    }

    public Participations(Participations l, String x, String y) {
        this.p = new Participation[l.p.length];


        for(Participation p : l.p) {
            if(p != null && p.getRace().compareTo(x) < 0 && p.getRacer().compareTo(y) <= 0){
                this.add(p);
            }
        }
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        int i=0;
        while (this.p[i]!=null) {
            i++;
        }
        this.p[i]=p;

    }

    public Participation peekAt (int x) {
        if (x< p.length){
        return this.p[x];}
        else {return null;}
    }
    
    // Print the filled entries in the order of insertion; each
    // participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    public void print() {
        int i=0;
        while (this.p[i]!=null) {
            this.p[i].print();
            i++;
        }
        System.out.println();
    }

    // Frage:

    // Wie unterscheidet sich Ihre Implementierung von Participations
    // bis hierher von Ihrer Implementierung von StartList?  Wenn Sie
    // in StartList Vorbedingungen ausgenutzt haben, um die
    // Implementierung zu vereinfachen, hat sich das in der
    // Gesamtsicht ausgezahlt?  Begründen Sie Ihre Antwort.


    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        int i=0;
        while(this.p[i]!=null) {
            if (this.p[i].getRacer().equals(r)) return this.p[i];
        }
        return null;
    }

    // Frage:

    // Sie können die erste participation finden, indem Sie beim
    // ersten eingefügten Element anfangen, oder beim letzten.  Welche
    // Variante haben Sie gewählt?  Welche ist aufwändiger zu
    // Programmieren?  Welche ist zur Laufzeit aufwändiger?  Begründen
    // Sie Ihre Antworten.


    // Assignment 2.4

    // introduce additional object variables if needed

    // Creates a 'Participations' object that contains all
    // participations where race.compareTo(r1)>=0 and
    // race.compareTo(r2)<=0.  The entries are in the same order as in
    // l; add will not be used on objects produced with this
    // constructor.
//    public Participations(Participations l, String r1, String r2) {
//        this(l.firstNull);
//        for (int i = 0; i < l.p.length; i++) {
//            if(l.p[i].getRace().compareTo(r1)>=0 && l.p[i].getRace().compareTo(r2)<=0){
//                this.add(l.p[i]);
//            }
//        }
//
//        }
    // Frage:

    // Welche Auswirkung hat die Einschränkung, dass add nicht auf mit
    // diesem Konstruktor erzeugte Objekte angewendet wird, auf Ihr
    // Programm?
    

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
        Participations p = new Participations(4);
        p.add(new Participation("a","a",1));
        p.add(new Participation("b","b",2));
        p.add(new Participation("c","c",3));
        Participations q = new Participations(p,"c","b");

        ParticipationsIter k = new ParticipationsIter(p);
        for (int i = 0; i < p.p.length ; i++) {
            if (k.hasNext()) {
                if (k.next() != null) {
                    k.next().print();
                } else {
                    k.next();
                }
            } else {
                k.next();
            }
        }
        q.print();
    }
}
