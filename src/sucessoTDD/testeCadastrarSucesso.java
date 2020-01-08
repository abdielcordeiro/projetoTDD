package sucessoTDD;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testeCadastrarSucesso {

	private WebDriver driver;

	@Before
	public void carregar() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void cadastrar() throws InterruptedException {
		Thread.sleep(1000);
		WebElement bntLogin = driver.findElement(By.id("hrefUserIcon"));
		bntLogin.click();
		System.out.println("Chegou aqui");
	}

}
