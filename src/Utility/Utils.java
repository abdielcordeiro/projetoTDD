package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

	public static WebDriver driver;

	public static WebDriver openBrowser(String nomeNavegador) {

		if(nomeNavegador.equals("Firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}else if (nomeNavegador.equals("Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;

	}

	public static void openURL(String url) {
		driver.get(url);
	}

}