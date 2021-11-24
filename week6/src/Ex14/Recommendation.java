package Ex14;

import java.io.IOException;
import java.util.*;

public class Recommendation {

    public static InitialFiles initialFiles;

    static {
        try {
            initialFiles = new InitialFiles("src/Ex14/films.txt", "src/Ex14/views.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* Находит среди списков просмотров те, у которых пересечение с нашим юзером соотвствует условию
     и берет из них те фильмы, что юзер еще не посмотрел */
    public static Set<Integer> crossings (Set<Integer> userFilms) {
        Set<Integer> crossing = new HashSet<>();
        for (Set<Integer> views : InitialFiles.listOfViews) {
            Set<Integer> result = new HashSet<>();
            result.addAll(userFilms);
            result.retainAll(views);
            if(result.size() >= (userFilms.size() - 1)/2 + 1) {
                Set<Integer> removes = new HashSet<>();
                removes.addAll(views);
                removes.removeAll(userFilms);
                crossing.addAll(removes);
            }
        }
        return crossing;
    }

    // Выбирает один фильм среди всех кандидатов на рекомендации
    public static Integer oneRecommendation(Set<Integer> allRecommendation) {
        int maxIndex = 0;
        Integer maxContain = null;
        for(Integer recommendation : allRecommendation) {
            int temp = 0;
            for (Set<Integer> views: InitialFiles.listOfViews) {
                if(views.contains(recommendation)) {
                    temp++;
                }
            }
            if(temp > maxIndex) {
                maxIndex = temp;
                maxContain = recommendation;
            }
        }
        return maxContain;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line  = scanner.nextLine();
        String[] films = line.split(",");
        Set<Integer> userFilms = new HashSet<>();
        for (String film: films) {
            userFilms.add(Integer.parseInt(film));
        }
        Set<Integer> allRecommendation = crossings(userFilms);
        Integer recommendation = oneRecommendation(allRecommendation);
        if(recommendation != null) {
            System.out.println(InitialFiles.films.get(recommendation));
        }
        else {
            System.out.println("Not recommendation");
        }
    }
}
