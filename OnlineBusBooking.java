package TESTNGdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class OnlineBusBooking {
	 WebDriver driver; 
  
  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\javee\\OneDrive\\Desktop\\shelljars\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
  }
	  
	  @Test(priority =1)
	  public void title() {
		  driver.get("https://www.busonlineticket.com/booking/bus-tickets.aspx");
		  driver.manage().window().maximize();
		Assert.assertEquals(driver.getTitle(),"Bus Online Booking Services at BusOnlineTicket.com Malaysia & Singapore"); 
	  }
		
	  @Test (priority = 2)
	  public void origin_destination() {
		
		//locating the Origin web element
		
		driver.findElement(By.id("txtOriginGeneral")).click();
		
		//capturing  the list of origins from dropdown
		
			List<WebElement>origins = driver.findElements(By.xpath("//div[@id='divFromList']//ul/li/div"));	
			System.out.println(origins.size());//printing the size of dropdown box			
			//capturing each origin option using for each loop

			for(WebElement origin : origins)
				{
					if(origin.getText().equals("Cameron Highlands"))
							{
						origin.click();
						break;
							}
				}
				
				
				//locating the destination web element
				
				driver.findElement(By.xpath("//input[@id='txtDestinationGeneral']")).click();
				
				//capturing the list of destinations from dropdown
				
				List<WebElement>destinations = driver.findElements(By.xpath("//ul[@class='select2-results']//li/ul/li"));	
				
				System.out.println(destinations.size());
				//capturing each destination option using for_each loop
				for(WebElement destination : destinations)
				{
					if(destination.getText().equals("Kuala Lumpur"))
							{
						destination.click();
						break;
							}
				}
	  }
			@Test(priority=4)
			public void month_year()
			{
				String emonth = "September";		
				String eyear = "2022";

				driver.findElement(By.id("txtDepartDateBooking")).click();
				
				while(true) {
					String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			 
				if(month.equalsIgnoreCase(emonth) && year.equals(eyear)) 
				{
				 break;
				}
				
				else
				 driver.findElement(By.xpath("//a[@title='Next']")).click();				}
			}
			
			
			@Test(priority = 5)
			public void datepick() {
				
			String edate = "20";

			List<WebElement> alldates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr/td"));

		
			for(WebElement date: alldates)
			{
				String dt = date.getText();

				
				if(dt.equals(edate))
					{
						date.click();
							break;
					}
			}
}

			@Test(priority = 6)
			public void searchbus() {
			WebElement searchbtn= driver.findElement(By.id("btnBusSearchNewGeneral"));
			searchbtn.click();
			}
			
			@Test(priority = 7)
			public void leastadultcost() {
				driver.findElement(By.id("cheapest")).click();
			}
			
			
			@Test(priority = 8)
			public void selectbus() {
				driver.findElement(By.xpath("//body[1]/form[1]/div[4]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/a[1]")).click();
			}


			@Test(priority = 9)

			public void  selectseat() throws InterruptedException  {
				Thread.sleep(3000);
			    List<WebElement> availableseats = driver.findElements( By.xpath( "//div[@class='seat_available']" ) );
			    availableseats.size();
			    System.out.println("Number of available seats:" +availableseats.size());
			    

	        if(availableseats.size() < 6)
		            //search for next bus, less than 6 seats.
		           System.out.println("Number of seats less than 6");
		     	  
				int i = 0;
		        //if noofseats are less than 6 move to next bus.
		        for ( WebElement seat: availableseats) {
		        	seat.click(); //simulate visual movement
		            Thread.sleep(3000);
		            i++;
		            if(i>=6)
		                break;
		        }        
				}
			    
				@Test(priority = 10)
				public void proceed() {
			   
				driver.findElement(By.xpath("//input[@value='Proceed']")).click();
				}
		
		
			@Test(priority = 11)
			
			//entering personal details
			public void personaldetails() {
			driver.findElement(By.xpath("//input[@class='payment_textName form-control pay-form-control']")).sendKeys("Afsheen");
			driver.findElement(By.xpath("//input[@class='payment_txtPhoneLogin form-control pay-form-control']")).sendKeys("8247866881");
			driver.findElement(By.xpath("//input[@class='payment_txtEmail form-control pay-form-control']")).sendKeys("amazingsheen@gmail.com");
			driver.findElement(By.xpath("//a[@id='btnNext']")).click();
		
			}
			@Test(priority = 12)
			public void proceedtopayment() throws InterruptedException {
				Thread.sleep(3000);

				driver.findElement(By.xpath("//input[@id='payment_btnProceedPayment']")).click();
			}



			@Test(priority = 13)
			public void alertmsg() throws InterruptedException {
				try
				{
					Thread.sleep(5000);
				
					 Alert alert = driver.switchTo().alert();

			 		 System.out.println("The alert message is:" +alert.getText());

			  		 Assert.assertTrue(alert.getText().contains("Please select a payment method"));
				}
			   catch(NoAlertPresentException e)
				{
					System.out. println("Alert not displayed") ;

				}
}	
}			




	


	








				
