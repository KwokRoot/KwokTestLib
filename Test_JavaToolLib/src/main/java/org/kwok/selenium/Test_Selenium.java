package org.kwok.selenium;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test_Selenium {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Kwok\\Work\\Other\\chromedriver.exe");
		
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://www.baidu.com/");
	    
	    Thread.sleep(5000);
	    driver.quit();
	    
	}

}
