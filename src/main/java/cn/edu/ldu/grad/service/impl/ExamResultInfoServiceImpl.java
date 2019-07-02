package cn.edu.ldu.grad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.ldu.grad.mapper.ExamResultInfoMapper;
import cn.edu.ldu.grad.pojo.ExamResultInfo;
import cn.edu.ldu.grad.service.ExamResultInfoService;

@Service
public class ExamResultInfoServiceImpl implements ExamResultInfoService {

	@Autowired
	private ExamResultInfoMapper examResultInfoMapper;
	
	@Override
	public int deleteByPrimaryKey(String bmh) {
		return this.examResultInfoMapper.deleteByPrimaryKey(bmh);
	}

	@Override
	public int insert(ExamResultInfo record) {
		return this.examResultInfoMapper.insert(record);
	}

	@Override
	public int insertSelective(ExamResultInfo record) {
		return examResultInfoMapper.insertSelective(record);
	}

	@Override
	public ExamResultInfo selectByPrimaryKey(String bmh) {
		return examResultInfoMapper.selectByPrimaryKey(bmh);
	}

	@Override
	public int updateByPrimaryKeySelective(ExamResultInfo record) {
		return examResultInfoMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(ExamResultInfo record) {
		return examResultInfoMapper.updateByPrimaryKey(record);
	}

	@Override
	public ExamResultInfo selectByXmZjhm(String xm, String zjhm) {
		// TODO Auto-generated method stub
		return examResultInfoMapper.selectByXmZjhm(xm, zjhm);
	}
	
}
