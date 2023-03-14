public class Lab4a
{
    public static void main (String args [])
    {
        int x1=-4, x2=2, z1=12, z2=-6;
        double m1, m2, k1, k2;
        k1=Math.exp(Math.PI*x1)*Math.cos(0.01*z1);
        m1=(Math.sqrt(Math.log(k1)+1000)-Math.sqrt(1000-Math.log(k1)))/(Math.pow(x1, 2)+18*x1-40);
        k2=Math.exp(Math.PI*x2)*Math.cos(0.01*z2);
        m2=(Math.sqrt(Math.log(k2)+1000)-Math.sqrt(1000-Math.log(k2)))/(Math.pow(x2, 2)+18*x2-40);
        System.out.printf("m1=%f; k1=%f; m2=%f; k2=%f. \n", m1, k1, m2, k2);
        System.out.println("m1=" + Long.toBinaryString(Double.doubleToLongBits(m1)));
        System.out.println("k1=" + Long.toBinaryString(Double.doubleToLongBits(k1)));
        System.out.println("m2=" + Long.toBinaryString(Double.doubleToLongBits(m2)));
        System.out.println("k2=" + Long.toBinaryString(Double.doubleToLongBits(k2)));
    }
}