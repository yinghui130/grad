package cn.edu.ldu.grad.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.ldu.grad.mapper.StuExamCheckInfoMapper;
import cn.edu.ldu.grad.mapper.StudentDocInfoMapper;
import cn.edu.ldu.grad.mapper.StudentInfoMapper;
import cn.edu.ldu.grad.mapper.StudentSubjectInfoMapper;
import cn.edu.ldu.grad.pojo.StuExamCheckInfo;
import cn.edu.ldu.grad.pojo.StudentDocInfo;
import cn.edu.ldu.grad.pojo.StudentInfo;
import cn.edu.ldu.grad.pojo.StudentSubjectInfo;
import cn.edu.ldu.grad.service.html.HtmlGenerator;
import cn.edu.ldu.grad.utils.PDFUtil;

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
  @Autowired
  private StudentDocInfoMapper studentDocInfoMapper;
  @Autowired
  private HtmlGenerator htmlGenerator;

  @PostMapping("/login/{username}/{password}/{type}")
  public HttpEntity<?> logIn(@PathVariable(value = "username", required = true) String username,
      @PathVariable(value = "password", required = true) String password,
      @PathVariable(value = "type", required = true) String type) {
    if (type.toLowerCase().equals("stu")) {
      StudentInfo studentInfo = studentInfoMapper.selectByPrimaryKey(password);
      if (studentInfo != null && !studentInfo.getName().equals(username))
        studentInfo = null;
      return new ResponseEntity<>(studentInfo, HttpStatus.OK);
    } else if (type.toLowerCase().equals("doc")) {
      StudentDocInfo studentDocInfo = studentDocInfoMapper.selectByPrimaryKey(password);
      if (studentDocInfo != null && !studentDocInfo.getXm().equals(username))
        studentDocInfo = null;
      return new ResponseEntity<>(studentDocInfo, HttpStatus.OK);
    } else {
      StudentSubjectInfo stuSubInfo = studentSubjectInfoMapper.selectByPrimaryKey(username);
      if (stuSubInfo != null && !stuSubInfo.getZjhm().equals(password))
        stuSubInfo = null;
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

  @PostMapping("/updateDownloadDate/{userId}")
  public HttpEntity<?> updateDownloadDate(
      @PathVariable(value = "userId", required = true) String userId) {
    StudentDocInfo studentDocInfo = this.studentDocInfoMapper.selectByPrimaryKey(userId);
    Date downloadDate = new Date();
    studentDocInfo.setDownloadDate(downloadDate);
    this.studentDocInfoMapper.updateByPrimaryKey(studentDocInfo);
    return new ResponseEntity<>(downloadDate, HttpStatus.OK);
  }

  @RequestMapping(value = "/print", method = RequestMethod.GET)
  public void getStudentDocPDF(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    String userId = request.getParameter("userId");
    StudentDocInfo studentDocInfo = this.studentDocInfoMapper.selectByPrimaryKey(userId);
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", String.format("filename=%s.pdf", userId));
    if (studentDocInfo.getLqlbm().equals("12")) {
      Resource htmlResource = new ClassPathResource("pdf/定向协议书.pdf");
      File htmlFile = htmlResource.getFile();
      OutputStream os = null;
      BufferedInputStream bis = new BufferedInputStream(new FileInputStream(htmlFile));
      byte[] b = new byte[bis.available() + 1000];
      int i = 0;
      os = response.getOutputStream(); // 直接下载导出
      while ((i = bis.read(b)) != -1) {
        os.write(b, 0, i);
        os.flush();
        os.close();
      }
    }
    if (studentDocInfo.getLqlbm().equals("11")) {
      String html = htmlGenerator.getStudentDoc(userId);
      String virtualPath = request.getContextPath();
      if (virtualPath == null || virtualPath.isEmpty()) {
        virtualPath = "";
      }
      System.out.println(String.format("%s\t%s\t%s", request.getLocalPort(),
          request.getServerPort(), request.getRemotePort()));
      html = html.replace("[#virtualPath#]", virtualPath).replace("[#port#]",
          request.getLocalPort() + "");

      PDFUtil.createPDF(response.getOutputStream(), html);
    }
  }
}
