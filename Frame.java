package week4.day1.classroom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frame {

	public static void main(String[] args) throws InterruptedException {
		
		//set property
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		//open url
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		//to get into the frame
		driver.switchTo().frame(0);
		
		//select all odd items
		WebElement item1 = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		WebElement item3 = driver.findElementByXPath("//ol[@id='selectable']/li[3]");
		WebElement item5 = driver.findElementByXPath("//ol[@id='selectable']/li[5]");
		WebElement item7 = driver.findElementByXPath("//ol[@id='selectable']/li[7]");
		
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1).click(item3).click(item5).click(item7).keyUp(Keys.CONTROL).perform();

	}

}
