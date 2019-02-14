package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

public class Profesores {
	private static final int MAX_PROFESORES=20;
	private Profesor[] profesores;
	private int numProfesores;

	public Profesores() {
		profesores=new Profesor[MAX_PROFESORES];
		numProfesores=0;
	}

	public Profesores(Profesores otrosProfesores) {
		setProfesores(otrosProfesores);
	}
	
	private void setProfesores(Profesores profesores) {
		if (profesores==null)
			throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
		
		this.profesores=copiaProfundaProfesores(profesores.profesores);	
	}
	
	private Profesor[] copiaProfundaProfesores (Profesor[] profesores) {
		Profesor[] otrosProfesores=new Profesor[MAX_PROFESORES];
		for (int i=0;i<MAX_PROFESORES && profesores[i]!=null ;i++) {
			otrosProfesores[i]=new Profesor(profesores[i]);
		}
		return otrosProfesores;
	}
	
	public Profesor[] getProfesores() {
		return copiaProfundaProfesores(profesores);
	}
	
	public int getNumProfesores() {
		return numProfesores;
	}
	
	public void insertar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor==null)
			throw new IllegalArgumentException ("No se puede insertar un profesor nulo.");
		
		for (int i=0; i<MAX_PROFESORES;i++)
			if (profesor.equals(profesores[i]))
				throw new OperationNotSupportedException ("El profesor ya existe.");
			else
				if (profesores[i]==null) {
					profesores[i]=profesor;
					i=MAX_PROFESORES;
					numProfesores++;
					}
	}
	
	private int buscarIndiceProfesor(Profesor profesor) {
		int indice=-1;
		for (int i=0; i<MAX_PROFESORES && profesores[i]!=null; i++)
			if (profesores[i].equals(profesor) ) {
				indice=i;
				i=MAX_PROFESORES;
			}
		return indice;
	}
	
	private boolean indiceNoSuperaTamaño(int indice) throws OperationNotSupportedException {
		if (indice<0)
			throw new OperationNotSupportedException("El indice no puede ser negativo.");		
		else if (indice>=MAX_PROFESORES)
			return false;
		else if (profesores[indice]==null)
			return false;
		else 
			return true;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) throws OperationNotSupportedException {
		if (indice<0)
			throw new OperationNotSupportedException("El indice no puede ser negativo.");		
		else if (indice>=MAX_PROFESORES)
			return false;
		else
			return true;
	}
	
	public Profesor buscar(Profesor profesor) {
		
		if (profesor==null || buscarIndiceProfesor(profesor)==-1)
			return null;
		return profesores[buscarIndiceProfesor(profesor)];
	}
	
	public void borrar(Profesor profesor) throws OperationNotSupportedException {
		if (profesor==null)
			throw new IllegalArgumentException ("No se puede borrar un profesor nulo.");
		
		if (buscarIndiceProfesor(profesor)==-1)
			throw new OperationNotSupportedException ("El profesor a borrar no existe.");
		desplazarUnaPosicionHaciaIzquierda(buscarIndiceProfesor(profesor));
		numProfesores--;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda (int indice) {
		profesores[indice]=null;
		for (int i=indice; i<MAX_PROFESORES-1; i++) {
			if (profesores[i+1]!=null) {
				profesores[i]=profesores[i+1];
				profesores[i+1]=null;
			}
		}
	}
	
	public String[] representar() {
		String[] representacion=new String[numProfesores];
		for (int i=0;i<numProfesores;i++) {
			representacion[i]=profesores[i].toString();			
		}
		return representacion;
	}
	
}