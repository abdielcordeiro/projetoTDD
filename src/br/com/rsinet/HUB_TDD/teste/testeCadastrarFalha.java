package br.com.rsinet.HUB_TDD.teste;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.pageFactory.Cadastrar_Page;
import br.com.rsinet.HUB_TDD.pageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.DriverFactory;
import br.com.rsinet.HUB_TDD.utility.DriverFactory.DriverType;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;
import br.com.rsinet.HUB_TDD.utility.print;

public class testeCadastrarFalha {

	private WebDriver driver;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = DriverFactory.openBrowser(DriverType.CHROME, Constant.URL);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		Home_Page.executaHomeCadastro(driver);
	}

	@Test
	public void cadastrar() throws Exception {

		String resposta = Cadastrar_Page.executaCadastroErro(driver);

		System.out.println("Teste mensagem: " + resposta);
		Assert.assertFalse(resposta.equals("Use maximum 15 character"),"Login de acesso invalido, mais caracteres do que o permitido");

	}

	@AfterMethod
	public void encerrar() throws Exception {
		print.takeSnapShot("testeCadastroFalha");
		DriverFactory.closeBrowser(driver);
	}

}
