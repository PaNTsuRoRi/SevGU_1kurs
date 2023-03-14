public class Department1 implements Department
{
    private final static int MAX_NUM=5;
    private final static String DEPARTMENT_FORMAT_STRING="Кафедра: %s, число преподавателей: %2d";
    private String name;
    private Lecturer[] lecArr;
    private int num;
    public Department1()
        {name=""; num=0; lecArr=new Lecturer [MAX_NUM];}
    public Department1(String name, int numMax)
        {this.name=name; 
         num=0;
         lecArr=new Lecturer [numMax];}
    public void setName(String name) {this.name=name;}
    public String getName() {return name;}
    public int getNum() {return num;}
    public Lecturer getLec(int id)
    {
        for (int i=0; i<num; i++)
            if(lecArr[i].getId()==id) return lecArr[i];
        return null;    
    }
    public String toString()
        {return String.format(DEPARTMENT_FORMAT_STRING, name, num);}
    public boolean addLec(Lecturer lec)
    {
        if (num==lecArr.length) return false;
        for (int i=0; i<num; i++)
            if (lecArr[i].getId()==lec.getId()) return false;
        lecArr[num]=lec;
        num++;
        return true;
    }
    public boolean delLec(int id)
    {
        int i;
        for (i=0; i<num; i++)
            if (lecArr[i].getId()==id) break;
        if (i==num)
            return false;
        for (i+=1; i<num; i++)
            lecArr[i-1]=lecArr[i];
        lecArr[i-1]=null;
        num--;
        return true;
    }
    public double avgSalary()
    {
        if (num==0) return 0;
        double avg=0;
        for (int i=0; i<num; i++)
            avg=avg+lecArr[i].getSalary();
        return avg/num;
    }
    public Department1 aboveAvgSalary()
    {
        double avg = avgSalary();
        Department1 list = new Department1(String.format
                ("Преподаватели, у которых ставка выше среднего %2f:", avg),num);
        for (int i=0; i<num; i++)
            if(lecArr[i].getSalary()>avg) list.addLec(lecArr[i]);
        return list;    
    }
    public Department1 betweenSalary(double s1, double s2)
    {
        Department1 list = new Department1(String.format
                ("Преподаватели, у которых ставка в диапазоне от %2f до %2f:", s1, s2),num);
        for (int i=0; i<num; i++)
        {
            double s=lecArr[i].getSalary();
            if((s>=s1)&&(s<=s2))
                list.addLec(lecArr[i]);
        }
        return list;
    }
    public void putDepartment()
    {
        System.out.println(name);
        if (num!=0)
        {
            System.out.printf("%5s%17s%11s%17s\n", 
                              "Номер", "id преподавателя", "ФИО", "Размер ставки");
            for (int i=0; i<num; i++)
            {
                System.out.printf(" %-7d %-15d %-16s %-10.2f\n", 
                                  i+1, lecArr[i].getId(), lecArr[i].getName(), lecArr[i].getSalary());
            }
        }
    }
}