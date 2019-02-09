import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;

public class Task {
public static void main(String[]args){

Map<String,String>namesMap = new TreeMap<>();

 namesMap.put("Kowalski", "Jan Kowalski - 35");
 namesMap.put("Adamiak", "Ania Adamiak - 21");
 namesMap.put("Zaręba", "Adam Zaręba - 17");
 namesMap.put("Piotrowski", "Karol Piotrowski - 42");
 namesMap.put("Bobrowska", "Michalina Bobrowska - 15");

 Iterator<String> valuesIterator = namesMap.values().iterator();
 while (valuesIterator.hasNext()){
  System.out.println(valuesIterator.next());
 }
}
}
