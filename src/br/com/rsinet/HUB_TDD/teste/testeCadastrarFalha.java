package br.com.rsinet.HUB_TDD.teste;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.HUB_TDD.module.modulos;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeCadastrarFalha {

	private WebDriver driver;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", Constant.URL);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		modulos.executaHomeCadastro(driver);
	}

	@Test
	public void cadastrar() throws Exception {

		String resposta = modulos.executaCadastro(driver);

		System.out.println("Teste mensagem: " + resposta);
		Assert.assertFalse("Login de acesso invalido, mais caracteres do que o permitido", resposta.equals("Use maximum 15 character"));

	}

	@After
	public void encerrar() throws Exception {
		print.takeSnapShot("testeCadastroFalha");
		Utils.closeBrowser(driver);
	}

}
