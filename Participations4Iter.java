public class Participations4Iter implements PartIterator {
    // This class implements an iterator for the class Participations4
    


    private Participations1[] values;
    private PartIterator currentValueIterator;
    private int nextValuesIdex=0;
    

    public Participations4Iter (Participations1[] k){
        this.values =k;
    }
    
    // returns the next 'Participation' object in the container that
    // 'this' iterates over.
    @Override
    public Participation next() {
        if (currentValueIterator == null || !currentValueIterator.hasNext()){
            for (int i = nextValuesIdex; i < values.length ; i++) {
                if (values[i] != null) {
                    nextValuesIdex = i+1;
                    currentValueIterator = values[i].iterator();
                    break;
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
        return true;
    }
}
