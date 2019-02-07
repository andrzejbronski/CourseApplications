import java.io.File;

public class CheckResources {

    private static final String APP_VERSION = "Check disk resources - ver 0.1";
    public static void main(String[] args) {

        File file = new File("E:/"); //path to disk which you want research
       if(file.exists() != true) {
           System.err.println("Nie znaleziono określonoej ścieżki!!");
           System.err.println("Sprawdź podany dysk!");
       }else {
           System.out.println(APP_VERSION);
           CheckResources checkResources = new CheckResources();
           checkResources.research(file);
       }
    }

    public void research(File fileX) {
        File[] files = fileX.listFiles();

            if (files != null) {
                for (File f : files) {
                    if (f.isDirectory()) {
                        System.out.println("Znaleziono folder: " + f.getAbsolutePath());
                        research(f);
                    } else {
                        System.out.println("Znaleziono plik: " + f.getAbsolutePath());

                    }
                }
            }
    }
}