package samples.mail;

public class Main {
	public static void main(String[] args) {

		// avast ≤Ù∞Ì Ω««‡«œªÔ.... §–§–§–§–§ª
		String userId = "sophia.jihyeparkk";
		String passwd = "111111";
		String emailFrom = "sophia.jihyeparkk@gmail.com";
		String emailTo = "jihyeparkk@naver.com";
		String subject = "test1";
		String content = "test1";

		Gmail gmail = new Gmail();
		Gmail.userId = userId;
		Gmail.passwd = passwd;
		gmail.setEmailFrom(emailFrom);
		gmail.setEmailTo(emailTo);
		gmail.setSubject(subject);
		gmail.setContent(content);

		gmail.sendMail();
	}
}
