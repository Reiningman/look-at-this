public class Participations3 {
    // Objects of class 'Participations3' contain participations from
    // several races.  The implementation uses a binary search tree as
    // associative data structure, using nodes that implement
    // 'PartTreeNodable'.  The tree uses 'racer' as key, and a
    // 'Participations1' object as value (as does Participations2).
    
    // This implementation does not use
    // classes from the Collections Framework (e.g., TreeMap)
    // <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.


    // Assignment 4.2, also in PartTreeNodable.java, PartTreeNull.java
    // and PartTreeBinary.java

    // TODO: Introduce (private) object variables, methods and classes as needed.
    private PartTreeNodable tree;

    // Creates an empty object of this class
    public Participations3() {
        tree = PartTreeNull.NIL;
    }

    // Adds p to 'this'.
    public void add(Participation p) {
        tree = tree.add(p);
    }
    
    // Print the participations in the same order and format as in
    // Participations2.
    public void print() {
        tree.print();
    }

    // Returns the first participation (the one that was inserted
    // earliest) in 'this' where the 'racer' equals 'r'.  If there is
    // no such participation, return null.
    public Participation lookupRacer(String r) {

        return tree.lookupRacer(r);
    }

    // Fragen:

    // 1) Wie unterscheidet sich Ihre Implementierung von
    // Participations3 bis hierher von Ihrer Implementierung von
    // Participations2?  Welche Vor- und Nachteile haben die
    // Implementierungen im Vergleich?

    // 2) Wozu ist der Rückgabewert des add in PartTreeNodable gut?
    // Wäre es auch möglich, mit einem 'add', das den Unterbaum nicht
    // zurückgibt (auch nicht auf andere Art als mit 'return'), das
    // Einfügen in den Baum zu implementieren, ohne mehr ifs zu
    // verwenden?

    // 3) Wo werden während dieser Aufgabe tatsächlich zur Laufzeit
    // unterschiedliche Implementierungen derselben Methode von der
    // selben Stelle aus aufgerufen?

        
    // Assignment 4.3

    // returns a string that contains the participations in the same
    // order and format as produced by 'print()'.  In other words,
    // print() can be implemented by just outputting the string
    // produced by toString().
    @Override
    public String toString() {
        //  Implement this method.  Add toString() methods in
        //  related classes as appropriate; observe the restrictions
        //  of PartTreeNodable and the classes that implement it.
        return tree.toString();
    }

    public String toString (String x, int y){
        return tree.toString(x, y);
    };

    // Fragen:

    // 1) Muss man dafür toString() zu 'PartTreeNodable' hinzufügen?
    // Darf man es? Begründen Sie Ihre Antwort.

    // 2) Vergleichen Sie die Implementierung von toString() von
    // Participations3 mit einer (hypothetischen oder tatsächlichen)
    // Implementierung von print(), die toString() nicht aufruft.  Was
    // sind die Unterschiede und Gemeinsamkeiten?


    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        Participations3 part25 = new Participations3();

        part25.add(new Participation("a","a",1));
        part25.add(new Participation("a","a",1));

        part25.add(new Participation("b","b",5));
        part25.add(new Participation("b","b",2));
        part25.add(new Participation("c","c",3));
        part25.add(new Participation("c","c",3));
        part25.add(new Participation("c","c",3));
        part25.add(new Participation("a","z",3));

        part25.print();

        part25.lookupRacer("b").print();


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

    }
}
