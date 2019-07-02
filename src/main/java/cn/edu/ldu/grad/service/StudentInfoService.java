package cn.edu.ldu.grad.service;

import cn.edu.ldu.grad.pojo.StudentInfo;

public interface StudentInfoService {
	int deleteByPrimaryKey(String personId);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String personId);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}
