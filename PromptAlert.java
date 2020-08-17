package week4.day2.classroom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class PromptAlert {

	public static void main(String[] args) throws InterruptedException {

		//set property
		System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
	
		//open url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		
		Thread.sleep(4000);

		driver.switchTo().frame(driver.findElementById("iframeResult"));


		//click on try it button
		driver.findElementByXPath("//button[text()='Try it']").click();
	
		//enter your name in the alert
		Alert alert1= driver.switchTo().alert();
		alert1.sendKeys("Kanchana");
		
		
		//accept alert
		alert1.accept();
		
		//read the text under try it button and verify it contains your name
		String text = driver.findElementByXPath("//p[@id='demo']").getText();
		System.out.println(text);
		
	}

}
