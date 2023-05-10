package ual.hmis.sesion05.ejercicio2;

public class Ejercicio2 {

	public boolean login(String username, String password) {

		// Comprobar que sean distintos de vacío
		if (username.equals("")) return false;
		if (password.equals("")) return false;

		// Comprobar que la longitud sea < 30
		if (username.length() >= 30) return false;
		if (password.length() >= 30) return false;
		
		// Comprobar que la contraseña tenga al menos una letra mayúscula, una minúscula y un dígito
		boolean contieneMay = false;
		boolean contieneMin = false;
		boolean contieneDig = false;

		for (char c  : password.toCharArray()) {
			if (Character.isUpperCase(c)) contieneMay = true;
			if (Character.isLowerCase(c)) contieneMin = true;
			if (Character.isDigit(c)) contieneDig = true;
		}
		
		if (!contieneMay || !contieneMin || !contieneDig) return false;
		
		// Llamar al método de la bbdd
		return compruebaLoginEnBD(username, password);
	}
	
	public boolean compruebaLoginEnBD(String username, String password) {

		// Método mock (simulado)
		if (username.equals("user") && password.equals("Pass1"))
			return true;
		else
			return false;
	}
}
