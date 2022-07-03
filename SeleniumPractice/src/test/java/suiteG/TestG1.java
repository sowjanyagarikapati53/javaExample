package suiteG;

import org.testng.annotations.Test;

public class TestG1
{
  @Test
  public void f() throws Exception 
  {
	  System.out.println("starting test G1");
	  Thread.sleep(2000);
	  System.out.println("ending test G1");
  }
}
