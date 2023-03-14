import java.util.*;
public class CompHoursDesc implements Comparator <DisciplineKey>
{
    Map <DisciplineKey, String> syllabus;
    public CompHoursDesc(Map <DisciplineKey, String> syllabus)
    {
        this.syllabus=syllabus;
    }
    public int compare(DisciplineKey dis1, DisciplineKey dis2)
    {
        int hours1=Syllabus.transHour(syllabus.get(dis1));
        int hours2=Syllabus.transHour(syllabus.get(dis2));
        if(hours1>hours2) return -1;
        return 1;
    }
}