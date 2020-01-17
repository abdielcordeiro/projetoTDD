package br.com.rsinet.HUB_TDD.pageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.utility.Constant;
import br.com.rsinet.HUB_TDD.utility.ExcelUtils;

public class BuscarLupa_Page {

	@FindBy(how = How.ID, using = "menuSearch")
	private static WebElement bnt_lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	private static WebElement input_buscar;
//
//	@FindBy(how = How.ID, using = "24")
//	private static WebElement bnt_clicarProduto;
//

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	private static WebElement label_resposta;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	private static WebElement label_nomeProduto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	private static WebElement bnt_X;

	@FindBy(how = How.ID, using = "speakersImg")
	private static WebElement bnt_categoria;

	@FindBy(how = How.ID, using = "19")
	private static WebElement bnt_produto;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[2]/e-sec-plus-minus/div/div[3]")
	private static WebElement bnt_addProduto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	private static WebElement bnt_salvarCarrinho;

	@FindBy(how = How.ID, using = "menuCart")
	private static WebElement bnt_entrarCarrinho;

	@FindBy(how = How.XPATH, using = "//*[@id=\"shoppingCart\"]/table/tbody/tr/td[4]/label[2]")
	private static WebElement label_quantidade;

	public static WebElement pesquisaProdutoTela(WebDriver driver, String produto) {
		WebElement element = driver.findElement(By.xpath("//*[. ='"+ produto +"']"));
		return element;
	}

	public static String executaPesquisa(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement bntBuscar = wait.until(ExpectedConditions.elementToBeClickable(bnt_lupa));
		bntBuscar.click();

		String produto = ExcelUtils.getCellData(1, Constant.Produto);
		input_buscar.sendKeys(produto + Keys.ENTER);

		Thread.sleep(2000);
		bnt_X.click();

		String nomeProduto = ExcelUtils.getCellData(1, Constant.nomeProduto);
		pesquisaProdutoTela(driver, nomeProduto).click();

		return label_resposta.getText();
	}

	public static String executaPesquisaErro(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);

		WebElement bntBuscar = wait.until(ExpectedConditions.elementToBeClickable(bnt_lupa));
		bntBuscar.click();

		String produto = ExcelUtils.getCellData(1, Constant.Produto);
		input_buscar.sendKeys(produto + Keys.ENTER);

		return label_resposta.getText();
	}

	public static String executaPesquisaClick(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		bnt_categoria.click();

		String nomeProduto = ExcelUtils.getCellData(1, Constant.nomeProduto);
		pesquisaProdutoTela(driver, nomeProduto).click();

		return label_nomeProduto.getText();
	}

	public static int executaPesquisaClickErro(WebDriver driver) throws Exception {
		PageFactory.initElements(driver, BuscarLupa_Page.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		bnt_categoria.click();

		String nomeProduto = ExcelUtils.getCellData(1, Constant.nomeProduto);
		pesquisaProdutoTela(driver, nomeProduto).click();

		for (int i = 0; i < 19; i++) {
			bnt_addProduto.click();
		}

		bnt_salvarCarrinho.click();
		bnt_entrarCarrinho.click();

		int testaQuantidade = Integer.parseInt(label_quantidade.getText());

		return testaQuantidade;
	}

}
