package org.BennyIbarr.appFacturas.Modelo;

public class Itemfactura
{
    private int cantidad;
    private Producto producto;

    public Itemfactura(int cantidad, Producto producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getCantidad()
    {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    //método que calcula el precio del producto

    public float calcularImporte()
    {
       return cantidad * this.producto.getPrecio();
    }

    @Override
    public String toString() {
        return producto +
                "\t" + cantidad +
                "\t" + calcularImporte();
    }
}
