package br.com.rsinet.HUB_TDD.pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BuscarLupa_Page{

	@FindBy(how = How.ID, using = "menuSearch")
	public static WebElement bnt_lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	public static WebElement input_buscar;

	@FindBy(how = How.ID, using = "31")
	public static WebElement bnt_clicarProduto;

	@FindBy(how = How.XPATH, using = "//*[@id=\"Description\"]/h1")
	public static WebElement label_resposta;

	@FindBy(how = How.XPATH, using = "//*[@id=\"search\"]/div/div/img")
	public static WebElement bnt_X;


}
