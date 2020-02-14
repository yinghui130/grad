package cn.edu.ldu.grad.service;

import cn.edu.ldu.grad.pojo.StuExamCheckInfo;
import cn.edu.ldu.grad.pojo.StuExamCheckInfoKey;

public interface StuExamCheckInfoService {
    int deleteByPrimaryKey(StuExamCheckInfoKey key);

    int insert(StuExamCheckInfo record);

    int insertSelective(StuExamCheckInfo record);

    StuExamCheckInfo selectByPrimaryKey(StuExamCheckInfoKey key);

    int updateByPrimaryKeySelective(StuExamCheckInfo record);

    int updateByPrimaryKey(StuExamCheckInfo record);
}