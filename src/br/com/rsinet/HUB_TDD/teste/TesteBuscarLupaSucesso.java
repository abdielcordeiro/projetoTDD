package br.com.rsinet.HUB_TDD.teste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.pageFactory.BuscarLupa_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.DriverFactory;
import br.com.rsinet.HUB_TDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.print;

public class TesteBuscarLupaSucesso {


	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.CHROME, "http://www.advantageonlineshopping.com/#/");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class);
	}

	@Test
	public void buscar() throws Exception {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		buscarLupa.bntLupa();

		String produto = ExcelUtils.getCellData(1, Constant.Produto);
		buscarLupa.input_Produto(produto);

		buscarLupa.bntX(driver);

		String nomeProduto = ExcelUtils.getCellData(1, Constant.nomeProduto);
		buscarLupa.pesquisaProdutoTela(driver, nomeProduto);

		String resposta = buscarLupa.resultadoProduto();
		System.out.println(resposta);
		System.out.println(nomeProduto.toUpperCase());
		Assert.assertTrue(resposta.equals(nomeProduto.toUpperCase()), "Produto encontrado com sucesso");
	}

	@AfterMethod
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaLupaSucesso");
		DriverFactory.closeBrowser(driver);
	}
}
