package ual.hmis.sesion05.ejercicio3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Ejercicio3Test {

	@Test
	void testObjectNotNull() {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		assertNotEquals(ejercicio3, null);
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio3/passwords.csv")
	void testLongitudPasswordEntre9y11(String passwordEnmascaradaCSV) {

		Ejercicio3 ejercicio3 = new Ejercicio3();

		String[] passwordEnmascarada = passwordEnmascaradaCSV.split(", ");
		String password = passwordEnmascarada[0];
		String resultado = passwordEnmascarada[1];

		assertEquals(resultado, ejercicio3.enmascarar(password));
	}
}
