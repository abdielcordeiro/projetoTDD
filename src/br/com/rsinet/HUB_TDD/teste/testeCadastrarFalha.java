package br.com.rsinet.HUB_TDD.teste;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsi.HUB_TDD.utility.Utils;
import br.com.rsi.HUB_TDD.utility.print;

public class testeCadastrarFalha {

	private WebDriver driver;
	private JavascriptExecutor scroll;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", "http://www.advantageonlineshopping.com/#/");
		scroll = (JavascriptExecutor) driver;
		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement bntLogar = wait.until(ExpectedConditions.elementToBeClickable(By.id("hrefUserIcon")));
		bntLogar.click();
		// driver.findElement(By.id("hrefUserIcon")).click();

		WebElement bntCadastrar = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		bntCadastrar.click();
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")).sendKeys(Keys.ENTER);

	}

	@Test
	public void cadastrar() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		// Preencher os detalhes da conta
		driver.findElement(By.name("usernameRegisterPage")).sendKeys("abdielAAAAordeiro");

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

		WebElement labelMensagem = driver
				.findElement(By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[1]/div/label"));
		String mensagem = labelMensagem.getText();
		System.out.println("Teste mensagem: " + mensagem);
		Assert.assertFalse("Login de acesso invalido, mais caracteres do que o permitido", mensagem.equals("Use maximum 15 character"));

	}

	@After
	public void encerrar() throws Exception {
		print.takeSnapShot("testeCadastroFalha");
		Utils.closeBrowser(driver);
	}

}
