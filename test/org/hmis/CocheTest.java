package org.hmis;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CocheTest {

	@Test
	void testEqualsObject() {
		Coche c = new Coche ();   // Arrange
		assertTrue(c.equals(c));  // Action // Assert
	}
	
	@Test
	void testEqualsObjectNull() {
		Coche c = new Coche ();   // Arrange
		Coche c2 = null;
		assertFalse(c.equals(c2));  // Action // Assert
	}
	

	@Test
	void testEqualsObjectString() {
		Coche c = new Coche ();   // Arrange
		String c2 = "";
		assertFalse(c.equals(c2));  // Action // Assert
	}

	
	@Test
	void testEqualsObjectMultiple1() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Corolla", 2022, 22000);
		assertEquals(true, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple2() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Corolla", 2023, 22000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple3() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Nissan", "Corolla", 2022, 22000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple4() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Auris", 2022, 22000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}

	@Test
	void testEqualsObjectMultiple5() {
		Coche primero = new Coche ("Toyota", "Corolla", 2022, 22000);
		Coche segundo = new Coche ("Toyota", "Corolla", 2022, 32000);
		assertEquals(false, primero.equals(segundo));  // Action // Assert
	}
	
	@Test
	void testSetters() {
		Coche primero = new Coche();
		Coche segundo = new Coche("Audi", "A5", 2021, 35000);
		primero.setMarca("Audi");
		primero.setModelo("A5");
		primero.setAño(2021);
		primero.setPrecio(35000);
		assertEquals(true, primero.equals(segundo));
	}
	
	@Test
	void testGetterMarca() {
		Coche primero = new Coche("Audi", "A5", 2021, 35000);
		assertEquals("Audi", primero.getMarca());
	}
	
	@Test
	void testGetterModelo() {
		Coche primero = new Coche("Audi", "A5", 2021, 35000);
		assertEquals("A5", primero.getModelo());
	}
	
	@Test
	void testGetterAño() {
		Coche primero = new Coche("Audi", "A5", 2021, 35000);
		assertEquals(2021, primero.getAño());
	}
	
	@Test
	void testGetterPrecio() {
		Coche primero = new Coche("Audi", "A5", 2021, 35000);
		assertEquals(35000, primero.getPrecio());
	}
	
	@Test
	void testToString() {
		Coche primero = new Coche("Audi", "A5", 2021, 35000);
		assertEquals("Coche [marca=Audi, modelo=A5, año=2021, precio=35000]", primero.toString());
	}
	
	
	

}
