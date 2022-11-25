package org.BennyIbarr.appFacturas.Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Itemfactura[] items;
    private int indiceItems;
    public static final int MAX_ITEMS = 12;
    private static int ultimoFolio;

    //Constructor que crea objetos de tipo facturas
    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        //Serán un total de 12 facturas las que se crearan.
        this.items = new Itemfactura[MAX_ITEMS];
        //El folio se crea desde el inicio y el preincremento hace que se cree en 1
        this.folio = ++ultimoFolio;
        //Cuando se crea el objeto factura se crea con la fecga actual
        this.fecha = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Itemfactura[] getItems() {
        return items;
    }

    public void addItemFactura(Itemfactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        }
    }

    public float calcularTotal() {
        float total = 0.0f;
        for (Itemfactura item : this.items) {
            //Validamos con el objeto de evitar eun nuulPointerException
            if (item == null) {
                continue;
            }
            total += item.calcularImporte();
        }
        return total;
    }
    //utilizamos String Builder para construir todos los elementos a ser impresos
    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura No.: ");
        sb.append(folio)
                .append("\nCliente ")
                .append(this.cliente.getNombre())
                .append("\t RFC: ")
                .append(cliente.getRFC())
                .append("\nDescripción: ")
                .append(this.descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha de emision de la factura: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t $\t  Cant.\tTotal\n");

        for (Itemfactura item: this.items)
        {
            if(item == null)
            {
                continue;
            }
            sb.append(item)
                    .append("\n");
        }
        sb.append("\n Gran total de la factura: ")
                .append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}
