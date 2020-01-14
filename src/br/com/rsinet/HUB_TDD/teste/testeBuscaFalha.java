package br.com.rsinet.HUB_TDD.teste;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.module.modulos;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeBuscaFalha {

	private WebDriver driver;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", Constant.URL);

	}

	@Test
	public void executar() throws Exception {

		int testaQuantidade = modulos.executaPesquisaClickErro(driver);
		assertEquals("Quantidade Cadastrada diferente da pedida", testaQuantidade, 20);
	}

	@After
	public void finalizar() throws Exception {
		print.takeSnapShot("testeBuscaClickFalha");
		Utils.closeBrowser(driver);
	}

}
