public class Lecturer
{
    private final static String LECTURER _FORMAT_STRING="Преподаватель: %8d, %15s, %30s, %6.2f";
    private int id;
    private String name;
    private String position;
    private double salary;
    public Lecturer()
        {int id=0; name=""; position=""; salary=0.0;}
    public Lecturer(int id, String name, String position, double salary)
        {this.id=id; this.name=name; this.position=position; this.salary=salary;}
    public Lecturer (Lecturer lec)
    {
        id=lec.id; name=lec.name;
        position=lec.position; salary=lec.salary;
    }
    public int getId() {return id;}
    public String getName() {return name;}
    public String getPosition() {return position;}
    public double getSalary() {return salary;}
    public void setId(int id) {this.id=id;}
    public void setName(String name) {this.name=name;}
    public void setPosition(String position) {this.position=position;}
    public void setSalary(double salary) {this.salary=salary;}
    public String toString()
        {return String.format(LECTURER _FORMAT_STRING, id, name, position, salary);}
    public int compareTo(Lecturer lec)
    {
        if (id<lec.id) return -1;
        if ((id==lec.id)&&(name.compareTo(lec.name)<0)) return -1;
        if ((id==lec.id)&&(name.compareTo(lec.name)==0)&&
        (position.compareTo(lec.position)<0)) return -1;
        if ((id==lec.id)&&(name.compareTo(lec.name)==0)&&
        (position.compareTo(lec.position)==0)&&(salary<lec.salary)) return -1;
        if ((id==lec.id)&&(name.compareTo(lec.name)==0)&&
        (position.compareTo(lec.position)==0)&&(salary==lec.salary)) return 0;
        else return 1;
    }
}
