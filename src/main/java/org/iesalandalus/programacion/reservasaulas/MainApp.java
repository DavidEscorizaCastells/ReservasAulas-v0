package org.iesalandalus.programacion.reservasaulas;

import org.iesalandalus.programacion.reservasaulas.modelo.ModeloReservasAulas;
import org.iesalandalus.programacion.reservasaulas.vista.IUTextual;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Programa para la gestión de reservas de espacios del IES Al-Ándalus");
		ModeloReservasAulas modelo=new ModeloReservasAulas();
		IUTextual vista=new IUTextual();
		vista.comenzar();
	}

}
