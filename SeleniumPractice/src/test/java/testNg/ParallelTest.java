package testNg;

import org.testng.annotations.Test;

public class ParallelTest 
{
  @Test
  public void A1() 
  {
	 System.out.println("iam test A1 :"+Thread.currentThread().getId()); 
  }

  @Test
  public void A2() 
  {
	 System.out.println("iam test A2 :"+Thread.currentThread().getId()); 
  }

  @Test
  public void A3() 
  {
	 System.out.println("iam test A3 :"+Thread.currentThread().getId()); 
  }
  @Test
  public void A4() 
  {
	 System.out.println("iam test A4 :"+Thread.currentThread().getId()); 
  }
  @Test
  public void A5() 
  {
	 System.out.println("iam test A5 :"+Thread.currentThread().getId()); 
  }
  @Test
  public void A6() 
  {
	 System.out.println("iam test A6 :"+Thread.currentThread().getId()); 
  }
  @Test
  public void A7() 
  {
	 System.out.println("iam test A7 :"+Thread.currentThread().getId()); 
  }
}
