package com.qait.automation.TaticBasicWithJavaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainTest {
	
	WebDriver driver;
	
	@Test
	public void basicTest() {
		
		driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.get("http://10.0.1.86/tatoc");
		jse.executeScript("document.getElementsByTagName('a')[0].click();");
		jse.executeScript("document.getElementsByClassName('greenbox')[0].click();");
		
		String color_box1 = (String)jse.executeScript("return document.getElementById('main').contentWindow.document."				
				+ "querySelector('#answer').getAttribute('class');");
		
		String color_box2 = (String)jse.executeScript("return document.getElementById('main').contentWindow.document."
				+ "getElementById('child').contentWindow.document.querySelector('#answer').getAttribute('class');");
		
		while(color_box1.equals(color_box2) != true) {
			jse.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[0].click()");
			
			color_box2 = (String)jse.executeScript("return document.getElementById('main').contentWindow.document"
					+ ".getElementById('child').contentWindow.document.querySelector('#answer').getAttribute('class');");
			
		}
		
		jse.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[1].click()");
		System.out.println(color_box2);
		
		jse.executeScript("document.getElementById('dragbox').setAttribute('style','position : relative ; left : 32px ; top : -59px');");
		jse.executeScript("document.getElementsByTagName('a')[0].click()");
	}
	
}
