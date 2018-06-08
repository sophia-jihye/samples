package samples.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Gmail {

	public static String userId;
	public static String passwd;
	private String emailFrom;
	private String emailTo;
	private String subject;
	private String content;

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void sendMail() {
		Properties properties = new Properties();
		properties.put("mail.smtp.user", emailFrom);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.debug", "true");
		properties.put("mail.smtp.socketFactory.port", "465");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.socketFactory.fallback", "false");

		try {
			Authenticator auth = new senderAccount();
			Session session = Session.getInstance(properties, auth);
			session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.
			MimeMessage msg = new MimeMessage(session);

			msg.setSubject(subject);
			Address fromAddr = new InternetAddress(emailFrom); // 보내는사람
																// EMAIL
			msg.setFrom(fromAddr);
			Address toAddr = new InternetAddress(emailTo); // 받는사람
			// EMAIL
			msg.addRecipient(Message.RecipientType.TO, toAddr);
			msg.setContent(content, "text/plain;charset=KSC5601");
			Transport.send(msg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static class senderAccount extends javax.mail.Authenticator {

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(userId, passwd); 

		}
	}
}
