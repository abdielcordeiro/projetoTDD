package br.com.rsinet.HUB_TDD.teste;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.HUB_TDD.module.modulo_Home;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeCadastrarSucesso {

	private WebDriver driver;
	private JavascriptExecutor scroll;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", "http://www.advantageonlineshopping.com/#/");
		scroll = (JavascriptExecutor) driver;

		modulo_Home.executa(driver);
	}

	@Test
	public void cadastrar() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Preencher os detalhes da conta
		driver.findElement(By.name("usernameRegisterPage")).sendKeys("ASDDOrDEirO");

		driver.findElement(By.name("emailRegisterPage")).sendKeys("teste@rsinet.com.br");

		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Trocar@123");

		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Trocar@123");

		// Preencher os dados Pessoais
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Abdiel");

		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Cordeiro");

		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11987672784");

		// Preencher os dados de endereço
		scroll.executeScript("scrollBy(0,400)", "");
		WebElement pais = driver.findElement(By.name("countryListboxRegisterPage"));
		pais.click();
		Select comboBoxPais = new Select(pais);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		comboBoxPais.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Osasco");

		driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua Antonio Bertoldo de Oliveira");

		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("São Paulo");

		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("06290060");

		driver.findElement(By.name("i_agree")).click();

		// Botão de confirmar
		driver.findElement(By.id("register_btnundefined")).click();

	}

	@After
	public void encerrar() throws Exception {
		print.takeSnapShot("testeComSucesso");
		Utils.closeBrowser(driver);
	}

}
