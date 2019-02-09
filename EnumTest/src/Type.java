public enum Type {
    KAMIZELKA("Kamizel"),KOSZULKA("Kosz"),HALKA("Hal"),GOLF("Gol"),PULOWER("Pul");

    private String opis;

     Type(String description){ //konstruktor NIE MOŻE być public czy protected!
        opis = description;
    }
    public String getOpis(){
         return opis;
    }
}
