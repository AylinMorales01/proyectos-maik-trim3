package model;

public class Bicicleta {
    private Long id;
    private String marca;
    private String color;
    private Double precio;
    

    public Bicicleta (String marca, String color, Double precio) {
        this.marca = marca;
        this.color = color;
        this.precio = precio;
    }

    public Bicicleta (Long id, String marca, String color, Double precio) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public Double getPrecio() {
        return precio;
    }
}
