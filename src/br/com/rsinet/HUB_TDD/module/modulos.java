package br.com.rsinet.HUB_TDD.module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.pageFactory.BuscarLupa_Page;
import br.com.rsinet.HUB_TDD.pageFactory.Cadastrar_Page;
import br.com.rsinet.HUB_TDD.pageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;

public class modulos {

	public static String executaCadastro(WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PageFactory.initElements(driver, Cadastrar_Page.class);

		String userName = ExcelUtils.getCellData(1, Constant.userName);
		Cadastrar_Page.input_userName.sendKeys(userName);

		String password = ExcelUtils.getCellData(1, Constant.userPass);
		Cadastrar_Page.input_senha.sendKeys(password);
		Cadastrar_Page.input_confirmaSenha.sendKeys(password);

		String userEmail = ExcelUtils.getCellData(1, Constant.email);
		Cadastrar_Page.input_email.sendKeys(userEmail);

		String phoneNumber = ExcelUtils.getCellData(1, Constant.phoneNumber);
		Cadastrar_Page.input_phoneNumber.sendKeys(phoneNumber);

		String fristName = ExcelUtils.getCellData(1, Constant.FristName);
		Cadastrar_Page.input_fristName.sendKeys(fristName);

		String lastName = ExcelUtils.getCellData(1, Constant.LastName);
		Cadastrar_Page.input_lastName.sendKeys(lastName);

		// Preencher os dados de endereço
		WebElement pais = driver.findElement(By.name("countryListboxRegisterPage"));
		pais.click();
		Select comboBoxPais = new Select(pais);
		comboBoxPais.selectByVisibleText("Brazil");

		String cep = ExcelUtils.getCellData(1, Constant.CEP);
		Cadastrar_Page.input_cep.sendKeys(cep);

		String city = ExcelUtils.getCellData(1, Constant.City);
		Cadastrar_Page.input_city.sendKeys(city);

		String state = ExcelUtils.getCellData(1, Constant.State);
		Cadastrar_Page.input_state.sendKeys(state);

		String address = ExcelUtils.getCellData(1, Constant.address);
		Cadastrar_Page.input_address.sendKeys(address);

		Cadastrar_Page.bnt_concordar.click();
		Cadastrar_Page.bnt_registrar.click();

		Thread.sleep(1000);
		String resposta = driver.getCurrentUrl();

		return resposta;
	}

	public static String executaCadastroErro(WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PageFactory.initElements(driver, Cadastrar_Page.class);

		String userName = ExcelUtils.getCellData(1, Constant.userName);
		Cadastrar_Page.input_userName.sendKeys(userName);

		String password = ExcelUtils.getCellData(1, Constant.userPass);
		Cadastrar_Page.input_senha.sendKeys(password);
		Cadastrar_Page.input_confirmaSenha.sendKeys(password);

		String userEmail = ExcelUtils.getCellData(1, Constant.email);
		Cadastrar_Page.input_email.sendKeys(userEmail);

		String phoneNumber = ExcelUtils.getCellData(1, Constant.phoneNumber);
		Cadastrar_Page.input_phoneNumber.sendKeys(phoneNumber);

		String fristName = ExcelUtils.getCellData(1, Constant.FristName);
		Cadastrar_Page.input_fristName.sendKeys(fristName);

		String lastName = ExcelUtils.getCellData(1, Constant.LastName);
		Cadastrar_Page.input_lastName.sendKeys(lastName);

		// Preencher os dados de endereço
		WebElement pais = driver.findElement(By.name("countryListboxRegisterPage"));
		pais.click();
		Select comboBoxPais = new Select(pais);
		comboBoxPais.selectByVisibleText("Brazil");

		String cep = ExcelUtils.getCellData(1, Constant.CEP);
		Cadastrar_Page.input_cep.sendKeys(cep);

		String city = ExcelUtils.getCellData(1, Constant.City);
		Cadastrar_Page.input_city.sendKeys(city);

		String state = ExcelUtils.getCellData(1, Constant.State);
		Cadastrar_Page.input_state.sendKeys(state);

		String address = ExcelUtils.getCellData(1, Constant.address);
		Cadastrar_Page.input_address.sendKeys(address);

		Cadastrar_Page.bnt_concordar.click();
		Cadastrar_Page.bnt_registrar.click();

		return Cadastrar_Page.resposta.getText();
	}

	public static void executaHomeCadastro(WebDriver driver) {
		PageFactory.initElements(driver, Home_Page.class);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement bntLogar = wait.until(ExpectedConditions.elementToBeClickable(Home_Page.bnt_Login));
		bntLogar.click();

		WebElement bntCadastrar = wait.until(ExpectedConditions.elementToBeClickable(Home_Page.bnt_Cadastrar));
		bntCadastrar.sendKeys(Keys.ENTER);

	}

	public static String executaPesquisa(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement bntBuscar = wait.until(ExpectedConditions.elementToBeClickable(BuscarLupa_Page.bnt_lupa));
		bntBuscar.click();

		String produto = ExcelUtils.getCellData(1, Constant.Produto);
		BuscarLupa_Page.input_buscar.sendKeys(produto + Keys.ENTER);

		Thread.sleep(2000);
		BuscarLupa_Page.bnt_X.click();

		BuscarLupa_Page.bnt_clicarProduto.click();

		return BuscarLupa_Page.label_resposta.getText();
	}

	public static String executaPesquisaErro(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement bntBuscar = wait.until(ExpectedConditions.elementToBeClickable(BuscarLupa_Page.bnt_lupa));
		bntBuscar.click();

		String produto = ExcelUtils.getCellData(1, Constant.Produto);
		BuscarLupa_Page.input_buscar.sendKeys(produto + Keys.ENTER);

		return BuscarLupa_Page.label_resposta.getText();
	}

	public static String executaPesquisaClick(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		BuscarLupa_Page.bnt_categoria.click();
		BuscarLupa_Page.bnt_clicarProduto.click();

		return BuscarLupa_Page.label_nomeProduto.getText();
	}

	public static int executaPesquisaClickErro(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BuscarLupa_Page.bnt_categoria.click();
		BuscarLupa_Page.bnt_clicarProduto.click();

		for (int i = 0; i < 19; i++) {
			BuscarLupa_Page.bnt_addProduto.click();
		}

		BuscarLupa_Page.bnt_salvarCarrinho.click();
		BuscarLupa_Page.bnt_entrarCarrinho.click();

		int testaQuantidade = Integer.parseInt(BuscarLupa_Page.label_quantidade.getText());

		return testaQuantidade;
	}

}