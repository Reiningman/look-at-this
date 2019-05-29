import java.util.Arrays;

// Objects of CharStack are stacks holding chars.  The stack is
// implemented using an array, without using other classes.
// The array grows whenever the number of entries is insufficient.
public class CharStack {

    // Assignment 2.2 (partly also in Parse.java)

    // introduce (private) object variables as needed
    private char[] c;
    int firstNull;
    // Create an empty stack
    public CharStack() {
      this.c = new char[0];
      firstNull=0;
    }

    // Push c on 'this'.  
    public void push(char c) {
        this.c = Arrays.copyOf(this.c,firstNull+1);
        this.c[firstNull]=c;
        firstNull++;
    }

    // Pop the most recent character that was pushed, but has not been
    // popped yet
    public char pop() {
        firstNull--;
        return this.c[firstNull];
    }

    // returns true if all characters pushed on 'this' have been popped.
    public boolean isEmpty() {
        return firstNull==0;
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }
}
