package org.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	
	private DriverFactory(){
		//Do not allow to initialize this class from outside
	}

	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance(){
		return instance;
	}
	
	//thread local driver object for WebDriver
	ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	//call this method to get the driver object and launch the browser
	public RemoteWebDriver getDriver(){
		return driver.get();
	}
	
	public void setDriver(RemoteWebDriver driverParam){
		driver.set(driverParam);		
	}
	
	public void removeDriver(){
		driver.get().quit();
		driver.remove();
		
	}
	
}
