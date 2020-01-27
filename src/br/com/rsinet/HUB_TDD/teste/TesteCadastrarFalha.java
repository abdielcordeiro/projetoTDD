package br.com.rsinet.HUB_TDD.teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.extendReport.ExtendReport;
import br.com.rsinet.HUB_TDD.pageFactory.Cadastrar_Page;
import br.com.rsinet.HUB_TDD.pageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.DriverFactory;
import br.com.rsinet.HUB_TDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.MassaDados;

public class TesteCadastrarFalha {

	private WebDriver driver;
	private Home_Page home;
	private Cadastrar_Page cadastrar;
	private ExtentTest test;
	private MassaDados dados;

	@BeforeMethod
	public void carregar() throws Exception {

		/* Metodo que inicia o navegador e passa a URL */
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);

		/*
		 * Metodo que instancia a o local e a planilha que seram utilizadas junto com a
		 * aba da planilha
		 */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		home = PageFactory.initElements(driver, Home_Page.class);
		cadastrar = PageFactory.initElements(driver, Cadastrar_Page.class);

		home.executaHomeCadastro(driver);
		dados = new MassaDados();
		ExtendReport.setExtent();
	}

	@Test
	public void cadastrarFalha() throws Exception {
		/* Criando o report e dando um nome */
		test = ExtendReport.createTest("CadastroFalha");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/* Metodo que inseri nos campos os valores retornados da planilha de excel */
		cadastrar.preencherCadastro(dados.getUserNameFalha(), dados.getPassword(), dados.getEmail(),
				dados.getPhoneNumber(), dados.getFristName(), dados.getLastName(), dados.getCountry(),
				dados.getPostalCode(), dados.getCity(), dados.getState(), dados.getAddress());

		cadastrar.clicaBtnRegistrar();

		/*
		 * Método que valida se o cadsatro falhou por questão do nome de usuário tem
		 * mais que 15 caracteres
		 */
		Assert.assertTrue(cadastrar.respostaCadastro().equals("Use maximum 15 character"),
				"Login de acesso invalido, mais caracteres do que o permitido");

	}

	@AfterMethod
	public void encerrar(ITestResult result) throws Exception {

		ExtendReport.tearDown(result, test, driver);
		ExtendReport.endReport();

		/* Metodo que rola a tela para cima para poder printar a tela */
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scrollBy(0, -500)", "");


		DriverFactory.closeBrowser(driver);

	}

}
