public class MyLinkedCharList {
    private char value;
    private MyLinkedCharList next, head;

    public MyLinkedCharList(char u, MyLinkedCharList v) {
        value = u;
        next = v;
    }

    public void setNext(MyLinkedCharList n) {
        next = n;
    }

    public void setValue(char v) {
        value = v;
    }

    public char value() {
        return value;
    }

    public MyLinkedCharList next() {
        return next;
    }

    public void add(char c) {
        if (head == null) head = new MyLinkedCharList(c, null);
        else {
            MyLinkedCharList last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.setNext(new MyLinkedCharList(c, null));
        }
    }

    public char poll() {
        if (head != null) {
            char result = head.value();
            head = head.next();
            return result;
        } else {
            return (char) -1;
        }
    }

    public char peek() {
        return
        head == null ? null : head.value();

    }

    public char peekAt(int n) {
        MyLinkedCharList look = head;
        for (int i = 0; i < n; i++) {
            look = look.next;
        }
        return look.value;
    }
    public boolean isEmpty(){
        return head==null;
    }
}
