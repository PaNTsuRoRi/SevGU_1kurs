import java.util.*;
public class Department
{
    //Сущность - Кафедра
    //поля скрыты в классе
    private final static String DEP_FORMAT_STRING="Кафедра: %-10s|%-5d дисциплин";//формат записи о кафедре
    private String name;
    private Set <Discipline> disciplines; //список студентов
    //конструкторы
    public Department()
    {
        name=""; //без названия
        disciplines = new TreeSet <Discipline>(); //создается пустой список
    }
    public Department(String name)
    {
        this.name=name; //задается название кафедры
        disciplines = new TreeSet <Discipline>(); //создается пустой список
    }
    public Department(String name, Comparator comp)
    {
        this.name=name; //задается название кафедры
        disciplines = new TreeSet <Discipline>(comp); //создается пустой список, в котором сслки на добавляемые
    }                                                 //объекты будут упорядочиваться по правилам компаратора
    public Department(String name, Set set)
    {
        this.name=name; //задается название кафедры
        disciplines = new TreeSet <Discipline>(set); //создается на основе существующего набора set
    }
    //методы-геттеры для private-полей
    public String getDepartmentName(){return name;}
    public Set <Discipline> getDisciplines()
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
    //Запросы на сортировку данных
    //сортировка по возрастанию кредитов
    public Department sortCreditAsc()
    {
        Department depar=new Department(name+" (сортировка по возрастанию кредитов)",new CompCreditAsc());
        for(Discipline dis:disciplines) depar.addDis(dis);
        return depar;
    }
    //сортировка по убыванию кредитов
    public Department sortCreditDesc()
    {
        Department depar=new Department(name+" (сортировка по убыванию кредитов)",new CompCreditDesc());
        for(Discipline dis:disciplines) depar.addDis(dis);
        return depar;
    }
    //сортировка по возрастанию имени и убыванию кредитов
    public Department sortNameAscCreditDesc()
    {
        Department depar=new Department(name+" (сортировка по возрастанию имени и убыванию кредитов)",new CompNameAscCreditDesc());
        for(Discipline dis:disciplines) depar.addDis(dis);
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
    //Дополнительное задание
    //Обновление id у объекта с заданным id
    public boolean updateId(int firstId, int secondId)
    {
        if(getDiscipline(firstId) == null || getDiscipline(secondId) != null) return false;
        for(Discipline dis:disciplines)
            if(dis.getId() == firstId) dis.setId(secondId);
        return true;
    }
    //Удаление объектов, значение кредитов которых находятся в заданном интервале
    public Department deleteIntervalBetweenCredit(float x, float y)
    {
        Department depar = new Department(name+String.format("Кафедра, где удалены дисциплины кредиты которых между %2.2f и %2.2f",x,y));
        for(Discipline dis:disciplines)
            if(dis.getCredit() < x || dis.getCredit() > y) depar.addDis(dis);
        return depar;
    }
    //Возвращение группы объектов, имя которых содержит заданное буквосочетание
    public Department searchByString(String string)
    {
        Department depar = new Department(name+" (Дисциплины, название которых содержит - " + string+" )");
        Iterator<Discipline> iterator = disciplines.iterator();
        while(iterator.hasNext())
        {
            Discipline dis = iterator.next();
            String name = dis.getName();
            if(name.contains(string)) depar.addDis(dis);
        }
        return depar;
    }
}