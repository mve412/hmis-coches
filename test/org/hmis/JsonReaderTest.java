package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class JsonReaderTest {

	@Test
	void testLeerCochesJSON() {
		String ruta = "data/coches.json";
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals (4, coches.length);
	}

	@Test
	void testLeerCochesJSONprimero() {
		String ruta = "data/coches.json";
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche [] coches = JsonReader.leerCochesJSON(ruta);
		assertEquals(primero, coches[0]);
		assertTrue (primero.equals(coches[0]));
		assertTrue (coches[0].equals(primero));
	}

	
	@Test
	void testObjectNotNull() {
		JsonReader jsonReader = new JsonReader();

		assertNotEquals(jsonReader, null);
	}
	
	@Test
	void testNoExcepcionLeerCochesJSON() {
		String rutaIncorrecta = "data/automoviles.json";

		assertDoesNotThrow(() -> JsonReader.leerCochesJSON(rutaIncorrecta));
	}

}
