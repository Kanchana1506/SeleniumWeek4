package week4.day1.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {

		//set property
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		
		
		ChromeDriver driver = new ChromeDriver();
		
		//open url
		driver.get("https://jqueryui.com/sortable/");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,250)");
		
		//frame java
		driver.switchTo().frame(0);
		
		//first element to position 4
		// 2 3 4 1 5 6 7 order
		
		WebElement start = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		WebElement end = driver.findElementByXPath("//ul[@id='sortable']/li[4]");
	
		Point loc = driver.findElementByXPath("//ul[@id='sortable']/li[4]").getLocation();
		int x=loc.getX();
		int y = loc.getY();
				
		Actions builder= new Actions(driver);
		builder.dragAndDropBy(start, x, y).perform();

		System.out.println("end");
	}

}
