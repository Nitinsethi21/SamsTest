package WebSite;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class UpdatedClass {
	private WebDriver driver;
	private WebDriverWait wait;

	
	public void setup(){
		System.setProperty("webdriver.chrome.driver","/Users/chdsez319004dadm/Desktop/JARS/chromedriver 2");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-notification");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, 30);		
	}
	
		@Test(priority = 1)	
		
		public void ValidateNavigationToSamsClub(){
			Reporter.log("Navigate to SamsClub Website");
			driver.get("https://major-qa-www.samsclub.com/sams/");	
		}
		
		@Test(priority = 2)
		
		public void ValidateJoinNowButton(){
			Reporter.log("Tap on Join");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/sams/pagedetails/content.jsp?pageName=aboutSams&xid=hdr_join']")));
			driver.findElement(By.xpath("//a[@href='/sams/pagedetails/content.jsp?pageName=aboutSams&xid=hdr_join']")).click();
		}
		
		@Test(priority = 3)
		
		public void ValidateSelectMemberShip(){	
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='about-membership-cards-joinnow']")));
			driver.findElement(By.xpath("//span[text()='Select Club']")).click();
		}
		
		@Test(priority = 4)
		
		public void ValidateMemberShipDetails(){
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='fName']")));
			driver.findElement(By.xpath("//input[@id='fName']")).sendKeys("Nitin");
			driver.findElement(By.xpath("//input[@id='lName']")).sendKeys("Sethi");
			driver.findElement(By.xpath("//input[@id='uremail']")).sendKeys("n@iop.com");
			driver.findElement(By.xpath("//input[@id='stAdd']")).sendKeys("123 park avenue");
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Cupertino");
			Select state = new Select(driver.findElement(By.xpath("//select[@id='states']")));  //For Dropdown
			state.selectByVisibleText("CA");
			driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("95014");
			driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("9876958769");
			driver.findElement(By.xpath("//input[@id='urpass']")).sendKeys("nitin123");
			driver.findElement(By.xpath("//input[@id='confPass']")).sendKeys("nitin123");
			driver.findElement(By.xpath("//input[@id='checkage']")).click();
			driver.findElement(By.xpath("//button[@id='chkFuturePurchase']")).click();
		}
		
		@Test(priority = 5)
		
		public void ValidatePaymentDetails(){
			driver.findElement(By.xpath("//input[@id='nameOnCard']")).sendKeys("nitin");
			driver.findElement(By.xpath("//input[@id='CCaCardValue']")).sendKeys("4111111111111111");
			driver.findElement(By.xpath("//input[@name='cardCvv']")).sendKeys("123");
			Select month = new Select(driver.findElement(By.xpath("//select[@id='expMonth']")));  //Dropdown
			month.selectByIndex(3);
			Select year = new Select(driver.findElement(By.xpath("//select[@id='expYear']")));
			year.selectByIndex(4);
		}
		
		@Test(priority = 6)
		
		public void ValidateNavigationToHomeScreen(){
			driver.findElement(By.xpath("//a[@id='navLogo']")).click();	
		}
		
		@Test(priority = 7)
		
		public void ValidateLogin(){
			driver.findElement(By.xpath("//a[@href='/sams/account/signin/login.jsp?xid=hdr_account_login']")).click();
		}	
		
		@Test(priority = 8)
		
		public void ValidateSignIn()
		{	
			driver.findElement(By.xpath("//input[@id='txtLoginEmailID']")).clear();  //Clear
			driver.findElement(By.xpath("//input[@id='txtLoginEmailID']")).sendKeys("testsavings20190614061101@gmail.com");
			driver.findElement(By.xpath("//input[@id='txtLoginPwd']")).sendKeys("test@123");
			driver.findElement(By.xpath("//button[@id='signInButton']")).click();
		}
		
		@Test(priority = 9)
		
		public void ValidateSearchResults(){		
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='Search']")));
			driver.findElement(By.xpath("//input[@id='Search']")).sendKeys("milk");
			driver.findElement(By.xpath("//input[@id='Search']")).sendKeys(Keys.ENTER);
		}

		@Test(priority = 10)
		
		public void MiniCartScreen(){	
	       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='product-overlay']")));
	       try
	       {
		   driver.findElement(By.xpath("//span[@class='sc-mini-cart-count']")).click();
	       }
	       catch(WebDriverException e)
	       {
		   driver.findElement(By.xpath("//a[@id='oo_no_thanks']")).click();
		   driver.findElement(By.xpath("//span[@class='sc-mini-cart-count']")).click();
	       }
		}
	
	@Test(priority = 11)
	
	     public void ValidateCartScreen(){
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='nc-biggreenbtn adjust_postion js-purchase-contract js-checkout-btn']")));
	        driver.findElement(By.xpath("//a[@class='nc-biggreenbtn adjust_postion js-purchase-contract js-checkout-btn']")).click();
	}
	
	@Test(priority = 12)
	
	public void ValidateCheckout(){
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@text='Place Order']"))); //Place Order on Checkout screen
	
		driver.findElement(By.xpath("//span[@text='Place Order']")).click();
	
	
	
	}
	
}
	


