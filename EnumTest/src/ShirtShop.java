public class ShirtShop {
    public static void main(String[] args){
        System.out.println("Start programu");
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(Size.SMALL);
        System.out.println("Wybrałeś thirt "+tshirt.getSize()+" "+tshirt.getSize().getDescription());
        System.out.println("Dostępne rozmiary:");
        for(Size s:Size.values()){
            System.out.println(s.getDescription());
        }
        tshirt.setSize(Size.valueOf("LARGE"));
        System.out.println("Wybrałeś: "+tshirt.getSize().getDescription());

        System.out.println("Wyświetlam typ enum:");
        tshirt.setType(Type.KAMIZELKA);
        System.out.println(tshirt.getType());
        tshirt.setKol(Kolekcja.JESIENNA);
        System.out.println(tshirt.getKol());

    }
}
