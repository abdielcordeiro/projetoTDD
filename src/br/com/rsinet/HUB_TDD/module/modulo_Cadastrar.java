package br.com.rsinet.HUB_TDD.module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.pageFactory.Cadastrar_Page;

public class modulo_Cadastrar {

	public static void executa(WebDriver driver) {
		PageFactory.initElements(driver, Cadastrar_Page.class);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//String useName = ExcelUtils.getCellData(1, );
		Cadastrar_Page.input_userName.sendKeys("");
	}
}
