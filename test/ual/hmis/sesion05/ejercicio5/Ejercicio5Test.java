package ual.hmis.sesion05.ejercicio5;

import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Ejercicio5Test {

	@Test
	void testObjectNotNull() {

		Ejercicio5 ejercicio5 = new Ejercicio5();

		assertNotEquals(ejercicio5, null);
	}

	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio5/conjuntosAlgunoVacio.csv")
	void testPrimerConjuntoVacio(String conjuntoCSV) {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        Set<String> conjunto1 = new TreeSet<>();
        Set<String> conjunto2 = new TreeSet<>();

        for (String s : conjuntoCSV.split(", ")) {
        	conjunto2.add(s);
        }

		assertArrayEquals(conjunto2.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1, conjunto2).toArray());
	}
	
	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio5/conjuntosAlgunoVacio.csv")
	void testSegundoConjuntoVacio(String conjuntoCSV) {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        Set<String> conjunto1 = new TreeSet<>();
        Set<String> conjunto2 = new TreeSet<>();
        
        for (String s : conjuntoCSV.split(", ")) {
        	conjunto1.add(s);
        }

		assertArrayEquals(conjunto1.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1, conjunto2).toArray());
	}
	
	@Test
	void testConjuntosVacios() {

		Ejercicio5 ejercicio5 = new Ejercicio5();

        Set<Integer> conjunto1 = new TreeSet<>();
        Set<Integer> conjunto2 = new TreeSet<>();
        Set<Integer> conjuntoFusionado = new TreeSet<>();

		assertArrayEquals(conjuntoFusionado.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1, conjunto2).toArray());
	}
	
	Set<Integer> darFormatoConjuntoTipoInteger(String conjuntoCSV) {

        Set<Integer> conjunto = new TreeSet<>();

        for (String s : conjuntoCSV.split(", ")) {
        	conjunto.add(Integer.parseInt(s));
        }

		return conjunto;
	}
	
	Set<Double> darFormatoConjuntoTipoDouble(String conjuntoCSV) {

        Set<Double> conjunto = new TreeSet<>();

        for (String s : conjuntoCSV.split(", ")) {
        	conjunto.add(Double.parseDouble(s));
        }

		return conjunto;
	}
	
	Set<String> darFormatoConjuntoTipoString(String conjuntoCSV) {

        Set<String> conjunto = new TreeSet<>();

        for (String s : conjuntoCSV.split(", ")) {
        	conjunto.add(s);
        }

		return conjunto;
	}

	@ParameterizedTest
	@CsvFileSource(files = "test/ual/hmis/sesion05/ejercicio5/conjuntos.csv")
	void testFusionarConjuntosOrdenados(String conjuntosCSV) {

		Ejercicio5 ejercicio5 = new Ejercicio5();
		
		Set<Integer> conjunto1_i = null, conjunto2_i = null, conjuntoFusionado_i = null;
		Set<Double> conjunto1_d = null, conjunto2_d = null, conjuntoFusionado_d = null;
		Set<String> conjunto1_s = null, conjunto2_s = null, conjuntoFusionado_s = null;

        String[] tipoConjuntos = conjuntosCSV.split("; ");
        String tipo = tipoConjuntos[0];
        
        if (tipo.equals("primeroVacio")) {
        	conjunto1_s = conjunto2_s = new TreeSet<>();
        	
            String conjunto = tipoConjuntos[1];

            for (String s : conjunto.split(", ")) {
            	conjunto2_s.add(s);
            }
        } else if (tipo.equals("segundoVacio")) {
            conjunto1_s = conjunto2_s = new TreeSet<>();
            
            String conjunto = tipoConjuntos[1];

            for (String s : conjunto.split(", ")) {
            	conjunto1_s.add(s);
            }
        } else if (tipo.equals("ambosVacios")) {
        	conjunto1_s = conjunto2_s = conjuntoFusionado_s = new TreeSet<String>();
        } else if (tipo.equals("Integer")) {
            conjunto1_i = darFormatoConjuntoTipoInteger(tipoConjuntos[1]);
            conjunto2_i = darFormatoConjuntoTipoInteger(tipoConjuntos[2]);
            conjuntoFusionado_i = darFormatoConjuntoTipoInteger(tipoConjuntos[3]);
        } else if (tipo.equals("Double")) {
            conjunto1_d = darFormatoConjuntoTipoDouble(tipoConjuntos[1]);
            conjunto2_d = darFormatoConjuntoTipoDouble(tipoConjuntos[2]);
            conjuntoFusionado_d = darFormatoConjuntoTipoDouble(tipoConjuntos[3]);
        } else {
            conjunto1_s = darFormatoConjuntoTipoString(tipoConjuntos[1]);
            conjunto2_s = darFormatoConjuntoTipoString(tipoConjuntos[2]);
            conjuntoFusionado_s = darFormatoConjuntoTipoString(tipoConjuntos[3]);
        }
        
        if (tipo.equals("primeroVacio")) {
    		assertArrayEquals(conjunto2_s.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1_s, conjunto2_s).toArray());
        } else if (tipo.equals("segundoVacio")) {
    		assertArrayEquals(conjunto1_s.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1_s, conjunto2_s).toArray());
        } else if (tipo.equals("Integer")) {
    		assertArrayEquals(conjuntoFusionado_i.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1_i, conjunto2_i).toArray());
        } else if (tipo.equals("Double")) {
    		assertArrayEquals(conjuntoFusionado_d.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1_d, conjunto2_d).toArray());
        } else {
    		assertArrayEquals(conjuntoFusionado_s.toArray(), ejercicio5.fusionarConjuntosOrdenados(conjunto1_s, conjunto2_s).toArray());
        }
	}

}
