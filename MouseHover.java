package week4.day1.classroom;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {

		//set property
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		//open url
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		//mouse hover on mens fashion
		WebElement menfash = driver.findElementByXPath("//div[@id='leftNavMenuRevamp']/div[1]/div[2]/ul[1]/li[7]/a[1]/span[1]");
		
		Actions builder1 = new Actions(driver);
		builder1.moveToElement(menfash).perform();
		
		//click shirts
		driver.findElementByXPath("//div[@id='category6Data']/div[2]/div/div/p[4]").click();
		
		//mouse hover on first product
		WebElement frstprod = driver.findElementByXPath("//img[@class='product-image ']");
				
		Actions builder2 = new Actions(driver);
		builder2.moveToElement(frstprod).perform();
		
		//click on quick views
		driver.findElementByXPath("//div[@class='clearfix row-disc']").click();
		
		//close all the browsers
		driver.close();
	}

}
