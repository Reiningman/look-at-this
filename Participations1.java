/*
This class will be used in future assignments and in the ad-hoc
assignment.  It is recommended to solve Assignment 3.1, 3.2 and 3.3
*/
// Objects of class 'Participations1' contain participations from
// several races.  The implementation uses a linked list.  It does not
// use classes from the Collections Framework (e.g. LinkedList)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.

public class Participations1 {

    // Assignment 3.1

    // Introduce (private) object variables and classes as needed.

    // Creates an empty object of this class

    private int nodeCount;
    public MyQueue listNode;


    public Participations1(int n) {
        listNode = new MyQueue();

    }

    // Creates an empty object of this class
    public Participations1() {
        listNode = new MyQueue();
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        listNode.add(p);
        nodeCount++;
    }

    public PartIterator iterator (){
        MyIter iterator = new MyIter(this);
        return iterator;

    }



    public void addAfter(String myRace, Participation p) {
        int i = 0;

        int lastFound=-1;
        while (listNode.peekAt(i)!=null) {
            Participation k = listNode.peekAt(i);
            String s = k.getRace();
            if (s.equals(myRace)) {
                lastFound =i;
            }
            i++;
        }
        if (lastFound!=-1){ listNode.addAt(p,lastFound);}
        else {listNode.addAt(p,i);}


    }

    public void addBefore(String myRace, Participation p) {
        int i=0;
        boolean found = false;
        while (listNode.peekAt(i)!=null && !found){
            Participation k = listNode.peekAt(i);
            String s = k.getRace();
            if (s.equals(myRace)){

                    listNode.addAt(p, i);

                nodeCount++;
                found = true;
            }
            i++;
        }
        if (!found) add(p);
    }

    public void remove(String r) {
        int i=0;
        String s;
        boolean done = false;
        while (listNode.peekAt(i)!=null && !done) {
            s = listNode.peekAt(i).getRace();
            if (s.equals(r)){
                listNode.removeAt(i);
                done = true;
                nodeCount--;
            }
            i++;
        }
    }
    
    // Print the entries in the order of insertion; each participation
    // is printed in the same format as produced by print() in
    // Participation, followed by a newline.
    public void print() {
        int i=0;
        while(listNode.peekAt(i)!=null) {
               if (listNode.peekAt(i)!=null) listNode.peekAt(i).print();
               i++;
        }
        System.out.println();
    }

    public MyListNodeBetter start(){
        return listNode.head;
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {
        for (int i = 0; i < nodeCount ; i++) {
            Participation x = listNode.peekAt(i);
            if (x.getRacer().compareTo(r) ==0){
            return x;
            }
        }
        return null;
    }




    // Fragen:

    // 1) Wie unterscheidet sich Ihre Implementierung von
    // Participations1 bis hierher von Ihrer Implementierung von
    // Participations?  Welche Vor- und Nachteile haben die beiden
    // Implementierungen im Vergleich?  Wäre eine
    // Array-Implementierung, die das Array gegen ein doppelt so
    // großes tauscht, wenn der Platz nicht mehr reicht, für diese
    // Aufgabe weniger aufwändig?

    // 2) Hat der Parameter des Konstruktors eine Funktion? Wenn doch,
    // welche? Wenn nicht, ist es sinnvoll, den Parameter zu behalten?
    // Warum, bzw. warum nicht?

    // 3) Muss Ihre Implementierung bei jedem add-Aufruf die ganze
    // Liste durchgehen? Wenn ja, wie könnte man das vermeiden und
    // wieviel Programmieraufwand wäre nötig? Wenn nein, wieviel
    // Programmieraufwand hat das gekostet?

    
    // Assignment 3.2 (continued in Participations2.java)
    
    // Returns the first participation (the one that was inserted
    // earliest) in 'this'.  If there is no such participation, return
    // null.
    public Participation first() {
        return listNode.peek();
    }


    // Assignment 3.3 (continued in Participations2.java)

    // print the entries with bibnumber<=x in the order of insertion;
    // each participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    void print(int x) {
        for (int i = 0; i < nodeCount ; i++) {
            Participation y = listNode.peekAt(i);
            if (y.getBibnumber() <= x){
                y.print();
            }
        }
    }

    void print(int x, String y) {
        for (int i = 0; i < nodeCount ; i++) {
            Participation p = listNode.peekAt(i);
            if (p.getBibnumber() > x && p.getRace().compareTo(y) > 0){
                p.print();
            }
        }
    }

    public String toString (String x, int y){
        String combinedString = "";
        for (int i = 0; i < nodeCount; i++) {
            if ((listNode.peekAt(i).getRace().compareTo(x) <= 0) && listNode.peekAt(i).getBibnumber()<=y){
                combinedString+= listNode.peekAt(i);
            }
        }
        return combinedString;
    }

    public String toString(){
        String s ="";
        int i=0;
        while (listNode.peekAt(i)!=null) {
            s+=listNode.peekAt(i).getBibnumber()+" " +listNode.peekAt(i).getRacer()+" ("+listNode.peekAt(i).getRace()+") ";
            i++;
        }
        return s;
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
        Participations1 p = new Participations1(3);
        p.add(new Participation("a","a",1));
        p.add(new Participation("b","b",2));
        p.add(new Participation("c","c",3));


        p.addAfter("a",new Participation("a","a",3));
        p.addBefore("c",new Participation("c","a",30));
        p.remove("b");


        p.print();
       // p.lookupRacer("b").print();
       // p.first().print();
        //p.print(2);

    }

}
