public class ParticipationsIter implements PartIterator {
    // This class implements an iterator for the class Participations
    

    private Participations p;
    private int nextValuesIdex;
    // returns the next 'Participation' object in the container that
    // 'this' iterates over.

    public ParticipationsIter(Participations k) {
        p =k;
        nextValuesIdex =0;
    }
    @Override
    public Participation next() {
        if (p.peekAt(nextValuesIdex)!=null) {
            nextValuesIdex++;
            return p.peekAt(nextValuesIdex - 1);
        }
        else return next();
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {

        return p.peekAt(nextValuesIdex+1)!=null;
    }
}
