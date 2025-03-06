package testcases;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HomePageTest {
	WebDriver driver;
  
  @BeforeTest
  public void beforeTest() {
// 	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
 	  driver = new ChromeDriver();
	
	  driver.get("http://localhost:8080/PetStoreWebApp/");
		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
  }
                      
  @Test
  public void test01_titleTest() {
	  String pageTitle = driver.getTitle();
	  System.out.println(pageTitle);
	  Assert.assertEquals(pageTitle, "3 Pet Store");
	 
  }
//  @Test
  public void test02_contentTest() {
	  WebElement typeDropdown = driver.findElement(By.name("Type"));
	  Select petType = new Select(typeDropdown);
	  petType.selectByVisibleText("CAT");
	  driver.findElement(By.xpath("//input[@type='submit']")).click();
  }

  @AfterTest
  public void afterTest() {
//	  driver.close();
  }

}
