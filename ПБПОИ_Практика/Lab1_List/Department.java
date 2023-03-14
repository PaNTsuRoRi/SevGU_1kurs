import java.util.*;
public class Department
{
    //Сущность - Кафедра
    //поля скрыты в классе
    private final static String DEP_FORMAT_STRING="Кафедра: %-10s|%-5d дисциплин";//формат записи о кафедре
    private String name;
    private List <Discipline> disciplines; //список студентов
    //конструкторы
    public Department()
    {
        name=""; //без названия
        disciplines = new ArrayList <Discipline>(); //создается пустой список
    }
    public Department(String name)
    {
        this.name=name; //задается название кафедры
        disciplines = new ArrayList <Discipline>(); //создается пустой список
    }
    public Department(String name, List list)
    {
        this.name=name; //задается название кафедры
        disciplines = new ArrayList <Discipline>(list); //создается на основе существующего списка
    }
    //методы-геттеры для private-полей
    public String getDepartmentName(){return name;}
    public List <Discipline> getDisciplines()
    {return disciplines;}
    //геттер возвращающий дисциплину с заданным id
    public Discipline getDiscipline(int id)
    {
        for (Discipline discipline: disciplines)
            if(discipline.getId()==id) return discipline;
        return null;
    }
    //геттер возвращающий число дисциплин в списке кафедры
    public int getDisciplineNum()
    {
        return disciplines.size();
    }
    //метод-сеттер для private-поля
    public void setDepartmentName(String name)
    {this.name=name;}
    //добавление дисциплны в список
    public boolean addDis(Discipline dis)
    {
        if(getDis(dis.getId())!=null) return false;
        if(disciplines.add(dis)) return true;
        else return false;
    }
    //удаление дисциплины из списка
    public boolean delDis(int id)
    {
        if(disciplines.remove(new Discipline(id,"",0,0))) return true;
        else return false;
    }
    //Возвращает дисциплину с заданным id
    public Discipline getDis(int id)
    {
        for(Discipline dis:disciplines)
            if(dis.getId()==id) return dis;
        return null;    
    }
    //Возвращает среднее число кредитов для списка дисциплин кафедры
    public float avgCredit()
    {
        int num=disciplines.size();
        if(num==0) return 0;
        float avg=0;
        for(Discipline dis:disciplines)
            avg=avg+dis.getCredit();
        return avg/num;    
    }
    //Возвратить дисциплины, у которых число кредитов выше среднего
    public Department aboveAvgCredit()
    {
        float avg=avgCredit();
        Department depar = new Department(String.format("%s: дисциплины, у которых число кредитов выше среднего - %f",name,avg));
        for(Discipline dis:disciplines)
            if(dis.getCredit()>avg)depar.addDis(dis);
        return depar;    
    }
    //Возвратить дисциплины,число кредитов находятся в интервале
    public Department betweenCredit(float c1, float c2)
    {
        Department depar = new Department(String.format("%s: дисциплин, у которых кредиты в диапазоне от %2.2f до %2.2f",name,c1,c2));
        Iterator <Discipline> iter=disciplines.iterator();
        while(iter.hasNext())
        {
            Discipline dis=iter.next();
            if((dis.getCredit()>=c1)&&(dis.getCredit()<=c2))depar.addDis(dis);
        }
        return depar;
    }
    //Сортировка дисциплин в естественном порядке
    public Department sort()
    {
        Department depar = new Department(name, disciplines);
        Collections.sort(depar.disciplines);
        return depar;
    }
    //Сортировка дисциплин по правилу, задаваемому компаратором comp
    public Department sort(Comparator comp)
    {
        Department depar = new Department(name, disciplines);
        Collections.sort(depar.disciplines, comp);
        return depar;
    }
    //Вывод списка кафедры дисциплин в окно терминала
    public void putDepartment()
    {
        System.out.println(name);
        System.out.printf("%5s%5s%23s%9s%16s\n","Номер","ID","Название дисциплины","Семестр","Число кредитов");//заголовки столбцов
        int i=1;
        for(Discipline dis:disciplines)
        {
            System.out.printf("%-5d %-9d %-21s %-11d %-15.2f\n",i,dis.getId(),dis.getName(),dis.getSemester(),dis.getCredit());
            i+=1;
        }
        System.out.println();
    }
    //Переопределяющий метод toString
    public String toString()
    {
        return String.format(DEP_FORMAT_STRING,name,getDisciplineNum());
    }
}