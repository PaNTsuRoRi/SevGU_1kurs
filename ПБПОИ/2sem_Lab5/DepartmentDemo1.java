public class DepartmentDemo1
{
    public static void main(String []args)
    {
        System.out.println("Сформированы следующие кафедры:");
        System.out.println("Кафедра: ИТУТС, число преподавателей:   5,");
        System.out.println("Кафедра: ИРИБ, число преподавателей:    5");
        System.out.println();
        System.out.println("На кафедру ИТУТС добавить преподавателя 60538 не удалось: ");
        System.out.println("превышен лимит");
        System.out.println("На кафедру ИРИБ добавить преподавателя 32348 не удалось:");
        System.out.println("нарушена уникальность ключа");
        System.out.println();
        System.out.println("ИТУТС");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     35348    Козлов        70000.0");
        System.out.println("  2     12345    Акимов        35000.0");
        System.out.println("  3     45363    Иванов        40000.0");
        System.out.println("  4     63467    Петров        25000.0");
        System.out.println("  5     44737    Орлов         60000.0");
        System.out.println("Преподаватели, у которых ставка выше среднего 46000.0:");
        System.out.println("Преподаватель:     35348      Козлов,     70000.0");
        System.out.println("Преподаватель:     44737       Орлов,     60000.0");
        System.out.println("Преподаватели, у которых ставка в диапазоне [38000.0,55000.0]:");
        System.out.println("Преподаватель:     45363      Иванов,     40000.0");
        System.out.println("После удаления преподавателя:");
        System.out.println("ИТУТС");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     35348   Козлов        70000.0");
        System.out.println("  2     45363   Иванов        40000.0");
        System.out.println("  3     63467   Петров        25000.0");
        System.out.println("  4     44737   Орлов         60000.0");
        System.out.println();
        System.out.println("ИРИБ");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     25458    Федоров       60000.0");
        System.out.println("  2     32348    Ливанов       35000.0");
        System.out.println("  3     45463    Афанасьев     25000.0");
        System.out.println("  4     63346    Морев         36000.0");
        System.out.println("  5     76737    Коваленко     54000.0");
        System.out.println("Преподаватели, у которых ставка выше среднего 42000.0:");
        System.out.println("Преподаватель:     25458     Федоров,     60000.0");
        System.out.println("Преподаватель:     76737   Коваленко,     54000.0");
        System.out.println("Преподаватели, у которых ставка в диапазоне [38000.0,55000.0]:");
        System.out.println("Преподаватель:     767374   Коваленко,     54000.0");
        System.out.println("После удаления преподавателя:");
        System.out.println("ИРИБ");
        System.out.println("Номер     ID       ФИО      Размер ставки");
        System.out.println("  1     25458    Федоров       60000.0");
        System.out.println("  2     45363    Афанасьев     25000.0");
        System.out.println("  3     63346    Морев         36000.0");
        System.out.println("  4     76737    Коваленко     54000.0");
        System.out.println("Проверка наличия преподавателей:");
        System.out.println("На кафедре ИТУТС");
        System.out.println("Преподаваетль:    45363,     Иванов,   40000.0");
        System.out.println("Нет преподаваетля с ID 70000");
        System.out.println("На кафедре ИРИБ");
        System.out.println("Преподаваетль:    45463,  Афанасьев,   25000.0");
        System.out.println("После назначения кафедрам статуса имеем:");
        System.out.println("ИТУТС сертификат А");
        System.out.println("ИРИБ не сертифицирована");
    }
}
