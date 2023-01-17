package mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSenderService {
	
	public static void main(String[] args) {
	    String destinatario =  "tomas.gonzalez@estudiantes.utec.edu.uy"; //A quien le quieres escribir.
	    String destinatario2 =  "maria.noguera@estudiantes.utec.edu.uy";
	    String destinatario3 =  "mahil.gallardo@estudiantes.utec.edu.uy";
//	    String destinatario =  "tomas.com9@gmail.com";
	    String asunto = "Administración - Activación de cuenta";
	    String cuerpo = "<i style=\"margin-left: 30px;\">Prueba con JavaMail</i>\r\n"
	    		+ "	<p style=\"font-size: 18px;margin-left: 30px;\">\r\n"
	    		+ "		Su cuenta ha sido\r\n"
	    		+ "		<font color=\"#00A7F0\"> \r\n"
	    		+ "			activada \r\n"
	    		+ "		</font>\r\n"
	    		+ "		con éxito.\r\n"
	    		+ "	<br>\r\n"
	    		+ "		Ya puede iniciar sesión en la aplicación de UTEC.\r\n"
	    		+ "	</p>\r\n"
	    		+ "	<div dir=\"ltr\"><td width=\"70\">\r\n"
	    		+ "        <a href=\"https://mandrillapp.com/track/click/30706855/edu2.utec.edu.uy?p=eyJzIjoiX3JWLXJuWEd5UU1FcEJBOS1RaDZ0MDE1SFpFIiwidiI6MSwicCI6IntcInVcIjozMDcwNjg1NSxcInZcIjoxLFwidXJsXCI6XCJodHRwczpcXFwvXFxcL2VkdTIudXRlYy5lZHUudXlcXFwvP3V0bV9zb3VyY2U9c3R1ZGVudCZ1dG1fY2FtcGFpZ249YWNjb3VudGFjdGl2YXRpb24mdXRtX21lZGl1bT1lbWFpbCZ1dG1fY29udGVudD03MzU3ZDIxNi05MGVlLTRiNjYtODg0Ny0wNDdmM2MxODg1YzBcIixcImlkXCI6XCI5OTZlYWQzNDUxMzg0OWVjYTg0YmFhN2U0N2QyZDM0OFwiLFwidXJsX2lkc1wiOltcImQ3YTU5NmZkMGFlODgyNWE4NjU3Njk3ZWE1MWI5ZWZhYTczODM0ZTNcIl19In0\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://mandrillapp.com/track/click/30706855/edu2.utec.edu.uy?p%3DeyJzIjoiX3JWLXJuWEd5UU1FcEJBOS1RaDZ0MDE1SFpFIiwidiI6MSwicCI6IntcInVcIjozMDcwNjg1NSxcInZcIjoxLFwidXJsXCI6XCJodHRwczpcXFwvXFxcL2VkdTIudXRlYy5lZHUudXlcXFwvP3V0bV9zb3VyY2U9c3R1ZGVudCZ1dG1fY2FtcGFpZ249YWNjb3VudGFjdGl2YXRpb24mdXRtX21lZGl1bT1lbWFpbCZ1dG1fY29udGVudD03MzU3ZDIxNi05MGVlLTRiNjYtODg0Ny0wNDdmM2MxODg1YzBcIixcImlkXCI6XCI5OTZlYWQzNDUxMzg0OWVjYTg0YmFhN2U0N2QyZDM0OFwiLFwidXJsX2lkc1wiOltcImQ3YTU5NmZkMGFlODgyNWE4NjU3Njk3ZWE1MWI5ZWZhYTczODM0ZTNcIl19In0&amp;source=gmail&amp;ust=1673737947298000&amp;usg=AOvVaw0_qckE5f8UdqVvs5Oq_kAU\"><img src=\"https://ci3.googleusercontent.com/proxy/YUGSpIS9zBhslG7dk-qDEmzAX9aAh1wZBMMMkQo356LH90zYQiAusI01n6sQdDh-XZaFyFNUneClRFENyJNFqh6uwStesuHC10GDOvCoMzXidBw=s0-d-e1-ft#https://edx-utec-static.s3-sa-east-1.amazonaws.com/Logo_UTEC.png\" width=\"160\" height=\"86\" alt=\"Ve a la página principal de EDU \" class=\"CToWUd\" data-bit=\"iit\"></a>\r\n"
	    		+ "    </div>";
	    enviarConGMail(destinatario, destinatario2, destinatario3, asunto, cuerpo);
	}
	
	private static void enviarConGMail(String destinatario, String destinatario2, String destinatario3, String asunto, String cuerpo) {
	    //La dirección de correo de envío
//	    String remitente = "tomas.com9@gmail.com";
	    String remitente = "tomas.gonzalez@estudiantes.utec.edu.uy";
	    //La clave de aplicación obtenida según se explica en este artículo:
//	    String claveemail = "adeablmiyyefvewl";
	    String claveemail = "czbfhtsagogflrqd";

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", claveemail);    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress("UTEC"));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario2));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario3));
	        message.setSubject(asunto);
	        message.setText(cuerpo,"ISO-8859-1","html");
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, claveemail);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        System.out.println("Correo enviado a " + destinatario);
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	  }

}