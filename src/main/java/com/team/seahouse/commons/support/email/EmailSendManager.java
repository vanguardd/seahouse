package com.team.seahouse.commons.support.email;


import com.team.seahouse.commons.utils.DateUtils;
import com.team.seahouse.commons.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @Title: 邮件发送支持类
 * @Description: 包含发送普通邮件、设置邮件附件和以thymeleaf模板发送邮件
 * @Author: vanguard
 * @Version: 1.0
 * @Date: 18/7/21
 */
@SuppressWarnings("deprecation")
public class EmailSendManager {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String mailSenderAddress;

	@Autowired
	private TemplateEngine templateEngine;
	
	public boolean sendMail(EmailMsg emailMsg) {
		try{
			//使用JavaMail的MimeMessage，支付更加复杂的邮件格式和内容
			MimeMessage mime = javaMailSender.createMimeMessage();
			
			//创建MimeMessageHelper对象，处理MimeMessage的辅助类  
			MimeMessageHelper helper = new MimeMessageHelper(mime, true);
            
			// 设置发件人邮箱
            Address address = new InternetAddress(mailSenderAddress, emailMsg.getFromName());
            helper.setFrom((InternetAddress) address);
			
            //设置收件人
			if (emailMsg.getToEmails() != null && emailMsg.getToEmails().trim().length() > 0) {
				String[]  to= emailMsg.getToEmails().split(";");
				helper.setTo(to);
			}
			
			//设置抄送
			if (emailMsg.getCcEmails() != null && emailMsg.getCcEmails().trim().length() > 0) {
				String[] cc = emailMsg.getCcEmails().split(";");
				helper.setCc(cc);
			}
			
			// 设置邮件主题
			helper.setSubject(emailMsg.getSubject());
			
			// 设置邮件内容：true表示设定html格式
            if (emailMsg.getContent()!=null) {
            	helper.setText(emailMsg.getContent(), true);
            } else {
            	this.sendWithTemplate(emailMsg, helper);
            }
            
            //设置邮件图片
            if (null != emailMsg.getPictures()) {
                this.setAddInline(emailMsg, helper);
            }
            
            //设置邮件附件
            if (null != emailMsg.getAttachments()) {
                this.setAddAttachment(emailMsg, helper);           	
            }

            //设置邮件发送时间
            if (null != emailMsg.getSendTime()) {
            	helper.setSentDate(emailMsg.getSendTime());
            }else {
                helper.setSentDate(new Date());
            }

            //设置thymeleaf为模板发送邮件
            if(null != emailMsg.getThymeleafTemplate()) {
            	this.sendWithTemplate(emailMsg, helper);
			}

            // 发送邮件 
			javaMailSender.send(mime);
            LoggerUtils.info(EmailSendManager.class, "发送了一封邮件<" + emailMsg.getToEmails() + ">,主题为<" + emailMsg.getSubject() + ">,时间为<" + DateUtils.formatDateTime(new Date()) + ">");
			return true;
		}catch(Exception e){
			LoggerUtils.error(EmailSendManager.class, "发送邮件失败", e);
			return false;
		}
	}

	/**
	 * 加入图片文件
	 * @param emailMsg
	 * @param helper
	 */
	private void setAddInline(EmailMsg emailMsg, MimeMessageHelper helper){
        // 添加图片
        for (Iterator<Map.Entry<String, String>> it = emailMsg.getPictures().entrySet().iterator(); it.hasNext();) {
            Map.Entry<String, String> entry = it.next();
            String cid = entry.getKey();
            String filePath = entry.getValue();
            File file = new File(filePath);
            FileSystemResource img = new FileSystemResource(file);
            try {
				helper.addInline(cid, img);
			} catch (MessagingException e) {
            	LoggerUtils.error(EmailSendManager.class, "EmailSendManager.setAddInline={}", e);
			}
        }
	}
	
	/**
	 * 加入附件
	 * @param emailMsg
	 * @param helper
	 */
	private void setAddAttachment(EmailMsg emailMsg, MimeMessageHelper helper) {
		for (Iterator<Map.Entry<String, String>> it = emailMsg.getAttachments().entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, String> entry = it.next();
			String cid = entry.getKey();
			String filePath = entry.getValue();
			File file = new File(filePath);
			FileSystemResource fileResource = new FileSystemResource(file);
			try {
				helper.addAttachment(cid, fileResource);
			} catch (MessagingException e) {
				LoggerUtils.info(EmailSendManager.class, "EmailSendManager.setAddAttachment={}", e);
			}
		}
	}

	/**
	 * 以thymeleaf为模板发送邮件
	 * @param emailMsg
	 * @param helper
	 */
	private void sendWithTemplate(EmailMsg emailMsg, MimeMessageHelper helper) {
		try {
			//获取thymeleaf的html模板
			String emailContext = templateEngine.process(emailMsg.getThymeleafTemplate(), emailMsg.getContext());
			helper.setText(emailContext, true);
		} catch (Exception e) {
			LoggerUtils.error(EmailSendManager.class, "EmailSendManager.sendWithTemplate={}", e);
		}
	}

}
