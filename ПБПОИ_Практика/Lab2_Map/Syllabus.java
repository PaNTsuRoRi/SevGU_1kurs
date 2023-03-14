import java.util.*;
public class Syllabus
{
    //Сущность - учебный план
    private final static List <String> HOURS=Arrays.asList("32","64","72","128");
    //формат записи
    private final static String SYL_FORMAT_STRING="%s, количество часов: %d";
    //переменные экземляра
    private String name;
    private Map <DisciplineKey, String> syllabus;
    //конструкторы
    public Syllabus()
    {
        name="";
        syllabus=new TreeMap <DisciplineKey, String>(); //создается пустой план
    }
    public Syllabus(String name)
    {
        this.name=name; //задается название учебного плана
        syllabus=new TreeMap <DisciplineKey, String>(); //создается пустой план
    }
    public Syllabus(String name, Comparator comp)
    {
        this.name=name; //задается название учебного плана
        syllabus=new TreeMap <DisciplineKey, String> (comp); //создается пустой план, ссылки в которой будут упорядочиваться по правилам компаратора
    }
    //метод-сеттер для private-поля
    public void setSyllabusName(String name)
    {
        this.name=name;
    }
    //методы-геттеры для private-полей
    public String getSyllabusName(){return name;}
    public Map <DisciplineKey, String> getSyllabus()
    {
        return syllabus;
    }
    //Переопределяющий метод toString класса Object
    public String toString()
    {
        return String.format(SYL_FORMAT_STRING,name,size());
    }
    //Запрос на вставку и удаление данных:
    //добавить дисциплину в план
    public boolean addDis(DisciplineKey dk, String hour)
    {
        if(syllabus.containsKey(dk)) return false;
        if(!HOURS.contains(hour)) return false;
        syllabus.put(dk,hour);
        return true;
    }
    //удалить дисциплину из плана по ключу
    public boolean delDis(DisciplineKey dk)
    {
        if(syllabus.containsKey(dk)){syllabus.remove(dk); return true;}
        else return false;
    }
    //удалить дисциплину по ID
    public boolean delDis(int idDiscipline)
    {
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        Iterator <Map.Entry <DisciplineKey, String>> it=setD.iterator();
        int i=0;
        while(it.hasNext())
        {
            Map.Entry <DisciplineKey, String> keyVal=it.next();
            if(keyVal.getKey().getIdDiscipline()==idDiscipline)
            {
                it.remove();
                i+=1;
            }
        }
        return (i==0);
    }
    //обовить количество часов
    public boolean updateDiscipline(DisciplineKey dk, String hour)
    {
        if(!syllabus.containsKey(dk)) return false;
        if(!HOURS.contains(hour)) return false;
        syllabus.put(dk,hour);
        return true;
    }
    //Возвращает число дисциплин в плане
    public int size()
    {
        return syllabus.size();
    }
    //возвращает план по дисциплине
    public Syllabus selectDisciplineData(int idDis)
    {
        Syllabus subSyllabus=new Syllabus(String.format("%s: выборка по дисиплине %7d",name,idDis));
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        for(Map.Entry <DisciplineKey, String> keyVal:setD)
        {
            if(keyVal.getKey().getIdDiscipline()==idDis)
            subSyllabus.syllabus.put(keyVal.getKey(),keyVal.getValue());
        }
        return subSyllabus;
    }
    //Возвращает план по заданному логину преподавателя
    public Syllabus selectLoginData(String login)
    {
        Syllabus subSyllabus=new Syllabus(String.format("%s: выборка по логину преподавателя %s",name,login));
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        for(Map.Entry <DisciplineKey, String> keyVal:setD)
        {
            if(keyVal.getKey().getLogin().equals(login))
                subSyllabus.syllabus.put(keyVal.getKey(),keyVal.getValue());
        }
        return subSyllabus;
    }
    //Возвращает план по дисциплине в заданном семестре
    public Syllabus selectDisciplineSemesterData(int idDis, int semester)
    {
        Syllabus subSyllabus=new Syllabus(String.format("%s: выборка по дисциплине %d и семестру %d",name,idDis,semester));
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        for(Map.Entry <DisciplineKey, String> keyVal:setD)
        {
            if((keyVal.getKey().getIdDiscipline()==idDis)&&(keyVal.getKey().getSemester()==semester))
                subSyllabus.syllabus.put(keyVal.getKey(),keyVal.getValue());
        }
        return subSyllabus;
    }
    //перевод количества часов в числовую форму
    public static int transHour(String hour)
    {
        if(hour=="32") return 32;
        if(hour=="64") return 64;
        if(hour=="72") return 72;
        if(hour=="128") return 128;
        return 0;
    }
    //Возвращает суммарное количество часов для конкретной дисциплины
    public int selectSumHourDis(int idDis)
    {
        int sum=0;
        Syllabus subSyllabus=selectDisciplineData(idDis);
        Collection <String> v=syllabus.values();
        for(String hour:v) sum+=transHour(hour);
        return sum;
    }
    //Запросы на сортировку данных
    //сортировка по возраснанию ID и убыванию семестра
    public Syllabus sortIdAscSemesterDesc()
    {
        Syllabus subSyllabus=new Syllabus(String.format("%s:\n\t сортировка по возрастанию ID и убыванию номера семестра",name),new CompIdAscSemesterDesc());
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        for(Map.Entry <DisciplineKey, String> keyVal:setD)
        {
            subSyllabus.addDis(keyVal.getKey(),keyVal.getValue());
        }
        return subSyllabus;
    }
    //сортировка по позрастанию логина преподавателя и убыванию семестра
    public Syllabus sortLoginAscSemesterDesc()
    {
        Syllabus subSyllabus=new Syllabus(String.format("%s:\n\t сортировка по возрастанию логина преподаваетля и убыванию номера семестра",name),new CompLoginAscSemesterDesc());
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        for(Map.Entry <DisciplineKey, String> keyVal:setD)
        {
            subSyllabus.addDis(keyVal.getKey(),keyVal.getValue());
        }
        return subSyllabus;
    }
    //сортировка по убыванию количества часов
    public Syllabus sortHoursDesc()
    {
        Syllabus subSyllabus=new Syllabus(String.format("%s:\n\t сортировка по убыванию количества часов",name),new CompHoursDesc(this.syllabus));
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        for(Map.Entry <DisciplineKey, String> keyVal:setD)
        {
            subSyllabus.addDis(keyVal.getKey(),keyVal.getValue());
        }
        return subSyllabus;
    }
    //Запрос на вывод данных
    //вывод учебного плана в окно терминала
    public void putSyllabus()
    {
        System.out.println(name);
        System.out.printf("%5s%10s%13s%14s%15s\n","Номер","ID","Логин","Семестр","Кол-во часов");
        int i=1;
        Set <Map.Entry <DisciplineKey, String>> setD=syllabus.entrySet();
        for(Map.Entry <DisciplineKey, String> keyVal:setD)
        {
            DisciplineKey key=keyVal.getKey();
            System.out.printf("%-11d%-11d%-16s%-11d%-3s\n",i,key.getIdDiscipline(),key.getLogin(),key.getSemester(),keyVal.getValue());
            i+=1;
        }
        System.out.println();
    }
}