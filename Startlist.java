import java.util.Arrays;

/*
This class will be used in future assignments.  It is highly
recommended to solve Assignment 1.2.
*/
public class Startlist {

    // Assignment 1.2:


   private Participation participations[];
    private int indexEmty;
    private static int counter;


    // A new object constructed by
    //  
    //   new Startlist(100)
    //  
    // has room for 100 participations (all 'null' at first)
    public Startlist(int length) {
        participations = new Participation[length];
    }

    // adds p to 'this'
    public void add(Participation p) {

    }

    // Print the filled entries in an arbitrary order; each
    // participation is printed in the same format as produced by
    // print() in Participation, followed by a newline.
    public void print() {

        for (int i = 0; i < indexEmty; i++) {
            participations[i].print();
            System.out.println();

        }
        System.out.println();
    }

    // Print the filled entries in the order of increasing bib
    // numbers; each participation is printed in the same format as
    // produced by print() in Participation, followed by a newline.
    public void printOrdered() {
        Participation[] copyArray = Arrays.copyOf(participations, indexEmty );

        for (int i = 0; i < copyArray.length - 1; i++) {
            for (int j = 0; j < copyArray.length - i - 1; j++) {
                if (copyArray[j].getBibnumber() > copyArray[j + 1].getBibnumber()){
                    Participation temp = copyArray[j];
                    copyArray[j] = copyArray[j + 1];
                    copyArray[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < indexEmty; i++) {
            copyArray[i].print();
            System.out.println();

        }
        System.out.println();
    }

    // Questions:

    // 1) In which sensible ways can the program react if more entries
    // are added to 'this' than the array has entries?  What does your
    // program do?
    // 
    // 2) Frequent requirements for start lists are that all the bib
    // numbers in a race are different, contiguous, and start at 1.
    // We did not require these in this assignment.  Did you?  If so,
    // did this simplify the implementation?  How much more complex
    // would your program become if you lifted one or several of these
    // requirements?  With such requirements, what are sensible ways
    // to react to violations of these requirements?  In particular,
    // what happens if the same bib number is inserted twice?
    // 
    // 3) Another requirement for a start list is that all
    // participations are for the same race.  Do you check this?
    // What is a sensible way to react if this is violated?


    // Assignment 1.3:

    // Print all the permutations of the start list, with each
    // permutation followed by an empty line.
    public void printPermutations() {
        Participation[] participationsNoNull = Arrays.copyOf(participations,indexEmty);
        recursivePermutate(new Participation[0] ,participationsNoNull );

    }

    private void recursivePermutate(Participation[] fixArr, Participation[] varArray ) {

        if (varArray.length>0) {
            Participation[] newFixed = new Participation[fixArr.length+1];
            for (int i = 0; i < fixArr.length ; i++) {
                newFixed[i] = fixArr[i];
            }
            Participation[] newVar = new Participation[varArray.length-1];
            for (int i = 0; i < varArray.length; i++) {
                newFixed[fixArr.length] = varArray[i];
                //remove "i-index" Element from varArray
                for (int j = 0; j < newVar.length;j++) {
                    if (j>=i) {
                        newVar[j] = varArray[j+1];
                    } else {
                        newVar[j] = varArray[j];
                    }
                }
                counter++;
                recursivePermutate(newFixed,newVar);
            }
        }
        else {
            for (int i = 0; i < fixArr.length ; i++) {
                fixArr[i].print();
                System.out.println();
            }
            System.out.println();

        }
    }

    // Question:

    // How many calls to your recursive method do you get when you
    // call printPermutations() on a start list with n filled entries?



    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {

        Participation x = new Participation("Chuenisbärgli", "Franz", 1);
        Participation y = new Participation("Chuenisbärgli", "Brünhilde", 2);
        Participation z = new Participation("Chuenisbärgli", "Sigmund", 3);
        Participation u = new Participation("Chuenisbärgli", "Wotan", 4);


        Startlist startlist1 = new Startlist(5);
        startlist1.add(y);
        startlist1.add(x);
        startlist1.add(z);
        startlist1.add(u);
        startlist1.print();
        startlist1.printOrdered();
        startlist1.printPermutations();
        System.out.println(counter);

    }
}
