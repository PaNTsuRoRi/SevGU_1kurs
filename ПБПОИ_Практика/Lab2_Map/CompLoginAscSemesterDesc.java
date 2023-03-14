import java.util.*;
public class CompLoginAscSemesterDesc implements Comparator <DisciplineKey>
{
    public int compare(DisciplineKey dis1, DisciplineKey dis2)
    {
        String log1=dis1.getLogin();
        String log2=dis2.getLogin();
        int sem1=dis1.getSemester();
        int sem2=dis2.getSemester();
        if(dis1.compareTo(dis2)<0) return -1;
        if(dis1.compareTo(dis2)>0) return 1;
        if(sem1>sem2) return -1;
        if(sem1<sem2) return 1;
        return 0;
    }
}