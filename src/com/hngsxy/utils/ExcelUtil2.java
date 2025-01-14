package com.hngsxy.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.hngsxy.web.bean.zs.ZhenShu;




public class ExcelUtil2 {

    public static void analysis() {
    	ZhenShu zhenShu = new ZhenShu();
        Workbook wb =null;
        Sheet sheet = null;
        Row row = null;
        List<Map<String,String>> list = null;
        String cellData = null;
        String filePath = "D:\\test.xlsx";
        String columns [] = {"id","title","pic","content","classid","adddate","idcard","data","rank","sex","yy","mm","dd","culture"};
        wb = readExcel(filePath);
        if(wb != null){
            //用来存放表中数据
            list = new ArrayList<Map<String,String>>();
            //获取第一个sheet
            sheet = wb.getSheetAt(0);
            //获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            //获取第一行
            row = sheet.getRow(0);
            //获取最大列数
            int colnum = row.getPhysicalNumberOfCells();
            for (int i = 1; i<rownum; i++) {
                Map<String,String> map = new LinkedHashMap<String,String>();
                row = sheet.getRow(i);
                if(row !=null){
                    for (int j=0;j<colnum;j++){
                        cellData = (String) getCellFormatValue(row.getCell(j));
                        map.put(columns[j], cellData);
                    }
                }else{
                    break;
                }
                list.add(map);
            }
        }
        //遍历解析出来的list
        for (Map<String,String> map : list) {

            for (Entry<String,String> entry : map.entrySet()) {
            	//这里可以添加数据到数据库呢~
//                System.out.print(entry.getKey()+":"+entry.getValue()+",");
                
            	if(entry.getKey() == "id") {
            		zhenShu.setId(entry.getValue());
            	}
            	if(entry.getKey() == "title") {
            		zhenShu.setTitle(entry.getValue());
            	}
            	if(entry.getKey() == "pic") {
            		zhenShu.setPic(entry.getValue());
            	}
            	if(entry.getKey() == "content") {
            		zhenShu.setContent(entry.getValue());
            	}
            	if(entry.getKey() == "classid") {
            		zhenShu.setClassid(entry.getValue());
            	}
            	if(entry.getKey() == "adddate") {
            		zhenShu.setAdddate(entry.getValue());
            	}
            	if(entry.getKey() == "idcard") {
            		zhenShu.setIdcard(entry.getValue());
            	}
            	if(entry.getKey() == "data") {
            		zhenShu.setData(entry.getValue());
            	}
            	if(entry.getKey() == "rank") {
            		zhenShu.setRank(entry.getValue());
            	}
            	if(entry.getKey() == "sex") {
            		zhenShu.setSex(entry.getValue());
            	}
            	if(entry.getKey() == "yy") {
            		zhenShu.setYy(entry.getValue());
            	}
            	if(entry.getKey() == "mm") {
            		zhenShu.setMm(entry.getValue());
            	}
            	if(entry.getKey() == "dd") {
            		zhenShu.setDd(entry.getValue());
            	}
            	if(entry.getKey() == "culture") {
            		zhenShu.setCulture(entry.getValue());
            	}
            	zhenShu.setTheory("1");
            	zhenShu.setWork("1");
            	zhenShu.setZsStatus("1");
            }
            System.out.println();
            
//        	try {
//        		zheShuBiz.insertZheShu(zhenShu);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
        }

    }
    //读取excel
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型
            switch(cell.getCellType()){
            case Cell.CELL_TYPE_NUMERIC:{
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            }
            case Cell.CELL_TYPE_FORMULA:{
                //判断cell是否为日期格式
                if(DateUtil.isCellDateFormatted(cell)){
                    //转换为日期格式YYYY-mm-dd
                    cellValue = cell.getDateCellValue();
                }else{
                    //数字
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            case Cell.CELL_TYPE_STRING:{
                cellValue = cell.getRichStringCellValue().getString();
                break;
            }
            default:
                cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

	
}
