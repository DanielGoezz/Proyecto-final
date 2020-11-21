package ControlMercancia;

import java.util.ArrayList;

public class Mercancia implements Comparable<Mercancia>
{
	String tipo;
	int prioridad;
	int peso;
	ArrayList<String> productos =  new ArrayList<>();
	
	public Mercancia (String tipoVlr, int prioridadVlr,int pesoVlr) 
	{
		tipo = tipoVlr;
		prioridad = prioridadVlr;
		peso = pesoVlr;
	}

	@Override
	public int compareTo(Mercancia mercancia) 
	{
		return this.prioridad - mercancia.prioridad;
	}
}
