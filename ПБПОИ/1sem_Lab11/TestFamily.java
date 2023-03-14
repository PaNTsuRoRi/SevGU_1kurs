public class TestFamily{ 
  public static void main(String args[ ])
  { 
      Family f3=new Family(); 
      
      Family f1=new Family(2,3,true,70000.0); 
      Family f2=f1; 
      
      f3.setAdults(f2.getAdults()); 
      f3.setChildren(f2.getChildren()); 
      f3.setAnimal(f2.getAnimal());
      f3.setCost(f2.getCost()); 
      
      Family f4=new Family(3,1,false,50000.0); 
      
      Family f5 = null; 
      
      System.out.println("f1="+ f1); 
      System.out.println("f2="+ f2); 
      System.out.println("f3="+ f3); 
      System.out.println("f4="+ f4); 
      System.out.println("f5="+ f5); 
      
      System.out.println("f1==f2: "+ f1.equals(f2)); 
      System.out.println("f1==f3: "+ f1.equals(f3)); 
      System.out.println("f1==f4: "+ f1.equals(f4)); 
      System.out.println("f2==f3: "+ f2.equals(f3)); 
      System.out.println("f2==f4: "+ f2.equals(f4)); 
      System.out.println("f3==f4: "+ f3.equals(f4));  
      System.out.println("f3==f5: "+ f3.equals(f5));
  }     
}             
