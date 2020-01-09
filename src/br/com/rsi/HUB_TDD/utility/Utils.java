package br.com.rsi.HUB_TDD.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {
	public static WebDriver driver;

	public static WebDriver openBrowser(String navegador, String url) throws Exception {

		if (navegador.equals("Firefox")) {

			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;

		} else if (navegador.equals("Chrome")) {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;
		}
		return null;

	}

	public static void closeBrowser(WebDriver driver) {
		driver.close();
		driver.quit();
	}


}
