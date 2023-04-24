package org.hmis;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.*;

class MainTest {
	private final ByteArrayOutputStream salida = new ByteArrayOutputStream();
	private final PrintStream salidaOriginal = System.out;
	
	@Test
	void testObjectNotNull() {
		Main main = new Main();

		assertNotEquals(main, null);
	}

	@BeforeEach
	void setStream() {
		// Configurar que la salida se guarde en un array
		System.setOut(new PrintStream(salida));
	}

	@AfterEach
	void restoreInitial() {
		// Configurar que la salida vuelva a mostrarse por consola
		System.setOut(salidaOriginal);
	}

	@Test
	void testMain() {
    	String ruta = "data/coches.json";
    	Coche[] coches = JsonReader.leerCochesJSON(ruta);

    	String cadena = "Coche [marca=Toyota, modelo=Corolla, año=2022, precio=22000]\n"
    			+ "Coche [marca=Ford, modelo=Mustang, año=2021, precio=45000]\n"
    			+ "Coche [marca=Chevrolet, modelo=Camaro, año=2023, precio=52000]\n"
    			+ "Coche [marca=Honda, modelo=Civic, año=2022, precio=25000]\n";

//    	for (Coche coche : coches) {
//            cadena = cadena + coche + "\r\n";
//        }

    	// Ejecuta la función main
    	Main.main(null);
    	

		assertEquals(cadena, salida.toString());
	}
}