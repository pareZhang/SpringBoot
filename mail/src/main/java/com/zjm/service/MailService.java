package com.zjm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;

    /**
     * 发送简单邮件
     * @param from
     * @param to
     * @param cc
     * @param subject
     * @param content
     */
    public void sendSimpleMail(String from,String to,String cc,String subject,String content){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom(from); //发送者
        simpleMailMessage.setTo(to);    //收件人
        simpleMailMessage.setCc(cc);    //抄送人
        simpleMailMessage.setSubject(subject);  //邮件主题
        simpleMailMessage.setText(content);     //邮件内容
        javaMailSender.send(simpleMailMessage);
    }

    /**
     * 发送带附件的邮件
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param file
     */
    public void sendAttachFileMail(String from, String to, String subject, String content, File file){
        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true); //true表示构造一个multipart message类型的邮件，multipart message类型的邮件包含多个正文，附件以及内嵌资源
            helper.setFrom(from);
            helper.setTo(to);
            helper.setText(content);
            helper.addAttachment(file.getName(),file); //添加附件
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 在发送邮件时分别传入图片资源路径和资源id，通过FileSystemResource构造静态资源，然后调用addInline方法将资源添加到邮件对象中
     * @param from
     * @param to
     * @param subject
     * @param content
     * @param srcPath
     * @param resIds
     */
    public void sendMailWithImg(String from,String to,String subject,String content,String[] srcPath,String[] resIds){
        if (srcPath.length!=resIds.length){
            System.out.println("发送失败！");
            return;
        }
        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            for (int i=0;i<srcPath.length;i++){
                FileSystemResource res=new FileSystemResource(new File(srcPath[i]));
                helper.addInline(resIds[i],res);
            }
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
