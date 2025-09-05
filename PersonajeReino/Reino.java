abstract class PersonajeReino {
    private String nombre;
    private String raza;
    private int vida;


PersonajeReino(String nombre, String raza, int vida){
    this.nombre = nombre;
    this.raza = raza;
    this.vida = vida;
}


public String getNombre() {
    return nombre;
}

public String getRaza() {
    return raza;
}

public int getVida() {
    return vida;
}

public void setVida(int vida){
    this.vida = vida;
}

public void presentacion(){
    System.out.println (nombre + " es de raza " + raza + " y tiene " + vida + " de vida.");
}

abstract String secreto();
    abstract void ataque(PersonajeReino enemigo);

}

class Gigante extends PersonajeReino {
    Gigante(String nombre) {
        super(nombre, "Gigante", 150);
    }
@Override 
String secreto () {
    return "Con su fuerza, puede levantar piedras gigantes";
}

public void ataque(PersonajeReino enemigo) {
    System.out.println(getNombre() + " lanza una roca gigante!");
}
}

class Hada extends PersonajeReino {
    Hada (String nombre) {
        super(nombre, "Hada", 10);
    }
@Override
    String secreto () {
        return "Puede volar y tiene magia";
    }

public void ataque (PersonajeReino enemigo) {
    System.out.println(getNombre() + " lanza polvo de hada y hace volar a " + enemigo.getNombre());
}
}

class Bruja extends PersonajeReino {
    Bruja (String nombre){
        super(nombre, "Bruja", 80);
    }
@Override
    String secreto () {
        return "Lanza hechizos poderosos y posee una gran inteligencia";
    }

public void ataque (PersonajeReino enemigo) {
    System.out.println(getNombre() + " lanza un hechizo estratégico a " + enemigo.getNombre());
}
}

class Dios extends PersonajeReino {
    Dios (String nombre) {
        super(nombre, "Dios", 100000);
    }
@Override
    String secreto () {
        return "Dios del inframundo, controla las almas y tiene un perro de tres cabezas";
}

public void ataque (PersonajeReino enemigo) {
    System.out.println(getNombre() + " envía a su perro de tres cabezas para atacar a " + enemigo.getNombre());
}
}

public class Reino {
    public static void main(String[] args) {
        PersonajeReino gigante = new Gigante("Hagrid");
        PersonajeReino hada = new Hada("TinkerBell");
        PersonajeReino bruja = new Bruja("Maléfica");
        PersonajeReino dios = new Dios("Hades");

        System.out.println();
        gigante.presentacion();
        System.out.println(gigante.secreto());
        gigante.ataque(hada);
        System.out.println();

        hada.presentacion();
        System.out.println(hada.secreto());
        hada.ataque(bruja);
        System.out.println();


        bruja.presentacion();
        System.out.println(bruja.secreto());
        bruja.ataque(gigante);
        System.out.println();


        dios.presentacion();
        System.out.println(dios.secreto());
        dios.ataque(bruja);
        dios.ataque(hada);
        dios.ataque(gigante);
        System.out.println();
        
        
    }
}
