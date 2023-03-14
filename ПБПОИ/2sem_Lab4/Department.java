public class Department
{
    private final static String DEPARTMENT_FORMAT_STRING="Кафедра: %s, число преподавателей: %2d";
    private Lecturer lec;
    private Department next;
    public Department()
        {lec=null; next=null;}   
    public Department(String name)
    {
        lec=new Lecturer();
        lec.setId(0);
        lec.setName(name);
        lec.setPosition("");
        lec.setSalary(0.0);
    }
    public Department(Lecturer le)
    {
        lec=le;
        next=null;
    }
    public void setName(String name) {lec.setName(name);}
    public String getName() {return lec.getName();}
    public int getNum() 
    {
        int num=0;
        Department el=next;
        while(el!=null)
        {
            num++;
            el=el.next;
        }
        return num;
    }
    public Lecturer getLec(int id)
    {
        if(next==null) return null;
        Department el=next;
        while(el!=null)
        {
            if(el.lec.getId()==id) return el.lec;
            el=el.next;
        }
        return null;
    }
    public String toString()
        {return String.format(DEPARTMENT_FORMAT_STRING, lec.getName(), getNum());}  
    public boolean addLec(Lecturer lec)
    {
        if (getLec(lec.getId())!=null) return false;
        Department el=new Department(lec);
        if(next==null) next=el;
        else
        {
            Department old=next;
            next=el;
            el.next=old;
        }
        return true;
    }
    public boolean delLec(int id)
    {
        Department el=this;
        while(el.next!=null)
        {
            if(el.next.lec.getId()==id)
            {
                el.next=el.next.next;
                return true;
            }
            el=el.next;
        }
        return false;
    }
    public double avgSalary()
    {
        if (next==null) return 0;
        double avg=0; int num=0;
        Department el=next;
        while(el!=null)
        {
            avg=avg+el.lec.getSalary();
            num+=1;
            el=el.next;
        }
        return avg/num;
    }
    public Department aboveAvgSalary()
    {
        double avg=avgSalary();
        Department head=new Department(String.format
            ("Преподаваетли, у которых ставка выше среднего %f:", avg));
        Department el=next;
        while(el!=null)
        {
            if(el.lec.getSalary()>avg) head.addLec(el.lec);
            el=el.next;
        }
        return head;
    }
    public Department betweenSalary(double s1, double s2)
    {
        Department head=new Department(String.format
            ("Преподаватели, у которых ставка в диапазоне от %f да %f:", s1, s2));
        Department el=next;
        while(el!=null)
        {
            double s=el.lec.getSalary();
            if((s>=s1)&&(s<=s2)) head.addLec(new Lecturer(el.lec));
            el=el.next;
        }
        return head;
    }
    public void putDepartment()
    {
        System.out.println(lec.getName());
        System.out.printf("%5s%17s%11s%17s\n",
            "id преподавателя", "ФИО", "Должность","Размер ставки");
        Department el=next;
        int i=1;
        while(el!=null)
        {
            System.out.printf("%-7d %-15d %-16s %-10.2f\n",
                i,el.lec.getId(),el.lec.getName(),el.lec.getPosition(), el.lec.getSalary());
            el=el.next;
            i+=1;
        }
    }
}