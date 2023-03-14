public class Lab3a
{
    public static void main (String args [])
    {
        int a=145, b=312, x;
        int c=a/16+b%16-10*a;
        String s;
        s=Integer.toBinaryString(a);
        System.out.printf("a=%s(2)=%x(16)=%o(8)=%d(10) \n", s, a, a, a);
        s=Integer.toBinaryString(b);
        System.out.printf("b=%s(2)=%x(16)=%o(8)=%d(10) \n", s, b, b, b);
        s=Integer.toBinaryString(c);
        System.out.printf("c=%s(2)=%x(16)=%o(8)=%d(10) \n", s, c, c, c);
        x=-a;
        s=Integer.toBinaryString(x);
        System.out.printf("-a=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
        x=a+b;
        s=Integer.toBinaryString(x);
        System.out.printf("a+b=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
        x=a-b;
        s=Integer.toBinaryString(x);
        System.out.printf("a-b=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
        x=a*b;
        s=Integer.toBinaryString(x);
        System.out.printf("a*b=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
        x=a/b;
        s=Integer.toBinaryString(x);
        System.out.printf("a/b=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
        x=a%b;
        s=Integer.toBinaryString(x);
        System.out.printf("a%%b=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
        x=++a;
        s=Integer.toBinaryString(x);
        System.out.printf("a++=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
        x=--b;
        s=Integer.toBinaryString(x);
        System.out.printf("b--=%s(2)=%x(16)=%o(8)=%d(10) \n", s, x, x, x);
    }
}