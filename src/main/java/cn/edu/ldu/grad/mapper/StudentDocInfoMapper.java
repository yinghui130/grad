package cn.edu.ldu.grad.mapper;

import cn.edu.ldu.grad.pojo.StudentDocInfo;

public interface StudentDocInfoMapper {
    int deleteByPrimaryKey(String zjhm);

    int insert(StudentDocInfo record);

    int insertSelective(StudentDocInfo record);

    StudentDocInfo selectByPrimaryKey(String zjhm);

    int updateByPrimaryKeySelective(StudentDocInfo record);

    int updateByPrimaryKey(StudentDocInfo record);
}