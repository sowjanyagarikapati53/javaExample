package suiteG;

import org.testng.annotations.Test;

public class TestG2
{
  @Test
  public void f() throws Exception 
  {
	  System.out.println("starting test G2");
	  Thread.sleep(2000);
	  System.out.println("ending test G2");
  }
}
