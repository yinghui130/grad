package cn.edu.ldu.grad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.ldu.grad.mapper.StudentSubjectInfoMapper;
import cn.edu.ldu.grad.pojo.StudentSubjectInfo;
import cn.edu.ldu.grad.service.StudentSubjectInfoService;

@Service
public class StudentSubjectInfoServiceImpl implements StudentSubjectInfoService {
  @Autowired
  private StudentSubjectInfoMapper studentSubjectInfoMapper;

  public int deleteByPrimaryKey(String ksbh) {
    return this.studentSubjectInfoMapper.deleteByPrimaryKey(ksbh);
  }

  public int insert(StudentSubjectInfo record) {
    return this.studentSubjectInfoMapper.insert(record);
  }

  public int insertSelective(StudentSubjectInfo record) {
    return this.studentSubjectInfoMapper.insertSelective(record);
  }

  public StudentSubjectInfo selectByPrimaryKey(String ksbh) {
    return this.studentSubjectInfoMapper.selectByPrimaryKey(ksbh);
  }

  public int updateByPrimaryKeySelective(StudentSubjectInfo record) {
    return this.studentSubjectInfoMapper.updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(StudentSubjectInfo record) {
    return this.studentSubjectInfoMapper.updateByPrimaryKey(record);
  }
}
