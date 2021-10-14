package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Pessoas;

public class ApplicationGerarTXT {
	
	public static void main(String[] args) throws IOException {
		
		
		
//Dados
		Pessoas p1 = new Pessoas("João", "Joao@gmail.com", 5);
		Pessoas p2 = new Pessoas("Silva", "silva@gmail.com", 10);
		Pessoas p3 = new Pessoas("Carlos", "carlos@gmail.com", 11);
		Pessoas p4 = new Pessoas("Claus", "claus@gmail.com", 30);

		List<Pessoas> pessoas = new ArrayList<>();
		// add a lista
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);

		File file = new File("C:\\planilha\\arquivo.txt");
	
		
		if (!file.exists()) { // Se não existir o arquivo
			
			File file1 = new File("C:\\planilha");  
			
				file1.mkdir();// cria pasta
			
		
		
		}
		FileWriter flwr = new FileWriter(file);
		
		
		
		for (Pessoas p : pessoas) { //Percorrer  todo lista de pessoa
		
			flwr.write(p.getName() + ";" );
			flwr.write(p.getEmail() + ";");
			flwr.write(p.getIdade() + "\r\n");
		
		}

		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flwr.flush();
		flwr.close();

	}

		
	}


