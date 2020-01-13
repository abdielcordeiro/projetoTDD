package br.com.rsinet.HUB_TDD.teste;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsi.HUB_TDD.utility.Utils;
import br.com.rsi.HUB_TDD.utility.print;

public class testeBuscaSucesso {

	private WebDriver driver;
	private JavascriptExecutor scroll;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", "http://www.advantageonlineshopping.com/#/");
		scroll = (JavascriptExecutor) driver;
	}

	@Test
	public void executar() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("speakersImg")).click();

		driver.findElement(By.id("19")).click();

		WebElement element = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1"));

		String nomeProduto = element.getText();
		assertTrue("Produto encontrado com sucesso",nomeProduto.equals("HP S9500 BLUETOOTH WIRELESS SPEAKER"));
	}

	@After
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaClickSucesso");
		Utils.closeBrowser(driver);
	}

}
