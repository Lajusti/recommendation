package alejandro.lajusticia.recommendation.view.application.controller;

import alejandro.lajusticia.recommendation.view.application.controller.json.TagResponse;
import alejandro.lajusticia.recommendation.view.domain.exception.TagNotFoundException;
import alejandro.lajusticia.recommendation.view.domain.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tags")
class TagController {

    private final TagService tagService;

    public TagController(final TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    ResponseEntity<List<TagResponse>> getAllTags() {
        return new ResponseEntity<>(
                tagService.getAllTags().stream().map(tag -> {
                    TagResponse tagResponse = new TagResponse();
                    String tagId = tag.getId();
                    tagResponse.setTag(tagId);
                    try {
                        tagResponse.setPotentialTags(
                                tagService.getPotentialTagsFromTag(tagId)
                        );
                    } catch (TagNotFoundException e) {
                        System.out.println("ignored exception TagNotFoundException for id: " + tagId);
                    }
                    return tagResponse;
                }).collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "/{tagId}")
    ResponseEntity<List<String>> getPotentialTagsFromTag(@PathVariable String tagId) {
        try {
            return new ResponseEntity<>(
                    tagService.getPotentialTagsFromTag(tagId),
                    HttpStatus.OK
            );
        } catch (TagNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
