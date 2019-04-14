package alejandro.lajusticia.recommendation.view.infrastructure.repository.impl;

import alejandro.lajusticia.recommendation.view.domain.model.User;
import alejandro.lajusticia.recommendation.view.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRepositoryImpl implements UserRepository {

    private final Map<String, User> users;

    public UserRepositoryImpl() {
        users = new HashMap<>();
    }

    public User getUserOrCreate(String id) {
        User user = users.get(id);

        if (user == null) {
            user = new User(id);
            addUser(user);
        }

        return user;
    }

    @Override
    public void addUser(User user) {
        users.put(user.getId(), user);
    }

}
