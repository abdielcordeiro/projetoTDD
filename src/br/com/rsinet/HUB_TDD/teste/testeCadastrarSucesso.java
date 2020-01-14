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

public class testeCadastrarSucesso {

	private WebDriver driver;

	@BeforeMethod
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Chrome", Constant.URL);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Cadastro");
		modulos.executaHomeCadastro(driver);
	}

	@Test
	public void cadastrar() throws Exception {
		String resposta = modulos.executaCadastro(driver);
		System.out.println(resposta);
		Assert.assertTrue(resposta.equals("http://www.advantageonlineshopping.com/#/"), "Usuário cadastrado com sucesso!!");
	}

	@AfterMethod
	public void encerrar() throws Exception {
		print.takeSnapShot("testeComSucesso");
		Utils.closeBrowser(driver);
	}

}
