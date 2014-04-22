package Apuestas;

import java.util.List;

/**
 * Esta clase representa una colecci�n de apuestas, para un sistema de apuestas futbol�sticas simples.
 * Los equipos son identificados por valores num�ricos (e.g., 1..20). El sistema de apuestas consta de
 * un conjunto de apuestas, y las posiciones finales (tabla de posiciones al finalizar el campeonato)
 * Cada apuesta consiste de un usuario y el orden en que el usuario considera que los equipos quedar�n
 * al finalizar el campeonato. 
 * El sistema permite calcular los ganadores, es decir, aquellos cuya elecci�n se diferencie en menor medida
 * respecto de la tabla de posiciones final (la "distancia" de una apuesta respecto de la tabla de 
 * posiciones final se mide en t�rminos de cantidad de "inversiones" de la apuesta con respecto a la tabla
 * de posiciones obtenida).
 * @author
 * @version 0.1 14/04/2014
 */
public class ColeccionApuestas {

	
	/**
	 * Constructor por defecto. Setea el n�mero de equipos en 2 (el m�nimo posible). 
	 */
	public ColeccionApuestas() {
		//TODO implementar esta rutina
	}

	
	/**
	 * Constructor que toma como par�metro el n�mero de equipos de las apuestas.
	 * @param nroEquipos es el n�mero de equipos del campeonato.
	 */
	public ColeccionApuestas(int nroEquipos) {
		//TODO implementar esta rutina
	}

	/**
	 * N�mero de apuestas registradas en el sistema.
	 * @return n�mero de apuestas registradas en el sistema.
	 */
	public int numApuestas() {
		//TODO implementar esta rutina
		return 0;
	}

	/**
	 * Permite registrar una nueva apuesta en el sistema. Debe corresponder a un usuario no registrado 
	 * previamente, es decir, que no tenga una apuesta previa en el sistema (cada usuario puede apostar
	 * exactamente una vez).
	 * @param apuesta es la apuesta a agregar en el sistema. 
	 */
	public void agregar(Apuesta apuesta) {
		//TODO implementar esta rutina
	}

	/**
	 * Cambia el n�mero de equipos participantes en el campeonato. S�lo puede cambiarse si a�n no hay
	 * apuestas registradas.
	 * @param i es el nuevo n�mero de equipos en el campeonato.
	 */
	public void cambiarNroEquipos(int i) {
		//TODO implementar esta rutina
	}

	/**
	 * Establece cu�les son las posiciones de los equipos en la tabla de posiciones final. Una vez
	 * establecida la tabla de posiciones final, se puede calcular el o los ganadores.
	 * @param posiciones es la tabla de posiciones final del torneo.
	 */
	public void establecerPosicionesFinales(int[] posiciones) {
		//TODO implementar esta rutina
	}
	
	/**
	 * Retorna la lista de ganadores en el sistema. Si no hay apuestas, retorna la lista vac�a.
	 * Si no se invoc� previamente a calcularGanadores, lanza una excepci�n.
	 * @return la lista de ganadores del sistema.
	 */
	public List<String> ganadores() {
		//TODO implementar esta rutina
		return null;
	}

	/**
	 * Calcula los apostadores ganadores del sistema. Para poder computar apuestas, se debe contar
	 * con la tabla de posiciones final ya establecida en el sistema. No es necesario que haya apuestas
	 * registradas. Si no hay apuestas, no habr� ganadores. Los ganadores se obtienen con la rutina
	 * ganadores() (lista de ganadores, vac�a si no hubo apuestas).
	 */
	public void calcularGanadores() {
		//TODO implementar esta rutina
	}

}