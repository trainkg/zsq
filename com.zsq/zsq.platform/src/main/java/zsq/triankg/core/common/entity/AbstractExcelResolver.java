package zsq.triankg.core.common.entity;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public abstract class AbstractExcelResolver {
	/**
	 * Excel实际名称
	 */
	protected String fileName;
	/**
	 * Excel文件流
	 */
	protected InputStream inputStream;

	public AbstractExcelResolver(String fileName, InputStream inputStream)
			throws IOException {
		super();
		this.fileName = fileName;
		this.inputStream = inputStream;
		parseXmlFile();
	}

	/**
	 * 解析文件信息
	 * 
	 * @param file
	 * @throws IOException
	 */
	protected abstract void parseXmlFile() throws IOException;

	/**
	 * 获取对应类型的Workbook处理器
	 * 
	 * @param type
	 * @param fis
	 * @return
	 * @throws IOException
	 */
	protected Workbook getWorkbook() throws IOException {
		ExcelType type = getFileType();
		Workbook wb = null;
		switch (type) {
		case XLS:
			wb = new HSSFWorkbook(inputStream);
			break;
		case XLSX:
			wb = new XSSFWorkbook(inputStream);
			break;
		}
		return wb;
	}

	/**
	 * 抓取文件类型
	 * 
	 * @param file
	 * @return
	 */
	protected ExcelType getFileType() {
		String name = fileName;
		String suffix = name.substring(name.lastIndexOf(".") + 1);
		return Enum.valueOf(ExcelType.class, suffix.toUpperCase());
	}

	/**
	 * 获取合并单元格的值
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	protected String getMergedRegionValue(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();

			if (row >= firstRow && row <= lastRow) {

				if (column >= firstColumn && column <= lastColumn) {
					Row fRow = sheet.getRow(firstRow);
					Cell fCell = fRow.getCell(firstColumn);

					return getCellValue(fCell);
				}
			}
		}
		return null;
	}

	/**
	 * 判断指定的单元格是否是合并单元格
	 * 
	 * @param sheet
	 * @param row
	 * @param column
	 * @return
	 */
	protected boolean isMergedRegion(Sheet sheet, int row, int column) {
		int sheetMergeCount = sheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergeCount; i++) {
			CellRangeAddress ca = sheet.getMergedRegion(i);
			int firstColumn = ca.getFirstColumn();
			int lastColumn = ca.getLastColumn();
			int firstRow = ca.getFirstRow();
			int lastRow = ca.getLastRow();

			if (row >= firstRow && row <= lastRow) {
				if (column >= firstColumn && column <= lastColumn) {

					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 获取单元格的值
	 * 
	 * @param cell
	 * @return
	 */
	protected String getCellValue(Cell cell) {
		if (cell == null)
			return "";
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			return cell.getStringCellValue();
		} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		} else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			return cell.getCellFormula();
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		}
		return "";
	}
}
