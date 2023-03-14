public interface Department
{
    void setName(String name);
    String getName();
    int getNum();
    Lecturer getLec(int id);
    boolean addLec(Lecturer lec);
    boolean delLec(int id);
    double avgSalary();
    Department aboveAvgSalary();
    Department betweenSalary(double s1, double s2);
    void putDepartment();
}
