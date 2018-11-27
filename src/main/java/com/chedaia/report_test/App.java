package com.chedaia.report_test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Hello world!
 *
 */
public class App {

	static String compile() throws JRException, FileNotFoundException {
		String path = App.class.getResource("/insurance_style2.jrxml").getPath();
		File file = new File(path);
		String parentPath = file.getParent();
		String jrxmlDestSourcePath = parentPath + "/insurance_style2.jasper";
		System.out.println(jrxmlDestSourcePath);
		JasperCompileManager.compileReportToFile(path, jrxmlDestSourcePath);
		return jrxmlDestSourcePath;
	}

	public static void main(String[] args) {
		try{
		String jasperFile=compile();
        
        // 准备需要数据
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("VALID_TIME_RANGE", "从北京时间2018-11-28 00:00:00生效,到2019-11-27 23:59:59截止");
        parameters.put("CAR_OWNER", "叶兵");
        parameters.put("INSURANCE_NO", "000001");
        parameters.put("CARD_NO", "430723201112541254");
        parameters.put("CAR_NO", "粤BR651T");
        parameters.put("CAR_MODEL", "大众宝来");
        parameters.put("REGISTER_DATE", "2012-05-09");
        parameters.put("CAR_PRICE", "12.75万元");
        parameters.put("DEVICE_NO", "3651254125221111");
        parameters.put("INSTALL_DATE", "2018-10-25");
        parameters.put("ENGINE_NO", "558806");
        parameters.put("VIN", "LVF352154215221");
        parameters.put("SERVICE_FEE", "￥3245元");
        parameters.put("FRIST_BENEFICIARY", "法定");
        parameters.put("YEAR", "2018");
        parameters.put("MONTH", "11");
        parameters.put("DAY", "27");
        
        // 第三个参数: 必须有, 但可以是空数据源
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, parameters, new JREmptyDataSource());
        // 设置目标文件输出的路径
        String desFilePath = "C:\\test.pdf";
        // 输出文档
        JasperExportManager.exportReportToPdfFile(jasperPrint, desFilePath);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
