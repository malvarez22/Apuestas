package Apuestas;

/**
 * Esta clase representa una apuesta del sistema de apuestas. Una apuesta tiene un usuario, el que 
 * realiza la apuesta, y una "elecci—n" (la apuesta en s’). La elecci—n consiste de una lista
 * que define el orden que el apostador supone que tendr‡n los equipos en la tabla de posiciones final.
 * Los equipos son representados por valores numŽricos (e.g., 1..20).
 * @author
 * @version 0.1 14/04/2014
 */
public class Apuesta {
		String usuario;
		int NroEquipos;
		int [] posiciones;
	/**
	 * Constructor que crea una apuesta vac’a, dado el nombre del apostador.
	 * @param usuario es el nombre del apostador.
	 */
	public Apuesta(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Constructor que crea una apuesta, dados el nombre del apostador, nœmero de equipos y apuesta.
	 * La longitud de la apuesta debe coincidir con el nœmero de equipos.
	 * @param usuario es el nombre del apostador.
	 * @param NroEquipos es el nœmero de equipos en la apuesta.
	 * @param posiciones es la apuesta.
	 */
	public Apuesta(String usuario, int NroEquipos, int[] posiciones) {
		this.NroEquipos=NroEquipos;
		this.usuario=usuario;
	}

	/**
	 * Cambia el nœmero de equipos de la apuesta. 
	 * @param es el nuevo nœmero de equipos de la apuesta
	 */
	public void cambiarNroEquipos(int i) {
		//TODO implementar esta rutina
	}
	
	/**
	 * Nœmero de equipos de la apuesta.
	 * @return el nœmero de equipos de la apuesta.
	 */
	public int nroEquipos() {
		return NroEquipos;
	}

	/**
	 * Posiciones definidas por el usuario para su apuesta.
	 * @return el orden de los equipos seleccionado por el usuario en su apuesta.
	 */
	public int[] posiciones() {
		//TODO implementar esta rutina
		return null;
	}

	/**
	 * Cambia el orden establecido por el usuario para su apuesta.
	 * @param posiciones es el nuevo orden establecido por el usuario para los equipos del torneo.
	 */
	public void cambiarPosiciones(int[] posiciones) {
		//TODO implementar esta rutina
	}

	/**
	 * Nombre del usuario, i.e, del cliente que emite la apuesta.
	 * @return el nombre del usuario que emite la apuesta.
	 */
	public String usuario() {
		return usuario;
	}


}
