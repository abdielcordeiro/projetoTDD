package br.com.rsinet.HUB_TDD.teste;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.module.modulos;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.Utils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeCadastrarFalha {

	private WebDriver driver;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", Constant.URL);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		modulos.executaHomeCadastro(driver);
	}

	@Test
	public void cadastrar() throws Exception {

		String resposta = modulos.executaCadastroErro(driver);

		System.out.println("Teste mensagem: " + resposta);
		Assert.assertFalse(resposta.equals("Use maximum 15 character"),"Login de acesso invalido, mais caracteres do que o permitido");

	}

	@AfterMethod
	public void encerrar() throws Exception {
		print.takeSnapShot("testeCadastroFalha");
		Utils.closeBrowser(driver);
	}

}
