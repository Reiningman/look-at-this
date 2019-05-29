// Objects of CharStack1 are stacks holding chars.  The stack is
// implemented using a linked list.  It does not
// use classes from the Collections Framework (e.g. LinkedList)
// <https://docs.oracle.com/javase/8/docs/technotes/guides/collections/overview.html>.
public class CharStack1 {

    // Assignment 3.4 (partly also in Aufgabenblatt3.txt)

    // introduce (private) object variables as needed

private MyLinkedCharList list;
    // Create an empty stack
    public CharStack1() {
        list = new MyLinkedCharList((char) -1,null);
    }

    // Push c on 'this'.  
    public void push(char c) {
       list.add(c);
    }

    // Pop the most recent character that was pushed, but has not been
    // popped yet
    public char pop() {

        return list.poll();
    }

    // returns true if all characters pushed on 'this' have been popped.
    public boolean isEmpty() {

        return list.isEmpty();
    }

    // Frage:

    // Vergleichen Sie diese Implementierung mit CharStack.  Was sind
    // die Vor- und Nachteile der beiden Implementierungen?

    
    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
        CharStack1 c = new CharStack1();
        c.push('d');
        c.push('f');

        char a = c.pop();
        char b = c.pop();
        c.push('t');
        boolean ter = c.isEmpty();

        char k = c.pop();
        boolean at = c.isEmpty();
        System.out.println(a);
        System.out.println(b);
        System.out.println(k);
        System.out.println(ter);
        System.out.println(at);
    }
}
