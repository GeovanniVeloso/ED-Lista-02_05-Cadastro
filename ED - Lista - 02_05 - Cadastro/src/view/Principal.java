package view;

import java.io.IOException;

import controller.ModificacaoCadastroController;

public class Principal {

	public static void main(String[] args) {
		ModificacaoCadastroController mcc = new ModificacaoCadastroController();
		
		try {
			mcc.newRegister(41, 60, 8000.00);
			mcc.newRegister(31, 40, 5000.00);
			mcc.newRegister(21, 30, 3000.00);
		} catch (IOException e) {
			System.err.println(e);
		}

	}

}
