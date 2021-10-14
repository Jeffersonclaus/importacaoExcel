package application;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import entities.Usuarios;

public class ProgramJson {

	public static void main(String[] args) throws IOException {

		Usuarios usuario1 = new Usuarios("Jo�o Miguel", "joao.miguel", "slaskq", "01992927353");
		Usuarios usuario2 = new Usuarios("Carlos Silva", "carlos.silva", "slaskq", "0328373535113");
		Usuarios usuario3 = new Usuarios("Alex lemos","carlos.silva","slaskqaa" , "0322316353");
		
		List<Usuarios>usuarios = new ArrayList<>();
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Formatar o Jason
		
		String jsonUsers = gson.toJson(usuarios); // Pega lista e cria uma String
		
		
		File file = new File("c:\\planilha\\json.txt");
		
		if(!file.exists()) { // Se n�o existir arquivo
			
		file.createNewFile(); // cria arquivo
		file.mkdir(); //cria a pasta
			
			
		}
		
		FileWriter fw = new FileWriter(file); 
		fw.write(jsonUsers);// ESCREVE O OS ARQUIVOS DO jsonUsers
		fw.flush();
		fw.close();
		
		
		JOptionPane.showMessageDialog(null, "Arquivo Criado!!! " + "\n"+ file.getPath()); //Tela inforamndo que foi criado 
		
		System.out.println("*******************IMPORTANDO ARQUIVO .JSON P/ ARQUIVO .TXT *******************************");
		
		System.out.println(jsonUsers);
		
		System.out.println("*******************LENDO ARQUIVO TXT JSON ************************************************");
		//****************LENDO ARQUIVO JASON*************
		
		FileReader fileReader = new FileReader("c:\\planilha\\json.txt");
		
		//Convertendo a leitura de um arquivoJson  p/ Array
		// tem Cast JsonArray
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader); 
		
		List<Usuarios>lisUsuarios = new ArrayList<>(); //Cria lista de usu�rios
		
		for (JsonElement jsonElement : jsonArray) { // Percorre todo o arquivo
			
			// Copiar as informa�oes do tipo jsonElement para Usuarios
			Usuarios usuarioJ = new Gson().fromJson(jsonElement, Usuarios.class); 			
			
			lisUsuarios.add(usuarioJ); //add na lista
			
		}
		
		for (Usuarios usuarios2 : lisUsuarios) {
			
			System.out.println(usuarios2);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
