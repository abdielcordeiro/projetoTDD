package br.com.rsi.HUB_TDD.utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class print extends Utils{
	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "C://Users//abdiel.cordeiro//Documents//Projetos//eclipse-workspace//projetoTDD//target//prints//";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeDoArquivoImagem + ".png"));

	}


}