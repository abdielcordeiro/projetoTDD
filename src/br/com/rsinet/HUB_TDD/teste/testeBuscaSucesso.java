package br.com.rsinet.HUB_TDD.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.module.modulos;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeBuscaSucesso {

	private WebDriver driver;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", Constant.URL);
		//ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
	}

	@Test
	public void executar() throws Exception {

		String nomeProduto = modulos.executaPesquisaClick(driver);
		assertTrue("Produto encontrado com sucesso",nomeProduto.equals("HP ROAR MINI WIRELESS SPEAKER"));
	}

	@After
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaClickSucesso");
		Utils.closeBrowser(driver);
	}

}
