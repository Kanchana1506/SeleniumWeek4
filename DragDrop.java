package week4.day1.assignment;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {

	public static void main(String[] args) throws InterruptedException {

		//set property
				System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
				
				ChromeDriver driver = new ChromeDriver();
				
				//open url
				driver.get("https://jqueryui.com/droppable/");
				driver.manage().window().maximize();
				
				
				//frame
				driver.switchTo().frame(0);
				
				
				
				//source
				WebElement from = driver.findElementById("draggable");
				
				//target
				WebElement to = driver.findElementById("droppable");
				
				//drag drop
				Actions builder = new Actions(driver);
				builder.dragAndDrop(from, to).perform();
				
				/*
				 * ANOTHER METHOD
				Point to = driver.findElementById("droppable").getLocation();
				int x= to.getX();
				int y = to.getY();
						
				Actions builder = new Actions(driver);
				builder.dragAndDropBy(from, x, y).perform();*/
	}

}
