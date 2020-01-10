package br.com.rsinet.HUB_TDD.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.HUB_TDD.utility.Utils;
import br.com.rsi.HUB_TDD.utility.print;

public class testeBuscarLupaSucesso {

	private WebDriver driver;
	private JavascriptExecutor scroll;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", "http://www.advantageonlineshopping.com/#/");
		scroll = (JavascriptExecutor) driver;
	}

	@Test
	public void buscar() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement bntBuscar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"search\"]/a")));
		bntBuscar.click();

		driver.findElement(By.xpath("//*[@id=\"search\"]/a")).click();

		WebElement bntPreencher = wait.until(ExpectedConditions.elementToBeClickable(By.id("autoComplete")));
		bntPreencher.sendKeys("HP chromebook" + Keys.ENTER);

		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/img")).click();
		WebElement  produto = wait.until(ExpectedConditions.elementToBeClickable(By.id("10")));
		produto.click();


	}

	@After
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaLupa");
		Utils.closeBrowser(driver);
	}
}
