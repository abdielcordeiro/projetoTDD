package br.com.rsinet.HUB_TDD.teste;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeBuscarLupaSucesso {

	private WebDriver driver;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", "http://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void buscar() throws Exception {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("menuSearch")).click();

		driver.findElement(By.id("autoComplete")).sendKeys("Mice" + Keys.ENTER);

		driver.findElement(By.id("31")).click();


		String nomeProduto = driver.findElement(By.xpath("//*[@id=\"Description\"]/h1")).getText();
		System.out.println(nomeProduto);
		assertTrue("Produto encontrado com sucesso", nomeProduto.equals("LOGITECH G502 PROTEUS CORE"));

	}

	@After
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaLupaSucesso");
		Utils.closeBrowser(driver);
	}
}
