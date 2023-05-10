package ual.hmis.sesion05.ejercicio5;

import java.util.*;

public class Ejercicio5 {

	public <T extends Comparable<T>> Set<T> fusionarConjuntosOrdenados(Set<T> conjunto1, Set<T> conjunto2) {

		if (conjunto1.isEmpty())
			if (conjunto2.isEmpty()) return new TreeSet<T>();
			else return conjunto2;
		else if (conjunto2.isEmpty())
			return conjunto1;

        Set<T> conjuntoFusionado = new TreeSet<T>(conjunto1);
        conjuntoFusionado.addAll(conjunto2);

        return conjuntoFusionado;
	}
}
