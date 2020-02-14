package cn.edu.ldu.grad.service;

import cn.edu.ldu.grad.pojo.StudentSubjectInfo;

public interface StudentSubjectInfoService {
    int deleteByPrimaryKey(String ksbh);

    int insert(StudentSubjectInfo record);

    int insertSelective(StudentSubjectInfo record);

    StudentSubjectInfo selectByPrimaryKey(String ksbh);

    int updateByPrimaryKeySelective(StudentSubjectInfo record);

    int updateByPrimaryKey(StudentSubjectInfo record);
}