package org.BennyIbarr.appFacturas;

import org.BennyIbarr.appFacturas.Modelo.*;

import java.util.Scanner;

public class EjemploFactura
{
    public static void main(String[] args)
    {
        Cliente cliente = new Cliente();
        cliente.setRFC("IATB840430HNTB789");
        cliente.setNombre("Benito");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la descripción de la factura: ");
        String desc = sc.nextLine();
        Factura factura = new Factura(desc, cliente);

        Producto producto;
        System.out.println();

        for(int i=0; i<5;i++)
        {
            producto = new Producto();
            System.out.print("Ingrese producto No: " + producto.getCodigo() + ": " );
            producto.setNombre(sc.nextLine());

            System.out.print("Ingrese el precio del producto ");
            producto.setPrecio(sc.nextFloat());

            System.out.print("Ingrese la cantidad: ");
            factura.addItemFactura(new Itemfactura(sc.nextInt(), producto));

            System.out.println();
            sc.nextLine();
        }
        System.out.println(factura);
    }
}
