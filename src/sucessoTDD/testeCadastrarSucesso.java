package sucessoTDD;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import Utility.Utils;

public class testeCadastrarSucesso {

	@Before
	public void carregar() {
		Utils.openBrowser("Chrome");
		Utils.openURL("http://www.advantageonlineshopping.com/#/");
	}

	@Test
	public void cadastrar() {
		Utils.driver.findElements(By.xpath("//*[@id=\"hrefUserIcon\"]"));
		System.out.println("Chegou aqui");
	}

}
