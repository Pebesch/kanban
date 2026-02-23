package ch.schmucki.services;

import ch.schmucki.core.user.User;
import ch.schmucki.models.PersistedUser;
import ch.schmucki.repositories.PersistedUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final PersistedUserRepository persistedUserRepository;

    @Autowired
    public UserService(PersistedUserRepository persistedUserRepository) {
        this.persistedUserRepository = persistedUserRepository;
    }

    public User login(String username, String password) throws IllegalArgumentException {
        var user = this.persistedUserRepository.findByUsername(username);
        if(user.getPassword().equals(password)) {
            return user.toDomain();
        }
        throw new IllegalArgumentException("Could not find user");
    }

    public User register(String username, String password) {
        var persistedUser = new PersistedUser();
        persistedUser.setUsername(username);
        persistedUser.setPassword(password);
        return this.persistedUserRepository.save(persistedUser).toDomain();
    }
}
