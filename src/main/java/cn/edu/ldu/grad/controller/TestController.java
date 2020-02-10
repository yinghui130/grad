package cn.edu.ldu.grad.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/hello")
  public HttpEntity<?> hello() {
    return new ResponseEntity<>("系统运行成功！！", HttpStatus.OK);
  }
}
