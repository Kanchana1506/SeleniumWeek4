package week4.day2.assignment;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {

		//MergeLead: Application : http://leaftaps.com/opentaps/control/main
		//==========
		
		//1. Launch the browser
		System.setProperty("webdriver.chrome.driver","./drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
	
		//2. Enter the username
		WebElement usrname = driver.findElementById("username");
		usrname.sendKeys("demosalesmanager");


		//3. Enter the password
		WebElement pwd = driver.findElementById("password");
		pwd.sendKeys("crmsfa");

		//4. Click Login
		 WebElement submit = driver.findElementByClassName("decorativeSubmit");
		submit.click();

		//5. Click crm/sfa link
		WebElement crmlink = driver.findElementByLinkText("CRM/SFA");
		crmlink.click();

		//6. Click Leads link
		WebElement leads = driver.findElementByLinkText("Leads");
		leads.click();

		//7. Click Merge leads
		driver.findElementByXPath("//div[@id=\"left-content-column\"]/div/div[2]/ul/li[4]").click();

		//8. Click on Icon near From Lead
		driver.findElementByXPath("//img[@alt='Lookup']").click();
		
		//9. Move to new window
		Set<String> fromlead = driver.getWindowHandles();
		List <String> list1= new ArrayList<String> (fromlead);
		String secwin1 = list1.get(1);
		driver.switchTo().window(secwin1);
		
		//10. Enter Lead ID
		driver.findElementByXPath("//div[@class='x-form-element']/input[1]").sendKeys("11082");
				
		//11. Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		
		//12. Click First Resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
			
		//13. Switch back to primary window
		driver.switchTo().window(list1.get(0));
		
		//save the from lead  value
		String flead = driver.findElementByXPath("//input[@name='ComboBox_partyIdFrom']").getAttribute("value");
		
		//14. Click on Icon near To Lead
		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		
		
		//15. Move to new window
		Set<String> tolead = driver.getWindowHandles();
		List <String> list2= new ArrayList<String> (tolead);
		String secwin2 = list2.get(1);
		driver.switchTo().window(secwin2);
		
		//16. Enter Lead ID
		driver.findElementByXPath("//div[@class='x-form-element']/input").sendKeys("11083");
		
		//17. Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		Thread.sleep(2000);
		
		//18. Click First Resulting lead
		driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a").click();
		
		//19. Switch back to primary window
		driver.switchTo().window(list1.get(0));
		
		//20. Click Merge
		driver.findElementByXPath("//a[text()='Merge']").click();
		
		//21. Accept Alert
		driver.switchTo().alert().accept();
		
		//22. Click Find Leads link
		driver.findElementByXPath("//a[text()='Find Leads']").click();
		
		//23. Enter From Lead ID
		driver.findElementByXPath("//input[@name='id']").sendKeys(flead);
		
		
		//24. Click Find Leads button
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		
		
		Thread.sleep(2000);
		//25. Verify message "No records to display" in the Lead List. This message confirms that the successful merge of leads
		
		
		//WebElement msg = driver.findElementByXPath("//div[text()='No records to display']");
		String noRecordsTo = driver.findElementByXPath("//div[@class='x-toolbar x-small-editor']//div[1]").getText();
		
		
		//String bb = msg.getText();
		System.out.println(noRecordsTo);
		
		if(noRecordsTo.contains("No records to display"))
			System.out.println("successful merge of leads");
		else
			System.out.println("unsuccessful merge of leads");
		
		//26. Close the browser (Do not log out)
		driver.close();


	}

}
