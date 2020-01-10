package br.com.rsi.HUB_TDD.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
	}

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C://Users//abdiel.cordeiro//Pictures//";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem + ".png"));

	}


}
