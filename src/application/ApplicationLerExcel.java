package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import entities.Pessoas;

public class ApplicationLerExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream entrada = new FileInputStream(new File("C:\\planilha\\Relatorio.xls"));

		HSSFWorkbook hssfworkbook = new HSSFWorkbook(entrada); // entrada para ler aquivo
		HSSFSheet planilha = hssfworkbook.getSheetAt(0); // pega a primeira planilha na(aba)

		Iterator<Row> linhaIterator = planilha.iterator(); // Iterator de linha

		List<Pessoas> pessoas = new ArrayList<>();

		
		
		
		while (linhaIterator.hasNext()) { // Enquanto estiver linha

		

			Pessoas p = new Pessoas();

			Row linha = linhaIterator.next(); // Dados da Pessoa na linha

			Iterator<Cell> celulas = linha.iterator(); // Iterator de Celula

			while (celulas.hasNext()) {

				Cell cell = celulas.next();

				switch (cell.getColumnIndex()) {

				case 0:
					p.setName(cell.getStringCellValue());

					break;

				case 1:
					p.setEmail(cell.getStringCellValue());

					break;

				case 2:
					p.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
					break;

				
				}
				
		

			}
				
			pessoas.add(p);
			
		}
		hssfworkbook.close();
		
		for  (Pessoas p : pessoas) {
			
			
			System.out.println(p.toString());
		}
			
		
	
	

	}

}
