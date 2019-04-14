package alejandro.lajusticia.recommendation.view.infrastructure.repository.impl;

import alejandro.lajusticia.recommendation.view.domain.model.Tag;
import alejandro.lajusticia.recommendation.view.infrastructure.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TagRepositoryImpl implements TagRepository {

    private final Map<String, Tag> tags;

    public TagRepositoryImpl() {
        tags = new HashMap<>();
    }

    @Override
    public Tag getTagOrCreate(String id) {
        Tag tag = tags.get(id);

        if (tag == null) {
            tag = new Tag(id);
            addTag(tag);
        }

        return tag;
    }

    @Override
    public Optional<Tag> getTag(String id) {
        Tag tag = tags.get(id);

        if (tag == null) {
            return Optional.empty();
        }

        return Optional.of(tag);
    }

    @Override
    public void addTag(Tag tag) {
        tags.put(tag.getId(), tag);
    }

    @Override
    public List<Tag> getAllTags() {
        return new ArrayList<>(this.tags.values());
    }

}