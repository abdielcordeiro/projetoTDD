package sucessoTDD;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testeCadastrarSucesso {


	@Before
	public void carregar() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.advantageonlineshopping.com/#/");
	}


}
