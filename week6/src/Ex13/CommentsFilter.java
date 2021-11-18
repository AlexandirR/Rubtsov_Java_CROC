package Ex13;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CommentsFilter implements BlackListFilter {
    
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> badComments = new ArrayList<>();
        for (String comment : comments) {
            String tempComment = comment.toLowerCase();
            for (String badWord : blackList) {
                if(tempComment.contains(badWord)) {
                    badComments.add(comment);
                    break;
                }
            }
        }
        comments.removeAll(badComments);
    }
}