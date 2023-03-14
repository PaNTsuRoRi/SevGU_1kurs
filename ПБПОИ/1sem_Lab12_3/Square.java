public class Square extends Family{
    private final static String FAMILY_STRING_FORMAT = "%s, square of apartments: %d";
    private int square;
    public Square(){super(); square = 0;}
    public Square (int adult, int children, boolean animals, float money,int square){
        super (adult, children, animals, money); this.square = square;
    }
    public Square (Square ob){
        super(ob);
        square = ob.square;
    }
    public int getSquare(){return square;}
    public void setSquare(int square){this.square = square;}
    public String toString(){
        return String.format(FAMILY_STRING_FORMAT, super.toString(), square);
    }
    public boolean equals (Object ob){
        if(!super.equals(ob)) return false;
        Square fp = (Square) ob;
        return (square == fp.square);
    }
    public int hashCode(){
        return super.hashCode() + 19 * (new Double(square)).hashCode();
    }
    public int compareTo (Family family){
        int comp = super.compareTo(family);
        if(comp < 0) return -1;
        Square fp = (Square) family;
        if ((comp == 0) && (fp.square) < 0) return -1;
        if ((comp == 0) && (fp.square) == 0) return 0;
        return 1;
    }
}
