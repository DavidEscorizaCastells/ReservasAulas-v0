package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

public class AulaTest {
	/*
	private static final String ERROR_EXCEPCION = "Deber�a haber saltado la excepci�n.";
	private static final String ERROR_NO_EXCEPCION = "No debería haber saltado la excepción.";
	private static final String nombre = "Salón de actos";

	@Test
	public void constructorUnParametroValidoTest() {
		Aula aula = null;
		try {
			aula = new Aula(nombre);
			assertEquals(nombre, aula.getNombre());
		} catch (IllegalArgumentException e) {
			fail(ERROR_NO_EXCEPCION);
		}
	}
	
	@Test
	public void constructorUnParametroNoValidoTest() {
		Aula aula = null;
		try {
			String nombre = null;
			aula = new Aula(nombre);
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre del aula no puede ser nulo.", e.getMessage());
			assertNull(aula);
		}
		try {
			aula = new Aula("");
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("El nombre del aula no puede estar vacío.", e.getMessage());
			assertNull(aula);
		}
	}
	
	@Test
	public void constructorCopiaValidoTest() {
		Aula aula = new Aula(nombre);
		Aula aula1;
		try {
			aula1 = new Aula(aula);
			assertEquals(nombre, aula1.getNombre());
		} catch (IllegalArgumentException e) {
			fail(ERROR_NO_EXCEPCION);
		}
	}
	
	@Test
	public void constructorCopiaNoValidoTest() {
		Aula aula = null;
		try {
			Aula aula1 = null;
			aula = new Aula(aula1);
			fail(ERROR_EXCEPCION);
		} catch (IllegalArgumentException e) {
			assertEquals("No se puede copiar un aula nula.", e.getMessage());
			assertNull(aula);
		}
	}
	
	@Test
	public void getTest() {
		Aula aula = new Aula(nombre);
		assertEquals(nombre, aula.getNombre());
	}
	
	@Test
	public void hasCodeTest() {
		Aula aula = new Aula(nombre);
		Aula aula1 = new Aula(nombre);
		Aula aula2 = new Aula("Andrés");
		assertEquals(aula.hashCode(), aula.hashCode());
		assertEquals(aula.hashCode(), aula1.hashCode());
		assertNotEquals(aula.hashCode(), aula2.hashCode());
	}
	
	@Test
	public void equalTest() {
		Aula aula = new Aula(nombre);
		Aula aula1 = new Aula(nombre);
		Aula aula2 = new Aula("Andrés");
		assertNotEquals(aula, null);
		assertNotEquals(aula, "");
		assertEquals(aula, aula);
		assertEquals(aula, aula1);
		assertNotEquals(aula, aula2);
	}
	
	@Test
	public void toStringTest() {
		Aula aula = new Aula(nombre);
		assertEquals("[nombre=Salón de actos]", aula.toString());
	}
*/
}
