package br.com.rsinet.HUB_TDD.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class print extends DriverFactory {

	public static String pegaHora() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static void takeSnapShot(String nomeDoArquivoImagem) throws Exception {
		String nomeFoto = nomeDoArquivoImagem + pegaHora() + ".png";

		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String imageFileDir = "./target/prints/";
		FileUtils.copyFile(srcFile, new File(imageFileDir, nomeFoto));

	}

}