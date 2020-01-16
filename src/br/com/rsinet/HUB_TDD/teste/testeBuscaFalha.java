package br.com.rsinet.HUB_TDD.teste;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.pageFactory.BuscarLupa_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeBuscaFalha {

	private WebDriver driver;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", Constant.URL);

	}

	@Test
	public void executar() throws Exception {

		int testaQuantidade = BuscarLupa_Page.executaPesquisaClickErro(driver);
		Assert.assertEquals(testaQuantidade, 20, "Quantidade Cadastrada diferente da pedida");
	}

	@AfterMethod
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaClickFalha");
		Utils.closeBrowser(driver);
	}

}
