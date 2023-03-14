public class Family
{  
    private final static String FAMILY_FORMAT_STRING  =                                    
           "Семья: число взрослых: %d, число детей: %d, кошка или собака: %b, сумма оплаты: %f"; 
    private int adults, children;
    private boolean animal;
    private double cost;
     
    public Family(){adults=0; children=0; animal=false; cost=0.0;}
    public Family(int adults1, int children1, boolean animal1,double cost1)
    { 
        adults=adults1; children=children1; animal=animal1; cost=cost1;
    } 
    
    public int getAdults(){return adults;} 
    public int getChildren(){return children;} 
    public boolean getAnimal(){return animal;}
    public double getCost(){return cost;}
    
    public void setAdults(int adults1){adults=adults1;} 
    public void setChildren(int children1){children=children1;} 
    public void setAnimal(boolean animal1){animal=animal1;} 
    public void setCost(double cost1){cost=cost1;} 

    public String toString () 
    { 
       return String.format (FAMILY_FORMAT_STRING, adults, children, animal, cost); 
    } 
    
    public boolean equals (Family obj) {         
        if (this == obj) return true; 
        if (obj == null) return false;  
        if (adults == obj.adults  && children == obj.children && cost == obj.cost) return true; 
        return false;     
    }
} 
