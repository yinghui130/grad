package cn.edu.ldu.grad.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import cn.edu.ldu.grad.pojo.ExamResultInfo;
@Mapper
public interface ExamResultInfoMapper {
    int deleteByPrimaryKey(String bmh);

    int insert(ExamResultInfo record);

    int insertSelective(ExamResultInfo record);

    ExamResultInfo selectByPrimaryKey(String bmh);
    
    ExamResultInfo selectByXmZjhm(@Param("xm")String xm,@Param("zjhm")String zjhm);
    
    int updateByPrimaryKeySelective(ExamResultInfo record);

    int updateByPrimaryKey(ExamResultInfo record);
}