package week4.day1.assignment;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementAppear {

	public static void main(String[] args) {

		//set property
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
			
		//open url
		driver.get("http://leafground.com/pages/appear.html");
		driver.manage().window().maximize();
				
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("btn")));
		System.out.println("Text in button is: " + driver.findElementById("btn").getText());



	}

}
