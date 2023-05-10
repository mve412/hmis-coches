package org.hmis;


import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class JsonReaderTest {

	/*
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
	*/
	
	@ParameterizedTest
	@CsvSource({"data/coches1.json, 4",
				"data/coches2.json, 3",
				"data/coches3.json, 2",
				"data/coches4.json, 1"})
	void testLeerCochesJSON(String ruta, int numCoches) {

		Coche[] coches = JsonReader.leerCochesJSON(ruta);

		assertEquals(numCoches, coches.length);
	}
	
	@ParameterizedTest
	@CsvSource({"data/coches1.json, Toyota, Corolla, 2022, 22000",
				"data/coches2.json, Chevrolet, Camaro, 2023, 52000",
				"data/coches3.json, Honda, Civic, 2022, 25000",
				"data/coches4.json, Ford, Mustang, 2021, 45000"})
	void testLeerCochesJSONprimero(String ruta, String marca, String modelo, int anio, int precio) {

		Coche[] coches = JsonReader.leerCochesJSON(ruta);

		Coche primero = new Coche (marca, modelo, anio, precio);

		assertEquals(primero, coches[0]);
		assertTrue(primero.equals(coches[0]));
		assertTrue(coches[0].equals(primero));
	}

	@Test
	void testObjectNotNull() {

		JsonReader jsonReader = new JsonReader();

		assertNotEquals(jsonReader, null);
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"data/automoviles.json", "data/autos.json", "data/carros.json"})
	void testExcepcionLeerCochesJSON(String rutaMala) {

		assertDoesNotThrow(() -> JsonReader.leerCochesJSON(rutaMala));
	}

}
