package br.com.rsinet.HUB_TDD.module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.pageFactory.Home_Page;

public class modulo_Home {

	public static void executa(WebDriver driver) {
		PageFactory.initElements(driver, Home_Page.class);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement bntLogar = wait.until(ExpectedConditions.elementToBeClickable(Home_Page.bnt_Login));
		bntLogar.click();


		WebElement bntCadastrar = wait.until(ExpectedConditions.elementToBeClickable(Home_Page.bnt_Cadastrar));
		bntCadastrar.sendKeys(Keys.ENTER);


	}

}
