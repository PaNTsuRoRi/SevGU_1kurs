import java.util.*;
public class CompNameAscCreditDesc implements Comparator
{
    public int compare(Object ob1, Object ob2)
    {
        Discipline dis1 = (Discipline) ob1;
        Discipline dis2 = (Discipline) ob2;
        if(dis1.getName().compareTo(dis2.getName())<0) return -1;
        else if(dis1.getName().compareTo(dis2.getName())>0) return 1;
        else if(dis1.getCredit()<dis2.getCredit()) return 1;
        else if(dis1.getCredit()==dis2.getCredit()) return 0;
        else return -1;
    }
}
