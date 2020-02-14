package cn.edu.ldu.grad.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import cn.edu.ldu.grad.pojo.StuExamCheckInfo;
import cn.edu.ldu.grad.pojo.StuExamCheckInfoKey;

@Mapper
public interface StuExamCheckInfoMapper {
  int deleteByPrimaryKey(StuExamCheckInfoKey key);

  int deleteByKsbh(String ksbh);

  int insert(StuExamCheckInfo record);

  int insertSelective(StuExamCheckInfo record);

  StuExamCheckInfo selectByPrimaryKey(StuExamCheckInfoKey key);

  List<StuExamCheckInfo> selectByKsbh(String Ksbh);

  int updateByPrimaryKeySelective(StuExamCheckInfo record);

  int updateByPrimaryKey(StuExamCheckInfo record);
}
