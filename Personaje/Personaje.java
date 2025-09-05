public class Personaje {
    String nombre;
    String raza;
    Integer ki;
    Integer ataque;
    String planeta;

    public Personaje(String nombre, String raza, Integer ki, Integer ataque, String planeta) {
        this.nombre = nombre;
        this.raza = raza;
        this.ki = ki;
        this.ataque = ataque;
        this.planeta = planeta;
    }

    public void mostrarPersonaje(){
        System.out.println("El nombre es: " + nombre);
        System.out.println("La raza es: " + raza);
        System.out.println("El ki es: " + ki);
        System.out.println("El ataque es: " + ataque);
        System.out.println("El planeta es: " + planeta);    
    }

    public void ataque (Personaje oponente){
        System.out.println(this.nombre + " ataca a " + oponente.nombre + " con " + this.ataque + " de ataque.");
        oponente.ki -= this.ataque;
        System.out.println(oponente.nombre + " ahora tiene " + oponente.ki + " de ki.");
    }

    public void curar (Personaje curar, Integer catidadCuracion){
        System.out.println (curar.nombre + " cura a " + this.nombre);
        this.ki += curar.ki;
        System.out.println(this.nombre +  " ahora tiene " + this.ki + " de ki.");
    }

    public static void main(String[] args) {
        Personaje goku = new Personaje ("Goku", "Saiyan", 1000, 1500, "Vegito");
        Personaje vegeta = new Personaje ("Vegeta", "Saiyan", 1000, 1400, "Vegito");
        Personaje bulma = new Personaje ("Bulma", "Humana", 500, 0, "Tierra");
        
        
        /*goku.mostrarPersonaje();*/
        /*System.out.println();*/
        vegeta.mostrarPersonaje();
        System.out.println();
        goku.ataque(vegeta);
        System.out.println();
        vegeta.mostrarPersonaje();
        System.out.println();
        vegeta.curar(bulma, 1000);
        System.out.println();
        vegeta.mostrarPersonaje();
        

    }
}

