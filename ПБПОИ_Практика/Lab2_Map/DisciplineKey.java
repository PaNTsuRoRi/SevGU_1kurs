public class DisciplineKey implements Comparable <DisciplineKey>
{
    //Сущность - Ключ дисциплины
    //Именованная константа - формат записи
    private final static String DISKEY_FORMAT_STRING="ID дисциплины: %5d | Логин преподавателя: %s | Семестр: %1d";
    private int idDiscipline;
    private String login;
    private int semester;
    //конструктор без параметров
    public DisciplineKey()
    {
        idDiscipline=0; login=""; semester=0;
    }
    //конструктор с параметрами
    public DisciplineKey(int idDiscipline, String login, int semester)
    {
        this.idDiscipline=idDiscipline;
        this.login=login;
        this.semester=semester;
    }
    //методы-геттеры
    public int getIdDiscipline(){return idDiscipline;}
    public String getLogin(){return login;}
    public int getSemester(){return semester;}
    //методы-сеттеры
    public void setIdDiscipline(int idDiscipline){this.idDiscipline=idDiscipline;}
    public void setLogin(String login){this.login=login;}
    public void setSemester(int semester){this.semester=semester;}
    //переопределяющий метод toString класса Object
    public String toString()
    {
        return String.format(DISKEY_FORMAT_STRING,idDiscipline,login,semester);
    }
    //Переопрееляющий метод equals класса Object
    public boolean equals(Object ob)
    {
        if(ob==this) return true; //ссылки равны
        if(ob==null) return false; //в метод передана null ссылка
        if(getClass()!=ob.getClass()) return false; //объекты разных классов
        DisciplineKey dk=(DisciplineKey)ob; //Преобразуем Object
        return (idDiscipline==dk.idDiscipline)&&(login.equals(dk.login))&&(semester==dk.semester); //true если каждое из 3 полей равное соответсвующему
    }
    //Переопределяющий метод hashCode класса Object
    public int hashCode()
    {
        return 7*(new Integer(idDiscipline)).hashCode()+
              11*login.hashCode()+13*(new Integer(semester)).hashCode();
    }
    //Определяем метод CompareTo интерфейса Comparable
    public int compareTo(DisciplineKey dk)
    {
        if(idDiscipline<dk.idDiscipline) return -1;
        if(idDiscipline>dk.idDiscipline) return 1;
        if(login.compareTo(dk.login)<0) return -1;
        if(login.compareTo(dk.login)>0) return 1;
        if(semester<dk.semester) return -1;
        if(semester>dk.semester) return 1;
        return 0;
    }
}
