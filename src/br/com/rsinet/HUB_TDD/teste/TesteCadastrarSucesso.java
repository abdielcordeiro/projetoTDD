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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.extendReport.ExtendReport;
import br.com.rsinet.HUB_TDD.pageFactory.Cadastrar_Page;
import br.com.rsinet.HUB_TDD.pageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.DriverFactory;
import br.com.rsinet.HUB_TDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.MassaDados;
import br.com.rsinet.HUB_TDD.utility.print;

public class TesteCadastrarSucesso {

	private WebDriver driver;
	private Cadastrar_Page cadastrar;
	private Home_Page home;
	private ExtentReports extent = new ExtentReports();
	private ExtentTest test;
	private MassaDados dados;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		home = PageFactory.initElements(driver, Home_Page.class);
		home.executaHomeCadastro(driver);
		dados = new MassaDados();
		cadastrar = PageFactory.initElements(driver, Cadastrar_Page.class);
		extent = ExtendReport.setExtent("TesteCadastroSucesso");

	}

	@Test
	public void cadastrar() throws Exception {
		test = extent.createTest("CadastroSucesso");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		cadastrar.preencherCadastro(dados.getUserName(), dados.getPassword(), dados.getEmail(), dados.getPhoneNumber(),
				dados.getFristName(), dados.getLastName(), dados.getCountry(), dados.getPostalCode(), dados.getCity(),
				dados.getState(), dados.getAddress());

		cadastrar.clicaBtnRegistrar();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlToBe("http://www.advantageonlineshopping.com/#/"));

		Assert.assertTrue(driver.getCurrentUrl().equals("http://www.advantageonlineshopping.com/#/"),
				"Usuário cadastrado com sucesso!!");
	}

	@AfterMethod
	public void encerrar(ITestResult result) throws Exception {
		ExtendReport.tearDown(result, test);
		ExtendReport.endReport(extent);
		home.esperaHome(driver);
		print.takeSnapShot("testeComSucesso");
		DriverFactory.closeBrowser(driver);
	}

}
