package alejandro.lajusticia.recommendation.view.domain.service.impl;

import alejandro.lajusticia.recommendation.view.domain.model.User;
import alejandro.lajusticia.recommendation.view.domain.service.UserService;
import alejandro.lajusticia.recommendation.view.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(final UserRepository userRepository) {
        repository = userRepository;
    }

    @Override
    public void addTagToUser(String userId, String tagId) {
        User user = repository.getUserOrCreate(userId);
        user.addTag(tagId);
    }

    @Override
    public List<String> getRelatedTagsForUserAndTag(String userId, String tagId) {
        User user = repository.getUserOrCreate(userId);
        return user.getOtherTags(tagId);
    }
}
