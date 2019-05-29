public class Part4StringIter implements StringIterator {
    // This class implements an iterator for the class Participations4



    private Participations1[] values;
    private StringIterator currentValueIterator;
    private int nextValuesIdex=0;
    boolean k;

    public Part4StringIter (Participations1[] k){
        this.values =k;
    }

    // returns the next 'Participation' object in the container that
    // 'this' iterates over.
    @Override
    public String next() {
        if (currentValueIterator == null || !currentValueIterator.hasNext()){
            for (int i = nextValuesIdex; i < values.length ; i++) {
                if (values[i] != null) {
                    nextValuesIdex = i+1;
                    //currentValueIterator = values[i].iterator();
                }
            }
        }


        return currentValueIterator.next();
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {
        if (currentValueIterator == null || !currentValueIterator.hasNext()){
            for (int i = nextValuesIdex; i < values.length; i++) {
                if (values[i] != null){
                    return true;
                }
            }
            return false;
        }
        return false;
    }


    public boolean add(){
        return false;
    }
}

