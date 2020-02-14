package cn.edu.ldu.grad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.ldu.grad.mapper.StuExamCheckInfoMapper;
import cn.edu.ldu.grad.pojo.StuExamCheckInfo;
import cn.edu.ldu.grad.pojo.StuExamCheckInfoKey;
import cn.edu.ldu.grad.service.StuExamCheckInfoService;

@Service
public class StuExamCheckInfoServiceImpl implements StuExamCheckInfoService {
  @Autowired
  private StuExamCheckInfoMapper stuExamCheckInfoMapper;

  public int deleteByPrimaryKey(StuExamCheckInfoKey key) {
    return stuExamCheckInfoMapper.deleteByPrimaryKey(key);
  }

  public int insert(StuExamCheckInfo record) {
    return stuExamCheckInfoMapper.insert(record);
  }

  public int insertSelective(StuExamCheckInfo record) {
    return stuExamCheckInfoMapper.insertSelective(record);
  }

  public StuExamCheckInfo selectByPrimaryKey(StuExamCheckInfoKey key) {
    return stuExamCheckInfoMapper.selectByPrimaryKey(key);
  }

  public int updateByPrimaryKeySelective(StuExamCheckInfo record) {
    return stuExamCheckInfoMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(StuExamCheckInfo record) {
    return stuExamCheckInfoMapper.updateByPrimaryKey(record);
  }
}
