package se.salt.FoodStore.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private JpaUserRepository jpaUserRepository;

    public List<User> findAll() {
        return Streamable.of(jpaUserRepository.findAll()).toList();
    }

    public User saveUser(User user) {
        return jpaUserRepository.save(user);
    }
}
