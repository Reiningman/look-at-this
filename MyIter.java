public class MyIter implements PartIterator{


    private Participations1 list;
    private MyListNodeBetter nextIterPos = null;
    // returns the next 'Participation' object in the container that
    // 'this' iterates over.

    public MyIter(Participations1 k) {
        this.list =k;

    }
    @Override
    public Participation next() {
        if (nextIterPos==null){
            nextIterPos = list.start();
        } else {
            nextIterPos = nextIterPos.next();
        }
        return nextIterPos.value();
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {

        return (nextIterPos==null & list.start()!=null) || nextIterPos.next()!=null;
    }

}
