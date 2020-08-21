package week4.day1.assignment;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextChange {

	public static void main(String[] args) throws InterruptedException {
		
		//set property
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		//open url
		driver.get("http://leafground.com/pages/TextChange.html");
		driver.manage().window().maximize();
	
		System.out.println("initial value in button: " + driver.findElementByXPath("//button[@id='btn']").getText());
	
//		Thread.sleep(2000);
		
		//wait until button text changes to click me
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[text()='Click ME!']")));
		
				
		//once u clicked alert appears with text click me .. verify that 
		driver.findElementByXPath("//button[@id='btn']").click();
		System.out.println("button is clicked");
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println("text in alet is: " + alert1.getText().toString());
		
		//alert1.accept();
		alert1.accept();
	}
}
