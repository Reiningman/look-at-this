public class MyQueue {

    public MyListNodeBetter head;

    public void add(Participation v) {
        if (head == null){
            head = new MyListNodeBetter(v, null);
        } else {
            MyListNodeBetter last = head;
            while (last.next()!=null) {
                last = last.next();
            } last.setNext(new MyListNodeBetter(v,null));
        }
    }

    public void addAt(Participation v,int n) {
        int counter =0;
        if (head == null){
            head = new MyListNodeBetter(v, null);
        } else {
            MyListNodeBetter currentPos = head;
            while (currentPos.next()!=null && counter <n-1) {
                currentPos = currentPos.next();
                counter++;
            }
            MyListNodeBetter temp = currentPos.next();
            currentPos.setNext(new MyListNodeBetter(v,temp));
        }
    }

    public void removeAt(int n){
        if (head!=null){
            MyListNodeBetter currentPos = head;
            int counter=0;
            while (currentPos.next()!=null && counter <n-1) {
                currentPos=currentPos.next();
                counter++;
            }
            currentPos.setNext(currentPos.next().next());
        }
    }

    public Participation poll(){
        if (head != null) {
            Participation temp = head.value();
            head = head.next();
            return temp;
        }return null;
    }


    public Participation peek() {
        return head == null ? null : head.value();
    }

    public Participation peekAt(int n){
        if (head != null) {
            MyListNodeBetter temp = head;
            for (int i = 0; i < n; i++) {
                if (temp.next() != null) {
                    temp = temp.next();
                }
                else return null;
            }
            return temp.value();
        }else {return null;}
    }
}
