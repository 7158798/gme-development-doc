package com.manage.base.util;

import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

/**
 * 发送邮件
 * @author 2715131619qq.com
 *
 */
public class SendMail {
	
	public static void send(String to,String message,String title) throws Exception {
        Properties prop = new Properties();  
        //协议
        prop.setProperty("mail.transport.protocol", "smtp");
        //服务器
        prop.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
        //端口
        prop.setProperty("mail.smtp.port", "465");
        //使用smtp身份验证
        prop.setProperty("mail.smtp.auth", "true");
        //使用SSL，企业邮箱必需！
        //开启安全协议
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //
        //获取Session对象
        Session s = Session.getDefaultInstance(prop,new MyAuthenricator("support@ninecoin.com", "yX4RtChWCQy5o8qj"));
        //设置session的调试模式，发布时取消
     //   s.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(s);
        try {
            mimeMessage.setFrom(new InternetAddress("support@ninecoin.com"));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //设置主题
            mimeMessage.setSubject(title);
            mimeMessage.setSentDate(new Date());
            //设置内容
            mimeMessage.setContent(message,"text/html;charset=utf-8");
            mimeMessage.saveChanges();
            //发送
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
	
	
	
	public static void send1(String to,String message,String title) throws Exception {
        Properties prop = new Properties();  
        //协议
        prop.setProperty("mail.transport.protocol", "smtp");
        //服务器
        prop.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
        //端口
        prop.setProperty("mail.smtp.port", "465");
        //使用smtp身份验证
        prop.setProperty("mail.smtp.auth", "true");
        //使用SSL，企业邮箱必需！
        //开启安全协议
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
        } catch (GeneralSecurityException e1) {
            e1.printStackTrace();
        }
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.smtp.ssl.socketFactory", sf);
        //
        //获取Session对象
        Session s = Session.getDefaultInstance(prop,new MyAuthenricator("support@ninecoin.com", "yX4RtChWCQy5o8qj"));
        //设置session的调试模式，发布时取消
    //    s.setDebug(true);
        MimeMessage mimeMessage = new MimeMessage(s);
        try {
            mimeMessage.setFrom(new InternetAddress("support@ninecoin.com"));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            //设置主题
            mimeMessage.setSubject(title);
            mimeMessage.setSentDate(new Date());
            //设置内容
            mimeMessage.setText(message);
            mimeMessage.saveChanges();
            //发送
            Transport.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
    }
	
	
	static class MyAuthenricator extends Authenticator{  
        String u = null;  
        String p = null;  
        public MyAuthenricator(String u,String p){  
            this.u=u;  
            this.p=p;  
        }  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() {  
            return new PasswordAuthentication(u,p);  
        }  
    }
	
}
