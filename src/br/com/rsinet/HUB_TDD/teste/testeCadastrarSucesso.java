package br.com.rsinet.HUB_TDD.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.module.modulo_Cadastrar;
import br.com.rsinet.HUB_TDD.module.modulo_Home;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeCadastrarSucesso {

	private WebDriver driver;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", Constant.URL);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		modulo_Home.executa(driver);
	}

	@Test
	public void cadastrar() throws Exception {
		modulo_Cadastrar.executa(driver);
	}

	@After
	public void encerrar() throws Exception {
		print.takeSnapShot("testeComSucesso");
		Utils.closeBrowser(driver);
	}

}
