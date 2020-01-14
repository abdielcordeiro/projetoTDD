package br.com.rsinet.HUB_TDD.module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.HUB_TDD.pageFactory.Cadastrar_Page;
import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;

public class modulo_Cadastrar {

	public static void executa(WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PageFactory.initElements(driver, Cadastrar_Page.class);

		String userName = ExcelUtils.getCellData(1, Constant.userName);
		Cadastrar_Page.input_userName.sendKeys(userName);

		String password = ExcelUtils.getCellData(1, Constant.userPass);
		Cadastrar_Page.input_senha.sendKeys(password);
		Cadastrar_Page.input_confirmaSenha.sendKeys(password);

		String userEmail = ExcelUtils.getCellData(1, Constant.email);
		Cadastrar_Page.input_email.sendKeys(userEmail);

		String phoneNumber = ExcelUtils.getCellData(1, Constant.phoneNumber);
		Cadastrar_Page.input_phoneNumber.sendKeys(phoneNumber);

		String fristName = ExcelUtils.getCellData(1, Constant.FristName);
		Cadastrar_Page.input_fristName.sendKeys(fristName);

		String lastName = ExcelUtils.getCellData(1, Constant.LastName);
		Cadastrar_Page.input_lastName.sendKeys(lastName);

		// Preencher os dados de endereço
		WebElement pais = driver.findElement(By.name("countryListboxRegisterPage"));
		pais.click();
		Select comboBoxPais = new Select(pais);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		comboBoxPais.selectByVisibleText("Brazil");

		String cep = ExcelUtils.getCellData(1, Constant.CEP);
		Cadastrar_Page.input_cep.sendKeys(cep);

		String city = ExcelUtils.getCellData(1, Constant.City);
		Cadastrar_Page.input_city.sendKeys(city);

		String state = ExcelUtils.getCellData(1, Constant.State);
		Cadastrar_Page.input_state.sendKeys(state);

		String address = ExcelUtils.getCellData(1, Constant.address);
		Cadastrar_Page.input_address.sendKeys(address);

		Cadastrar_Page.bnt_concordar.click();
		Cadastrar_Page.bnt_registrar.click();
	}
}
