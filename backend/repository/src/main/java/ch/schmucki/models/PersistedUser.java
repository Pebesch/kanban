package ch.schmucki.models;

import ch.schmucki.core.user.Password;
import ch.schmucki.core.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersistedUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;

    public User toDomain() {
        User user = new User();
        user.setName(username);
        user.setPassword(new Password(password));
        return user;
    }

    public static PersistedUser fromDomain(User user) {
        PersistedUser persistedUser = new PersistedUser();
        persistedUser.setUsername(user.getName());
        persistedUser.setPassword(user.getPassword().getPassword());
        return persistedUser;
    }
}
