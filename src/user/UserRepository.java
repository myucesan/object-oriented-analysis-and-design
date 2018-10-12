package user;

import database.Database;

import java.util.List;

public class UserRepository {

    List<User> users;

    UserDao dao;

    public UserRepository(Database database) {
        dao = new UserDao(database);
    }

    public List<User> getUsers() {
        if (users == null) {
            users = dao.getUsers();
        }
        return users;
    }

    public List<User> getUserById(int id) {
        return null;
    }

    public User createUser(String name, String password, boolean isAdmin) {

        if (users == null) {
            getUsers();
        }

        //TODO: Check if user exsists


        User user = new User(name, new Password(password), isAdmin);
        users.add(user);

        return user;
    }
}
