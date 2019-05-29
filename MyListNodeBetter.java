public class MyListNodeBetter {
    private Participation value;
    private MyListNodeBetter next;

    public MyListNodeBetter (Participation v , MyListNodeBetter u){
        this.value = v;
        this.next = u;
    }

    public Participation value (){return this.value;};

    public MyListNodeBetter next (){return this.next;}

    public void setValue(Participation v) {this.value = v;}

    public void setNext(MyListNodeBetter u){this.next = u;}

}
