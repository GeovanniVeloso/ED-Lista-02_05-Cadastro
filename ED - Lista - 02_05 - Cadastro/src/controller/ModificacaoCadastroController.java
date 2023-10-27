package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import br.edu.fatec.zl.Lista;
import model.Cliente;

public class ModificacaoCadastroController {

	Cliente client;
	
	public ModificacaoCadastroController() {
		
	}
	
	public void newRegister(int ageMin, int ageMax, double credLimit) throws IOException {
		Lista <Cliente> lista = new Lista<Cliente>();
		File dir = new File ("D:\\3 Semestre\\temp");
		File arq = new File ("D:\\3 Semestre\\temp","cadastro.csv");
		
		if (dir.exists() && dir.isDirectory()) {
			if (arq.exists() && arq.isFile()) {
				FileInputStream flux = new FileInputStream(arq);
				InputStreamReader reader = new InputStreamReader(flux);
				BufferedReader buffer = new BufferedReader(reader);
				String linha = buffer.readLine();
				while(linha!=null) {
					String []vet = linha.split(";");
					String []vet2 = vet[3].split(",");
					client = new Cliente (vet[0], vet[1], Integer.parseInt(vet[2]), Double.parseDouble(vet2[0]));
					linha = buffer.readLine();
					
					if(client.getAge()>ageMin && client.getAge()<ageMax && client.getCredit_limit()>credLimit) {
						if(lista.isEmpty()) {
							lista.addFirst(client);
						}else {
							try {
								lista.addLast(client);
							} catch (Exception e) {
								System.err.println();
							}
						}
					}	
				}
				String name = "Idade maxima #"+ageMax+" Idade minima #"+ageMin+" Limite de Credito #"+credLimit;
				newArquive(lista, name);
				buffer.close();
				reader.close();
				flux.close();
			} else {
				throw new IOException("Arquivo Inválido");
			}
		} else {
			throw new IOException("Diretório Inválido");
		}
	}
	
	private void newArquive(Lista <Cliente> lista, String arqName) throws IOException {
		File dir = new File ("D:\\3 Semestre\\temp2");
		File arq = new File ("D:\\3 Semestre\\temp2",arqName + ".csv");
		
		if(dir.exists() && dir.isDirectory()) {
			boolean exist = false;
			if(arq.exists()) {
				exist = true;
			}
			StringBuffer buffer = new StringBuffer();
			while(!lista.isEmpty()) {
				try {
					client = lista.get(0);
				} catch (Exception e) {
					System.err.println(e);
				}
				buffer.append(client.getCpf()+";"+client.getName()+";"+client.getAge()+";"+client.getCredit_limit()+"\r\n");
				try {
					lista.remove(0);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
			String thing = buffer.toString();
			FileWriter fileWriter = new FileWriter(arq,exist);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(thing);
			print.flush();
			print.close();
			fileWriter.close();
		}else {
			System.err.println("Diretório Inválido");
		}
	}

}
