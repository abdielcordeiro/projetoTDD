package br.com.rsinet.HUB_TDD.teste;

import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeBuscarLupaFalha {

	private WebDriver driver;
	private JavascriptExecutor scroll;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", "http://www.advantageonlineshopping.com/#/");
		scroll = (JavascriptExecutor) driver;
	}

	@Test
	public void buscar() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("menuSearch")).click();

		driver.findElement(By.id("autoComplete")).sendKeys("Sabonete" + Keys.ENTER);

		String resposta = driver.findElement(By.xpath("/html/body/div[3]/section/article/div[3]/div/label/span")).getText();
		System.out.println(resposta);
		assertFalse("Produto não encontrado", resposta.equals("No results for \"Sabonete\""));

	}

	@After
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaLupaFalha");
		Utils.closeBrowser(driver);
	}
}
