package br.com.rsinet.HUB_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuscarLupa_Page{

	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement bnt_lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	public static WebElement input_buscar;

	@FindBy(how = How.ID, using = "24")
	public static WebElement bnt_clicarProduto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"searchPage\"]/div[3]/div/label/span")
	public static WebElement label_resposta;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	public static WebElement label_nomeProduto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	public static WebElement bnt_X;

	@FindBy(how = How.ID, using = "speakersImg")
	public static WebElement bnt_categoria;

	@FindBy(how = How.ID, using = "19")
	public static WebElement bnt_produto;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article[1]/div[2]/div[2]/div/div[2]/e-sec-plus-minus/div/div[3]")
	public static WebElement bnt_addProduto;

	@FindBy(how = How.NAME, using = "save_to_cart")
	public static WebElement bnt_salvarCarrinho;

	@FindBy(how = How.ID, using = "menuCart")
	public static WebElement bnt_entrarCarrinho;

	@FindBy(how = How.XPATH, using = "//*[@id=\"shoppingCart\"]/table/tbody/tr/td[4]/label[2]")
	public static WebElement label_quantidade;



}
