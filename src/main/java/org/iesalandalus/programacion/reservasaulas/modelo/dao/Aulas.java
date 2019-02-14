package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

public class Aulas {
	private static final int MAX_AULAS=20;
	private Aula[] aulas;
	private int numAulas;
	
	public Aulas() {
		aulas=new Aula[MAX_AULAS];
		numAulas=0;
	}
	
	public Aulas(Aulas otrasAulas) {
		setAulas(otrasAulas);
	}
	
	private void setAulas(Aulas aulas) {
		if (aulas==null)
			throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
		
		this.aulas=copiaProfundaAulas(aulas.aulas);			
		
	}
	
	private Aula[] copiaProfundaAulas(Aula[] aulas) {
		Aula[] otrasAulas=new Aula[MAX_AULAS];
		for (int i=0;i<MAX_AULAS && aulas[i]!=null ;i++) {
			otrasAulas[i]=new Aula(aulas[i]);
		}
		return otrasAulas;
	}

	public Aula[] getAulas() {
		return copiaProfundaAulas(aulas);
	}

	public int getNumAulas() {
		return numAulas;
	}
	
	public void insertar(Aula aula) throws OperationNotSupportedException {
		if (aula==null)
			throw new IllegalArgumentException ("No se puede insertar un aula nula.");
		
		for (int i=0; i<MAX_AULAS;i++)
			if (aula.equals(aulas[i]))
				throw new OperationNotSupportedException ("El aula ya existe.");
			else
				if (aulas[i]==null) {
					aulas[i]=aula;
					i=MAX_AULAS;
					numAulas++;
					}
	}	
	
	private int buscarIndiceAula(Aula aula) {
		int indice=-1;
		for (int i=0; i<MAX_AULAS && aulas[i]!=null; i++)
			if (aulas[i].equals(aula) ) {
				indice=i;
				i=MAX_AULAS;
			}
		return indice;
	}
	
	private boolean indiceNoSuperaTamaño(int indice) throws OperationNotSupportedException {
		if (indice<0)
			throw new OperationNotSupportedException("El indice no puede ser negativo.");		
		else if (indice>=MAX_AULAS)
			return false;
		else if (aulas[indice]==null)
			return false;
		else 
			return true;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) throws OperationNotSupportedException {
		if (indice<0)
			throw new OperationNotSupportedException("El indice no puede ser negativo.");		
		else if (indice>=MAX_AULAS)
			return false;
		else
			return true;
	}

	
	public Aula buscar(Aula aula) {
			
		if (aula==null || buscarIndiceAula(aula)==-1)
			return null;
		return aulas[buscarIndiceAula(aula)];
	}
	
	public void borrar(Aula aula) throws OperationNotSupportedException {
		if (aula==null)
			throw new IllegalArgumentException ("No se puede borrar un aula nula.");
		
		if (buscarIndiceAula(aula)==-1)
			throw new OperationNotSupportedException ("El aula a borrar no existe.");
		desplazarUnaPosicionHaciaIzquierda(buscarIndiceAula(aula));
		numAulas--;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda (int indice) {
		aulas[indice]=null;
		for (int i=indice; i<MAX_AULAS-1; i++) {
			if (aulas[i+1]!=null) {
				aulas[i]=aulas[i+1];
				aulas[i+1]=null;
			}
		}
	}
	
	public String[] representar() {
		String[] representacion=new String[numAulas];
		for (int i=0;i<numAulas;i++) {
			representacion[i]=aulas[i].toString();			
		}
		return representacion;
	}
	

}
