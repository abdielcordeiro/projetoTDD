package sucessoTDD;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Utils;

public class testeCadastrarSucesso {

	private WebDriver driver;

	@Before
	public void carregar() throws Exception {
		driver = Utils.openBrowser("Firefox", "http://www.advantageonlineshopping.com/#/");

		Thread.sleep(1000);
		WebElement bntLogar = driver.findElement(By.id("hrefUserIcon"));
		bntLogar.click();
		Thread.sleep(3000);
		WebElement bntCadastrar = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		bntCadastrar.click();
	}

	@Test
	public void cadastrar() {


	}

	@After
	public void encerrar() {
		//Utils.closeBrowser(driver);
	}

}
