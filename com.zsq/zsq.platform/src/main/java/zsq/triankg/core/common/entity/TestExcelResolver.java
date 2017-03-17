/*
 * 文件名称:          TestExcelResolver.java
 * 版权所有@ 2014——2015 KISUN
 * 时间:             2015年6月11日 下午5:42:29
 */

package zsq.triankg.core.common.entity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * EXCEL 抽象解析器 测试用例
 * 
 * <p>
 * <p>
 * 
 * @项目 petrel.commonU
 *     <p>
 * @作者: jihailong
 *      <p>
 * @日期: 2015年6月11日
 *      <p>
 * @负责人: KISUN
 *       <p>
 * @负责小组: <p>
 *        <p>
 */
public class TestExcelResolver extends AbstractExcelResolver {
	// 解析返回数据
	private List<Object> list;

	public TestExcelResolver(String fileName, InputStream inputStream)
			throws IOException {
		super(fileName, inputStream);
	}

	@Override
	protected void parseXmlFile() throws IOException {
		list = new ArrayList<Object>();
		Workbook wb = getWorkbook();
		// 抓取第一个SHEET
		Sheet sheet = wb.getSheetAt(0);
		if (sheet == null) {
			throw new IllegalArgumentException("NO Sheet info.");
		}
		parseSheet(sheet);
	}

	private void parseSheet(Sheet sheet) {
		int first = sheet.getFirstRowNum();
		int last = sheet.getLastRowNum();
		for (int i = first + 1; i <= last; i++) {
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			// 异常对象声明
			IllegalArgumentException e = null;

			boolean blankRow = true;
			for (int j = 0; j < row.getLastCellNum(); j++) {
				String value = null;
				/* 防止数据之间出现空行 */
				Cell cell = row.getCell(j);

				if (cell == null) {
					blankRow = blankRow & true;
				} else {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					// 预防合并情况
					if (isMergedRegion(sheet, i, j)) {
						value = getMergedRegionValue(sheet, i, j);
					} else {
						value = cell.getStringCellValue().trim();
					}
				}

				if (StringUtils.isBlank(value)) {
					if (j == 1 || j == 2) {
						e = new IllegalArgumentException("第" + (i + 1) + "行, 第"
								+ (j + 1) + "列, 信息不完整");
					}
					blankRow = blankRow & true;
				} else {
					blankRow = false;
				}

				switch (j) {
				case 0:
					break;
				case 1:
					break;
				case 2:
					break;
				default:
					break;
				}
			}
			if (blankRow) {
				continue;
			} else if (e != null) {
				throw e;
			}

			// TODO数据作成
		}

	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}

}
