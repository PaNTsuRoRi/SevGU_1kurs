public class Family implements Comparable <Family>
{
    public final static String familyFormatString = "Family:\nNum of adults: %d; Num of children: %d; Having cat or dog: %s Sum of pays: %.2f(rub)";
    private int adult, children;
    private boolean animals;
    private double money;
    public Family(){adult = 0; children = 0; animals = false; money = 0.0;}
    public Family(int adult, int children, boolean animals, double money){
        this.adult = adult;
        this.children = children;
        this.animals = animals;
        this.money = money;
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
    public double getMoney(){return money;}
    public void setAdult (int adult){this.adult = adult;}
    public void setChildren (int children){this.children = children;}
    public void setAnimals (boolean animals){this.animals = animals;}
    public void setMoney (double money){this.money = money;}
    public boolean equals(Family obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(adult == obj.adult && children == obj.children && animals == obj.animals && money == obj.money) return true;
        return false;
    }
    public int hashCode (){
        return 7 * (new Integer(adult)) + 11 * (new Integer(children)).hashCode() + 17 * (new Double(money)).hashCode();
    }
    public String toString() 
    {
        return String.format(familyFormatString, adult, children, animals, money);
    }
    public int compareTo (Family si){
        if (adult < si.adult) return -1;
        if ((adult == si.adult)&&(children < si.children)) return -1;
        if ((adult == si.adult)&&(children == si.children) && !animals && si.animals) return -1;
        if ((adult == si.adult)&&(children == si.children)&&(animals == si.animals)&&(money < si.money)) return -1;
        if ((adult == si.adult)&&(children == si.children)&&(animals == si.animals)&&(money == si.money)) return 0;
        else return 1;
    }
    public double Costs(){return (money/(adult+children));}
    public boolean accord(Housing li)
    {
        if ((((adult+children)>8 && li.getType()=="дом")||((adult+children)<=8))
        &&(adult<=li.getRoom())&&(((children/2)+(children % 2))<=(li.getRoom()-adult))
        &&(((animals == true)&&(li.getBalcony() == true))||(animals == false))
        &&(money >= li.getMoney())) return true;
        else return false;
    }
}