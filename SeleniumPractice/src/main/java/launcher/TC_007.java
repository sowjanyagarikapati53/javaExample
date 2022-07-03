package launcher;

import org.apache.log4j.Logger;

public class TC_007 extends BaseTest
{

		private static final Logger log = Logger.getLogger(TC_007.class);

		public static void main(String[] args) throws Exception 
		{
			
			init();
			log.info("Init the Properties files....");
			
			launch("chromebrowser");
			log.info("Opening the Browser :- " + p.getProperty("chromebrowser"));
			
			navigateUrl("amazonurl");
			log.info("Navigating to application : " + childprop.getProperty("amazonurl"));
			
			selectOption("amazondropbox_id","Books");
			log.info("Selecting option Books By using locator : " + orprop.getProperty("amazondropbox_id"));
			
			typeText("amazonsearchtextbox_name","Harry Potter");
			log.info("Typing text Harry Potter By using Locator : "+ orprop.getProperty("amazonsearchtextbox_name"));
			
			clickElement("amazonsearchbutton_id");
			log.info("Clicked on Element By ussong Locator : " + orprop.getProperty("amazonsearchbutton_id"));
		}

	}


