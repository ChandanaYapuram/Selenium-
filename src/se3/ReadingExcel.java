package se3;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws Exception{
/*	    WorkBook > Sheet > Cells(row, col)
		POI supports boths extension of excel file .xls & .xlsx also
		.xls >     HSSF
		.xlsx > XSSF*/
		//1.Reading WorkBook
		HSSFWorkbook wb=new HSSFWorkbook(new FileInputStream("C:\\Users\\Sai Teja\\Desktop\\data1.xls"));
		
		//2.Reading Sheet
		HSSFSheet sh=wb.getSheet("Sheet1");
		
		//3.Reading from cells(rows,col)
		String data=sh.getRow(0).getCell(1).toString();
		System.out.println(data);
		for(int i=0;i<=3;i++) {
			String user=sh.getRow(i).getCell(0).toString();
			System.out.print(user+" ");
			String pwd=sh.getRow(i).getCell(1).toString();
			System.out.println(pwd);
		}
	}

}
