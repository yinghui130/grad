package cn.edu.ldu.grad.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.edu.ldu.grad.pojo.ExamResultInfo;
import cn.edu.ldu.grad.service.ExamResultInfoService;
import cn.edu.ldu.grad.service.html.HtmlGenerator;
import cn.edu.ldu.grad.utils.PDFUtil;

@RestController
@RequestMapping("/api/exam")
@CrossOrigin
public class ExamController {
  @Autowired
  private ExamResultInfoService examResultInfoService;
  @Autowired
  private HtmlGenerator htmlGenerator;

  @PostMapping("/login")
  public HttpEntity<?> logIn(@RequestParam(value = "username", required = true) String username,
      @RequestParam(value = "password", required = true) String password) {
    ExamResultInfo examResultInfo = examResultInfoService.selectByXmZjhm(username, password);
    return new ResponseEntity<>(examResultInfo, HttpStatus.OK);
  }

  @RequestMapping(value = "/getExamResultInfo/{xm}/{zjhm}/{type}", method = RequestMethod.POST)
  public ExamResultInfo getExamResultInfo(@PathVariable("xm") String xm,
      @PathVariable("zjhm") String zjhm,
      @PathVariable(value = "type", required = true) String type) {
    return examResultInfoService.selectByXmZjhm(xm, zjhm);
  }

  @RequestMapping(value = "/print", method = RequestMethod.GET)
  public void getExamResultInfo(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    String bmh = request.getParameter("bmh");
    String html = htmlGenerator.getHtml(bmh);
    String virtualPath = request.getContextPath();
    if (virtualPath == null || virtualPath.isEmpty()) {
      virtualPath = "";
    }
    System.out.println(String.format("%s\t%s\t%s", request.getLocalPort(), request.getServerPort(),
        request.getRemotePort()));
    html = html.replace("[#virtualPath#]", virtualPath).replace("[#port#]",
        request.getLocalPort() + "");
    response.setContentType("application/pdf");
    response.setHeader("Content-Disposition", String.format("filename=%s.pdf", bmh));
    PDFUtil.createPDF(response.getOutputStream(), html);
  }
}
