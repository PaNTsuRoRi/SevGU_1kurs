public class DepartmentDemo
{
    public static void putlecArr(Lecturer []arr)
    {
        if (arr ==null) return;
        for (int i=0; i<arr.length; i++)
        {System.out.println(arr[i]);}
    }
    public static void main(String []args)
    {
        Department dep1=new Department("ИТУТС",10);
        Department dep2=new Department();
        dep2.setName("ИРИБ");
        int j=0;
        /*for (int i=0; i<5; i++)
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
        }*/
        System.out.println("Сформированы следующие кафедры:");
        System.out.printf("%s,\n%s\n\n", dep1, dep2);
        dep1.addLec(new Lecturer(32348, "Козлов", "Доцент", 70000.0));
        dep1.addLec(new Lecturer(60538, "Акимов", "Ассистент", 35000.0));
        dep1.addLec(new Lecturer(32348, "Козлов", "Доцент", 54000.0));
        /*if (!dep1.addLec(new Lecturer(32348, "Козлов", "Доцент", 70000.0)));
        {
            System.out.printf("На кафедру %s добавить преподавателя 32348 не удалось:\n", dep1.getName());
            System.out.println("нарушена уникальность ключа");
        }
        if (!dep2.addLec(new Lecturer(60538, "Акимов", "Ассистент", 35000.0)));
        {
            System.out.printf("В группу %s добавить преподавателя 60538 не удалось:\n", dep2.getName());
            System.out.println("превышен лимит");
        }*/
        System.out.println();
        dep1.sortSalary(-1);
        dep1.putDepartment();
        System.out.printf("Средний размер ставки: %.2f\n", dep1.avgSalary());
        System.out.println("Преподаватели, у которых ставка выше среднего на кафедре:");
        putlecArr(dep1.aboveAvgSalary());
        System.out.println("Преподаватели, у которых ставка в диапазоне [40000.0,80000.0]:");
        putlecArr(dep1.betweenSalary(40000.0,80000.0));
        dep1.delLec(12345);
        System.out.printf("Состав кафедры %s после удаления студента:\n", dep1.getName());
        dep1.putDepartment();
        System.out.println();
        dep2.putDepartment();
        System.out.printf("Средний размер ставки: %.2f\n", dep2.avgSalary());
        System.out.println("Преподаватели, у которых ставка выше среднего на кафедре:");
        putlecArr(dep2.aboveAvgSalary());
        System.out.println("Преподаватели, у которых ставка в диапазоне [40000.0,60000.0]:");
        putlecArr(dep2.betweenSalary(30000.0,60000.0));
        dep2.delLec(54321);
        System.out.printf("Состав кафедры %s после удаления студента:\n", dep2.getName());
        dep2.putDepartment();
        System.out.println();
        System.out.println("Проверка наличия преподавателей:");
        int n=54321;
        Lecturer l1=dep1.getLec(n);
        System.out.printf("На кафедре %s:\n",dep1.getName());
        if(l1==null) System.out.printf("Нет преподавателя с ID %d\n", n);
        else System.out.println(l1);
        n=700000;
        l1=dep1.getLec(n);
        if(l1==null) System.out.printf("Нет преподавателя с ID %d\n", n);
        else System.out.println(l1);
        n=533490;
        l1=dep2.getLec(n);
        System.out.printf("В группе %s:\n", dep2.getName());
        if(l1==null) System.out.printf("Нет преподавателя с ID %d\n", n);
        else System.out.println(l1);
    }
}
