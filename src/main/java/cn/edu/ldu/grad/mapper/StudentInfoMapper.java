package cn.edu.ldu.grad.mapper;

import cn.edu.ldu.grad.pojo.StudentInfo;

public interface StudentInfoMapper {
    int deleteByPrimaryKey(String personId);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    StudentInfo selectByPrimaryKey(String personId);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
}