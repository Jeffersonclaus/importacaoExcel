package application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import entities.Pessoas;

public class ApplicationGeraExcel {

	
	
	public static void main(String[] args) throws IOException {
		
		

		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		
		
		Pessoas p1 = new Pessoas("João", "Joao@gmail.com", 5);
		Pessoas p2 = new Pessoas("Silva", "silva@gmail.com", 10);
		Pessoas p3 = new Pessoas("Carlos", "carlos@gmail.com", 11);
		Pessoas p4 = new Pessoas("Claus", "claus@gmail.com", 30);

		List<Pessoas> pessoas = new ArrayList<>();
		pessoas.add(p1);
		pessoas.add(p2);
		pessoas.add(p3);
		pessoas.add(p4);
		
		
		
		File file = new File("C:\\planilha\\Relatorio.xls");
	
		
		if (!file.exists()) { // Se não existir o arquivo
			
			File file1 = new File("C:\\planilha"); 
			file1.mkdir();// cria pasta
		
		
		}

		HSSFWorkbook hssWorkBook = new HSSFWorkbook(); // Vai ser usado para escrever a planilha
		HSSFSheet linhasPessoas = hssWorkBook.createSheet("Panillha de pessoas Jclaus");
		
	

		int numeroLinha = 0;// Iniciar linha com zero
		int celula = 0; // Iniciar celula com zero para o cabeçalho

		Row linha = linhasPessoas.createRow(numeroLinha); // Começa da linha Zero para o CABEÇALHO
	
		Cell CellDate = linha.createCell(0);
		CellDate.setCellValue(sdf.format(date)); // Data atual
		
		
		Cell cabecalhoNome = linha.createCell(0); // Celula 0
		cabecalhoNome.setCellValue("NOME"); // Cria NOME do cabeçalho

		Cell cabecalhoEmail = linha.createCell(1); // Celula 1
		cabecalhoEmail.setCellValue("E-MAIL"); // Cria NOME do cabeçalho

		Cell cabecalhoIDADE = linha.createCell(2);
		cabecalhoIDADE.setCellValue("IDADE"); // Cria IDADE do cabeçalho
		
	//	Cell cabecalhoDate = linha.createCell(3);
//		cabecalhoDate.setCellValue("Data Gerada: "+ sdf.format(date)); // Cria data atual do relatorio gerado no sistema

		numeroLinha = 0; // Começa a importar os dados na linha 1, pois a linha zero é do cabeçalho

		int somaIdade = 0;
		int somalinha = 0;
		for (Pessoas p : pessoas) {
			 somalinha = numeroLinha;
			
			celula = 0; // Iniciar celula com zero
			linha = linhasPessoas.createRow(numeroLinha++); // criando linha na planilha

			Cell cellNome = linha.createCell(celula++); // Celula 1
			cellNome.setCellValue(p.getName().toUpperCase());

			Cell cellEmail = linha.createCell(celula++); // Celula 2
			cellEmail.setCellValue(p.getEmail().toUpperCase());

			Cell cellIdade = linha.createCell(celula++); // Celula 3
			cellIdade.setCellValue(p.getIdade());
			
	//		somaIdade += p.getIdade(); //soma a idade

		} // Termina palnilha
		
	
		linha = linhasPessoas.createRow(somalinha +2); //Deu Salto de duas linhas 
		Cell cellIdade = linha.createCell(0); //Coloquei na celula 0 
		cellIdade.setCellValue("Soma das idades: " + somaIdade);
		
		
		
		FileOutputStream saida = new FileOutputStream(file);
		
		hssWorkBook.write(saida); // Escreve a planilha em arquivo
	
	
		saida.flush();
		file.canExecute() ;
		saida.close();
		hssWorkBook.close();


		JOptionPane.showMessageDialog(null, "PLANILHA CRIADA!!!");
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
