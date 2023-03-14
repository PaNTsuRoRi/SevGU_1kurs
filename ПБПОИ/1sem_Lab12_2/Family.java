public class Family{
    public final static String familyFormatString = "Family:\nNum of adults: %d; Num of children: %d; Having cat or dog: %s Sum of pays: %.2f(rub)";
    private int adult, children;
    private boolean animals;
    private float money;
    public Family(){adult = 0; children = 0; animals = false; money = 0.0f;}
    public Family(int adult, int children, boolean animals, float money){
        this.adult = adult;
        this.children = children;
        this.animals = animals;
        this.money = (float)money;
    }
    public Family(Family si){
        adult = si.adult;
        children = si.children;
        animals = si.animals;
        money = si.money;
    }
    public int getAdult(){return adult;}
    public int getChildren(){return children;}
    public boolean getAnimals(){return animals;}
    public float getMoney(){return money;}
    public void setAdult (int adult){this.adult = adult;}
    public void setChildren (int children){this.children = children;}
    public void setAnimals (boolean animals){this.animals = animals;}
    public void setMoney (float money){this.money = (float)money;}
    public String toString() {return String.format(familyFormatString, adult, children, animals, money);}
    public boolean equals(Family obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(adult == obj.adult && children == obj.children && animals == obj.animals && money == obj.money) return true;
        return false;
    }
    public int hashCode (){
        return 7 * (new Integer(adult)) + 11 * (new Integer(children)).hashCode() + 17 * (new Float(money)).hashCode();
    }
    public int CompareTo (Family si){
        if (adult < si.adult) return -1;
        if ((adult == si.adult)) return -1;
        if ((adult == si.adult)) return 0;
        else return 1;
    }
    public float Costs(){return (money/(adult+children));}
}