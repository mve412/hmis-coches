package ual.hmis.sesion05.ejercicio4;

public class Ejercicio4 {

	public static double[][] obtenerDiagonales(double[][] matriz) {

	    int n = matriz.length;
	    double[][] diagonales = new double[2][n];

	    for (int i = 0; i < n; i++) {
	    	diagonales[0][i] = matriz[i][i]; // Diagonal principal
	    	diagonales[1][i] = matriz[i][n - 1 - i]; // Diagonal secundaria
	    }

	    return diagonales;
	}

	public static double[] sumarColumnas(double[][] matriz) {

	    int n = matriz.length;
	    double[] resultado = new double[n];

	    for (int j = 0; j < n; j++) {
	    	double suma = .0;

	    	for (int i = 0; i < n; i++) {
	    		suma += matriz[i][j];
	    	}

	    	resultado[j] = suma;
	    }

	    return resultado;
	}
}
