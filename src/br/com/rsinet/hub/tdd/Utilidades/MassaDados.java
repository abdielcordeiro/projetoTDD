package br.com.rsinet.hub.tdd.Utilidades;

import java.util.Random;

public class MassaDados {

	private static int linha = 1;
	private static int linhaFalha = 6;


	public String getNomeUsuario(int quantidadeLetra) {
		Random quantidadedeletras = new Random();
		int index;

		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVYWXZabcdefghijklmnopqrstuvxwyz0123456789";
		String palavraRandom = "";

		for (int i = 0; i <= quantidadeLetra - 1; i++) {
			index = quantidadedeletras.nextInt(caracteres.length());
			palavraRandom += caracteres.substring(index, index + 1);
		}
		return palavraRandom;
	}

	public String getSenha() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.UserPass);
	}

	public String getEmail() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.Email);
	}

	public String getPrimeiroNome() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.FristName);
	}

	public String getUltimoNome() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.LastName);
	}

	public String getTelefone() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.PhoneNumber);
	}

	public String getCidade() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.City);
	}

	public String getEndereco() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.Address);
	}

	public String getEstado() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.State);
	}

	public String getPostalCode() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.PostalCode);
	}

	public String getPais() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.Country);
	}

	public String getTipoProduto() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.TipoProduto);
	}

	public String getNomeProduto() throws Exception {
		return ExcelUtils.getCellDataString(linha, Constant.NomeProduto);
	}

	public String getNomeProdutoFalha() throws Exception {
		return ExcelUtils.getCellDataString(linhaFalha, Constant.NomeProdutoFalha);
	}

	public Integer getQuantidadeProduto() throws Exception {
		return Integer.valueOf(ExcelUtils.getCellDataNumber(linha, Constant.QuantidadeProduto));
	}

}
