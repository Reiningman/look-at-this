import java.util.LinkedHashSet;

public class MyStringIter implements StringIterator {
    private Participations1 list;
    private LinkedHashSet hashSet;
    private MyListNodeBetter current = null;

    // returns the next 'Participation' object in the container that
    // 'this' iterates over.

    public MyStringIter(Participations1 k) {
        this.list =k;
        current = k.listNode.head;
    }
    @Override
    public String next() {
        if (current!=null) {
            MyListNodeBetter temp = current;
            current=current.next();
                add(temp.value().getRace());
                return temp.value().getRace();
            }

        else return next();
    }

    // returns true if there is another 'Participation' object that
    // this.next() can return.
    @Override
    public boolean hasNext() {

        return current!=null;
    }

    public boolean add(String s){
        if (!hashSet.contains(s)) {
            hashSet.add(s);
            return true;
        } else {
            return false;
        }
    }

}
