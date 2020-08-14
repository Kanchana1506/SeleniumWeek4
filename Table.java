package week4.day1.assignment;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Table {

	public static void main(String[] args) {
	
		//set property
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		//open url
		driver.get("http://leafground.com/pages/table.html");
		driver.manage().window().maximize();
		
		//get count of number of columns
		int countcols=0;
		List<WebElement> cols = driver.findElementsByXPath("//table//tr/th");
				
		for (int i =1; i<=6;i++)
		{
			String name = driver.findElementByXPath("//table//tr//th["+i+"]").getText();
			if(name != "")
				countcols++;
		}
		System.out.println("get count of number of columns: " + countcols);
		
//get count of number of rows
		int rowcount=0;
		List<WebElement> row = driver.findElementsByXPath("//table//tr");
		
		for (int i=1; i<= 5; i++)
		{
			String name = driver.findElementByXPath("//table//tr["+i+"]").getText();
			if(name != "")
				rowcount++;
		}
		System.out.println("get count of number of rows: " + rowcount);
		
		//get the progress value of 'Learn to interact with elements'
		List<WebElement> prog = driver.findElementsByXPath("//table//tr/td");
		
		for (int i =3; i<=3; i++)
		{
			for(int j=2; j<=2;j++) {
				String name = driver.findElementByXPath("//table//tr["+i+"]//td["+j+"]").getText();
				System.out.println("get the progress value of 'Learn to interact with elements' is: " + name);
			}

		}
		
		//check the vital taask for the least compelted progress
		driver.findElementByXPath("(//input[@type='checkbox'])[3]").click();
		System.out.println("checkbox is checked");
	}

}
