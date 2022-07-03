package suiteC;

import org.testng.annotations.Test;

public class TestC1 
{
  @Test
  public void testC1 () throws Exception
  {
	System.out.println("starting test C1"); 
	Thread.sleep(2000);
	System.out.println("ending test C1");
  }
 
}
