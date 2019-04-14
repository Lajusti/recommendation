package alejandro.lajusticia.recommendation.view.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    private final String id;
    private List<String> tags;

    public User(final String id) {
        this.id = id;
        tags = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addTag(String tag) {
        if (!hasTag(tag)) {
            tags.add(tag);
        }
    }

    public List<String> getOtherTags(String tag) {
        return tags.stream()
                .filter(currentTag -> !currentTag.equals(tag))
                .collect(Collectors.toList());
    }

    public boolean hasTag(String tag) {
        return tags.contains(tag);
    }

}