package ControlMercancia;
import java.util.*;

public class Bodega 
{
	PriorityQueue<Mercancia> colaMercancia= new PriorityQueue<>();
	
	void imprimirOrden()
	{
		for (Mercancia mercancia : colaMercancia)
		{
			System.out.println("\nTipo de mercancia: " + mercancia.tipo);
			
			System.out.println("productos: ");
			for(String productos: mercancia.productos)
			{
				System.out.println(productos);
			}
		}
	}
	
	void añadir (Mercancia mercancia)
	{
		colaMercancia.add(mercancia);
	}
	
	void mostrarCantidadProductos () 
	{
		Hashtable<String,Integer > hashtable = new Hashtable<>();
		
		for (Mercancia mercancia: colaMercancia) 
		{
			int contador = 1;
			for(String productos : mercancia.productos)
			{
				if (hashtable.containsKey(mercancia.tipo)) 
				{
					contador =  hashtable.get(mercancia.tipo);
					contador++;
				}
				
				hashtable.put(mercancia.tipo, contador);
			}
		}
		
		hashtable.forEach((key, value) -> {
			System.out.println(key + ": " + value);
		});
	}
	void calcularPagoTotalDescargue()//Calculo 3.
	{
		int valorTotal = 0;
		for(Mercancia mercancia: colaMercancia)
		{			
			int valor = convertirKxT(mercancia.peso) * 10000;
			valorTotal += valor;
		}
		
		System.out.println("El pago total por descargues fue de: " + valorTotal);

		System.out.println("\n====== Promedio del descargue por camiones ======");
		System.out.println("El promedio pagado por camion fue de: " + valorTotal / colaMercancia.size()); //Calculo 4.
	}
	
	void calcularPagoDescargue()//Calculo 2.
	{
		int contador = 1;
		for(Mercancia mercancia: colaMercancia)
		{			
			int valor = convertirKxT(mercancia.peso) * 10000;
			System.out.println("El camion " + contador + " con " + mercancia.tipo + " debe de pagar " + valor + " por el descargue.");
			contador ++;
		}
	}
	
	int convertirKxT(int kilos) //Calculo 1.
	{
		int tonelada = kilos / 1000;
		return tonelada;
	}
}

