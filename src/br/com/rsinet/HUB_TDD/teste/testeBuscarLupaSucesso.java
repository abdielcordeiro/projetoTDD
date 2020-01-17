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

public class testeBuscarLupaSucesso {

	//Alerar a busca na massa de dados para MICE
	private WebDriver driver;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.CHROME, "http://www.advantageonlineshopping.com/#/");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
	}

	@Test
	public void buscar() throws Exception {

		String resposta = BuscarLupa_Page.executaPesquisa(driver);

		Assert.assertTrue(resposta.equals("LOGITECH G502 PROTEUS CORE"),"Produto encontrado com sucesso");

	}

	@AfterMethod
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaLupaSucesso");
		DriverFactory.closeBrowser(driver);
	}
}
