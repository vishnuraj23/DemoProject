package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static Workbook book;
	static Sheet sheet;

	public static Workbook getWorkbook(String path, String name) throws Exception {
		Workbook wb = null;
		File file = new File(path + "\\" + name);
		FileInputStream inputStream = new FileInputStream(file);
		String fileExtensionName = name.substring(name.indexOf("."));
		try {
			if (fileExtensionName.equals(".xlsx")) {
				wb = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				POIFSFileSystem fs = new POIFSFileSystem(inputStream);
				wb = new HSSFWorkbook(fs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				//wb.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return wb;
	}
	public static Sheet getsheetName(String path, String name, int index)
			throws IOException {
		Workbook wb = null;
		Sheet sheet = null;
		File file = new File(path + "\\" + name);
		FileInputStream inputStream = new FileInputStream(file);
		String fileExtensionName = name.substring(name.indexOf("."));
		try {
			if (fileExtensionName.equals(".xlsx")) {
				wb = new XSSFWorkbook(inputStream);
			} else if (fileExtensionName.equals(".xls")) {
				wb = new HSSFWorkbook(inputStream);
			}

			sheet = wb.getSheetAt(index);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wb != null) {
				//wb.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}

		return sheet;

	}
	public static Object[][] getExcelData(String path, String filename,String sheetname) throws Exception
	{
		Sheet sheet = null;
		int rowCount = 0;
		int colCount =0;
		int index=-1;
		Object[][] excelData = null;
		try {
			index = getWorkbook(path, filename).getSheetIndex(sheetname);
			sheet=getsheetName(path,filename,index);
			rowCount = sheet.getLastRowNum();
			System.out.println("Row Count :- " + rowCount);
			rowCount = sheet.getLastRowNum();
			DataFormatter formatter = new DataFormatter();
			System.out.println("rowCount :" +rowCount);

			int totalCount = 0;
			for (int i = 1; i < rowCount; i++) {
				Row r = sheet.getRow(i);
				colCount = r.getLastCellNum();
				if(formatter.formatCellValue(r.getCell(colCount-1)).equalsIgnoreCase("YES"))
				{
					totalCount=totalCount+1;
				}
			}
			System.out.println("totalCount: "+totalCount);
			excelData = new Object[totalCount][colCount-1];
			int tempNum=0;
			for (int i = 1; i < rowCount; i++) {
				for (int j = 0; j < colCount-1; j++) {
					if(formatter.formatCellValue(sheet.getRow(i).getCell(colCount-1)).equalsIgnoreCase("YES"))
					{

						excelData[tempNum][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j)).trim();
						System.out.print(excelData[tempNum][j] +" ");
					}
				}
				if(formatter.formatCellValue(sheet.getRow(i).getCell(colCount-1)).equalsIgnoreCase("YES"))
				{
					tempNum=tempNum+1;
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}          
		return excelData;
	}
	
}
