public class Lab2a
{
    public static void main (String args [])
    {
        String str = "Еремеев ПИН/б-19-1-о";
        int a = 1565;
        short b = 978;
        byte c = 126;
        double d = 845.6456;
        float f = 654.649f;
        System.out.printf("Привет, %s: a=%x, b=%o, с=%08d, d=%+-11.5f, f=%09.4f", str, a, b, c, d, f);
    }
}
