import java.util.*;
public class CompIdAscSemesterDesc implements Comparator <DisciplineKey>
{
    public int compare(DisciplineKey dis1, DisciplineKey dis2)
    {
        int id1=dis1.getIdDiscipline();
        int id2=dis2.getIdDiscipline();
        int sem1=dis1.getSemester();
        int sem2=dis2.getSemester();
        if(id1<id2) return -1;
        if(id1>id2) return 1;
        if(sem1>sem2) return -1;
        if(sem1<sem2) return 1;
        return 0;
    }
}