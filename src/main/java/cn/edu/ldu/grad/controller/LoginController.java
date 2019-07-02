package cn.edu.ldu.grad.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator.Builder;
import com.auth0.jwt.algorithms.Algorithm;

import cn.edu.ldu.grad.intercepter.JwtOperation;
import cn.edu.ldu.grad.pojo.ExamResultInfo;
import cn.edu.ldu.grad.service.ExamResultInfoService;
import lombok.Data;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {
	@Autowired
	private ExamResultInfoService examResultInfoService;
	@Autowired 
	private HttpServletRequest request;
	
	@RequestMapping(value = "/login/{xm}/{zjhm}", method = RequestMethod.POST)
	public Token getExamResultInfo(@PathVariable("xm") String xm, @PathVariable("zjhm") String zjhm)
			throws IllegalArgumentException, UnsupportedEncodingException {
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			System.out.println(key + ":" + value);
		}
		Token token = new Token();
		ExamResultInfo examResultInfo = examResultInfoService.selectByXmZjhm(xm, zjhm);
		if (examResultInfo == null) {
			token.setStatus(false);
		} else {
			Date date = new Date();
			long times = date.getTime() + 60 * 8 * 60 * 1000;
			date.setTime(times);
			Algorithm algorithm = Algorithm.HMAC256(JwtOperation.SECRET);
			Builder tokenBuilder = JWT.create().withIssuer(JwtOperation.PUBLISHER)
					.withClaim("username", examResultInfo.getXm()).withExpiresAt(date);
			String tokenStr = tokenBuilder.sign(algorithm);
			token.setExamResultInfo(examResultInfo);
			token.setStatus(true);
			token.setToken(tokenStr);
		}
		return token;
	}

	@Data
	class Token {
		private boolean status;
		private String token;
		private ExamResultInfo examResultInfo;
	}
}
