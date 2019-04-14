package alejandro.lajusticia.recommendation.view.infrastructure.repository;

import alejandro.lajusticia.recommendation.view.domain.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagRepository {

    Tag getTagOrCreate(String id);

    Optional<Tag> getTag(String id);

    void addTag(Tag tag);

    List<Tag> getAllTags();

}
