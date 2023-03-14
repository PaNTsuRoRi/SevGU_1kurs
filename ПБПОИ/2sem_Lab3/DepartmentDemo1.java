public class DepartmentDemo1
{
    public static void main(String []args)
    {
        System.out.println("Сформированы следующие кафедры:");
        System.out.println("Кафедра ИТУТС, число преподавателей:   5,");
        System.out.println("Кафедра ИРИБ, число преподавателей:    5");
        System.out.println();
        System.out.println("На кафедру ИТУТС добавить преподавателя 32348 не удалось: ");
        System.out.println("  нарушена уникальност ключа");
        System.out.println("На кафедру ИРИБ добавить преподавателя 60538 не удалось: ");
        System.out.println("  превышен лимит");
        System.out.println();
        System.out.println("ИТУТС");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     256486   Козлов        70000.0");
        System.out.println("  2     564563   Акимов        35000.0");
        System.out.println("  3     453637   Иванов        40000.0");
        System.out.println("  4     634674   Петров        25000.0");
        System.out.println("  5     447374   Орлов         60000.0");
        System.out.println("Средний размер ставки: 46000.0");
        System.out.println("Преподаватели, у которых ставка выше среднего на кафедре:");
        System.out.println("Преподаватель:     256486      Козлов,     70000.0");
        System.out.println("Преподаватель:     256486       Орлов,     60000.0");
        System.out.println("Преподаватели, у которых ставка в диапазоне [38000.0,55000.0]:");
        System.out.println("Преподаватель:     453637      Иванов,     40000.0");
        System.out.println("Состав кафедры ИТУТС после удаления преподавателя:");
        System.out.println("ИТУТС");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     256486   Козлов        70000.0");
        System.out.println("  2     453637   Иванов        40000.0");
        System.out.println("  3     634674   Петров        25000.0");
        System.out.println("  4     447374   Орлов         60000.0");
        System.out.println();
        System.out.println("ИРИБ");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     254586   Федоров       60000.0");
        System.out.println("  2     585563   Ливанов       35000.0");
        System.out.println("  3     453632   Афанасьев     25000.0");
        System.out.println("  4     633464   Морев         36000.0");
        System.out.println("  5     767374   Коваленко     54000.0");
        System.out.println("Средний размер ставки: 42000.0");
        System.out.println("Преподаватели, у которых ставка выше среднего на кафедре:");
        System.out.println("Преподаватель:     254586     Федоров,     60000.0");
        System.out.println("Преподаватель:     767374   Коваленко,     54000.0");
        System.out.println("Преподаватели, у которых ставка в диапазоне [38000.0,55000.0]:");
        System.out.println("Преподаватель:     767374   Коваленко,     54000.0");
        System.out.println("Состав кафедры ИРИБ после удаления преподавателя:");
        System.out.println("ИРИБ");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     254586   Федоров       60000.0");
        System.out.println("  2     453632   Афанасьев     25000.0");
        System.out.println("  3     633464   Морев         36000.0");
        System.out.println("  4     767374   Коваленко     54000.0");
        System.out.println("Проверка наличия преподавателей:");
        System.out.println("На кафедре ИТУТС");
        System.out.println("Преподаваетль:    453637,     Иванов,   40000.0");
        System.out.println("Нет преподаваетля с ID 700000");
        System.out.println("На кафедре ИРИБ");
        System.out.println("Преподаваетль:    453632,  Афанасьев,   25000.0");
    }
}
