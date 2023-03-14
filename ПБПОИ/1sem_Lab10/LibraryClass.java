public class LibraryClass
{
    public static void WriteArr(int X[])
    {
        if (X==null) return;
        for (int i=0; i<X.length; i++)
            System.out.print(X[i]+" ");
        System.out.println();
    }
    public static int SumPositiveElem(int X[],int start,int end)
    {
        int sum=0;
        if (start<=end)
        {
            if (start==end)
            {
                if (X[start]>0) sum=X[start];
            }
            else 
            {
                sum=SumPositiveElem(X, start+1, end);
                if (X[start]>0) sum+=X[start];
            }   
        }
        return sum;
    }
    public static int NumNegativeElem(int X[],int start,int end)
    {
        int res=0;
        for (int i=start; i<=end; i++)
        {
            if (X[i]<0) res++;
        }
        return res;
    }
}