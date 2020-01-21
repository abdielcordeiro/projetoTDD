package br.com.rsinet.HUB_TDD.teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import br.com.rsinet.HUB_TDD.utility.print;

public class TesteCadastrarSucesso {

	private WebDriver driver;
	private Cadastrar_Page cadastrar;
	private Home_Page home;
	private ExtentReports extent = new ExtentReports();
	private ExtentTest test;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.FIREFOX, Constant.URL);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");

		home = PageFactory.initElements(driver, Home_Page.class);
		home.executaHomeCadastro(driver);

		cadastrar = PageFactory.initElements(driver, Cadastrar_Page.class);
		extent = ExtendReport.setExtent("TesteCadastroSucesso");

	}

	@Test
	public void cadastrar() throws Exception {
		test = extent.createTest("CadastroSucesso");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		String userName = ExcelUtils.getCellData(1, Constant.userName);

		String password = ExcelUtils.getCellData(1, Constant.userPass);

		String userEmail = ExcelUtils.getCellData(1, Constant.email);

		String phoneNumber = ExcelUtils.getCellData(1, Constant.phoneNumber);

		String fristName = ExcelUtils.getCellData(1, Constant.FristName);

		String lastName = ExcelUtils.getCellData(1, Constant.LastName);

		String pais = ExcelUtils.getCellData(1, Constant.Pais);

		String cep = ExcelUtils.getCellData(1, Constant.CEP);

		String city = ExcelUtils.getCellData(1, Constant.City);

		String state = ExcelUtils.getCellData(1, Constant.State);

		String address = ExcelUtils.getCellData(1, Constant.address);

		cadastrar.preencherCadastro(userName, password, userEmail, phoneNumber, fristName, lastName, pais, cep, city,
				state, address);

		cadastrar.clicaBtnRegistrar();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlToBe("http://www.advantageonlineshopping.com/#/"));

		String resposta = driver.getCurrentUrl();

		System.out.println(resposta);
		Assert.assertTrue(resposta.equals("http://www.advantageonlineshopping.com/#/"),
				"Usuário cadastrado com sucesso!!");
	}

	@AfterMethod
	public void encerrar(ITestResult result) throws Exception {
		ExtendReport.tearDown(result, test);
		ExtendReport.endReport(extent);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"speakersImg\"]"));
		WebDriverWait wait1 = new WebDriverWait(driver, 200);
		wait1.until(ExpectedConditions.visibilityOf(element));
		print.takeSnapShot("testeComSucesso");
		DriverFactory.closeBrowser(driver);
	}

}
