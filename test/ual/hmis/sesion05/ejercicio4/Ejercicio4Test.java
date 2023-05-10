package ual.hmis.sesion05.ejercicio4;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Ejercicio4Test {

	@Test
	void testObjectNotNull() {

		Ejercicio4 ejercicio4 = new Ejercicio4();

		assertNotEquals(ejercicio4, null);
	}
	
	double[][] darFormatoMatriz(String matrizCSV, int tipoDiagonal) {

        String[] elementos = matrizCSV.split(", ");
        int n, m;
        
        if (tipoDiagonal == 0) {
        	n = m = (int) Math.sqrt(elementos.length);
        } else {
        	n = 2;
        	m = elementos.length / 2;
        }
        
        double[][] matriz = new double[n][m];

        int index = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = Double.parseDouble(elementos[index++]);
            }
        }
        
        return matriz;
	}

	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio4/matrices.csv")
	void testObtenerDiagonales(String matricesCSV) {

		String[] arrayMatricesCSV = matricesCSV.split("; ");

		double[][] matriz = darFormatoMatriz(arrayMatricesCSV[0], 0);
		double[][] diagonales = darFormatoMatriz(arrayMatricesCSV[1], 1);

		assertArrayEquals(diagonales, Ejercicio4.obtenerDiagonales(matriz));
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio4/matrices.csv")
	void testSumarColumnas(String matricesCSV) {

		String[] arrayMatricesCSV = matricesCSV.split("; ");

		double[][] matriz = darFormatoMatriz(arrayMatricesCSV[0], 0);

        String[] elementos = arrayMatricesCSV[2].split(", ");
		double[] resultado = new double[elementos.length];

        for (int i = 0; i < elementos.length; i++) {
			resultado[i] = Double.parseDouble(elementos[i]);
		}

		assertArrayEquals(resultado, Ejercicio4.sumarColumnas(matriz));
	}
}
