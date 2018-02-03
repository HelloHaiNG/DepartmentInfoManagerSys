package com.intelligent.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sun.mail.util.MailSSLSocketFactory;

public class Utils {
	private HttpServletResponse response = ServletActionContext.getResponse();

	public void download(File file) {
		try {
			InputStream inputStream = new BufferedInputStream(
					new FileInputStream(file));
			/* 第三步：创建缓冲区，大小为流的最大字符数 */
			byte[] buffer = new byte[inputStream.available()]; // int
																// available()
																// 返回值为流中尚未读取的字节的数量
			/* 第四步：从文件输入流读字节流到缓冲区 */
			inputStream.read(buffer);
			/* 第五步： 关闭输入流 */
			inputStream.close();

			String fileName = file.getName();// 获取文件名
			// response.reset();
			response.addHeader("Content-Disposition", "attachment;filename="
					+ new String(fileName.getBytes("utf-8"), "iso8859-1"));
			response.addHeader("Content-Length", "" + file.length());

			/* 第六步：创建文件输出流 */
			OutputStream outputStream = new BufferedOutputStream(
					response.getOutputStream());
			response.setContentType("application/octet-stream");
			/* 第七步：把缓冲区的内容写入文件输出流 */
			outputStream.write(buffer);
			/* 第八步：刷空输出流，并输出所有被缓存的字节 */
			outputStream.flush();
			/* 第九步：关闭输出流 */
			outputStream.close();
			
		} catch (Exception e) {
		}
	}

	public void mail() {
		try {
			// 收件人电子邮箱
			String to = "hong.liao@cygia.com";
			// 发件人电子邮箱
			String from = "hong.liao@cygia.com";
			// 指定发送邮件的主机为 smtp.qq.com
			String host = "mail.cygia.com"; // QQ 邮件服务器
			// 获取系统属性
			Properties properties = System.getProperties();
			// 设置邮件服务器
			properties.setProperty("mail.smtp.host", host);
			properties.put("mail.smtp.auth", "true");
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
			// 获取默认session对象
			Session session = Session.getDefaultInstance(properties,
					new Authenticator() {
						public PasswordAuthentication getPasswordAuthentication() { // qq邮箱服务器账户、第三方登录授权码
							return new PasswordAuthentication(
									"hong.liao@cygia.com", "HelloHaiNG"); // 发件人邮件用户名、密码
						}
					});
			try {
				// 创建默认的 MimeMessage 对象
				MimeMessage message = new MimeMessage(session);
				// Set From: 头部头字段
				message.setFrom(new InternetAddress(from));
				// Set To: 头部头字段
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));
				// Set Subject: 主题文字
				message.setSubject("java发送邮件");
				// 创建消息部分
				BodyPart messageBodyPart = new MimeBodyPart();
				// 消息
				messageBodyPart.setText("发送成功怎么说");
				// 创建多重消息
				Multipart multipart = new MimeMultipart();
				// 设置文本消息部分
				multipart.addBodyPart(messageBodyPart);
				// 附件部分
				messageBodyPart = new MimeBodyPart();
				// 设置要发送附件的文件路径
				String filename = "C:/Users/dmrj/Desktop/a.txt";
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				// messageBodyPart.setFileName(filename);
				// 处理附件名称中文（附带文件路径）乱码问题
				messageBodyPart.setFileName(MimeUtility.encodeText(filename));
				multipart.addBodyPart(messageBodyPart);
				// 发送完整消息
				message.setContent(multipart);
				// 发送消息
				Transport.send(message);
				System.out.println("Sent message successfully....");
			} catch (MessagingException mex) {
				mex.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
