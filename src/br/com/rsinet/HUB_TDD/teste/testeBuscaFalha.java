package br.com.rsinet.HUB_TDD.teste;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeBuscaFalha {

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

		WebElement produto = driver
				.findElement(By.xpath("//*[@id=\"productProperties\"]/div[2]/e-sec-plus-minus/div/div[3]"));

		for (int i = 0; i < 19; i++) {
			produto.click();
		}

		driver.findElement(By.name("save_to_cart")).click();

		driver.findElement(By.id("menuCart")).click();

		WebElement quantidade = driver.findElement(By.xpath("//*[@id=\"shoppingCart\"]/table/tbody/tr/td[4]/label[2]"));

		int testaQuantidade = Integer.parseInt(quantidade.getText());
		assertEquals("Quantidade Cadastrada diferente da pedida", testaQuantidade, 20);
	}

	@After
	public void finalizar() throws Exception {
		 print.takeSnapShot("testeBuscaClickSucesso");
		 Utils.closeBrowser(driver);
	}

}
