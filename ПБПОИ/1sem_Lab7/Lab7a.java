public class Lab7a
{
    public static double fun(double x)
    {
        double y=1/Math.pow(x, 1.0/3.0);
        return y;
    }
    public static double funlter (double x, int n)
    {
        double y=x;
        for (int i=1; i<=n; i++)
        {
            y=y+(1.0/3.0)*(y-x*Math.pow(y, 4));
            System.out.printf("x=%e, y=%e, i=%d \n", x, y, i);
        }
        return y;
    }
    public static void go(double startX, double endX, double deltaX)
    {
        double x=startX, yt, yn, e;
        int n=10;
        while (x<=endX)
        {
            yt=fun(x);
            yn=funlter(x, n);
            e=Math.abs(yt-yn);
            System.out.printf("x=%e, yn=%e, yn=%e, e=%e \n", x, yt, yn, e);
            x=x+deltaX;
        }
    }
    public static void main(String args [])
    {
        System.out.println("Начало табулирования");
        go(0.8,2.0,0.2);
        System.out.println("Табулирование окончено");
        System.out.println("Начало табулирования");
        go(10,20,2);
        System.out.println("Табулирование окончено");
    }
}
