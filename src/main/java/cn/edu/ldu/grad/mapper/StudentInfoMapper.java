package cn.edu.ldu.grad.mapper;

import org.apache.ibatis.annotations.Mapper;
import cn.edu.ldu.grad.pojo.StudentInfo;

@Mapper
public interface StudentInfoMapper {
  int deleteByPrimaryKey(String personId);

  int insert(StudentInfo record);

  int insertSelective(StudentInfo record);

  StudentInfo selectByPrimaryKey(String personId);

  int updateByPrimaryKeySelective(StudentInfo record);

  int updateByPrimaryKey(StudentInfo record);
}
