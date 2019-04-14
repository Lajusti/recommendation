package alejandro.lajusticia.recommendation.view.domain.service.impl;

import alejandro.lajusticia.recommendation.view.domain.exception.TagNotFoundException;
import alejandro.lajusticia.recommendation.view.domain.model.RelatedTag;
import alejandro.lajusticia.recommendation.view.domain.model.Tag;
import alejandro.lajusticia.recommendation.view.domain.service.TagService;
import alejandro.lajusticia.recommendation.view.infrastructure.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository repository;

    public TagServiceImpl(final TagRepository tagRepository) {
        repository = tagRepository;
    }

    @Override
    public void addRelatedTagsToTag(List<String> relatedTagsId, String tagId) {
        Tag tag = repository.getTagOrCreate(tagId);
        List<Tag> relatedTags = relatedTagsId.stream()
                .map(relatedTagId -> {
                    Tag relatedTag = repository.getTagOrCreate(relatedTagId);
                    relatedTag.addRelatedTags(Collections.singletonList(tag));
                    return relatedTag;
                })
                .collect(Collectors.toList());
        tag.addRelatedTags(relatedTags);
    }

    @Override
    public List<String> getPotentialTagsFromTag(String id) throws TagNotFoundException {
        Optional<Tag> optionalTag = repository.getTag(id);

        if (!optionalTag.isPresent()) {
            throw new TagNotFoundException(id);
        }

        Tag tag = optionalTag.get();
        List<RelatedTag> relatedTags = tag.getSortedRelatedTags();
        if (relatedTags.size() > 10) {
            relatedTags = relatedTags.subList(0, 10);
        }

        return relatedTags.stream()
                .map(RelatedTag::getTagId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Tag> getAllTags() {
        return repository.getAllTags();
    }

}
