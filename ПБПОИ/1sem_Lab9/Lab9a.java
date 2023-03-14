public class Lab9a
{
    public static int Scalar(int X[][]) 
    {
        int max=X[0][0];
        for (int i=0; i<X.length; i++)
        {
            if (X[i][i]>max) max=X[i][i];
        }
        if (max>0) return max;
        else return 0;
    }
    public static int[] Vector(int X[][])
    {
        int A[]=new int[X[0].length];
        for (int j=0; j<X[0].length; j++)
        {
            int elem=0;
            for (int i=0; i<X.length; i++)
            {
                if (X[i][j]<0) elem++;
            }
            A[j]=elem;
        }
        return A;
    }
    public static int[][] Transpose(int X[][])
    {
        int A[][]=new int[X.length][X[0].length];
        for (int i=0; i<X.length; i++)
        {
            for (int j=0; j<X[0].length; j++)
            {
                A[i][j]=X[j][i];
            }
        }
        return A;
    }
    public static void WriteArr(int X[][])
    {
        for (int i=0; i<X.length; i++)
        {
            for (int j=0; j<X[0].length; j++)
            {
                System.out.print(X[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void WriteVec(int X[])
    {
        for (int i=0; i<X.length; i++)
        {
            System.out.print(X[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args [])
    {
        int A[][]={   
            {-3,5,-1},
            {8,-8,9},
            {-2,1,-6}};
        System.out.println("Матрица:");
        WriteArr(A);
        System.out.println("Максимальный из '+' элементов главной диагонали:");
        System.out.println(Scalar(A));
        System.out.println("Число отрицательных элементов для каждого столбца матрицы:");
        WriteVec(Vector(A));
        System.out.println("Транспонированная матрица:");
        WriteArr(Transpose(A));
    }
}
