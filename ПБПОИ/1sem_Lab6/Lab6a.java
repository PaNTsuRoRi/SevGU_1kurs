import static java.lang.Math.pow;
public class Lab6a
{
    public static void main(String args [])
    {
        double g, z, y;
        double x=2.0;
        if (x<=0) g=(3+Math.sin(x))/(1+pow(x, 2));
        else g=(2*pow(x, 2)*pow(Math.cos(x), 2));
        if (x<0) z=pow(Math.abs(x), 1.0/3.0);
        else if (x>=0 && x<=1) z=-2*x+(x/(1+x));
        else z=Math.abs(3-x)/(1+x);
        y=g+z;
        System.out.printf("При x=%e, g=%e, z=%e, y=%e", x, g, z, y);
    }
}
