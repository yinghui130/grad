package cn.edu.ldu.grad.controller;

import java.io.IOException;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.ldu.grad.excel.ExcelReader;
import cn.edu.ldu.grad.pojo.StudentInfo;
import cn.edu.ldu.grad.service.StudentInfoService;

@RestController
@RequestMapping("/api/fileupload")
@CrossOrigin
public class FileUploadController {
	@Autowired
	StudentInfoService studentInfoService;
	@RequestMapping(value="/upload")
	String uploadFile(@PathParam(value="fileName")String fileName,@RequestParam("file") MultipartFile file) throws IOException
	{
		System.out.println(fileName+"\t"+file.getSize());
		ExcelReader excelReader =new ExcelReader();
		//excelReader.read(file.getInputStream());
		List<StudentInfo> list=excelReader.getStudentList(file.getInputStream());
		for (StudentInfo studentInfo : list) {
			studentInfoService.insertSelective(studentInfo);
		}
		return "ok";
	}
}
