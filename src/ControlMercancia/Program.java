package ControlMercancia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Program {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		Bodega bdg = new Bodega();
		
		BufferedReader bf = new BufferedReader(new FileReader("Datos-Bodega.txt"));
		int cantidadMercancia = Integer.parseInt(bf.readLine());
		
		String[] arrMercancia;
		for (int i = 0; i < cantidadMercancia; i++)
		{
			arrMercancia = bf.readLine().split(", ");
			Mercancia mercancia = new Mercancia(arrMercancia[0],Integer.parseInt(arrMercancia[1]), Integer.parseInt(arrMercancia[2]));
			
			int cantProductos = Integer.parseInt(arrMercancia[3]);
			
			for (int j = 0; j < cantProductos; j++) 
			{
				String producto = bf.readLine();
				mercancia.productos.add(producto);
			}
			
			bdg.añadir(mercancia);
		}
		
		System.out.println("\n====== Camiones ordenados por prioridad de mercancia ======");
		bdg.imprimirOrden();

		System.out.println("\n======  Cantidad de productos por tipo de mercancia   ======");
		bdg.mostrarCantidadProductos();
		
		System.out.println("\n======        Pago de descargue por cada camion       ======");
		bdg.calcularPagoDescargue();

		System.out.println("\n======   Pago total por todos los descargues hechos    ======");
		bdg.calcularPagoTotalDescargue();
	}
}
