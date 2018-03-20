package samples.simpleExcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CustomerExcelWriter {

	public void xlsWriter(List<CustomerVo> list, String filePath) {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell;

		cell = row.createCell(0);
		cell.setCellValue("���̵�");

		cell = row.createCell(1);
		cell.setCellValue("�̸�");

		cell = row.createCell(2);
		cell.setCellValue("����");

		cell = row.createCell(3);
		cell.setCellValue("�̸���");

		CustomerVo vo;
		for (int rowIndex = 0; rowIndex < list.size(); rowIndex++) {
			vo = list.get(rowIndex);

			row = sheet.createRow(rowIndex + 1);

			cell = row.createCell(0);
			cell.setCellValue(vo.getCustId());
			cell = row.createCell(1);
			cell.setCellValue(vo.getCustName());
			cell = row.createCell(2);
			cell.setCellValue(vo.getCustAge());
			cell = row.createCell(3);
			cell.setCellValue(vo.getCustEmail());
		}

		File file = new File(filePath);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void xlsxWriter(List<CustomerVo> list, String filePath) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;

		cell = row.createCell(0);
		cell.setCellValue("���̵�");

		cell = row.createCell(1);
		cell.setCellValue("�̸�");

		cell = row.createCell(2);
		cell.setCellValue("����");

		cell = row.createCell(3);
		cell.setCellValue("�̸���");

		CustomerVo vo;
		for (int rowIndex = 0; rowIndex < list.size(); rowIndex++) {
			vo = list.get(rowIndex);

			row = sheet.createRow(rowIndex + 1);

			cell = row.createCell(0);
			cell.setCellValue(vo.getCustId());
			cell = row.createCell(1);
			cell.setCellValue(vo.getCustName());
			cell = row.createCell(2);
			cell.setCellValue(vo.getCustAge());
			cell = row.createCell(3);
			cell.setCellValue(vo.getCustEmail());
		}

		File file = new File(filePath);
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null) {
					workbook.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
