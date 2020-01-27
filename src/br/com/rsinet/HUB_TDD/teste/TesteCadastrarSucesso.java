package br.com.rsinet.HUB_TDD.teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class TesteCadastrarSucesso {

	private WebDriver driver;
	private Cadastrar_Page cadastrar;
	private Home_Page home;
	private ExtentTest test;
	private MassaDados dados;

	@BeforeMethod
	public void carregarSucesso() throws Exception {

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
	public void cadastrar() throws Exception {

		/* Criando o report e dando um nome */
		test = ExtendReport.createTest("CadastroSucesso");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/* Metodo que inseri nos campos os valores retornados da planilha de excel */
		cadastrar.preencherCadastro(dados.getUserName(), dados.getPassword(), dados.getEmail(), dados.getPhoneNumber(),
				dados.getFristName(), dados.getLastName(), dados.getCountry(), dados.getPostalCode(), dados.getCity(),
				dados.getState(), dados.getAddress());

		cadastrar.clicaBtnRegistrar();


		/* Método para espera a pagina carregar para buscar a URL */
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlToBe("http://www.advantageonlineshopping.com/#/"));

		/* Método que valida se a URL que busquei da página é a mesma da HOMEs*/
		Assert.assertTrue(driver.getCurrentUrl().equals("http://www.advantageonlineshopping.com/#/"),
				"Usuário cadastrado com sucesso!!");
	}

	@AfterMethod
	public void encerrar(ITestResult result) throws Exception {

		/* Método que faz esperar a página carregar para poder printar*/
		home.esperaHome(driver);
		ExtendReport.tearDown(result, test, driver);
		ExtendReport.endReport();
		DriverFactory.closeBrowser(driver);

	}

}
