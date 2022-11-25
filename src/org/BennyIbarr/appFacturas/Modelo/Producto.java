package org.BennyIbarr.appFacturas.Modelo;

public class Producto
{
    private int codigo;
    private String nombre;
    float precio;
    private static int ultimoCodigo;

    //Constructor de la clase
    public Producto()
    {
        this.codigo = ++ultimoCodigo;
    }

    //Getters y Setters para poder tener acceso a los atributos encapsulados.
    public int getCodigo() {
        return codigo;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return  codigo +
                "\t" + nombre +
                "\t" + precio;
    }
}
