package cn.edu.ldu.grad.controller;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.ldu.grad.mapper.StuExamCheckInfoMapper;
import cn.edu.ldu.grad.mapper.StudentInfoMapper;
import cn.edu.ldu.grad.mapper.StudentSubjectInfoMapper;
import cn.edu.ldu.grad.pojo.StuExamCheckInfo;
import cn.edu.ldu.grad.pojo.StudentInfo;
import cn.edu.ldu.grad.pojo.StudentSubjectInfo;

@RestController
@CrossOrigin
@RequestMapping("/api/student")
public class StudentController {
  @Autowired
  private StudentInfoMapper studentInfoMapper;
  @Autowired
  private StudentSubjectInfoMapper studentSubjectInfoMapper;
  @Autowired
  private StuExamCheckInfoMapper stuExamCheckInfoMapper;

  @PostMapping("/login/{username}/{password}/{type}")
  public HttpEntity<?> logIn(@PathVariable(value = "username", required = true) String username,
      @PathVariable(value = "password", required = true) String password,
      @PathVariable(value = "type", required = false) String type) {
    if (Strings.isBlank(type)) {
      StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(password);
      return new ResponseEntity<>(studentInfo, HttpStatus.OK);
    } else {
      StudentSubjectInfo stuSubInfo = studentSubjectInfoMapper.selectByPrimaryKey(username);
      return new ResponseEntity<>(stuSubInfo, HttpStatus.OK);
    }
  }

  @PostMapping("/update")
  public HttpEntity<?> update(@RequestBody StudentInfo info) {
    studentInfoMapper.updateByPrimaryKey(info);
    return new ResponseEntity<>(true, HttpStatus.OK);

  }

  @PostMapping("/getStuExamCheckList/{ksbh}")
  public HttpEntity<?> getStuExamCheckList(
      @PathVariable(value = "ksbh", required = true) String ksbh) {
    List<StuExamCheckInfo> list = stuExamCheckInfoMapper.selectByKsbh(ksbh);
    return new ResponseEntity<>(list, HttpStatus.OK);
  }

  @PostMapping("/saveStuExamCheckList/{ksbh}")
  public HttpEntity<?> saveStuExamCheckList(
      @PathVariable(value = "ksbh", required = true) String ksbh,
      @RequestBody List<StuExamCheckInfo> list) {
    stuExamCheckInfoMapper.deleteByKsbh(ksbh);
    if (list.size() > 0) {
      Date date = new Date();
      for (StuExamCheckInfo stuExamCheckInfo : list) {
        stuExamCheckInfo.setSumitTime(date);
        stuExamCheckInfoMapper.insert(stuExamCheckInfo);
      }
    }
    return new ResponseEntity<>(true, HttpStatus.OK);
  }
}
