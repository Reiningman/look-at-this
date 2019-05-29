public class PartTreeBinary implements PartTreeNodable {
    // An object of class 'PartTreeBinary' represents a nonempty node
    // in a binary search tree, using 'racer' as key.
    
    // Variables and expressions of type 'PartTreeNodable' and its
    // subtypes are never null.  Instead, an empty subtree is
    // represented by a 'PartTreeNull' object.
    
    // Do not use 'if', 'while', or '? :' to check whether a node is
    // empty or not; instead, call the appropriate method
    // implementation with dynamic binding.

    // TODO: define object variables, constructors and methods as needed

    private String key;
    private Participations1 value;
    private PartTreeNodable left,right;


    public PartTreeBinary(String s, Participations1 value){
        this.key = s;
        left = right = PartTreeNull.NIL;
        if (value == null) this.value=null;
        else this.value = value;
    }

    @Override
    public PartTreeNodable add(Participation p) {
        if (p==null){
            return this;
        }
        if (key.compareTo(p.getRacer())>0) {
            left = left.add(p);
        } else if (key.compareTo(p.getRacer())<0) {
            right = right.add(p);
        } else {
            this.value.add(p);
        }
        return this;
    }

    @Override
    public void print() {
        left.print();
        this.value.print();
        right.print();
    }

    @Override
    public Participation lookupRacer(String r) {
        if (key.compareTo(r)>0) {
            return left.lookupRacer(r);
        } else if (key.compareTo(r)<0) {
           return right.lookupRacer(r);
        } else {
            return this.value.first();
        }
    }

    @Override
    public String toString(){
        return left.toString() + value.toString() + right.toString();
    }

    public String toString(String x, int y) {
        return left.toString(x,y) + value.toString(x,y)+right.toString(x,y);
    }

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        //  write your own test cases here if necessary.
    }
}
