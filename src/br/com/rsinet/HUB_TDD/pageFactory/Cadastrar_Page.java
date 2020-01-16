package br.com.rsinet.HUB_TDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;

public class Cadastrar_Page {

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private static WebElement input_userName;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private static WebElement input_email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private static WebElement input_senha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private static WebElement input_confirmaSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private static WebElement input_fristName;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private static WebElement input_lastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private static WebElement input_phoneNumber;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private static WebElement input_city;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private static WebElement input_address;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private static WebElement input_state;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private static WebElement input_cep;

	@FindBy(how = How.NAME, using = "i_agree")
	private static WebElement bnt_concordar;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private static WebElement bnt_registrar;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[1]/div/label")
	private static WebElement resposta;

	public static String executaCadastro(WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PageFactory.initElements(driver, Cadastrar_Page.class);

		String userName = ExcelUtils.getCellData(1, Constant.userName);
		input_userName.sendKeys(userName);

		String password = ExcelUtils.getCellData(1, Constant.userPass);
		input_senha.sendKeys(password);
		input_confirmaSenha.sendKeys(password);

		String userEmail = ExcelUtils.getCellData(1, Constant.email);
		input_email.sendKeys(userEmail);

		String phoneNumber = ExcelUtils.getCellData(1, Constant.phoneNumber);
		input_phoneNumber.sendKeys(phoneNumber);

		String fristName = ExcelUtils.getCellData(1, Constant.FristName);
		input_fristName.sendKeys(fristName);

		String lastName = ExcelUtils.getCellData(1, Constant.LastName);
		input_lastName.sendKeys(lastName);

		// Preencher os dados de endere�o
		WebElement pais = driver.findElement(By.name("countryListboxRegisterPage"));
		pais.click();
		Select comboBoxPais = new Select(pais);
		comboBoxPais.selectByVisibleText("Brazil");

		String cep = ExcelUtils.getCellData(1, Constant.CEP);
		input_cep.sendKeys(cep);

		String city = ExcelUtils.getCellData(1, Constant.City);
		input_city.sendKeys(city);

		String state = ExcelUtils.getCellData(1, Constant.State);
		input_state.sendKeys(state);

		String address = ExcelUtils.getCellData(1, Constant.address);
		input_address.sendKeys(address);

		bnt_concordar.click();
		bnt_registrar.click();

		Thread.sleep(1000);
		String resposta = driver.getCurrentUrl();

		return resposta;
	}

	public static String executaCadastroErro(WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PageFactory.initElements(driver, Cadastrar_Page.class);

		String userName = ExcelUtils.getCellData(1, Constant.userName);
		input_userName.sendKeys(userName);

		String password = ExcelUtils.getCellData(1, Constant.userPass);
		input_senha.sendKeys(password);
		input_confirmaSenha.sendKeys(password);

		String userEmail = ExcelUtils.getCellData(1, Constant.email);
		input_email.sendKeys(userEmail);

		String phoneNumber = ExcelUtils.getCellData(1, Constant.phoneNumber);
		input_phoneNumber.sendKeys(phoneNumber);

		String fristName = ExcelUtils.getCellData(1, Constant.FristName);
		input_fristName.sendKeys(fristName);

		String lastName = ExcelUtils.getCellData(1, Constant.LastName);
		input_lastName.sendKeys(lastName);

		// Preencher os dados de endere�o
		WebElement pais = driver.findElement(By.name("countryListboxRegisterPage"));
		pais.click();
		Select comboBoxPais = new Select(pais);
		comboBoxPais.selectByVisibleText("Brazil");

		String cep = ExcelUtils.getCellData(1, Constant.CEP);
		input_cep.sendKeys(cep);

		String city = ExcelUtils.getCellData(1, Constant.City);
		input_city.sendKeys(city);

		String state = ExcelUtils.getCellData(1, Constant.State);
		input_state.sendKeys(state);

		String address = ExcelUtils.getCellData(1, Constant.address);
		input_address.sendKeys(address);

		bnt_concordar.click();
		bnt_registrar.click();

		return resposta.getText();
	}

}