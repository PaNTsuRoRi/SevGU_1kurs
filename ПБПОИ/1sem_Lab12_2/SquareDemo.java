public class SquareDemo{
    public static void bubbleSort (Family[] arr){
        boolean flag;
        for (int m = arr.length-1; m > 0; m--){
            flag = true;
            for(int j = 0; j < m; j++){
            if(arr[j].CompareTo(arr[j +1 ]) > 0){
                    Family b = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = b;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }
    public static void putSquareArr (Square[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.printf("%s, HashCode: %d\n", arr[i], arr[i].hashCode());
        }
    }
    public static void main(){
        Square f0 = new Square();
        f0.setAdult(4); f0.setChildren(3); f0.setAnimals(true); f0.setMoney(30000.00f); f0.setSquare(50);
        System.out.printf("F0: Adults: %3d, children: %3d, animals: %B, sum of pays: %.2f, square of apartments: %d\n",
        f0.getAdult(), f0.getChildren(), f0.getAnimals(), f0.getMoney(), f0.getSquare());
        Square s1 = new Square (2,5,true,10000.00f, 20);
        Square s2 = new Square (1,0,false,30000.00f,30);
        Square s3 = new Square(s1);
        Square s4 = s2;
        Square s5 = null;
        System.out.printf("s1: %s, HashCode: %d\n", s1, s1.hashCode());
        System.out.printf("s2: %s, HashCode: %d\n", s2, s2.hashCode());
        System.out.printf("s3: %s, HashCode: %d\n", s3, s3.hashCode());
        System.out.printf("s4: %s, HashCode: %d\n", s4, s4.hashCode());
        System.out.printf("s5: %s\n", s5);
        System.out.println("\nComparable results: ");
        System.out.printf("s1 == f2: %s\n", s1.equals(s2));
        System.out.printf("s2 == f4: %s\n", s2.equals(s4));
        System.out.printf("s1 == f4: %s\n", s1.equals(s4));
        System.out.printf("s4 == f5: %s\n", s4.equals(s5));
        Square[] arr = new Square [7];
        arr[0] = new Square(2,1,false,32000.50f,20);
        arr[1] = new Square(10,0,false,10002.40f,10);
        arr[2] = new Square(2,0,true,30010.00f,15);
        arr[3] = new Square(3,6,false,30300.00f,60);
        arr[4] = new Square(6,3,true,40000.70f,25);
        arr[5] = new Square(10,7,true,70000.10f,19);
        arr[6] = new Square(8,2,false,15000.40f,70);
        System.out.println("\nArray families before sort:  ");
        putSquareArr(arr);
        bubbleSort(arr);
        System.out.println("\nArray families after sort: ");
        putSquareArr(arr);
    }
}
