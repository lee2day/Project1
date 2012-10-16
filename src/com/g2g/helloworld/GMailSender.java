package com.g2g.helloworld;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import android.util.Log;

public class GMailSender {
	private String mMailHost = "smtp.gmail.com";
	private Session mSession;

	public GMailSender(String user, String pwd)	{
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", mMailHost);
		mSession = Session.getInstance(props, new EmailAuthenticator(user, pwd));
	} // constructor

	public void sendMail(String subject, String body, String sender,
			String recipients)
	{
		try {
			Message msg = new MimeMessage(mSession);
			msg.setFrom(new InternetAddress(sender));
			msg.setSubject(subject);
			msg.setContent(body, "text/html;charset=EUC-KR");
			msg.setSentDate(new Date());
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
			
			Transport.send(msg);
		} 
		catch (Exception e) {
			Log.d("lastiverse", "Exception occured : ");
			Log.d("lastiverse", e.toString());
			Log.d("lastiverse", e.getMessage());
		} 
	} 
	
	public void sendMailWithFile(String subject, String body, String sender,
			String recipients, String filePath, String fileName) {
		try {
			Message msg = new MimeMessage(mSession);
			msg.setFrom(new InternetAddress(sender));
			msg.setSubject(subject);
			msg.setContent(body, "text/html;charset=EUC-KR");
			msg.setSentDate(new Date());
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));

			MimeBodyPart attachPart = new MimeBodyPart();
			attachPart.setDataHandler(new DataHandler(new FileDataSource(new File(filePath))));
			
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(attachPart);
			
			msg.setContent(multipart);
			msg.setFileName(fileName);
			
			Transport.send(msg);
			
			Log.d("lastiverse", "sent");
		} 
		catch (Exception e) {
			Log.d("lastiverse", "Exception occured : ");
			Log.d("lastiverse", e.toString());
			Log.d("lastiverse", e.getMessage());
		} 
	}

	class EmailAuthenticator extends Authenticator {
		private String id;
		private String pw;

		public EmailAuthenticator(String id, String pw) {
			super();
			this.id = id;
			this.pw = pw;
		} // constructor

		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(id, pw);
		} 
	}
}