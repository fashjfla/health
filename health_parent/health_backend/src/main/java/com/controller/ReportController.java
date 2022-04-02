/*
package com.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.constant.MessageConstant;
import com.entity.Result;
import com.pojo.EnrollmentAll;
import com.service.ReportService;
import com.service.SetmealService;
import com.service.entrollment.PolicyService;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

*/
/**
 * 统计报表
 *//*

@RestController
@RequestMapping("/report")
public class ReportController {


	@Reference
	private PolicyService policyService;


	*/
/**
	 * 导出Excel报表
	 *
	 * @return
	 *//*

	@RequestMapping("/exportBusinessReport")
	public Result exportBusinessReport(HttpServletRequest request, HttpServletResponse response) {
		try {
			*/
/*
			远程调用报表服务获取报表数据
			Map<String, Object> result = reportService.getBusinessReport();
			获得Excel模板文件绝对路径
			*//*


			String temlateRealPath = request.getSession().getServletContext().getRealPath("template") +
					File.separator + "template1.xlsx";
			//读取模板文件创建Excel表格对象
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(temlateRealPath)));

			List<EnrollmentAll> enrollmentAllList = policyService.query();

			int sum = enrollmentAllList.size();
			AtomicInteger rows = new AtomicInteger(1);
			enrollmentAllList.forEach(enrollmentAll -> {
				String school = enrollmentAll.getSchool();
				String period = enrollmentAll.getPeriod();
				String startDate = enrollmentAll.getStartDate();
				String endDate = enrollmentAll.getEndDate();
				Integer people = enrollmentAll.getPeople();
				Integer enrollment = enrollmentAll.getEnrollment();
				String ageGroup = enrollmentAll.getAgeGroup();
				//读取第一个工作表
				XSSFSheet sheet = workbook.getSheetAt(0);
				//获得第2行第1个单元格
				XSSFRow row = sheet.getRow(rows.getAndIncrement());
				row.getCell(0).setCellValue(school);//日期

				row.getCell(1).setCellValue(period);//新增会员数（本日）
				row.getCell(2).setCellValue(startDate);//总会员数

				row.getCell(3).setCellValue(endDate);//本周新增会员数
				row.getCell(4).setCellValue(people);//本月新增会员数

				row.getCell(5).setCellValue(enrollment);//今日预约数

				row.getCell(6).setCellValue(ageGroup);//本周预约数
			});

			//通过输出流进行文件下载 基于浏览器作为客户端进行下载
			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/vnd.ms-excel");//代表的是excel文件类型
			response.setHeader("content-Disposition", "attachment;filename=report.xlsx");//指定以附件形式下载
			workbook.write(out);

			out.flush();
			out.close();
			workbook.close();

			return null;
		} catch (Exception e) {
			return new Result(false, MessageConstant.GET_FAIL, null);
		}
	}

	//导出运营数据到pdf并提供客户端下载
	//@RequestMapping("/exportBusinessReport4PDF")
*/
/*
	public Result exportBusinessReport4PDF(HttpServletRequest request, HttpServletResponse response) {
		try {
			//Map<String, Object> result = reportService.getBusinessReport();

			//取出返回结果数据，准备将报表数据写入到PDF文件中
			List<Map> hotSetmeal = (List<Map>) result.get("hotSetmeal");

			//动态获取模板文件绝对磁盘路径
			String jrxmlPath =
					request.getSession().getServletContext().getRealPath("template") + File.separator + "health_business3.jrxml";
			String jasperPath =
					request.getSession().getServletContext().getRealPath("template") + File.separator + "health_business3.jasper";
			//编译模板
			JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);

			//填充数据---使用JavaBean数据源方式填充
			JasperPrint jasperPrint =
					JasperFillManager.fillReport(jasperPath, result,
							new JRBeanCollectionDataSource(hotSetmeal));

			ServletOutputStream out = response.getOutputStream();
			response.setContentType("application/pdf");
			response.setHeader("content-Disposition", "attachment;filename=report.pdf");

			//输出文件
			//JasperExportManager.exportReportToPdfStream(jasperPrint, out);

			out.flush();
			out.close();

			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, MessageConstant.GET_FAIL);
		}
	}
*//*

}*/
