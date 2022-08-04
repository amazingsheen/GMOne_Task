

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
			driver.findElement(By.id("txtOriginGeneral")).click();
			driver.findElement(By.xpath("//body[1]/form[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/div[1]")).click();
			driver.findElement(By.xpath("//input[@id='txtDestinationGeneral']")).click();
			driver.findElement(By.xpath("//body[1]/form[1]/div[4]/div[1]/div[2]/div[2]/div[2]/div[1]/div[3]/div[1]/div[2]/ul[1]/li[1]/ul[1]/li[1]/div[1]")).click();
	  }
			@Test(priority=2)
			public void datepicker()
			{
				String emonth = "September";
				String eyear = "2022";
			  
				driver.findElement(By.id("txtDepartDateBooking")).click();
				while(true)
				{
				String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				String year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			 
				if(month.equalsIgnoreCase(emonth) && year.equals(eyear)) {
				 break;
				}
				else
				 driver.findElement(By.xpath("//a[@title='Next']")).click();
				}
	
		
			driver.findElement(By.xpath("//a[normalize-space()='20']")).click();
			}
			
			@Test(priority = 3)
			public void searchbus() {
			WebElement searchbtn= driver.findElement(By.id("btnBusSearchNewGeneral"));
			searchbtn.click();
			}
			
			@Test(priority = 4)
			public void lowfare() {
				driver.findElement(By.id("cheapest")).click();
			}
			
			
			@Test(priority = 5)
			public void selectbus() {
				driver.findElement(By.xpath("//body[1]/form[1]/div[4]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/a[1]")).click();
			}



			@Test(priority = 6)

	public void  selectseat() throws InterruptedException {
				  Thread.sleep(5000);
				  //hardcoding the seats
			 driver.findElement(By.xpath("//div[normalize-space()='27']")).click();
			 driver.findElement(By.xpath("//div[normalize-space()='28']")).click();
			 driver.findElement(By.xpath("//div[normalize-space()='29']")).click();
			 driver.findElement(By.xpath("//div[normalize-space()='30']")).click();
			 driver.findElement(By.xpath("//div[normalize-space()='1']")).click();
			 driver.findElement(By.xpath("//div[normalize-space()='2']")).click();
			 
			 
			}
	@Test(priority = 7)
	public void proceed() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Proceed']")).click();
	}
	
	@Test(priority = 8)
	public void personaldetails() {
		driver.findElement(By.xpath("//input[@class='payment_textName form-control pay-form-control']")).sendKeys("Afsheen");
		driver.findElement(By.xpath("//input[@class='payment_txtPhoneLogin form-control pay-form-control']")).sendKeys("8247866881");
		driver.findElement(By.xpath("//input[@class='payment_txtEmail form-control pay-form-control']")).sendKeys("amazingsheen@gmail.com");
		driver.findElement(By.xpath("//a[@id='btnNext']")).click();
	}


@Test(priority = 9)
public void proceedtopayment() throws InterruptedException {
	Thread.sleep(3000);

	driver.findElement(By.xpath("//input[@id='payment_btnProceedPayment']")).click();
}



@Test(priority = 10)
public void alertmsg() throws InterruptedException {
	
	
	try
	{
		Thread.sleep(3000);
		   Alert alert = driver.switchTo().alert();
			
		   System.out.println("The alert message is:" +alert.getText());

		   Assert.assertTrue(alert.getText().contains("Please select a payment method"));
	}
		
		catch(NoAlertPresentException ne)
		{
			System.out. println("Alert not displayed") ;

		}
}
	
}

	








				