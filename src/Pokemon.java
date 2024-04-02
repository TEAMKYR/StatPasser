public class Pokemon implements Comparable {

    private String name;

    private String eggGroup1;

    private String eggGroup2;

    private double MaleRatio;

    private int eggCycles;

    private String[] eggGroups = new String[2];

    public Pokemon(String name, String eggGroup1, String eggGroup2, double MaleRatio, int eggCycles) {
        this.name = name;
        this.eggGroup1 = eggGroup1;
        this.eggGroup2 = eggGroup2;
        this.MaleRatio = MaleRatio;
        eggGroups[0] = eggGroup1;
        eggGroups[1] = eggGroup2;
    }

    public Pokemon(String name, String eggGroup, double MaleRatio, int eggCycles) {
        this.name = name;
        this.eggGroup1 = eggGroup;
        this.eggGroup2 = null;
        this.MaleRatio = MaleRatio;
        eggGroups[0] = eggGroup;
        eggGroups[1] = null;
    }

    public int compareTo(Object o) {
        if (o.getClass() != Pokemon.class) {
            throw new IllegalArgumentException();
        }
        double thisMonsternum = eggCycles - MaleRatio;
        double oMonsternum = ((Pokemon) o).eggCycles - ((Pokemon) o).MaleRatio;
        return Double.compare(thisMonsternum, oMonsternum);
    }

    public String getName() {
        return name;
    }

    public String getEggGroup1() {
        return eggGroup1;
    }

    public String getEggGroup2() {
        return eggGroup2;
    }

    public double getMaleRatio() {
        return MaleRatio;
    }

    public int getEggCycles() {
        return eggCycles;
    }

    public String[] getEggGroups() {
        return eggGroups;
    }

    public static void main(String[] args) {

    }


}