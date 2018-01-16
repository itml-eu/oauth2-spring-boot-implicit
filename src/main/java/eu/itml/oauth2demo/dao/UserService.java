package eu.itml.oauth2demo.dao;

import java.util.ArrayList;
import java.util.List;

import eu.itml.oauth2demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserService implements UserDetailsService {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1L, "peterfox@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri"));
        users.add(new User(2L, "johndoe@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri"));
        users.add(new User(3L, "katie@example.com", "$2a$10$D4OLKI6yy68crm.3imC9X.P2xqKHs5TloWUcr6z5XdOqnTrAK84ri"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users
                .stream()
                .filter(user -> hasSameUsername(username, user))
                .findFirst()
                .orElse(null);
    }

    private boolean hasSameUsername(String s, User user) {
        return user.getUsername().equals(s);
    }
}
