public class DepDisDemo //Взаимодействие дисциплин и кадедр
{
    public static void main(String args[])
    {
        //Создаем кафедры
        Department dep1 = new Department("ИТИКС");
        Department dep2 = new Department("ИС");
        //Добавление дисциплин на кафедру ИТИКС
        dep1.addDis(new Discipline(12549,"Архитектура ЭВМ",3,5.0f));
        dep1.addDis(new Discipline(12550,"Базы данных",4,3.0f));
        dep1.addDis(new Discipline(13698,"Программирование",2,6.0f));
        dep1.addDis(new Discipline(12259,"Информатика",1,3.5f));
        dep1.addDis(new Discipline(13168,"Схемотехника",5,5.5f));
        //Добавление дисциплин на кафедру ИС
        dep2.addDis(new Discipline(21987,"Электроника",3,4.0f));
        dep2.addDis(new Discipline(22368,"Системный анализ",2,3.5f));
        dep2.addDis(new Discipline(21985,"Web-технологии",3,4.7f));
        dep2.addDis(new Discipline(23947,"Геоинформатика",5,5.3f));
        dep2.addDis(new Discipline(20329,"Численные методы",4,3.2f));
        //Выводим список кафедры ИТИКС без сортировки
        System.out.println("Дисциплины кафедры(без сортировки)");
        dep1.putDepartment();
        //Пытаемся добавить дисциплину с тем же id
        System.out.println("Попытка добавить дисциплину: 13698, Физика, 2, 3.5\n");
        dep1.addDis(new Discipline(13698,"Физика",2,3.5f));
        //Вывод дисциплин, у которых число кредитов выше среднего на кафедре
        dep1.aboveAvgCredit().putDepartment();
        //Вывод дисциплин, у которых число кредитов находятся в интервале
        dep1.betweenCredit(3.5f,5.6f).putDepartment();
        //сортировка по возрастанию кредитов
        dep1.sortCreditAsc().putDepartment();
        //сортировка по убыванию кредитов
        dep1.sortCreditDesc().putDepartment();
        //сортировка по возрастанию имени и убыванию кредитов
        dep1.sortNameAscCreditDesc().putDepartment();
        //удаление дисциплины по id
        dep1.delDis(12550);
        //Вывод списка кафедры после удаления дисциплины
        System.out.println("После удаления дисциплины с id=12550:");
        dep1.putDepartment();
        //Выводим список кафедры ИС без сортировки
        System.out.println("Дисциплины кафедры(без сортировки)");
        dep2.putDepartment();
        //Вывод дисциплин, у которых число кредитов выше среднего на кафедре
        dep2.aboveAvgCredit().putDepartment();
        //Вывод дисциплин, у которых число кредитов находятся в интервале
        dep2.betweenCredit(3.5f,5.6f).putDepartment();
        //сортировка по возрастанию кредитов
        dep2.sortCreditAsc().putDepartment();
        //сортировка по убыванию кредитов
        dep2.sortCreditDesc().putDepartment();
        //сортировка по возрастанию имени и убыванию кредитов
        dep2.sortNameAscCreditDesc().putDepartment();
        //Проверка наличия дисциплины с заданным id
        int n=13698;
        System.out.printf("Проверка наличия дисциплины с id=%d\n",n);
        Discipline d1=dep1.getDiscipline(n);
        if(d1==null) System.out.printf("На кафедре %s нет дисциплины с id=%d\n",dep1.getDepartmentName(),n);
        else System.out.println(d1);
        n=70000;
        System.out.printf("\nПроверка наличия дисциплины с id=%d\n",n);
        d1=dep1.getDiscipline(n);
        if(d1==null) System.out.printf("На кафедре %s нет дисциплины с id=%d\n",dep1.getDepartmentName(),n);
        else System.out.println(d1);
        n=23947;
        System.out.printf("\nПроверка наличия дисциплины с id=%d\n",n);
        d1=dep2.getDiscipline(n);
        if(d1==null) System.out.printf("На кафедре %s нет дисциплины с id=%d\n",dep2.getDepartmentName(),n);
        else System.out.println(d1);
        //Дополнительное задание
        //Обновление id у объекта с заданным id
        n=84645;
        System.out.println("Обновление ID у объекта c 84645 на 21987");
        dep2.updateId(n, 21987);
        dep2.putDepartment();
        n=21987;
        System.out.println("Обновление ID у объекта c 21987 на 24553");
        dep2.updateId(n, 24553);
        dep2.putDepartment();
        //Удаление объектов, значение кредитов которых находятся в заданном интервале
        dep2.deleteIntervalBetweenCredit(3.0f,4.0f).putDepartment();
        //Возвращение группы объектов, имя которых содержит заданное буквосочетание
        dep2.searchByString("ка").putDepartment();
    }
}
