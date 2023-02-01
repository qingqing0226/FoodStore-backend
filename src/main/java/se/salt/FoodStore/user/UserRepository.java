package se.salt.FoodStore.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

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

    public User findById(long id) {
        return jpaUserRepository.findById(id).orElseThrow();
    }

    public User findByEmail(String email) {
        List<User> results = jpaUserRepository.findByEmail(email);
        if(results.size() == 0) throw new NoSuchElementException("No such user");
        else return results.get(0);
    }
}
