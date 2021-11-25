package Ex16;

import Ex16.entities.Pair;
import Ex16.entities.Person;

import java.util.*;

public class Splitting {

    // Делаем реверс мапу, где ключ это пара значений - возратсные границы, а значения это сет с набором личностей этого возраста
    public static void initializeMap (Map<Pair<Integer, Integer>, Set<Person>> splitPersons, String[] args) {
        int leftLevel = 0;
        int rightLevel;
        for(String arg : args) {
            rightLevel = Integer.parseInt(arg);
            splitPersons.put(new Pair<>(leftLevel, rightLevel), new TreeSet<>());
            leftLevel = rightLevel + 1;
        }
        splitPersons.put(new Pair<>(leftLevel, null), new TreeSet<>());
    }

    //вывод мапы
    public static void outputMap (Map<Pair<Integer, Integer>, Set<Person>> splitPersons) {
        for (Map.Entry entry : splitPersons.entrySet()) {
            if(((TreeSet<Person>) entry.getValue()).size() != 0) {
                System.out.print(entry.getKey() + ": ");
                Iterator<Person> iterator =  ((TreeSet<Person>) entry.getValue()).iterator();
                while(iterator.hasNext()) {
                    Person personInSet = iterator.next();
                    System.out.print(personInSet);
                    if (iterator.hasNext()) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    //Считываем людей и ищем с помощью "upperbound"(т.к. мапа реверс по ключам) возрастные границы в которые они входят
    public static void main (String[] args) {
        TreeMap<Pair<Integer, Integer>, Set<Person>> splitPersons = new TreeMap<>(Collections.reverseOrder());
        initializeMap(splitPersons, args);
        String person = "";
        Scanner  scanner = new Scanner(System.in);
        person = scanner.nextLine();
        while(!person.equals("END")) {
            Integer age = Integer.parseInt(person.substring(person.indexOf(',') + 1));
            String name = person.substring(0, person.indexOf(','));
            Person onePerson = new Person(name, age);
            Pair<Integer, Integer> key = splitPersons.ceilingKey(new Pair<Integer, Integer>(age, age));
            splitPersons.get(key).add(onePerson);
            person = scanner.nextLine();
        }
        outputMap(splitPersons);
    }
}
