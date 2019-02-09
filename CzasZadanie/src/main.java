import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
public class main {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        Instant start = null;
        Instant stop = null;
        System.out.println("Aby uruchomić stoper wciśnij ENTER");
        String button = scanner.nextLine();
       if (button.isEmpty()){
           System.out.println("Wcisnąłes ENTER -> Start odliczania\nAby przerwać stoper wciśnij ENTER ponownie");
          start = Instant.now();

       }else {
           System.out.println("Podałeś inny znak niż ENTER! Wyjście awaryjne z programu!!");
           System.exit(0);

       }
        button = scanner.nextLine();
       if (button.isEmpty()){
           System.out.println("Wsisnąłeś ENTER ponownie -> koniec odliczania");
           stop = Instant.now();
       }else {
           System.out.println("Wcisnąłeś inny klawisz niż ENTER! Wyjście awaryjne z programu!");
       }
        Duration duration = Duration.between(start,stop);
        System.out.println("Upłynęło: "+duration.getSeconds()+" sekund");
    }

}
