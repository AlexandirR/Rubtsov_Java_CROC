package Ex13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main (String[] args) {
        CommentsFilter commentsFilter = new CommentsFilter();
        List<String> comments = new ArrayList<>();
        comments.addAll(Arrays.asList("Abracadabra", "badword", "BadWord iN CaPs", "MorE AbrAcAdAbrA", "UgaBuga, you say goodword"));
        Set<String> badWords = Set.of("badword", "goodword");
        commentsFilter.filterComments(comments, badWords);
        System.out.println(comments);
    }
}
