package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

public class Reservas {
	private static final int MAX_RESERVAS=20;
	private Reserva[] reservas;
	private int numReservas;
	
	public Reservas() {
		reservas=new Reserva[MAX_RESERVAS];
		numReservas=0;
	}
	
	public Reservas(Reservas otrasReservas) {
		setReservas(otrasReservas);
	}
	
	private void setReservas(Reservas reservas) {
		if (reservas==null)
			throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
		
		this.reservas=copiaProfundaReservas(reservas.reservas);			
		
	}
	
	private Reserva[] copiaProfundaReservas(Reserva[] reservas) {
		Reserva[] otrasReservas=new Reserva[MAX_RESERVAS];
		for (int i=0;i<MAX_RESERVAS && reservas[i]!=null ;i++) {
			otrasReservas[i]=new Reserva(reservas[i]);
		}
		return otrasReservas;
	}

	public Reserva[] getReservas() {
		return copiaProfundaReservas(reservas);
	}

	public int getNumReservas() {
		return numReservas;
	}
	
	public void insertar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva==null)
			throw new IllegalArgumentException ("No se puede realizar una reserva nula.");
		
		for (int i=0; i<MAX_RESERVAS;i++)
			if (reserva.equals(reservas[i]))
				throw new OperationNotSupportedException ("La reserva ya existe.");
			else
				if (reservas[i]==null) {
					reservas[i]=reserva;
					i=MAX_RESERVAS;
					numReservas++;
					}
	}	
	
	private int buscarIndiceReserva(Reserva reserva) {
		int indice=-1;
		for (int i=0; i<MAX_RESERVAS && reservas[i]!=null; i++)
			if (reservas[i].equals(reserva) ) {
				indice=i;
				i=MAX_RESERVAS;
			}
		return indice;
	}
	
	private boolean indiceNoSuperaTamaño(int indice) throws OperationNotSupportedException {
		if (indice<0)
			throw new OperationNotSupportedException("El indice no puede ser negativo.");		
		else if (indice>=MAX_RESERVAS)
			return false;
		else if (reservas[indice]==null)
			return false;
		else 
			return true;
	}
	
	private boolean indiceNoSuperaCapacidad(int indice) throws OperationNotSupportedException {
		if (indice<0)
			throw new OperationNotSupportedException("El indice no puede ser negativo.");		
		else if (indice>=MAX_RESERVAS)
			return false;
		else
			return true;
	}

	
	public Reserva buscar(Reserva reserva) {
			
		if (reserva==null || buscarIndiceReserva(reserva)==-1)
			return null;
		return reservas[buscarIndiceReserva(reserva)];
	}
	
	public void borrar(Reserva reserva) throws OperationNotSupportedException {
		if (reserva==null)
			throw new IllegalArgumentException ("No se puede anular una reserva nula.");
		
		if (buscarIndiceReserva(reserva)==-1)
			throw new OperationNotSupportedException ("La reserva a anular no existe.");
		desplazarUnaPosicionHaciaIzquierda(buscarIndiceReserva(reserva));
		numReservas--;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda (int indice) {
		reservas[indice]=null;
		for (int i=indice; i<MAX_RESERVAS-1; i++) {
			if (reservas[i+1]!=null) {
				reservas[i]=reservas[i+1];
				reservas[i+1]=null;
			}
		}
	}
	
	public String[] representar() {
		String[] representacion=new String[numReservas];
		for (int i=0;i<numReservas;i++) {
			representacion[i]=reservas[i].toString();			
		}
		return representacion;
	}
	
	public Reserva[] getReservasProfesor(Profesor profesor) {
		Reserva[] reservasProfesor=new Reserva[MAX_RESERVAS];
		for (int i=0; i<MAX_RESERVAS && reservas[i]!=null; i++) {
			if (profesor.equals(reservas[i].getProfesor()))
				reservasProfesor[i]=reservas[i];
		}
		return reservasProfesor;
	}
	
	public Reserva[] getReservasAula(Aula aula) {
		Reserva[] reservasAula=new Reserva[MAX_RESERVAS];
		for (int i=0; i<MAX_RESERVAS && reservas[i]!=null; i++) {
			if (aula.equals(reservas[i].getAula()))
				reservasAula[i]=reservas[i];
		}
		return reservasAula;
	}
	
	public Reserva[] getReservasPermanencia(Permanencia permanencia) {
		Reserva[] reservasPermanencia=new Reserva[MAX_RESERVAS];
		int k=0;
		for (int i=0; i<MAX_RESERVAS && reservas[i]!=null; i++) {
			if (permanencia.equals(reservas[i].getPermanencia())) {
				reservasPermanencia[k]=reservas[i];
				k++;
			}
		}
		return reservasPermanencia;
	}
	
	public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia) {
		if (aula==null)
			throw new IllegalArgumentException ("No se puede consultar la disponibilidad de un aula nula.");
		if (permanencia==null)
			throw new IllegalArgumentException ("No se puede consultar la disponibilidad de una permanencia nula.");
		for (int i=0; i<MAX_RESERVAS && reservas[i]!=null; i++)
			if (reservas[i].getAula().equals(aula) && reservas[i].getPermanencia().equals(permanencia))
				return false;
		return true;
	}
	
	
}
