package cn.edu.ldu.grad.mapper;

import org.apache.ibatis.annotations.Mapper;
import cn.edu.ldu.grad.pojo.StudentSubjectInfo;

@Mapper
public interface StudentSubjectInfoMapper {
  int deleteByPrimaryKey(String ksbh);

  int insert(StudentSubjectInfo record);

  int insertSelective(StudentSubjectInfo record);

  StudentSubjectInfo selectByPrimaryKey(String ksbh);

  int updateByPrimaryKeySelective(StudentSubjectInfo record);

  int updateByPrimaryKey(StudentSubjectInfo record);
}
