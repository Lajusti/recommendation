package alejandro.lajusticia.recommendation.view.domain.service;

import alejandro.lajusticia.recommendation.view.domain.exception.TagNotFoundException;
import alejandro.lajusticia.recommendation.view.domain.model.Tag;

import java.util.List;

public interface TagService {

    void addRelatedTagsToTag(List<String> relatedTagsId, String tagId);

    List<String> getPotentialTagsFromTag(String id) throws TagNotFoundException;

    List<Tag> getAllTags();

}
