public class MyTreeNode {
    private Participations1 value;
    private String key;
    private MyTreeNode left,right;


    public MyTreeNode(Participation v) {
        Participations1 pr = new Participations1();
        pr.add(v);
        value = pr;

            key = pr.first().getRacer();
    }
    public MyTreeNode() {
        Participations1 pr = new Participations1();

        value = pr;

        key = "";
    }


    public void add(Participation v) {

        Participations1 p= new Participations1();
        p.add(v);
        if (v.getRacer().compareTo(key) < 0) {
            if (left != null) {
                left.add(v);
            } else {
                left = new MyTreeNode(v);
            }
        } else if (v.getRacer().compareTo(key) > 0) {
            if (right != null) {
                right.add(v);
            } else {
                right = new MyTreeNode(v);
            }
        } else {
            value.add(v);
        }
    }

    public boolean contains(Participation v) {
        return v.getRacer().equals(key) ||
            (v.getRacer().compareTo(key) < 0 ? left != null && left.contains(v)
                : right != null && right.contains(v));
    }

    public void traverseLR() {
        if (left !=null) { left.traverseLR();}
        value.print();
        if (right !=null) { right.traverseLR();}
    }

    public Participations1 findKey(String s) {

            if (key.equals(s) && value != null) {return value;}
            if (left != null && key.compareTo(s) < 0) {
                return left.findKey(s);
            } else if (right != null && key.compareTo(s) > 0) {
                return right.findKey(s);
            } else {
                return null;
            }
    }

    public void printBibX(int x) {

        if (left !=null) { left.printBibX(x);}
        value.print(x);
        if (right !=null) { right.printBibX(x);}
    }

    public void printBibX(int x, String y) {

        if (left !=null) { left.printBibX(x, y);}
        value.print(x, y);
        if (right !=null) { right.printBibX(x, y);}
    }

    public void traverseRL(int pos) {
        if (pos < 0) {
            System.out.print(value + " ");
        }
        if (right != null) {
            right.traverseRL(pos);
        }
        if (pos == 0) {
            System.out.print(value + " ");
        }
        if (left != null) {
            left.traverseRL(pos);
        }
        if (pos > 0) {
            System.out.print(value + " ");
        }
    }
}
