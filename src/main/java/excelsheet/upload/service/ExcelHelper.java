package excelsheet.upload.service;


import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import excelsheet.upload.model.Patient;


public class ExcelHelper {

	private static String[] HEADERs = { "firstName", "lastName", "phoneNumber", "fees", "email" };

	// checking that file whether excel type or not

	public static boolean excelSheet(MultipartFile multFile) {
		String content = multFile.getContentType();
		if (content.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}

	}

//	check headers
	public static boolean headerSheet(InputStream inputStream) {
		XSSFWorkbook workbook = null;
		try {

			workbook = new XSSFWorkbook(inputStream);

			XSSFSheet sheet = workbook.getSheetAt(0);
			Row firstRow = sheet.getRow(0);

			if (firstRow.getPhysicalNumberOfCells() != HEADERs.length) {
				return false;
			} else {
				for (int i = 0; i < HEADERs.length; i++) {

					if (!HEADERs[i].equals(firstRow.getCell(i).getStringCellValue())) {
						return false;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	// Convert to List User Details
	
	public static List<Patient> convertList(InputStream inputStream) {
		List<Patient> list = new ArrayList<>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheetAt(0);

			for (Row row : sheet) {
				Patient patient = new Patient();
				if (row.getRowNum() == 0) {
					continue;
				}
				for (int i = 0; i < HEADERs.length; i++) {
					switch (i) {
					case 0:
						patient.setFirstName(row.getCell(i).getStringCellValue());
						break;

					case 1:
						patient.setLastName(row.getCell(i).getStringCellValue());
						break;
					case 2:
						patient.setPhoneNumber(NUMBER_FORMAT("0", row.getCell(i).getNumericCellValue()));
						break;
					case 3:
						patient.setFees(row.getCell(i).getNumericCellValue());
						break;
					case 4:
						patient.setEmail(row.getCell(i).getStringCellValue());
						break;
					default:
						break;
					}
				}
				list.add(patient);
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	private static String NUMBER_FORMAT(String format, Double value) {
		String number = "";
		DecimalFormat df = new DecimalFormat(format);
		number = df.format(value);
		return number;
	}
}

