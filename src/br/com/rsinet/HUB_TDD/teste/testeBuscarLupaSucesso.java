package br.com.rsinet.HUB_TDD.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsi.HUB_TDD.utility.Utils;

public class testeBuscarLupaSucesso {

	private WebDriver driver;
	private JavascriptExecutor scroll;


	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Firefox", "http://www.advantageonlineshopping.com/#/");
		scroll = (JavascriptExecutor) driver;
	}

	@Test
	public void buscar() throws Exception {

		Thread.sleep(1000);
		WebElement bntBuscar = driver.findElement(By.xpath("//*[@id=\"search\"]/a"));
		bntBuscar.click();

		Thread.sleep(2000);
		driver.findElement(By.id("autoComplete")).sendKeys("HP chromebook");
		bntBuscar.click();
	}

	@After
	public void finalizar() {
		Utils.closeBrowser(driver);
	}
}
