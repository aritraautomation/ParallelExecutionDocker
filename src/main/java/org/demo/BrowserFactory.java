package org.demo;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static RemoteWebDriver createInstance(String browser)
	{
		RemoteWebDriver driver = null;
		DesiredCapabilities cap =new DesiredCapabilities();
		String hubURL = "http://172.21.236.81:4446/wd/hub";
		
		try {
			if(browser.equalsIgnoreCase("chrome")){
				
				   /*cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
					cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);*/
					cap.setBrowserName("chrome");
					cap.setPlatform(Platform.LINUX);
					
					ChromeOptions options = new ChromeOptions();
					options.merge(cap);
									
					driver = new RemoteWebDriver(new URL(hubURL),options);	
			}
			else if(browser.equalsIgnoreCase("firefox")){
				
				cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
				cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
				
				driver = new RemoteWebDriver(new URL(hubURL),cap);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
		return driver;
	}
}
