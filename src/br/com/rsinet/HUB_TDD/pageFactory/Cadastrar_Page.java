package br.com.rsinet.HUB_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Cadastrar_Page {

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	public static WebElement input_userName;


	@FindBy(how = How.NAME, using = "emailRegisterPage")
	public static WebElement input_email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	public static WebElement input_senha;


	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	public static WebElement input_confirmaSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	public static WebElement input_fristName;


	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	public static WebElement input_lastName;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	public static WebElement input_phoneNumber;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	public static WebElement input_city;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	public static WebElement input_address;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	public static WebElement input_state;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	public static WebElement input_cep;

	@FindBy(how = How.NAME, using = "i_agree")
	public static WebElement bnt_concordar;

	@FindBy(how = How.NAME, using = "register_btnundefined")
	public static WebElement bnt_registrar;
}
