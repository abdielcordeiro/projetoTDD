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
import br.com.rsinet.HUB_TDD.pageFactory.BuscarLupa_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.DriverFactory;
import br.com.rsinet.HUB_TDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.print;

public class TesteBuscarLupaFalha {

	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;
	private ExtentReports extent = new ExtentReports();
	private ExtentTest test;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.CHROME, "http://www.advantageonlineshopping.com/#/");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class);

		extent = ExtendReport.setExtent("TesteBuscarLupaFalha");
	}

	@Test
	public void buscar() throws Exception {
		test = extent.createTest("BuscaLupaFalha");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		buscarLupa.bntLupa();

		String nomeProduto = ExcelUtils.getCellData(6, Constant.nomeProdutoFalha);
		buscarLupa.input_Produto(nomeProduto);

		buscarLupa.bntLupa();

		String resposta = buscarLupa.label_Respota();
		System.out.println(resposta);
		System.out.println("No results for " + "\"" + nomeProduto + "\"");
		Assert.assertTrue(resposta.equals("No results for " + "\"" + nomeProduto + "\""),
				"Produto: " + nomeProduto + "  não encontrado");

	}

	@AfterMethod
	public void finalizar(ITestResult result) throws Exception {
		ExtendReport.tearDown(result, test);
		ExtendReport.endReport(extent);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span"));
		WebDriverWait wait1 = new WebDriverWait(driver, 20);
		wait1.until(ExpectedConditions.visibilityOf(element));

		print.takeSnapShot("testeBuscaLupaFalha");
		DriverFactory.closeBrowser(driver);
	}
}
