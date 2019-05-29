import java.util.Objects;

/*
This class will be extended in the ad-hoc-assignment, and will be used
in future assignments, so it is highly recommended to solve this
assignment.

Thiclass is part of software for ski racing administration.s
 */
public class Participation {

    // Assignment 1.1:
    

    private String race;
    private String racer;
    private int bibnumber;

    private int place;
    private String date;

    //  (Startnummer) shall be declared here.


    // A new object constructed by
    //
    //   new Participation("Lienz 2011 Ladies' Slalom", "Mikaela Shiffrin", 40)
    //
    // shall specify the name of the race, the racer, and the bibnumber.
     public Participation (String race, String racer, int bibnumber){
         this.race = race;
         this.racer = racer;
         this.bibnumber = bibnumber;
     }

    public Participation (String race, String racer, int bibnumber, int place, String date){
        this.race = race;
        this.racer = racer;
        this.bibnumber = bibnumber;

        this.place = place;
        this.date = date;
    }

    // Returns the 'race' of this participation.
    public String getRace() {
        return race;
    }

    // Returns the 'racer' of this participation.
    public String getRacer() {
        return racer;
    }

    // Returns the 'bibnumber' of this participation.
    public int getBibnumber() {
        return bibnumber;
    }

    public int getPlace() { return place; }
    public String getDate() { return date; }

    // Output the following (without newline at the start or end) for
    // the participation- created by the constructor call above:
    //
    // 40 Mikaela Shiffrin (Lienz 2011 Ladies' Slalom)
    //
    public void print() {
        System.out.print(bibnumber+ " "+racer+" ("+race+")");
        System.out.println();
    }

    public void print1() {
         if(place == 0 && date == null){
             print();
         } else {
             System.out.println(bibnumber+ " "+racer+" ("+race+"); " + place + "; " + date);
         }
    }

    // In addition to the standard requirements for equals, a
// participation is equal to another object of class Participation if
// and only if the 'racer's are equal and the 'race's are equal.
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != Participation.class) {
            return false;
        }

        Participation x = (Participation) o;
        if (this.race.equals(x.race) && this.racer.equals(((Participation) o).racer)){
            return true;
        }
        return false;
    }

    public int hashCode() {
         int k=0 ;
         int j=0;

        for (int i = 0; i < racer.length(); i++) {
            k+=racer.charAt(i);
        }
        for (int i = 0; i < race.length(); i++) {
            j+=race.charAt(i);
        }
         return (j+k)%17;

    }

    // Question:
    
    // Should there also be setter methods for the object variables?
    // Why or why not?
    // No. Because the Variables dont need to change after they've been set by the constructor

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        Participation p = new Participation("race", "racer", 50, 1, "1.1.19");
        Participation p1 = new Participation("race", "racer", 50, 0, "1.1.19");
        Participation p2 = new Participation("race", "racer", 50, 0, null);
        p.print1();
        System.out.println();
        p1.print1();
        System.out.println();
        p2.print1();
        System.out.println();
    }

}
