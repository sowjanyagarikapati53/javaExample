package testcases;

import org.testng.ITestContext;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PaymentManager 
{
	
  @Test
  public void applyDiscount() 
  {
	System.out.println("applyDiscount");
  }
	
  
  @Parameters({"action"})
  @Test
  public void makePayment(String parameterType, ITestContext context) 
  {
	  //System.out.println("makePayment");
	  if(parameterType.equals("Electronic media"))
		  System.out.println("MakePayment through Electronic media");
	  else
		  System.out.println("Make payment through pay@hotel");
	  
	  // Booking ID
	  
	  String bookingID = "RRR250877";
	  System.out.println("Booking ID : " +  bookingID);
	  context.setAttribute("bID", bookingID);
  }
}
