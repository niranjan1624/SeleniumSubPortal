package com.assignment.tester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	 
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      testUpload(driver, "CourseManagement", "C:\\Users\\Vedavyas\\Desktop\\CourseManagementTest_Structure.zip");
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      testUpload( driver, "CourseManagement", "C:\\Users\\Vedavyas\\Desktop\\test.zip");
	}

public static void testUpload( WebDriver driver, String assignmentName, String fileLoc) {
	driver.navigate().to("http://ec2-52-74-113-241.ap-southeast-1.compute.amazonaws.com:8080/Assignment_Portal/AssignmentTest.jsp");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    
    System.out.println(driver.getCurrentUrl());
    driver.navigate().refresh();
	Select select = new Select(driver.findElement(By.xpath(".//*[@id='assignmentselection']")));
	   System.out.println(select);
	   select.selectByVisibleText(assignmentName);
	   driver.findElement(By.xpath(".//*[@id='file-0a']")).sendKeys(fileLoc);
	   driver.findElement(By.xpath(" .//*[@id='modalform']/fieldset/div/span/div[3]/div[2]/button[3]")).click();
	   System.out.println(driver.getCurrentUrl());
	   System.out.println(driver.findElement(By.xpath(" html/body")).getText());
	   System.out.println("----------------------------");
	  // driver.close();
}
public void manipulatePopUp(final WebDriver driver, final WebDriverWait wait) {
	final String mainWindowHandle = driver.getWindowHandle();
	driver.findElement(By.id("linkThatOpensPopUp")).click();
	
	  

	
	for (String activeHandle : driver.getWindowHandles()) {
		if (!activeHandle.equals(mainWindowHandle)) {
			driver.switchTo().window(activeHandle);
		}
	}

	driver.close();
	driver.switchTo().window(mainWindowHandle);
}
	
}


// BACKUP


//Launch website
/*    driver.navigate().to("http://ec2-52-74-113-241.ap-southeast-1.compute.amazonaws.com:8080/Assignment_Portal/AssignmentTest.jsp");
String mainWindow = driver.getWindowHandle();*/
/*    //Maximize the browser
driver.manage().window().maximize();

driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

String mainWindow = driver.getWindowHandle();

driver.findElement(By.xpath(".//*[@id='customBtn']/input")).click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

for (String activeHandle : driver.getWindowHandles()) {
	System.out.println("Active Handle: "+activeHandle.toString());
	if (!activeHandle.equals(mainWindow)) {
		driver.switchTo().window(activeHandle);
	}
	
	if(activeHandle.equals(mainWindow)){
		System.out.println("Eureka !!!");
	}
}

driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("npuli9753@gmail.com");;

driver.findElement(By.xpath(".//*[@id='next']")).click();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("niranjandarling123");

driver.findElement(By.xpath(".//*[@id='signIn']")).click();
*/  
/*WebDriverWait wait = new WebDriverWait(driver,15);
System.out.println("waiting 10 seconds....");
driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
try {
	  System.out.println("waiting 10 seconds....");
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='submit_approve_access']")));
	element.click(); 
	System.out.println("After 10 seconds...." + element);
	
} catch(NoSuchElementException e) {
	  e.printStackTrace();
} catch(TimeoutException e) {
	  e.printStackTrace();
}*/


/*     System.out.println(driver.getTitle());
 Select select = new Select(driver.findElement(By.xpath(".//*[@id='assignmentselection']")));
 System.out.println(select);
 select.selectByVisibleText("CourseManagement");
 System.out.println(select.getOptions());
 
 driver.findElement(By.xpath(".//*[@id='file-0a']")).sendKeys("C:\\Users\\Vedavyas\\Desktop\\CourseManagementTest_Structure.zip");

 driver.findElement(By.xpath(" .//*[@id='modalform']/fieldset/div/span/div[3]/div[2]/button[3]")).click();
 
 System.out.println(driver.getCurrentUrl());
 System.out.println(driver.findElement(By.xpath(" html/body")).getText());
 System.out.println("----------------------------");*/
// driver.close();