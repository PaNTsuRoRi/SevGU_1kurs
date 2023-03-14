public class DepartmentDemo
{
    public static void SetGroupStatus(Department group, String status)
    {
        group.setName(group.getName()+""+status);
    }
    public static void main(String []args)
    {
        Department dep1=new Department1("ИТУТС", 5);
        Department dep2=new Department2("ИРИБ");
        int j=0;
        for (int i=0; i<5; i++)
        {
            int id=Integer.valueOf(args[j]); j++;
            String name=args[j]; j++;
            String position=args[j]; j++;
            double salary=Double.valueOf(args[j]); j++;
            dep1.addLec(new Lecturer(id, name, position, salary));
        }
        for (int i=0; i<5; i++)
        {
            int id=Integer.valueOf(args[j]); j++;
            String name=args[j]; j++;
            String position=args[j]; j++;
            double salary=Double.valueOf(args[j]); j++;
            dep2.addLec(new Lecturer(id, name, position, salary));
        }
        System.out.println("Сформированы следующие кафедры:");
        System.out.printf("%s,\n%s\n\n", dep1, dep2);
        if (!dep1.addLec(new Lecturer(60538, "Акимов", "Ассистент", 70000.0)));
        {
            System.out.printf("На кафедру %s добавить преподавателя 60538 не удалось:\n", dep2.getName());
            System.out.println("превышен лимит");
        }
        if (!dep2.addLec(new Lecturer(32348, "Козлов", "Доцент", 70000.0)));
        {
            System.out.printf("На кафедру %s добавить преподавателя 32348 не удалось:\n", dep2.getName());
            System.out.println("нарушена уникальность ключа");
        }
        System.out.println();
        dep1.putDepartment();
        dep1.aboveAvgSalary().putDepartment();
        dep1.betweenSalary(35000.0,41000.0).putDepartment();
        dep1.delLec(12345);
        System.out.println("После удаления преподавателя:");
        dep1.putDepartment();
        System.out.println();
        dep2.putDepartment();
        dep2.aboveAvgSalary().putDepartment();
        dep2.betweenSalary(35000.0,41000.0).putDepartment();
        dep2.delLec(53347);
        System.out.println("После удаления преподавателя:");
        dep2.putDepartment();
        System.out.println();
        System.out.println("Проверка наличия преподавателей:");
        int n=45363;
        Lecturer l1=dep1.getLec(n);
        System.out.printf("В группе %s:\n", dep1.getName());
        if(l1==null) System.out.printf("Нет преподавателя с номером зачетки %d\n",n);
        else System.out.println(l1);
        n=70000;
        l1=dep1.getLec(n);
        if(l1==null) System.out.printf("Нет студента с номером зачетки %d\n",n);
        else System.out.println(l1);
        n=45463;
        l1=dep2.getLec(n);
        System.out.printf("На кафедре %s:\n",dep2.getName());
        if(l1==null) System.out.printf("Нет студентас с номером зачетки %d\n",n);
        else System.out.println(l1);
        System.out.println();
        SetGroupStatus(dep1, "сетрификат А");
        SetGroupStatus(dep2, "не сертифицирована");
        System.out.println("После назначения кафедрам статуса имеем:");
        System.out.println(dep1.getName()+";");
        System.out.println(dep2.getName()+";");
    }
}
