package interfaz;

import java.awt.Dimension;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entities.Usuario;
import com.exception.ServicesException;
import com.services.UsuarioBeanRemote;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

public class TutorPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Usuario usuario;

	public TutorPrincipal(Long idUsuario) {
		
		setUsuario(idUsuario);
		cerrar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	    int height = pantalla.height;
	    int width = pantalla.width;
	    setBounds(new Rectangle((width-450)/2, (height-300)/2, 450, 300));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTutor = new JLabel("Tutor");
		lblTutor.setHorizontalAlignment(SwingConstants.CENTER);
		lblTutor.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblTutor.setBounds(120, 102, 194, 56);
		contentPane.add(lblTutor);
		
		JLabel lblUserName = new JLabel(usuario.getNombreUsuario());
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setBounds(135, 189, 164, 26);
		contentPane.add(lblUserName);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private void cerrar() {
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {		
				dispose();
				new Login();
			}
		});
		
	}
	
	public static Usuario getUsuario() {
		return usuario;
	}

	private static void setUsuario(Long idUsuario) {
		UsuarioBeanRemote usuarioBean = null;
		try {
			usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("PDT_EJB/UsuarioBean!com.services.UsuarioBeanRemote");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		Usuario user = null;
		try {
			user = usuarioBean.find(idUsuario);
		} catch (ServicesException e) {
			e.printStackTrace();
		}

		TutorPrincipal.usuario = user;
	}

}
