package cn.edu.ldu.grad.service;

import cn.edu.ldu.grad.pojo.ExamResultInfo;

public interface ExamResultInfoService {
	 int deleteByPrimaryKey(String bmh);

	    int insert(ExamResultInfo record);

	    int insertSelective(ExamResultInfo record);

	    ExamResultInfo selectByPrimaryKey(String bmh);

	    ExamResultInfo selectByXmZjhm(String xm,String zjhm);
	    
	    int updateByPrimaryKeySelective(ExamResultInfo record);

	    int updateByPrimaryKey(ExamResultInfo record);
}
