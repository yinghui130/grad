package cn.edu.ldu.grad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.ldu.grad.mapper.StudentInfoMapper;
import cn.edu.ldu.grad.pojo.StudentInfo;
import cn.edu.ldu.grad.service.StudentInfoService;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {

	@Autowired
	private StudentInfoMapper studentInfoMapper;
	@Override
	public int deleteByPrimaryKey(String personId) {
		// TODO Auto-generated method stub
		return this.studentInfoMapper.deleteByPrimaryKey(personId);
	}

	@Override
	public int insert(StudentInfo record) {
		// TODO Auto-generated method stub
		return this.studentInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int insertSelective(StudentInfo record) {
		// TODO Auto-generated method stub
		return this.studentInfoMapper.insertSelective(record);
	}

	@Override
	public StudentInfo selectByPrimaryKey(String personId) {
		// TODO Auto-generated method stub
		return this.studentInfoMapper.selectByPrimaryKey(personId);
	}

	@Override
	public int updateByPrimaryKeySelective(StudentInfo record) {
		// TODO Auto-generated method stub
		return this.studentInfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKey(StudentInfo record) {
		// TODO Auto-generated method stub
		return this.studentInfoMapper.updateByPrimaryKey(record);
	}

}
