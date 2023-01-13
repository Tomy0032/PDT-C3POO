package controladores;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Documento;
import com.services.DocumentoBeanRemote;
import com.services.UsuarioBeanRemote;

import interfaces.ControlCampo;

public class Control_bd_documento implements ControlCampo{
	
	private String documento;
	private boolean ok = false;
	
	public Control_bd_documento(String documento) {
		this.documento = documento;
	}
	
	public void controlCampo() throws NamingException{		
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote"); 
		DocumentoBeanRemote documentoBean = (DocumentoBeanRemote) InitialContext.doLookup("PDT_EJB/DocumentoBean!com.services.DocumentoBeanRemote"); 

		try{
			
			Documento doc = new Documento();
			doc = documentoBean.findAll(documento).get(0);
			
			usuarioBean.findAllForDocument(doc).get(0);
			ok = false;
			
		}catch(Exception e) {
			ok = true;
			System.out.println(e.getMessage());
		}
		
	}
	
	public boolean isOk() {
		return ok;
	}

}
