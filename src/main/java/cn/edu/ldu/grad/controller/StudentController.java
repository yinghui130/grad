package cn.edu.ldu.grad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.ldu.grad.mapper.StudentInfoMapper;
import cn.edu.ldu.grad.pojo.StudentInfo;

@RestController
@CrossOrigin
@RequestMapping("/api/student")
public class StudentController {
  @Autowired
  private StudentInfoMapper studentInfoMapper;

  @PostMapping("/login/{username}/{password}")
  public HttpEntity<?> logIn(@PathVariable(value = "username", required = true) String username,
      @PathVariable(value = "password", required = true) String password) {
    StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(password);
    return new ResponseEntity<>(studentInfo, HttpStatus.OK);
  }
  @PostMapping("/update")
  public HttpEntity<?> update(@RequestBody StudentInfo info){
    studentInfoMapper.updateByPrimaryKey(info);
    return new ResponseEntity<>(true,HttpStatus.OK);
    
  }
}
