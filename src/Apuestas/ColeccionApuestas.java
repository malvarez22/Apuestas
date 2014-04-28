package Apuestas;

import java.util.ArrayList;
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
	
	private List<String> listaGanadores;
	private List<Apuesta> listaApuestas = new ArrayList<Apuesta>();
	private int numEquipos;
	private int numApuestas;
	private int[] posicionesFinales;
	private int error;
	
	/**
	 * Constructor por defecto. Setea el número de equipos en 2 (el minimo posible). 
	 */
	public ColeccionApuestas() {
		numApuestas=listaApuestas.size();
		numEquipos = 2;
	}
	
	/**
	 * Constructor que toma como par�metro el n�mero de equipos de las apuestas.
	 * @param nroEquipos es el n�mero de equipos del campeonato.
	 */
	public ColeccionApuestas(int nroEquipos) {
		this.numEquipos=nroEquipos;
		numApuestas = 0;
	}

	/**
	 * N�mero de apuestas registradas en el sistema.
	 * @return n�mero de apuestas registradas en el sistema.
	 */
	public int numApuestas() {
		return listaApuestas.size();
	}

	/**
	 * Permite registrar una nueva apuesta en el sistema. Debe corresponder a un usuario no registrado 
	 * previamente, es decir, que no tenga una apuesta previa en el sistema (cada usuario puede apostar
	 * exactamente una vez).
	 * @param apuesta es la apuesta a agregar en el sistema. 
	 */
	public void agregar(Apuesta apuesta) {
		if (numEquipos != apuesta.NroEquipos) throw new IllegalArgumentException("numero de apuestas invalido");
		boolean contiene = false;
		for(int i = 0; i < listaApuestas.size() && !contiene; i++){
			if (listaApuestas.get(i).usuario() == apuesta.usuario()) contiene = true;  
		}
		if(!contiene){ //Pregunta si el usuario no esta en alguna apuesta registrada
			listaApuestas.add(apuesta);
			numApuestas++;
		}else{
			throw new IllegalArgumentException("El usuario ya ha apostado");
		}
	}

	/**
	 * Cambia el n�mero de equipos participantes en el campeonato. S�lo puede cambiarse si a�n no hay
	 * apuestas registradas.
	 * @param newNumber es el nuevo número de equipos en el campeonato.
	 */
	public void cambiarNroEquipos(int newNumber) {
		if (!listaApuestas.isEmpty()) throw new IllegalStateException("Ya hay apuestas realizadas");
		numEquipos = newNumber;
	}

	/**
	 * Establece cu�les son las posiciones de los equipos en la tabla de posiciones final. Una vez
	 * establecida la tabla de posiciones final, se puede calcular el o los ganadores.
	 * @param posiciones es la tabla de posiciones final del torneo.
	 */
	public void establecerPosicionesFinales(int[] posiciones) {
		if (posiciones == null) throw new IllegalArgumentException("Posiciones es null");
		if (posiciones.length != numEquipos ) throw new IllegalArgumentException("numero posiciones invalido");
		posicionesFinales = posiciones; //armar una matriz booleana
	}
	
	/**
	 * Retorna la lista de ganadores en el sistema. Si no hay apuestas, retorna la lista vac�a.
	 * Si no se invoc� previamente a calcularGanadores, lanza una excepci�n.
	 * @return la lista de ganadores del sistema.
	 */
	public List<String> ganadores() {
		if (listaGanadores == null) throw new IllegalStateException("Ganadores no han sido computados");
		return listaGanadores;
	}
	
	
	/**
	 * Calcula los apostadores ganadores del sistema. Para poder computar apuestas, se debe contar
	 * con la tabla de posiciones final ya establecida en el sistema. No es necesario que haya apuestas
	 * registradas. Si no hay apuestas, no habr� ganadores. Los ganadores se obtienen con la rutina
	 * ganadores() (lista de ganadores, vac�a si no hubo apuestas).
	 */
	public void calcularGanadores() {
		listaGanadores = new ArrayList<String>();
		boolean [][] matrizEquipos=cargarMatriz(posicionesFinales);
		int [] errores = new int [numApuestas];
		for(int i=0;i<numApuestas;i++){
			int [] pos = listaApuestas.get(i).posiciones();
			error = 0;
			split(pos,0,pos.length-1,matrizEquipos);
			errores[i]= error;
		}
		// Busca el error minimo
		int minError=Integer.MAX_VALUE;
		for(int i=0;i<errores.length;i++){
			if(errores[i] < minError){
				minError = errores[i];				
			}
		}
		// Busca las apuestas con el error minimo
		for(int j=0;j<errores.length;j++){
			if (errores[j] == minError){
				listaGanadores.add(listaApuestas.get(j).usuario());
			}
		}
	}
	
	/**
	 * Metodo que retorna una matriz booleana indicando que equipos ganan contra otros.
	 * @param posFinal es la lista de posiciones finales.
	 */
	public static boolean[][] cargarMatriz(int [] posFinal){
		int cantEquipos = posFinal.length;
		boolean[][] matriz = new boolean[cantEquipos][cantEquipos];
		for(int i =0;i<posFinal.length;i++){
			for(int j=i;j<posFinal.length;j++){
				if(i==j){
					matriz[i][j]=false;
				}else{
					matriz[posFinal[i]-1][posFinal[j]-1] = true;
					matriz[posFinal[j]-1][posFinal[i]-1] = false;
				}
			}
		}
		return matriz;
	}
	
	/**
	 * Realiza la particion del arreglo posicionesFinales y tambien la particion de cada arreglo de apuestas
	 * para luego llamar al metodo compararEquiposGanadores()
	 */
	public void split(int [] pos, int inicio, int fin, boolean [][] matrizEquipos){
		if(inicio<fin){
			int medio = (inicio + fin)/2;
			split(pos,inicio,medio,matrizEquipos);
			split(pos,medio+1,fin,matrizEquipos);
			calcularError(pos,inicio,medio,fin,matrizEquipos);
		}
	}

	private void calcularError(int[] pos, int inicio, int medio, int fin, boolean[][] matrizEquipos) {
		int i = inicio;
		int j = medio+1;
		int index = inicio;
		int [] tempArray= new int[pos.length];
		while(i<=medio && j<=fin){
			if(!matrizEquipos[pos[i]-1][pos[j]-1]){
				error=error+((medio-inicio)+1);
				tempArray[index] = pos[j];
				j++;
			}else{
				tempArray[index] = pos[i];
				i++;
			}
			index++;
		} // end while
		while(i<=medio){
			tempArray[index]=pos[i];
			i++;
			index++;
		}
		while(j<=fin){
			tempArray[index]=pos[j];
			j++;
			index++;
		}
		for(index=inicio;index<=fin;index++){
			pos[index]=tempArray[index];
		}		
	}
}
