public class Metody {
    public static void main(String[]args){

        Metody metody = new Metody();
        metody.print5Times(3);
        metody.print5Times("Seba");

    }
    public <T> void print5Times(T arg){
        for (int i=0; i<5;i++){
            System.out.println(arg);
        }
    }
}
