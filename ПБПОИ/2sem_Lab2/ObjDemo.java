public class ObjDemo
{
    public static void bubbleSort(Comparable[] arr)
    {
        boolean flag;
        for (int m=arr.length-1; m>0; m--)
        {
            flag=true;
            for (int j=0; j<m; j++)
            if (arr[j].compareTo(arr[j+1])>0)
            {
                Comparable b=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=b;
                flag=false;
            }
            if (flag) break;
        }
    }
    public static void putArr(Family[] arr)
    {
        for (int i=0; i<arr.length; i++)
            System.out.printf("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }
    public static void putArr(Housing[] arr)
    {
        for (int i=0; i<arr.length; i++)
            System.out.printf("%s, хэшкод: %d\n", arr[i], arr[i].hashCode());
    }
    public static void main(String args[])
    {
        System.out.println("1)Демонстрируем работу методов toString(), equals() и hashCode() для объектов класса Housing");
        Housing housing1=new Housing("дом", 5, false, 35000.0);
        Housing housing2=housing1;
        Housing housing3=new Housing(housing1);
        Housing housing4=new Housing("квартира", 3, true, 25000.0);
        Housing housing5=null;
        System.out.printf("housing1: %s, хэшкод: %d\n", housing1, housing1.hashCode());
        System.out.printf("housing2: %s, хэшкод: %d\n", housing2, housing2.hashCode());
        System.out.printf("housing3: %s, хэшкод: %d\n", housing3, housing3.hashCode());
        System.out.printf("housing4: %s, хэшкод: %d\n", housing4, housing4.hashCode());
        System.out.printf("housing5: %s\n", housing5);
        System.out.println("Результаты сравнения на равенство:");
        System.out.printf("housing1==housing2: %s\n",housing1.equals(housing2));
        System.out.printf("housing1==housing3: %s\n",housing1.equals(housing3));
        System.out.printf("housing1==housing4: %s\n",housing1.equals(housing4));
        System.out.printf("housing4==housing5: %s\n",housing4.equals(housing5));
        System.out.println();
        System.out.println("2)Демонстрируем сортировку элементов массивов arr1 и arr2 одним и тем же методом bubbleSort():");
        Family[] arr1=new Family[6];
        arr1[0]=new Family(2,1,true,85000.0);
        arr1[1]=new Family(1,1,false,65000.0);
        arr1[2]=new Family(2,2,true,95000.0);
        arr1[3]=new Family(2,0,true,75000.0);
        arr1[4]=new Family(1,0,false,33000.0);
        arr1[5]=new Family(2,3,true,100000.0);
        System.out.println("Массив Family до сортировки:");
        putArr(arr1);
        bubbleSort(arr1);
        System.out.println("Массив Family после сортировки:");
        putArr(arr1);
        Housing[] arr2=new Housing[6];
        arr2[0]=new Housing("дом",3,false,28000.0);
        arr2[1]=new Housing("дом",5,true,35000.0);
        arr2[2]=new Housing("квартира",2,true,23000.0);
        arr2[3]=new Housing("квартира",1,false,18000.0);
        arr2[4]=new Housing("дом",2,false,27000.0);
        arr2[5]=new Housing("квартира",3,true,26000.0);
        System.out.println("Массив Housing до сортировки:");
        putArr(arr2);
        bubbleSort(arr2);
        System.out.println("Массив Housing после сортировки:");
        putArr(arr2);
        System.out.println();
        System.out.println("3)Демонстрируем взаимодействие объектов при опредеении соответствия семей и жилья:");
        Housing housing=new Housing("дом",5,true,35000.0);
        Family family1=new Family(2,1,true,85000.0);
        Family family2=new Family(1,1,false,65000.0);
        Family family3=new Family(2,2,true,95000.0);
        Family family4=new Family(2,0,true,75000.0);
        Family family5=new Family(1,0,false,33000.0);
        Family family6=new Family(2,3,true,100000.0);
        System.out.printf("housing: %s\n",housing);
        System.out.printf("family1: %s\n",family1);
        System.out.printf("family2: %s\n",family2);
        System.out.printf("family3: %s\n",family3);
        System.out.printf("family4: %s\n",family4);
        System.out.printf("family5: %s\n",family5);
        System.out.printf("family6: %s\n",family6);
        System.out.printf("family1.accord(housing): %s\n", family1.accord(housing));
        System.out.printf("housing.accord(family1): %s\n", housing.accord(family1));
        System.out.printf("family2.accord(housing): %s\n", family2.accord(housing));
        System.out.printf("housing.accord(family2): %s\n", housing.accord(family2));
        System.out.printf("family3.accord(housing): %s\n", family3.accord(housing));
        System.out.printf("housing.accord(family3): %s\n", housing.accord(family3));
        System.out.printf("family4.accord(housing): %s\n", family4.accord(housing));
        System.out.printf("housing.accord(family4): %s\n", housing.accord(family4));
        System.out.printf("family5.accord(housing): %s\n", family5.accord(housing));
        System.out.printf("housing.accord(family5): %s\n", housing.accord(family5));
        System.out.printf("family6.accord(housing): %s\n", family6.accord(housing));
        System.out.printf("housing.accord(family6): %s\n", housing.accord(family6));
        housing.setType("квартира");
        housing.setRoom(2);
        housing.setBalcony(false);
        housing.setMoney(23000.0);
        family6.setAdult(1);
        family6.setChildren(0);
        family6.setAnimals(false);
        family6.setMoney(33000.0);
        if (family6.accord(housing))
        {
            System.out.printf("Объект %s\n", family6);
            System.out.println("соответствует объекту");
            System.out.println(housing);
        }
    }
}