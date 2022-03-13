package lld.ride_sharing.User;

import java.util.HashMap;

public class UserManager {
    private static UserManager userManager;
    public static HashMap<String, User> userDB = new HashMap<>();

    public static UserManager getUserManager() {
        if (userManager == null) {
            userManager = new UserManager();
        }

        return userManager;
    }

    public void addUser(String name) {
        userDB.put(name, new User(name));
    }

    public User getUser(String userName) {
        return userDB.get(userName);
    }
}
