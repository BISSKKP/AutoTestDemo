package com.test.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Learn {

	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
//		WebDriver driver=new FirefoxDriver();
		WebDriver driver=new ChromeDriver();
		
		driver.navigate().to("https://www.baidu.com");
		
	System.out.println(driver.getPageSource());
		
	WebElement searchInput=driver.findElement(By.id("kw"));
	System.out.println(searchInput.getAttribute("name"));
	
	searchInput.sendKeys("selecnium");
	
	WebElement submit=driver.findElement(By.id("su"));
	submit.click();
	
		//WebElement loginLink=driver.findElement(By.partialLinkText("登"));
		
		//loginLink.click();
		
		//
		//WebElement button=driver.findElement(By.id("/html/body/div/input[@value='查询']"));
		
		//结束
		//driver.close();
		
	}
}
