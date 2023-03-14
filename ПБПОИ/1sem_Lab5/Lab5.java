public class Lab5
{
    public static void main (String args [])
    {
        char a, c='$', d='L';
        a=((c=='$'|| Character.isDigit(c))&&Character.isLetter(d)) ? Character.toLowerCase(d) : c;
        System.out.printf("c=%c=(код)%x; d=%c=(код)%x; a=%c=(код)%x\n", c, (int)c, d, (int)d, a, (int)a);
    }
}