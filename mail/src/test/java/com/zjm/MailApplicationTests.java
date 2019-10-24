package com.zjm;

import com.zjm.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailApplicationTests {
	@Autowired
	private MailService mailService;
	@Test
	public void sendSimpleMail(){
		mailService.sendSimpleMail("pareZhang@126.com",
				"pareZhangj@126.com",
				"pareZhangjm@126.com",
				"测试邮件主题",
				"测试邮件内容");
	}
	@Test
	public void sendAttachFileMail(){
		mailService.sendAttachFileMail("pareZhang@126.com",
				"pareZhangj@126.com",
				"附件邮件主题",
				"测试邮件内容",
				new File("C:\\Users\\zjm\\Desktop\\新建文本文档.TXT"));
	}
	@Test
	public void sendMailWithImg(){
		mailService.sendMailWithImg("pareZhang@126.com",
				"pareZhangj@126.com",
				"测试邮件主题（图片）",
				"<div>hello，这是一封带图片资源的邮件：" +
						 "这是图片1：<div><img src='cid:p01'/></div>" +
						 "这是图片2：<div><img src='cid:p02'/></div>"+
						 "</div>",
				new String[]{"C:\\Users\\zjm\\Desktop\\123.PNG","C:\\Users\\zjm\\Desktop\\456.PNG"},
				new String[]{"p01","p02"});
	}
}
