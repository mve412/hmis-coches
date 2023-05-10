package ual.hmis.sesion05.ejercicio2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Ejercicio2Test {

	@Test
	void testObjectNotNull() {

		Ejercicio2 ejercicio2 = new Ejercicio2();
		
		assertNotEquals(ejercicio2, null);
	}
	
	@ParameterizedTest
	@CsvSource({"'', Pass1, false",
				"user,'', false",
				"'', '', false",
				"123456789012345678901234567890, Pass1, false",
				"1234567890123456789012345678901, Pass1, false",
				"user, 123456789012345678901234567890, false",
				"user, 1234567890123456789012345678901, false",
				"123456789012345678901234567890, 123456789012345678901234567890, false",
				"123456789012345678901234567890, 1234567890123456789012345678901, false",
				"1234567890123456789012345678901, 123456789012345678901234567890, false",
				"1234567890123456789012345678901, 1234567890123456789012345678901, false",
				"user, pass1, false",
				"user, PASS1, false",
				"user, Pass, false",
				"user, Pass1, true",
				"user, wrongPass1, false",
				"wrongUser, Pass1, false",
				"wrongUser, wrongPass1, false"})
	void testLogin(String username, String password, Boolean resultado) {

		Ejercicio2 ejercicio2 = new Ejercicio2();

		assertEquals(resultado, ejercicio2.login(username, password));
	}
}
