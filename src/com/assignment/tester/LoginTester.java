package com.assignment.tester;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 WebDriver driver = new FirefoxDriver();
	      //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
	 
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	          driver.navigate().to("http://ec2-52-74-113-241.ap-southeast-1.compute.amazonaws.com:8080/Assignment_Portal/index.jsp");
	         //Maximize the browser
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

	      driver.findElement(By.xpath(".//*[@id='Email']")).sendKeys("EMAIL@gmail.com");;

	      driver.findElement(By.xpath(".//*[@id='next']")).click();

	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	      driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("PASSWORD");

	      driver.findElement(By.xpath(".//*[@id='signIn']")).click();
	      
	      System.out.println(driver.getCurrentUrl());
	    //  System.out.println(getPreviousSessionIdFromSomeStorage());
	      driver.close();
	   System.out.println("-------------------------------------");
	    String[] sfs = {"",""};
	    AssignmentTester.main(sfs);
	}

}
