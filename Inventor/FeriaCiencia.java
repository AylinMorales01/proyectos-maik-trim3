public class FeriaCiencia {
    public static void main(String[] args) {
        Inventor inventor1 = new InventorMecanico("James Watt", 30, 200, "Reino Unido", false, 0);
        Inventor inventor2 = new InventorSoftware("Ana Lisa Melano", 45, 90, "Colombia", true, 0);
        Inventor inventor3 = new InventorElectrico("Nikola Tesla" , 23, 95, "Croacia", false, 0);

        System.out.println();
        inventor1.presentacionInvento();
        inventor1.setTieneInvento(true);
        inventor1.ganarPuntos(100);
        System.out.println();
        inventor2.presentacionInvento();
        inventor2.ganarPuntos(15);
        System.out.println();
        inventor3.presentacionInvento();
        inventor3.setTieneInvento(true);
        inventor3.ganarPuntos(20);

    }
}