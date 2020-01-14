package br.com.rsinet.HUB_TDD.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.module.modulos;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeBuscarLupaSucesso {

	private WebDriver driver;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", "http://www.advantageonlineshopping.com/#/");
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Pesquisa");
	}

	@Test
	public void buscar() throws Exception {

		String resposta = modulos.executaPesquisa(driver);

		assertTrue("Produto encontrado com sucesso", resposta.equals("LOGITECH G502 PROTEUS CORE"));

	}

	@After
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaLupaSucesso");
		//Utils.closeBrowser(driver);
	}
}
