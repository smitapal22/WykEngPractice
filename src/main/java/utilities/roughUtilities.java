package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class roughUtilities {
	public String TESTDATA_SHEET_PATH="";
	@Test
		@DataProvider(name="getData")
		public String[][] getextData(Method m) throws EncryptedDocumentException, IOException, InvalidFormatException{
			String excelSheetName = m.getName();
			FileInputStream file = null;
			file = new FileInputStream(TESTDATA_SHEET_PATH);
			//File f= new File("C:\\Users\\91897\\Documents\\eclipse\\weyyak_cucumber\\src\\test\\resources\\testdata\\testdata.xls");
			//FileInputStream fis = new FileInputStream(f);
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheetName = wb.getSheet(excelSheetName);
			int totalRows = sheetName.getLastRowNum();
			System.out.println(totalRows);
			Row rowCells = sheetName.getRow(0);
			int totalCols=rowCells.getLastCellNum();
			System.out.println(totalCols);
			DataFormatter format = new DataFormatter();
			String testData[][]=new String[totalRows][totalCols];
			
			for(int i=1; i<=totalRows; i++){
				for(int j=0;j<totalCols;j++) {
					testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
					System.out.println(testData[i-1][j]);
			}
		
			}
		return testData;
		}
	
	public String[][] getText(Method m) throws InvalidFormatException, IOException{
		String excelSheetName = m.getName();
		FileInputStream fis= new FileInputStream("TESTDATA_SHEET_PATH");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheetName= wb.getSheet(excelSheetName);
		int totalRows=sheetName.getLastRowNum();
		Row rowCells=sheetName.getRow(0);
		int totalCols=rowCells.getLastCellNum();
		String testData[][]= new String[totalRows][totalCols];
		DataFormatter format=new DataFormatter();
		for(int i=0;i<totalRows;i++) {
			for(int j=0;j<totalCols;j++) {
				testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testData;
	}
	
	public JSONObject[] jsonDataExtract(String Key) throws ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject =(JSONObject)jsonParser.parse("");
		JSONArray jsonArray=(JSONArray)jsonObject.get(Key);
		JSONObject arr[]=new JSONObject[jsonArray.size()];
		for(int i=0;i<jsonArray.size();i++) {
			arr[i]=(JSONObject)jsonArray.get(i);
		}
		return arr;
	}
	
}
