package br.com.rsinet.hub.tdd.Teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.tdd.ExtendReport.ExtendReport;
import br.com.rsinet.hub.tdd.PageFactory.Cadastrar_Page;
import br.com.rsinet.hub.tdd.PageFactory.Home_Page;
import br.com.rsinet.hub.tdd.Utilidades.Constant;
import br.com.rsinet.hub.tdd.Utilidades.DriverFactory;
import br.com.rsinet.hub.tdd.Utilidades.DriverFactory.DriverType;
import br.com.rsinet.hub.tdd.Utilidades.ExcelUtils;
import br.com.rsinet.hub.tdd.Utilidades.MassaDados;

public class TesteCadastrar {

	private WebDriver driver;
	private Cadastrar_Page cadastrar;
	private Home_Page home;
	private ExtentTest test;
	private MassaDados dados;

	@BeforeTest
	public void report() {
		ExtendReport.setExtent();
	}

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
	}

	@Test
	public void cadastrarSucesso() throws Exception {

		/* Criando o report e dando um nome */
		test = ExtendReport.createTest("CadastroSucesso");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/* Metodo que inseri nos campos os valores retornados da planilha de excel */
		cadastrar.preencherNomeUsuario(dados.getNomeUsuario(6));
		cadastrar.preencherSenha(dados.getSenha());
		cadastrar.preencherConfirmaSenha(dados.getSenha());
		cadastrar.preencherEmail(dados.getEmail());
		cadastrar.preencherTelefone(dados.getTelefone());
		cadastrar.preencherPrimeiroNome(dados.getPrimeiroNome());
		cadastrar.preencherUltimoNome(dados.getUltimoNome());
		cadastrar.preencherPais(dados.getPais());
		cadastrar.preencherCodigoPostal(dados.getPostalCode());
		cadastrar.preencherCidade(dados.getCidade());
		cadastrar.preencherEstado(dados.getEstado());
		cadastrar.preencherEndereco(dados.getEndereco());
		cadastrar.clicarBtnConcordo();

		cadastrar.clicaBtnRegistrar();

		/* Método para espera a pagina carregar para buscar a URL */
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlToBe("http://www.advantageonlineshopping.com/#/"));

		/* Método que valida se a URL que busquei da página é a mesma da HOMEs */
		Assert.assertTrue(driver.getCurrentUrl().equals("http://www.advantageonlineshopping.com/#/"),
				"Usuário cadastrado com sucesso!!");
	}

	@Test
	public void cadastrarFalha() throws Exception {
		/* Criando o report e dando um nome */
		test = ExtendReport.createTest("CadastroFalha");

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		/* Metodo que inseri nos campos os valores retornados da planilha de excel */
		cadastrar.preencherNomeUsuario(dados.getNomeUsuario(16));
		cadastrar.preencherSenha(dados.getSenha());
		cadastrar.preencherConfirmaSenha(dados.getSenha());
		cadastrar.preencherEmail(dados.getEmail());
		cadastrar.preencherTelefone(dados.getTelefone());
		cadastrar.preencherPrimeiroNome(dados.getPrimeiroNome());
		cadastrar.preencherUltimoNome(dados.getUltimoNome());
		cadastrar.preencherPais(dados.getPais());
		cadastrar.preencherCodigoPostal(dados.getPostalCode());
		cadastrar.preencherCidade(dados.getCidade());
		cadastrar.preencherEstado(dados.getEstado());
		cadastrar.preencherEndereco(dados.getEndereco());
		cadastrar.clicarBtnConcordo();

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

		/* Método que faz esperar a página carregar para poder printar */
		ExtendReport.tearDown(result, test, driver);
		DriverFactory.closeBrowser(driver);

	}

	@AfterTest
	public void finalizaReporte() {
		ExtendReport.endReport();
	}
}
