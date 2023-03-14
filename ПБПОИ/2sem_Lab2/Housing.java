public class Housing implements Comparable <Housing>
{
    public final static String housingFormatString = "Housing:\nType (дом или квартира): %s; Num of room: %d; Have a balcony: %s; Sum of pays: %.2f(rub)";
    private String type;
    private int room;
    private boolean balcony;
    private double money;
    public Housing(){type = " "; room = 0; balcony = false; money = 0.0;}
    public Housing(String type, int room, boolean balcony, double money){
        this.type = type;
        this.room = room;
        this.balcony = balcony;
        this.money = money;
    }
    public Housing(Housing li){
        type = li.type;
        room = li.room;
        balcony = li.balcony;
        money = li.money;
    }
    public String getType(){return type;}
    public int getRoom(){return room;}
    public boolean getBalcony(){return balcony;}
    public double getMoney(){return money;}
    public void setType (String type){this.type = type;}
    public void setRoom (int room){this.room = room;}
    public void setBalcony (boolean balcony){this.balcony = balcony;}
    public void setMoney(double money){this.money = money;}
    public boolean equals(Housing obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if(type == obj.type && room == obj.room && balcony == obj.balcony && money == obj.money) return true;
        return false;
    }
    public int hashCode (){
        return 7 * (new String(type)).hashCode() + 11 * (new Integer(room)).hashCode() + 13 * (new Boolean(balcony)).hashCode() + 17 * (new Double(money)).hashCode();
    }
    public String toString()
    {
        return String.format(housingFormatString, type, room, balcony?"есть балкон":"нет балкона", money); 
    }
    public int compareTo (Housing li){
        if (type.compareTo(li.type)<0) return -1;
        if ((type.compareTo(li.type)==0)&&(room < li.room)) return -1;
        if ((type.compareTo(li.type)==0)&&(room == li.room) && !balcony && li.balcony) return -1;
        if ((type.compareTo(li.type)==0)&&(room == li.room)&&(balcony == li.balcony)&&(money < li.money)) return -1;
        if ((type.compareTo(li.type)==0)&&(room == li.room)&&(balcony == li.balcony)&&(money == li.money)) return 0;
        else return 1;
    }
    public boolean accord(Family si)
    {
        if (((type=="дом" && si.getAdult()+si.getChildren()>8)||((si.getChildren()+si.getAdult())<=8))
        &&(room>=si.getAdult())&&((room-si.getAdult())>=(si.getChildren()/2)+(si.getChildren()%2))
        &&(((balcony == true)&&(si.getAnimals()== true))||(si.getAnimals() == false))
        &&(si.getMoney() >= money)) return true;
        else return false;
    }
}