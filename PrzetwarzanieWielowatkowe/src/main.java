
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[]args){
        List<Integer> lista = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        lista = lista.stream().parallel().map(main::incrementValue).collect(Collectors.toList());

    }
    private static int incrementValue(int x){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Przetwarzam: "+x);
        return x+1;
    }
}
