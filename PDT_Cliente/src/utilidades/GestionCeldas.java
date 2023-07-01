package utilidades;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.DefaultCellEditor;

import java.text.DecimalFormat;

public class GestionCeldas extends DefaultTableCellRenderer{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String tipo="text";

	private Font normal = new Font( "Verdana",Font.PLAIN ,12 );
	private Font bold = new Font( "Verdana",Font.BOLD ,12 );

	private JLabel label = new JLabel();

	private ImageIcon iconoBuscar = new ImageIcon(getClass().getResource("/recursos/imagenes/ico_buscar.png"));
	private ImageIcon iconoActivar = new ImageIcon(getClass().getResource("/recursos/imagenes/ico_activar.png"));
	private ImageIcon iconoEliminar = new ImageIcon(getClass().getResource("/recursos/imagenes/ico_eliminar.png"));
	private ImageIcon iconoEditar = new ImageIcon(getClass().getResource("/recursos/imagenes/ico_editar.png"));
	
	
	public GestionCeldas(){
		
	}

	public GestionCeldas(String tipo){
		this.tipo=tipo;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
		
        Color colorFondo = null;
        Color colorFondoPorDefecto=new Color( 158, 206, 221);
        Color colorFondoSeleccion=new Color( 0, 174 , 239);
                
        JComboBox<String> asistencia = new JComboBox<>();
        DecimalFormat numberFormat = new DecimalFormat("#.##");
            	
        if (selected) {                
            this.setBackground(colorFondoPorDefecto );   
        }
        else
        {
            this.setBackground(Color.white);
        }
                
        if( tipo.equals("texto"))
        {
            if (focused) {
    			colorFondo=colorFondoSeleccion;
    		}else{
    			colorFondo= colorFondoPorDefecto;
    		}
            this.setHorizontalAlignment( JLabel.LEFT );
            this.setText( (String) value );
            this.setBackground( (selected)? colorFondo :Color.WHITE);	
            this.setFont(normal);   
            return this;
        }
         
        if( tipo.equals("icono"))
        {
        	if(!String.valueOf(value).equals("")) {
        		if(String.valueOf(value).equals("VER")) {
            		label.setIcon(iconoBuscar);
            	}
        		else if(String.valueOf(value).equals("ACTIVAR")) {
            		label.setIcon(iconoActivar);
            	}
        		else if(String.valueOf(value).equals("ELIMINAR")) {
            		label.setIcon(iconoEliminar);
            	}
        		else if(String.valueOf(value).equals("EDITAR")) {
            		label.setIcon(iconoEditar);
            	}
        		 label.setHorizontalAlignment( JLabel.LEFT );
                 label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        	}else {
                label.setBorder(null);
                label.setIcon(null);
        	}
        	       	
           	
           
            return label;
        }
        
        if( tipo.equals("numerico"))
        {           
        	if (focused) {
     			colorFondo=colorFondoSeleccion;
     		}else{
     			colorFondo=colorFondoPorDefecto;
     		}
            this.setHorizontalAlignment( JLabel.CENTER );
            this.setText( (String) value );            
            this.setForeground( (selected)? new Color(255,255,255) :new Color( 0, 174 , 239) );    
            this.setBackground( (selected)? colorFondo :Color.WHITE);
            this.setFont(bold);            
            return this;   
        }
        
        if( tipo.equals("nota"))
        {           
        	if (focused) {
     			colorFondo=colorFondoSeleccion;
     		}else{
     			colorFondo=colorFondoPorDefecto;
     		}
            this.setHorizontalAlignment( JLabel.CENTER );
            if(value.getClass().equals(String.class)) {
            	this.setValue(Double.parseDouble((String) value));
            }else {
            	if((Double) value > 5) {
	            	this.setValue(5.00);
	            }
            	else if((Double) value < 0) {
            		this.setValue(0.00);
            	}
            	else {
	            	this.setValue(numberFormat.format(value));
	            }
            }
            
            
            this.setFont(bold);            
            return this;   
        }
        
        if( value.equals("ASISTENCIA"))
        {
        	System.out.println(value.getClass());
            this.setEnabled(true);
            asistencia.addItem("ASISTENCIA");
            return asistencia;
            
        }
        
        if( value.equals("MEDIA ASISTENCIA"))
        {

            this.setEnabled(true);
            asistencia.addItem("MEDIA ASISTENCIA");
            return asistencia;
            
        }
        
        if( value.equals("AUSENCIA"))
        {

            this.setEnabled(true);
            asistencia.addItem("AUSENCIA");
            return asistencia;
            
        }
        
        if( value.equals("AUSENCIA JUSTIFICADA"))
        {

            this.setEnabled(true);
            asistencia.addItem("AUSENCIA JUSTIFICADA");
            return asistencia;
            
        }
		
		return this;
		
		
	}
	
}