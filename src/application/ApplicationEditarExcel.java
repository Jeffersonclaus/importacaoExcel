package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ApplicationEditarExcel {
	
	public static void main(String[] args) throws IOException {
		
		File file =  new File("c:\\planilha\\relatorio.xls");
		

		FileInputStream entrada = new FileInputStream(file) ; //Entrada do arquivo
		
		HSSFWorkbook hhsfworkbook = new HSSFWorkbook(entrada); // Ler planilha
		
		HSSFSheet planilha = hhsfworkbook.getSheetAt(0); //Ler 1° aba da planilha
		
		Iterator<Row>linhasPlanilhas = planilha.iterator(); //Cria um Iterator das linha
		
		while (linhasPlanilhas.hasNext()) { //enquanto tive linha ele vai ler 
			
			Row linha = linhasPlanilhas.next(); //Dados da pessoa na linha
			
			int  numerosCelulas = linha.getPhysicalNumberOfCells();
			
			Cell cell = linha.createCell(numerosCelulas); // cria nova celula
			cell.setCellValue("5.500,00"); //Cria nova celula
			
			
			String valorCelula = linha.getCell(0).getStringCellValue(); //Pega a celula e copia na String
			
		
		linha.getCell(0).setCellValue(valorCelula + "NOVA LINHA TESTE"); //Pega a String valorCelula e altera + um novo texto;
		
			
		}
		
		
		entrada.close();
		
		FileOutputStream saida = new FileOutputStream(file);
		saida.close();
		hhsfworkbook.close();
		
		
		
		
			
			
			
		}
		
		
		
		
		
		
		
		


}
