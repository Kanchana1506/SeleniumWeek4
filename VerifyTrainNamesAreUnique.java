package week4.day1.classroom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyTrainNamesAreUnique {

	public static void main(String[] args) throws InterruptedException {
		
		//Set the system property and Launch the URL
		System.setProperty("webdriver.chrome.driver", "./drivers\\chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		
		Thread.sleep(2000);
		
		//maximize window
		driver.manage().window().maximize();
		
		//Click the 'sort on date' checkbox
		driver.findElementById("chkSelectDateOnly").click();
		
		//	clear the existing text from station text field
		driver.findElementById("txtStationFrom").clear();
		
		//type "ms"in the from station text field
		WebElement frmstat = driver.findElementById("txtStationFrom");
		frmstat.sendKeys("ms");
		
		//tab in the from station text field
		driver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
		
		//clear the existing text in the to station text field
		driver.findElementById("txtStationTo").clear();
		
		//type "mdu" in the to station text field
		WebElement tostat = driver.findElementById("txtStationTo");
		tostat.sendKeys("mdu");
		
		//tab in the to station text field
		driver.findElementById("txtStationTo").sendKeys(Keys.TAB);
		
		//Add a java sleep for 2 seconds
		Thread.sleep(3000);
		
		//Store all the train names in a list
		List<WebElement> tname = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr");
		
		//Get the size of list
		int listsize = tname.size();
		System.out.println("size of list is: " + listsize);

		
		//Add the list into a new Set
		Set<String> values = new LinkedHashSet<String>();
		for (String eachval : values) {
		values.add(eachval);}
	
		//	Get the size of set
		int setsize = values.size();
		System.out.println("size of set is: " + setsize);
	
		//need to copy data  from set to list so that the method get  can be used
		List<String> copyset = new ArrayList<String>(setsize);
		for (String eachval : copyset) {
			copyset.add(eachval);
		}

	
		//Compare the Size of list and Set to verify the names are unique
		if (listsize == setsize)
			System.out.println("names are unique");
		else
			System.out.println("names are  not unique");

}

}
