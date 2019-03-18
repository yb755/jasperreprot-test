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

	static String compile(String jrxmlfile) throws JRException, FileNotFoundException {
		//String path = App.class.getResource("/"+jrxmlfile).getPath();
		File file = new File(jrxmlfile);
		String jrxmlDestSourcePath = jrxmlfile.substring(0,jrxmlfile.lastIndexOf("."))+".jasper";
		System.out.println(jrxmlDestSourcePath);
		File jasperFile = new File(jrxmlDestSourcePath);
		//if (!jasperFile.exists() || !jasperFile.isFile()) {
			System.out.println("编绎jasper文件");
			JasperCompileManager.compileReportToFile(jrxmlfile, jrxmlDestSourcePath);
		//}
		return jrxmlDestSourcePath;
	}

	public static void main(String[] args) {
		try {
			//String jasperFile = compile("D:\\git\\study\\report-test\\src\\main\\java\\insurance_no_price.jrxml");
			String jasperFile = compile("D:\\git\\study\\report-test\\src\\main\\java\\insurance_no_price.jrxml");

			// 准备需要数据
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("VALID_DATE_RANGE", "2018-11-28  至 2019-11-27");
			parameters.put("CAR_OWNER", "阿力米尔扎•沙依提");
			parameters.put("INSURANCE_NO", "BYKJ000001");
			parameters.put("CARD_NO", "430723201112541254");
			parameters.put("CAR_NO", "粤BR651T");
			parameters.put("CAR_MODEL", "大众宝来");
			parameters.put("REGISTER_DATE", "2012-05-09");
			parameters.put("CAR_PRICE", "￥12.75万元");
			parameters.put("PAY_FOR_MONEY", "50");			
			parameters.put("DEVICE_NO", "3651254125221111");
			parameters.put("INSTALL_DATE", "2018-10-25 11:11:11");
			parameters.put("ENGINE_NO", "558806");
			parameters.put("VIN", "LVF352154215221");
			parameters.put("SERVICE_FEE", "￥3245元");
			parameters.put("FRIST_BENEFICIARY", "叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶兵叶戈");
			parameters.put("REMARK", "备注:地山高路远的全景绵延指路远跌宕指山高山路蜿蜒伸向远方直达起伏不定的连绵的雪峰这是我和战友们巡逻必经之地颔联继续写实连用两个特写镜头一是巡边战士翻山越岭汗湿衣衫背部遇冷凝霜一是寒风掠过脸庞像被利刃划过般疼痛唯山头积雪寒风如刀之际战士们必定穿着厚实难以通过镜头表现汗衫衣背故毋宁说这是带有夸张色彩的写意镜头脸度刀度过也此句蕴含了对腊月边地严寒的主观感受颈联由实入虚总括前四句上句爬冰巡线早将特定场景");
			parameters.put("YEAR", "2018");
			parameters.put("MONTH", "11");
			parameters.put("DAY", "27");
			
			//parameters.put("IMG_BACKGROUND", "C:\\bg_no_price.jpg");
			parameters.put("IMG_BACKGROUND", "C:\\0318bg_no_price.jpg");
			parameters.put("IMG_MARK_BY", "C:\\IMG_MARK_BY.png");
			parameters.put("IMG_MARK_RB", "C:\\IMG_MARK_RB.png");

			// 第三个参数: 必须有, 但可以是空数据源
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile, parameters, new JREmptyDataSource());
			// 设置目标文件输出的路径
			String desFilePath = "C:\\test.pdf";
			// 输出文档
			JasperExportManager.exportReportToPdfFile(jasperPrint, desFilePath);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
