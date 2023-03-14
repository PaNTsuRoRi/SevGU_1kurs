public class FamilyDemo{
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
    public static void putFamilyArr (Family[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.printf ("%s, HashCode: %d\n", arr[i], arr[i].hashCode());
        }
    }
    public static void main(){
        Family f0 = new Family();
        f0.setAdult(4); f0.setChildren(3); f0.setAnimals(true); f0.setMoney(30000.00f);
        System.out.printf("F0: Adults: %3d, children: %3d, animals: %B, sum of pays: %.2f\n",
            f0.getAdult(), f0.getChildren(), f0.getAnimals(), f0.getMoney());
        Family f1 = new Family (2,3,false,100000.00f);
        Family f2 = new Family (1,1,true,30000.00f);
        Family f3 = new Family(f1);
        Family f4 = f2;
        Family f5 = null;
        System.out.printf("f1: %s, HashCode: %d\n", f1, f1.hashCode());
        System.out.printf("f2: %s, HashCode: %d\n", f2, f2.hashCode());
        System.out.printf("f3: %s, HashCode: %d\n", f3, f3.hashCode());
        System.out.printf("f4: %s, HashCode: %d\n", f4, f4.hashCode());
        System.out.printf("f5: %s\n", f5);
        System.out.println("\nComparable results: ");
        System.out.printf("f1 == f2: %s\n", f1.equals(f2));
        System.out.printf("f2 == f4: %s\n", f2.equals(f4));
        System.out.printf("f1 == f4: %s\n", f1.equals(f4));
        System.out.printf("f4 == f5: %s\n", f4.equals(f5));
        Family[] arr = new Family [7];
        arr[0] = new Family(2,1,false,32000.50f);
        arr[1] = new Family(10,0,false,10002.40f);
        arr[2] = new Family(2,0,true,30010.00f);
        arr[3] = new Family(3,6,false,30300.00f);
        arr[4] = new Family(6,3,true,40000.70f);
        arr[5] = new Family(10,7,true,70000.10f);
        arr[6] = new Family(8,2,false,15000.40f);
        System.out.println("\nArray families before sort: ");
        putFamilyArr(arr);
        bubbleSort(arr);
        System.out.println("\nArray families after sort: ");
        putFamilyArr(arr);
    }
}
