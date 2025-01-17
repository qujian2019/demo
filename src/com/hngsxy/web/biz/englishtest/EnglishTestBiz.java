package com.hngsxy.web.biz.englishtest;

import java.util.ArrayList;

import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import com.hngsxy.web.bean.gsxyenglishexamination.GsxyEnglishExaminationTable;
import com.hngsxy.web.bean.gsxyenglishexamination.GsxySemester;

/**
 * 英语三级考试
 * @author 
 *
 */
@Service
public interface EnglishTestBiz {
	//新增考生信息
	Integer insertEnglishTest(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//修改考生信息
	Integer updateEnglishTest(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//学生录入信息查询
	ArrayList<GsxyEnglishExaminationTable>findEnglishExamination(GsxyEnglishExaminationTable gsxyEnglishExaminationTable,int page, int limit)throws Exception;
	//删除一个学生信息
	Integer updateExaminationStatus(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//查询一个报考信息
	GsxyEnglishExaminationTable selectGsxyEnglishExaminationTableOne(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//逻辑删除
	Integer updateEnglishTestState(String[] ids)throws Exception;
	//查询英语考试
	Integer selectEnglishTestIdCard(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//到处Excel
	//public void export(String[] titles, ServletOutputStream out);
	//考生导出Excel
	void findEnglishExaminationExcel(GsxyEnglishExaminationTable g,String[] titles, ServletOutputStream out)throws Exception;
	//查询考期
	ArrayList<GsxySemester>findSemester(GsxySemester gsxySemester,int page, int limit)throws Exception;
	//新增考期
	Integer insertSemester(GsxySemester gsxySemester)throws Exception;
	//删除一个考期
	Integer updateSemesterStatus(GsxySemester gsxySemester)throws Exception;
	//修改一个考期名称
	Integer updateSemesterName(GsxySemester gsxySemester)throws Exception;
	//查询考期
	ArrayList<GsxySemester>selectSemesterByTow()throws Exception;
	//报考通过
	Integer updateEnglishTestStateByAdopt(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//不通过理由
	Integer updateEnglishTestUnqualifiedReason(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//通过身份证查询考生状态
	GsxyEnglishExaminationTable findEnglishTestByIdCard(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
	//根据身份证修改考试编号,和作为编号
	Integer updateAdmissionTicket(GsxyEnglishExaminationTable gsxyEnglishExaminationTable)throws Exception;
}
