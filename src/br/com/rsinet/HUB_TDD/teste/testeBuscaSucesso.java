package br.com.rsinet.HUB_TDD.teste;

import org.openqa.selenium.WebDriver;
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

public class testeBuscaSucesso {

	private WebDriver driver;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
	}

	@Test
	public void executar() throws Exception {

		String nomeProduto = BuscarLupa_Page.executaPesquisaClick(driver);
		Assert.assertTrue(nomeProduto.equals("HP ROAR MINI WIRELESS SPEAKER"),"Produto encontrado com sucesso");
	}

	@AfterMethod
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaClickSucesso");
		DriverFactory.closeBrowser(driver);
	}

}
