package model;

import java.util.Comparator;

public abstract class Ordenar implements Comparator<Arbitro> {

	public abstract int compare(Arbitro uno, Arbitro otro);
}
