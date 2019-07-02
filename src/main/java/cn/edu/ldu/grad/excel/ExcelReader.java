package cn.edu.ldu.grad.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import cn.edu.ldu.grad.pojo.StudentInfo;

public class ExcelReader {

	public void read(InputStream inputStream) {
		try {
			//InputStream inputStream = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(inputStream);
			inputStream.close();
			Sheet sheet = workbook.getSheetAt(0);
			for (int rowNum = 1; rowNum < sheet.getLastRowNum()+1 ; rowNum++) {
				Row row = sheet.getRow(rowNum);
				for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
					System.out.print(getValue(row.getCell(cellNum)) + "\t");
				}
				System.out.println(""); 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<StudentInfo> getStudentList(InputStream inputStream)
	{
		List<StudentInfo> list = new ArrayList<StudentInfo>();
		try {
			//InputStream inputStream = new FileInputStream(file);
			Workbook workbook = WorkbookFactory.create(inputStream);
			inputStream.close();
			Sheet sheet = workbook.getSheetAt(0);
			for (int rowNum = 1; rowNum < sheet.getLastRowNum()+1 ; rowNum++) {
				Row row = sheet.getRow(rowNum);
				StudentInfo studentInfo = new StudentInfo();
				studentInfo.setName(getValue(row.getCell(0)));
				studentInfo.setPersonId(getValue(row.getCell(1)));
				//System.out.println(getValue(row.getCell(1)));
				studentInfo.setAccessType(getValue(row.getCell(2)));
				studentInfo.setExamNo(getValue(row.getCell(3)));
				studentInfo.setStudentNo(getValue(row.getCell(4)));
				studentInfo.setCollegeCode(getValue(row.getCell(5)));
				studentInfo.setCollegeName(getValue(row.getCell(6)));
				studentInfo.setMajorCode(getValue(row.getCell(7)));
				studentInfo.setMajorName(getValue(row.getCell(8)));
				studentInfo.setEduType(getValue(row.getCell(9)));
				list.add(studentInfo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private String getValue(Cell cell) {
		if (cell.getCellType() == CellType.BOOLEAN)
			return String.valueOf(cell.getBooleanCellValue());
		else if (cell.getCellType() == CellType.NUMERIC) {
			if (DateUtil.isCellDateFormatted(cell)) {
				// 用于转化为日期格式
				Date d = cell.getDateCellValue();
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return formater.format(d);
			}
			return String.valueOf(cell.getNumericCellValue());
		} else
			return String.valueOf(cell.getRichStringCellValue());
	}
	public static void main(String[] args) throws FileNotFoundException {
		ExcelReader reader = new ExcelReader();
		InputStream inputStream1 = new FileInputStream(new File("d:/test.xls"));
		InputStream inputStream2 = new FileInputStream(new File("d:/研究生数据模版.xlsx"));
		reader.read(inputStream1);
		reader.getStudentList(inputStream2);
		System.out.println("hello excel");
	}
}
