public class Lab10
{
    public static void main(String args[])
    {
        int A[]={1,5,6,7,9,12,10,94,45};
        int B[]={1,5,-6,7,-9,-12,10,94,-45};
        int C[]={-1,-5,-6,-7,-9,-12,-10,-94,-45};
        System.out.println("Массив А:");
        LibraryClass.WriteArr(A);
        System.out.println("Сумма подожительных элементов:");
        System.out.println(LibraryClass.SumPositiveElem(A,0,A.length-1));
        System.out.println("Количество отрицательных элементов:");
        System.out.println(LibraryClass.NumNegativeElem(A,0,A.length-1));
        System.out.println("Массив B:");
        LibraryClass.WriteArr(B);
        System.out.println("Сумма подожительных элементов:");
        System.out.println(LibraryClass.SumPositiveElem(B,0,B.length-1));
        System.out.println("Количество отрицательных элементов:");
        System.out.println(LibraryClass.NumNegativeElem(B,0,B.length-1));
        System.out.println("Массив C:");
        LibraryClass.WriteArr(C);
        System.out.println("Сумма подожительных элементов:");
        System.out.println(LibraryClass.SumPositiveElem(C,0,C.length-1));
        System.out.println("Количество отрицательных элементов:");
        System.out.println(LibraryClass.NumNegativeElem(C,0,C.length-1));
    }
}
