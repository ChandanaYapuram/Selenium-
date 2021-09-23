package se3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class WritingExcel {

	public static void main(String[] args) throws Exception{
		HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream("C:\\Users\\Sai Teja\\Desktop\\data.xls"));
		HSSFSheet sh=wb.getSheet("Sheet1");
		// if Rows and Cells both Exists
		sh.getRow(1).getCell(1).setCellValue("hr@12345");
		// if Row exists & cell does not exist
		sh.getRow(2).createCell(2).setCellValue("abcdef");
		// if row and cell both does not exists
		sh.createRow(4).createCell(2).setCellValue("Chandana");
		wb.write(new FileOutputStream("C:\\Users\\Sai Teja\\Desktop\\data1.xls"));
	}

}
