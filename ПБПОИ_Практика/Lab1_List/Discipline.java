public class Discipline implements Comparable <Discipline>
{
    //Сущность - Дисциплина
    //поля скрыты в классе
    private final static String DIS_FORMAT_STRING = "Дисциплина: %-7d|%-10s|%-2d|%-1.2f|"; //формат записи о дисциплине
    private int id; // id дисциплины, ключевое поле
    private String name; //название дисциплины
    private int semester; //номер семестра
    private float credit; //число кредитов
    //конструктор без параметров
    public Discipline()
    {
        this.id=0; this.name="";
        this.semester=0; this.credit=0;
    }
    //конструктор с параметрами
    public Discipline(int id, String name, int semester, float credit)
    {
        this.id=id; this.name=name;
        this.semester=semester; this.credit=credit;
    }
    //методы-геттеры
    public int getId(){return id;}
    public String getName(){return name;}
    public int getSemester(){return semester;}
    public float getCredit(){return credit;}
    //методы-сеттеры
    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setSemester(int semester){this.semester=semester;}
    public void setCredit(float credit){this.credit=credit;}
    //Переопределяющий метод toString
    public String toString()
    {
        return String.format(DIS_FORMAT_STRING, id, name, semester, credit);
    }
    //Переопределяющий метод equals
    public boolean equals (Object ob)
    {
        if(ob==this) return true; //ссылки равны - один и тот же объект
        if(ob==null) return false; //null-ссылка
        if(getClass()!=ob.getClass()) return false; //объекты разных классов
        Discipline ds=(Discipline)ob; //преобразуем Object в Discipline
        return id==ds.id; //id - ключевое поле обекта
    }
    //Переопределяющий метод hashCode
    //Возвращает хэш-код объекта
    public int hashCode()
    {
        return 7*(new Integer(id)).hashCode();
    }
    //Опеределяем метод CompareTo интерфейса Comparable
    //Для опеределения естественного порядка перечисления элементов
    public int compareTo(Discipline dis)
    {
        if(id<dis.id) return -1;
        else if (id==dis.id) return 0;
        else return 1;
    }
}
