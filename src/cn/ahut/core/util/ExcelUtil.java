package cn.ahut.core.util;

import java.util.List;


import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.ahut.sys.food.entity.Food;





public class ExcelUtil {

	/**
	 * 导出菜品的所有列表到excel
	 
	 */
	public static void exportFoodExcel(List<Food> foodList, ServletOutputStream outputStream) {
		try {
			//1、创建工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			//1.1、创建合并单元格对象
			CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 3);//起始行号，结束行号，起始列号，结束列号
			
			//1.2、头标题样式
			HSSFCellStyle style1 = createCellStyle(workbook, (short)16);
			
			//1.3、列标题样式
			HSSFCellStyle style2 = createCellStyle(workbook, (short)13);
			
			//2、创建工作表
			HSSFSheet sheet = workbook.createSheet("菜品列表");
			//2.1、加载合并单元格对象
			sheet.addMergedRegion(cellRangeAddress);
			//设置默认列宽
			sheet.setDefaultColumnWidth(25);
			
			//3、创建行
			//3.1、创建头标题行；并且设置头标题
			HSSFRow row1 = sheet.createRow(0);
			HSSFCell cell1 = row1.createCell(0);
			//加载单元格样式
			cell1.setCellStyle(style1);
			cell1.setCellValue("菜品列表");
			
			//3.2、创建列标题行；并且设置列标题
			HSSFRow row2 = sheet.createRow(1);
			String[] titles = {"菜名", "所属菜系", "价格", "会员价格"};
			for(int i = 0; i < titles.length; i++){
				HSSFCell cell2 = row2.createCell(i);
				//加载单元格样式
				cell2.setCellStyle(style2);
				cell2.setCellValue(titles[i]);
			}
			
			//4、操作单元格；将用户列表写入excel
			if(foodList != null){
				for(int j = 0; j < foodList.size(); j++){
					HSSFRow row = sheet.createRow(j+2);
					HSSFCell cell11 = row.createCell(0);
					cell11.setCellValue(foodList.get(j).getFoodName());
					HSSFCell cell12 = row.createCell(1);
					cell12.setCellValue(foodList.get(j).getFoodType().getTypeName());
					HSSFCell cell13 = row.createCell(2);
					cell13.setCellValue(foodList.get(j).getPrice());
					HSSFCell cell14 = row.createCell(3);
					cell14.setCellValue(foodList.get(j).getMprice());
				}
			}
			//5、输出
			workbook.write(outputStream);
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建单元格样式
	 * @param workbook 工作簿
	 * @param fontSize 字体大小
	 * @return 单元格样式
	 */
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
		//创建字体
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//加粗字体
		font.setFontHeightInPoints(fontSize);
		//加载字体
		style.setFont(font);
		return style;
	}

}
