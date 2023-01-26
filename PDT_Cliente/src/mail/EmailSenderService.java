package mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSenderService {
	
	final static String REMITENTE = "tomas.gonzalez@estudiantes.utec.edu.uy";
	final static String CLAVE = "czbfhtsagogflrqd";
		
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
		
		Properties props = System.getProperties();
	
		props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.user", REMITENTE);
	    props.put("mail.smtp.clave", CLAVE);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.port", "587");
	    
	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress("UTEC"));
	        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
	        message.setSubject(asunto);
	        message.setText(cuerpo,"ISO-8859-1","html");
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", REMITENTE, CLAVE);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	        System.out.println("Correo enviado a " + destinatario);
	    }
	    catch (MessagingException me) {
	    	me.printStackTrace();
	    }
	}
	
	public static void correoInicial(String destinatario) {
		
		String asunto = "Administración - Registro de nuevo usuario";
		String cuerpo = "<p style=\"font-size: 18px;margin-left: 30px;\">\r\n"
	    		+ "		Registro completado correctamente.\r\n"
	    		+ "	<br>\r\n"
	    		+ "		Espere a que su cuenta sea activada por un analista de UTEC.\r\n"
	    		+ "	</p>\r\n"
	    		+ "	<div dir=\"ltr\"><td width=\"70\">\r\n"
	    		+ "        <a href=\"https://mandrillapp.com/track/click/30706855/edu2.utec.edu.uy?p=eyJzIjoiX3JWLXJuWEd5UU1FcEJBOS1RaDZ0MDE1SFpFIiwidiI6MSwicCI6IntcInVcIjozMDcwNjg1NSxcInZcIjoxLFwidXJsXCI6XCJodHRwczpcXFwvXFxcL2VkdTIudXRlYy5lZHUudXlcXFwvP3V0bV9zb3VyY2U9c3R1ZGVudCZ1dG1fY2FtcGFpZ249YWNjb3VudGFjdGl2YXRpb24mdXRtX21lZGl1bT1lbWFpbCZ1dG1fY29udGVudD03MzU3ZDIxNi05MGVlLTRiNjYtODg0Ny0wNDdmM2MxODg1YzBcIixcImlkXCI6XCI5OTZlYWQzNDUxMzg0OWVjYTg0YmFhN2U0N2QyZDM0OFwiLFwidXJsX2lkc1wiOltcImQ3YTU5NmZkMGFlODgyNWE4NjU3Njk3ZWE1MWI5ZWZhYTczODM0ZTNcIl19In0\" target=\"_blank\" data-saferedirecturl=\"https://www.google.com/url?q=https://mandrillapp.com/track/click/30706855/edu2.utec.edu.uy?p%3DeyJzIjoiX3JWLXJuWEd5UU1FcEJBOS1RaDZ0MDE1SFpFIiwidiI6MSwicCI6IntcInVcIjozMDcwNjg1NSxcInZcIjoxLFwidXJsXCI6XCJodHRwczpcXFwvXFxcL2VkdTIudXRlYy5lZHUudXlcXFwvP3V0bV9zb3VyY2U9c3R1ZGVudCZ1dG1fY2FtcGFpZ249YWNjb3VudGFjdGl2YXRpb24mdXRtX21lZGl1bT1lbWFpbCZ1dG1fY29udGVudD03MzU3ZDIxNi05MGVlLTRiNjYtODg0Ny0wNDdmM2MxODg1YzBcIixcImlkXCI6XCI5OTZlYWQzNDUxMzg0OWVjYTg0YmFhN2U0N2QyZDM0OFwiLFwidXJsX2lkc1wiOltcImQ3YTU5NmZkMGFlODgyNWE4NjU3Njk3ZWE1MWI5ZWZhYTczODM0ZTNcIl19In0&amp;source=gmail&amp;ust=1673737947298000&amp;usg=AOvVaw0_qckE5f8UdqVvs5Oq_kAU\"><img src=\"https://ci3.googleusercontent.com/proxy/YUGSpIS9zBhslG7dk-qDEmzAX9aAh1wZBMMMkQo356LH90zYQiAusI01n6sQdDh-XZaFyFNUneClRFENyJNFqh6uwStesuHC10GDOvCoMzXidBw=s0-d-e1-ft#https://edx-utec-static.s3-sa-east-1.amazonaws.com/Logo_UTEC.png\" width=\"160\" height=\"86\" alt=\"Ve a la página principal de EDU \" class=\"CToWUd\" data-bit=\"iit\"></a>\r\n"
	    		+ "    </div>";
		
		enviarConGMail(destinatario, asunto, cuerpo);
		
	}
	
	public static void correoActivacion(String destinatario) {
		
		String asunto = "Administración - Activación de cuenta";
		String cuerpo = "<p style=\"font-size: 18px;margin-left: 30px;\">\r\n"
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
		
		enviarConGMail(destinatario, asunto, cuerpo);
		
	}

}