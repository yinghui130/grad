package cn.edu.ldu.grad.service.html;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import cn.edu.ldu.grad.pojo.ExamResultInfo;
import cn.edu.ldu.grad.service.ExamResultInfoService;

@Service
public class HtmlGenerator {
	@Autowired
	private ExamResultInfoService examResultInfoService;
	@Autowired
	Environment environment;
	
	public String getHtml(String bmh) throws IOException {
		Resource htmlResource = new ClassPathResource("pdf/html_template/成绩单.html");
		File htmlFile = htmlResource.getFile();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(htmlFile)));
		StringBuilder stringBuilder = new StringBuilder();// 定义一个字符串缓存，将字符串存放缓存中
		String s = "";
		while ((s = bufferedReader.readLine()) != null) {// 逐行读取文件内容，不读取换行符和末尾的空格
			stringBuilder.append(s);// 将读取的字符串添加换行符后累加存放在缓存中
		}
		bufferedReader.close();
		ExamResultInfo examResultInfo = this.examResultInfoService.selectByPrimaryKey(bmh);
		String picNo=String .format("%d_%s", DateTime.now().getYear()-2001,bmh);
		String html=stringBuilder.toString();
		html=html//.replace("[#port#]",environment.getProperty("server.port")) //titlePicFile.getPath().replace("\\","/"))
		.replace("[#year#]", DateTime.now().getYear()+"")
		.replace("[#picno#]", picNo)
		.replace("[#xm#]",examResultInfo.getXm())
		.replace("[#ksbh#]",examResultInfo.getKsbh())
		.replace("[#bkzydm#]",examResultInfo.getBkzydm())
		.replace("[#bkzymc#]",examResultInfo.getBkzymc())
		.replace("[#bkyxsmc#]",examResultInfo.getBkyxsmc())
		.replace("[#bkxxfsmc#]",examResultInfo.getBkxxfsmc())
		.replace("[#zzllmc#]",examResultInfo.getZzllmc())
		.replace("[#zzll#]",examResultInfo.getZzll()+"")
		.replace("[#wgym#]",examResultInfo.getWgym())
		.replace("[#wgymc#]",examResultInfo.getWgymc())
		.replace("[#wgy#]",examResultInfo.getWgy()+"")
		.replace("[#ywk1m#]",examResultInfo.getYwk1m())
		.replace("[#ywk1mc#]",examResultInfo.getYwk1mc())
		.replace("[#ywk1#]",examResultInfo.getYwk1()+"")
		.replace("[#ywk2m#]",examResultInfo.getYwk2m())
		.replace("[#ywk2mc#]",examResultInfo.getYwk2mc())
		.replace("[#ywk2#]",examResultInfo.getYwk2()+"")
		.replace("[#zf#]",examResultInfo.getZf()+"")
		.replace("[#zzllm#]",examResultInfo.getZzllm());
		////System.out.println(html);
		return html;
	}
}
