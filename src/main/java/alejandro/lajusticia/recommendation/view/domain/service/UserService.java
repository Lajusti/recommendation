package alejandro.lajusticia.recommendation.view.domain.service;

import java.util.List;

public interface UserService {

    void addTagToUser(String userId, String tagId);

    List<String> getRelatedTagsForUserAndTag(String userId, String tagId);

}
