package alejandro.lajusticia.recommendation.view.domain.model;

import java.util.*;

public class Tag {

    private final String id;
    private List<RelatedTag> sortedRelatedTags;
    private Map<String, RelatedTag> relatedTagMap;
    private final static TagComparator tagComparator = new TagComparator();

    public Tag(final String id) {
        this.id = id;
        sortedRelatedTags = new ArrayList<>();
        relatedTagMap = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void addRelatedTags(List<Tag> tags) {
        tags.forEach(tag -> {
            RelatedTag relatedTag = relatedTagMap.get(tag.id);
            if (relatedTag == null) {
                relatedTag = new RelatedTag(tag);
                relatedTagMap.put(tag.id, relatedTag);
                sortedRelatedTags.add(relatedTag);
            }
            relatedTag.addView();
        });
        sortedRelatedTags.sort(tagComparator);
    }

    public List<RelatedTag> getSortedRelatedTags() {
        return sortedRelatedTags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return id.equals(tag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private static class TagComparator implements Comparator<RelatedTag> {

        public int compare(RelatedTag a, RelatedTag b) {
            if (a.getViews() > b.getViews()) {
                return -1;
            } else if (b.getViews() > a.getViews()) {
                return 1;
            }
            return 0;
        }

    }

}
