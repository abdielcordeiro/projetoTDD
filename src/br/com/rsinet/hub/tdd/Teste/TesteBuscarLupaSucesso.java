package br.com.rsinet.hub.tdd.Teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub.tdd.ExtendReport.ExtendReport;
import br.com.rsinet.hub.tdd.PageFactory.BuscarLupa_Page;
import br.com.rsinet.hub.tdd.Utilidades.Constant;
import br.com.rsinet.hub.tdd.Utilidades.DriverFactory;
import br.com.rsinet.hub.tdd.Utilidades.ExcelUtils;
import br.com.rsinet.hub.tdd.Utilidades.MassaDados;
import br.com.rsinet.hub.tdd.Utilidades.DriverFactory.DriverType;

public class TesteBuscarLupaSucesso {

	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;
	private ExtentTest test;
	private MassaDados dados;

	@BeforeTest
	public void report() {
		ExtendReport.setExtent();
	}

	@BeforeMethod
	public void carregar() throws Exception {

		/* Metodo que inicia o navegador e passa a URL */

		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);

		/*
		 * Metodo que instancia a o local e a planilha que seram utilizadas junto com a
		 * aba da planilha
		 */
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");

		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class);
		dados = new MassaDados();
	}

	@Test
	public void buscarLupaSucesso() throws Exception {

		/* Criando o report e dando um nome */
		test = ExtendReport.createTest("BuscaLupaSucesso");

		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		buscarLupa.bntLupa();
		buscarLupa.input_Produto(dados.getTipoProduto());
		buscarLupa.bntX(driver);
		buscarLupa.pesquisaProdutoTela(driver, dados.getNomeProduto());

		/*
		 * Metodo que valida se o produto que estava buscando pela lupa foi encontrado
		 * com sucesso
		 */
		Assert.assertTrue(buscarLupa.resultadoProduto().equals(dados.getNomeProduto().toUpperCase()),
				"Produto encontrado com sucesso");
	}

	@AfterMethod
	public void finalizar(ITestResult result) throws Exception {

		ExtendReport.tearDown(result, test, driver);
		ExtendReport.endReport();
		DriverFactory.closeBrowser(driver);

	}
}
