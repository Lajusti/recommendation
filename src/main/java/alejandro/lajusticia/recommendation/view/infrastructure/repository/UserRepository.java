package alejandro.lajusticia.recommendation.view.infrastructure.repository;

import alejandro.lajusticia.recommendation.view.domain.model.User;

public interface UserRepository {

    User getUserOrCreate(String id);

    void addUser(User user);

}
