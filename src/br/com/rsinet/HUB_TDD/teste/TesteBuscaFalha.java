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

public class TesteBuscaFalha {

	private WebDriver driver;
	private BuscarLupa_Page buscarLupa;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
		buscarLupa = PageFactory.initElements(driver, BuscarLupa_Page.class);
	}

	@Test
	public void executar() throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String produto = ExcelUtils.getCellData(1, Constant.Produto);
		buscarLupa.preencherPorduto(produto);

		String nomeProduto = ExcelUtils.getCellData(1, Constant.nomeProduto);
		buscarLupa.pesquisaProdutoTela(driver, nomeProduto);

		for (int i = 0; i < 19; i++) {
			buscarLupa.bntAddProduto();
		}

		buscarLupa.bntAddCarinho();
		buscarLupa.bntEntrarCarinho();

		/*
		 * Mensagem deseja que seja de falha, pois a cadastrada é diferente da quantidade adicionada no carrinho
		 */
		Assert.assertEquals(buscarLupa.respostaQnt(), 20, "Quantidade Cadastrada diferente da pedida");
	}

	@AfterMethod
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaClickFalha");
		DriverFactory.closeBrowser(driver);
	}

}
