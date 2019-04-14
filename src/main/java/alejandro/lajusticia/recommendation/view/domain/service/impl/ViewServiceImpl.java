package alejandro.lajusticia.recommendation.view.domain.service.impl;

import alejandro.lajusticia.recommendation.view.application.exception.WrongViewFormatException;
import alejandro.lajusticia.recommendation.view.domain.service.TagService;
import alejandro.lajusticia.recommendation.view.domain.service.UserService;
import alejandro.lajusticia.recommendation.view.domain.service.ViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {

    private final TagService tagService;
    private final UserService userService;

    public ViewServiceImpl(final TagService tagService, final UserService userService) {
        this.tagService = tagService;
        this.userService = userService;
    }

    @Override
    public void processView(String view) throws WrongViewFormatException {
        String[] viewSplitted = view.split(",");

        if (viewSplitted.length < 3) {
            throw new WrongViewFormatException(view);
        }

        String userId = viewSplitted[1];
        String tagId = viewSplitted[2];
        userService.addTagToUser(userId, tagId);
        List<String> relatedTagsOfView = userService.getRelatedTagsForUserAndTag(userId, tagId);
        tagService.addRelatedTagsToTag(relatedTagsOfView, tagId);
    }

}
