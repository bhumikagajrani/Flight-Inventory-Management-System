package flightmanagement.feature;

import flightmanagement.base.User;
import java.util.*;
public class UserService {

    private static UserService userService;
    private Map<String, User> users;

    private UserService() {
        users = new HashMap<>();
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();

        }
        return userService;
    }

    public User addUser(String userId, String name, double funds) {
        User user = new User(userId, name, funds);
        users.put(userId, user);
        return user;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
