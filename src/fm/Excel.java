package fm;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	Workbook wb;
	public Excel(String pathWithFileName) {
		try {
			if(pathWithFileName.endsWith(".xls")) {
				wb=new HSSFWorkbook(new FileInputStream(pathWithFileName));
			}else if(pathWithFileName.endsWith(".xlsx")) {
				wb=new XSSFWorkbook(new FileInputStream(pathWithFileName));
			}}catch(Exception E) {
				System.out.println("Error with File Connection with message "+E.getMessage());
			}
		}
	public String getData(String sheetName,int row,int col) {
		String data=wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		return data;
	}
	public int getRowNum(String sheetName) {
		int row=wb.getSheet(sheetName).getLastRowNum()+1;
		return row;
	}
	public int getColNum(String sheetName) {
		int col=wb.getSheet(sheetName).getRow(0).getLastCellNum();
		return col;
	}
}
