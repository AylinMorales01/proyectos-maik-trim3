abstract class Inventor {
    private String nombre;
    private int edad;
    private int nivelCreatividad;
    private String pais;
    private boolean tieneInvento;
    private int puntos;

    public Inventor (String nombre, int edad, int nivelCreatividad, String pais, boolean tieneInvento, int puntos) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivelCreatividad = nivelCreatividad;
        this.pais = pais;
        this.tieneInvento = false;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getNivelCreatividad() {
        return nivelCreatividad;
    }

    public boolean isTieneInvento() {
        return tieneInvento;
    }

    protected void setTieneInvento(boolean tieneInvento) {
        this.tieneInvento = tieneInvento;
    }

    public int getpuntos() {
        return puntos;
    }

    public void ganarPuntos (int puntos) {
        if (!tieneInvento) {
            System.out.println(nombre + " no tiene un invento presentado, no puede ganar puntos.");
            return;
        }
        if (puntos > 0){
            this.nivelCreatividad += puntos;
            System.out.println(nombre + " ganó " + puntos + " puntos, ahora tiene " + nivelCreatividad + " puntos de creatividad.");
        }
    }

    public String getPais() {
        return pais;
    }

    public abstract void presentacionInvento();
    }

    class InventorMecanico extends Inventor {
        public InventorMecanico(String nombre, int edad, int nivelCreatividad, String pais, boolean tieneInvento, int puntos) {
            super(nombre, edad, nivelCreatividad, pais, tieneInvento, puntos);
        }

            @Override
            public void presentacionInvento() {
                System.out.println ("Hola, soy " + getNombre() + " vengo de " + getPais() + ", me apasiona la mecánica y hoy les voy a presentar un invento que durante mucho tiempo he estado construyendo, yo la llamo la máquina de Newcomen, esta funciona convirtiendo la energía térmica del vapor de agua en energía mecánica permitiendole a un objeto, por ejemplo, una rueda moverse.");
        }
    }

    class InventorSoftware extends Inventor {
        public InventorSoftware(String nombre, int edad, int nivelCreatividad, String pais, boolean tieneInvento, int puntos) {
            super(nombre, edad, nivelCreatividad, pais, tieneInvento, puntos);
        }

        @Override
        public void presentacionInvento() {
            System.out.println ("Buenas tardes a todos los jurados, mi nombre es " + getNombre() + " tengo " + getEdad() + " años, desde muy joven me ha gustado el software y les presento mi programa de software que podria revolucionar el mundo de la tecnología.");
        }
    }

    class InventorElectrico extends Inventor {
        public InventorElectrico(String nombre, int edad, int nivelCreatividad, String pais, boolean tieneInvento, int puntos) {
            super(nombre, edad, nivelCreatividad, pais, tieneInvento, puntos);
        }

        @Override
        public void presentacionInvento() {
            System.out.println ("Buenas noches soy " + getNombre() + ", me interesa la electricidad hoy les voy a mostrar la transmisión de energía eléctrica sin cables.");
        }
    }


