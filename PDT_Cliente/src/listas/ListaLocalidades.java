package listas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Localidad;
import com.services.LocalidadBeanRemote;

public class ListaLocalidades {
	
	private static ListaLocalidades listaLocalidades = null;
	private static List<Localidad> listaMontevideo = new LinkedList<Localidad>();
	private static List<Localidad> listaArtigas = new LinkedList<Localidad>();
	private static List<Localidad> listaCanelones = new LinkedList<Localidad>();
	private static List<Localidad> listaCerroLargo = new LinkedList<Localidad>();
	private static List<Localidad> listaColonia = new LinkedList<Localidad>();
	private static List<Localidad> listaDurazno = new LinkedList<Localidad>();
	private static List<Localidad> listaFlores = new LinkedList<Localidad>();
	private static List<Localidad> listaFlorida = new LinkedList<Localidad>();
	private static List<Localidad> listaLavalleja = new LinkedList<Localidad>();
	private static List<Localidad> listaMaldonado = new LinkedList<Localidad>();
	private static List<Localidad> listaPaysandu = new LinkedList<Localidad>();
	private static List<Localidad> listaRioNegro = new LinkedList<Localidad>();
	private static List<Localidad> listaRivera = new LinkedList<Localidad>();
	private static List<Localidad> listaRocha = new LinkedList<Localidad>();
	private static List<Localidad> listaSalto = new LinkedList<Localidad>();
	private static List<Localidad> listaSanJose = new LinkedList<Localidad>();
	private static List<Localidad> listaSoriano = new LinkedList<Localidad>();
	private static List<Localidad> listaTacuarembo = new LinkedList<Localidad>();
	private static List<Localidad> listaTreintaYTres = new LinkedList<Localidad>();
	
	private ListaLocalidades() {
		try {
			cargarListas();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ListaLocalidades getListaLocalidades() {
		if(listaLocalidades == null) {
			listaLocalidades = new ListaLocalidades();
		}
		return listaLocalidades;
	}
	
	public static void cargarListas() throws NamingException {
		
		LocalidadBeanRemote localidadBean = (LocalidadBeanRemote) InitialContext.doLookup("PDT_EJB/LocalidadBean!com.services.LocalidadBeanRemote"); 		
		List<Localidad> listaLocalidades = localidadBean.findAll();
		
		for(Localidad l : listaLocalidades) {
				
			if(l.getDepartamento().getIdDepartamento() == 1) {
				listaMontevideo.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 2) {
				listaArtigas.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 3) {
				listaCanelones.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 4) {
				listaCerroLargo.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 5) {
				listaColonia.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 6) {
				listaDurazno.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 7) {
				listaFlores.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 8) {
				listaFlorida.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 9) {
				listaLavalleja.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 10) {
				listaMaldonado.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 11) {
				listaPaysandu.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 12) {
				listaRioNegro.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 13) {
				listaRivera.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 14) {
				listaRocha.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 15) {
				listaSalto.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 16) {
				listaSanJose.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 17) {
				listaSoriano.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 18) {
				listaTacuarembo.add(l);
			}
			else if(l.getDepartamento().getIdDepartamento() == 19) {
				listaTreintaYTres.add(l);
			}
							
		}
		
	}
	
	public static String[] getListaString(int id) {
		
		ArrayList<String> s = new ArrayList<>();
		List<Localidad> lista = null;		
		
		switch(id) {
		case 1:
			lista = listaMontevideo;
			break;
		case 2:
			lista = listaArtigas;
			break;
		case 3:
			lista = listaCanelones;
			break;
		case 4:
			lista = listaCerroLargo;
			break;
		case 5:
			lista = listaColonia;
			break;
		case 6:
			lista = listaDurazno;
			break;
		case 7:
			lista = listaFlores;
			break;
		case 8:
			lista = listaFlorida;
			break;
		case 9:
			lista = listaLavalleja;
			break;
		case 10:
			lista = listaMaldonado;
			break;
		case 11:
			lista = listaPaysandu;
			break;
		case 12:
			lista = listaRioNegro;
			break;
		case 13:
			lista = listaRivera;
			break;
		case 14:
			lista = listaRocha;
			break;
		case 15:
			lista = listaSalto;
			break;
		case 16:
			lista = listaSanJose;
			break;
		case 17:
			lista = listaSoriano;
			break;
		case 18:
			lista = listaTacuarembo;
			break;
		case 19:
			lista = listaTreintaYTres;
			break;
		}
		
		for(Localidad l : lista) {
			
			s.add(l.getNombre());
			
		}
		
		String[] localidades = s.toArray(new String[0]);
		return localidades;
		
	}

	public static List<Localidad> getListaMontevideo() {
		return listaMontevideo;
	}

	public static void setListaMontevideo(List<Localidad> listaMontevideo) {
		ListaLocalidades.listaMontevideo = listaMontevideo;
	}

	public static List<Localidad> getListaArtigas() {
		return listaArtigas;
	}

	public static void setListaArtigas(List<Localidad> listaArtigas) {
		ListaLocalidades.listaArtigas = listaArtigas;
	}

	public static List<Localidad> getListaCanelones() {
		return listaCanelones;
	}

	public static void setListaCanelones(List<Localidad> listaCanelones) {
		ListaLocalidades.listaCanelones = listaCanelones;
	}

	public static List<Localidad> getListaCerroLargo() {
		return listaCerroLargo;
	}

	public static void setListaCerroLargo(List<Localidad> listaCerroLargo) {
		ListaLocalidades.listaCerroLargo = listaCerroLargo;
	}

	public static List<Localidad> getListaColonia() {
		return listaColonia;
	}

	public static void setListaColonia(List<Localidad> listaColonia) {
		ListaLocalidades.listaColonia = listaColonia;
	}

	public static List<Localidad> getListaDurazno() {
		return listaDurazno;
	}

	public static void setListaDurazno(List<Localidad> listaDurazno) {
		ListaLocalidades.listaDurazno = listaDurazno;
	}

	public static List<Localidad> getListaFlores() {
		return listaFlores;
	}

	public static void setListaFlores(List<Localidad> listaFlores) {
		ListaLocalidades.listaFlores = listaFlores;
	}

	public static List<Localidad> getListaFlorida() {
		return listaFlorida;
	}

	public static void setListaFlorida(List<Localidad> listaFlorida) {
		ListaLocalidades.listaFlorida = listaFlorida;
	}

	public static List<Localidad> getListaLavalleja() {
		return listaLavalleja;
	}

	public static void setListaLavalleja(List<Localidad> listaLavalleja) {
		ListaLocalidades.listaLavalleja = listaLavalleja;
	}

	public static List<Localidad> getListaMaldonado() {
		return listaMaldonado;
	}

	public static void setListaMaldonado(List<Localidad> listaMaldonado) {
		ListaLocalidades.listaMaldonado = listaMaldonado;
	}

	public static List<Localidad> getListaPaysandu() {
		return listaPaysandu;
	}

	public static void setListaPaysandu(List<Localidad> listaPaysandu) {
		ListaLocalidades.listaPaysandu = listaPaysandu;
	}

	public static List<Localidad> getListaRioNegro() {
		return listaRioNegro;
	}

	public static void setListaRioNegro(List<Localidad> listaRioNegro) {
		ListaLocalidades.listaRioNegro = listaRioNegro;
	}

	public static List<Localidad> getListaRivera() {
		return listaRivera;
	}

	public static void setListaRivera(List<Localidad> listaRivera) {
		ListaLocalidades.listaRivera = listaRivera;
	}

	public static List<Localidad> getListaRocha() {
		return listaRocha;
	}

	public static void setListaRocha(List<Localidad> listaRocha) {
		ListaLocalidades.listaRocha = listaRocha;
	}

	public static List<Localidad> getListaSalto() {
		return listaSalto;
	}

	public static void setListaSalto(List<Localidad> listaSalto) {
		ListaLocalidades.listaSalto = listaSalto;
	}

	public static List<Localidad> getListaSanJose() {
		return listaSanJose;
	}

	public static void setListaSanJose(List<Localidad> listaSanJose) {
		ListaLocalidades.listaSanJose = listaSanJose;
	}

	public static List<Localidad> getListaSoriano() {
		return listaSoriano;
	}

	public static void setListaSoriano(List<Localidad> listaSoriano) {
		ListaLocalidades.listaSoriano = listaSoriano;
	}

	public static List<Localidad> getListaTacuarembo() {
		return listaTacuarembo;
	}

	public static void setListaTacuarembo(List<Localidad> listaTacuarembo) {
		ListaLocalidades.listaTacuarembo = listaTacuarembo;
	}

	public static List<Localidad> getListaTreintaYTres() {
		return listaTreintaYTres;
	}

	public static void setListaTreintaYTres(List<Localidad> listaTreintaYTres) {
		ListaLocalidades.listaTreintaYTres = listaTreintaYTres;
	}
	
}
