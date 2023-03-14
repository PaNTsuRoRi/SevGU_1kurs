public class SyllabusDemo
{
    //Взаиможействие дисциплин и учебного плана
    public static void main(String[] args)
    {
        //Создаем учебный план
        Syllabus sul=new Syllabus ("Учебный план кафедры ИТИКС");
        //добавляем дисциплины в план
        sul.addDis(new DisciplineKey(45634,"Dubik",4),"72");
        sul.addDis(new DisciplineKey(45635,"Glebov",2),"64");
        sul.addDis(new DisciplineKey(45635,"Kovalenko",4),"128");
        sul.addDis(new DisciplineKey(45635,"Saenko",3),"72");
        sul.addDis(new DisciplineKey(46723,"Moroz",3),"64");
        sul.addDis(new DisciplineKey(46837,"Khlopchik",1),"72");
        sul.addDis(new DisciplineKey(46984,"Petrov",2),"32");
        sul.addDis(new DisciplineKey(46984,"Sidorov",3),"64");
        sul.addDis(new DisciplineKey(46986,"Yaroshenko",3),"128");
        sul.addDis(new DisciplineKey(46987,"Ivanov",1),"64");
        //Вывод учебного плана без сортировки
        System.out.println(String.format("Начальное состояние учебного плана \n%s:",sul));
        sul.putSyllabus();
        //Запросы на добавление и обновление дисциплин
        System.out.println("Запрос на добавление дисциплины в план");
        //попытка добавить дисциплину с ID, который уже есть в плане
        DisciplineKey dk=new DisciplineKey(46984,"Petrov",2);
        if(!sul.addDis(dk,"32"))
            System.out.println(String.format("Запись %s\n\t нарушает правило уникальности ключа",dk));
        System.out.println("\nЗапрос на обновление записи о дисциплине");   
        //изменить количество часов в плане
        dk=new DisciplineKey(45634,"Dubik",4);
        sul.updateDiscipline(dk,"32");
        System.out.println(String.format("После обновления количества часов в записи:\n\t %s",dk));
        sul.putSyllabus();
        //Запрос на выборку данных
        System.out.println("Запрос на выборку записей о дисциплинах");
        //выводим выборку из плана для заданного ID дисциплины,
        //упорядоченного по возрастанию логина преподавателя и уменьшению семестра
        sul.selectDisciplineData(45635).sortLoginAscSemesterDesc().putSyllabus();
        //выводим суммарное кол-во часов для  данной дисциплины
        System.out.println(String.format("Суммарное кол-во часов дисциплины 45635: %5d^",sul.selectSumHourDis(45635)));
        //выводим выборку из плана для заданного ID дисциплины
        //в заданном семестре, упорядоченному по кол-ву часов
        sul.selectDisciplineSemesterData(46984,2).sortHoursDesc().putSyllabus();
        //выводим выборку из плана для заданного логина преподователя
        //упорядоченного по ID дисциплины и семестру
        sul.selectLoginData("Glebov").sortIdAscSemesterDesc().putSyllabus();
        //Запросы на удаление записей о дисциплинах
        System.out.println("Запросы на удаление записей о дисциплинах");
        //удаляем из плана запись о дисциплине 45635 в 3 семестре
        dk=new DisciplineKey(45635,"Saenko",3);
        sul.delDis(dk);
        //Выводим план после удаления дисциплины
        System.out.println(String.format("После удаления записи:\n\t%s",dk));
        sul.putSyllabus();
        //Пытаемся удалить записть, которой нет в плане
        dk=new DisciplineKey(97835,"Saenko",5);
        if(!sul.delDis(dk))
            System.out.println(String.format("Поптка удаления несуществующей записи:\n\t%s",dk));
        //удаляем из плана все записи о дисциплине 46984
        sul.delDis(46984);
        //Выводим план после удаления записей
        System.out.println("После удаления всех записей о дисциплине 46984");
        sul.putSyllabus();
        //пытаемся удалить записи о дисциплине, которой нет в плане
        if(!sul.delDis(98888))
            System.out.println(String.format("Попытка удаления записей несуществующей дисциплины^%7d",98888));
        System.out.println("\n Рассмотренная структура программы обработки БД");
        System.out.println("код и вызовы запросов встроен в код программы,");
        System.out.println("может применяться, если список запросов к БД");
        System.out.println("ограничен и заранее известен.");
        System.out.println("В противном случае, нужно использовать возможности Java");
        System.out.println("по применению встроенного динамического SQL.");
    }
}
