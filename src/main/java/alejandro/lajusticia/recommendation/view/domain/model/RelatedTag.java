package alejandro.lajusticia.recommendation.view.domain.model;

import java.util.Objects;

public class RelatedTag {

    private final Tag tag;
    private long views;

    public RelatedTag(final Tag tag) {
        this.tag = tag;
        views = 0;
    }

    public String getTagId() {
        return tag.getId();
    }

    public void addView() {
        views++;
    }

    public long getViews() {
        return views;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelatedTag that = (RelatedTag) o;
        return tag.equals(that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tag);
    }

}
