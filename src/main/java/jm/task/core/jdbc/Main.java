package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import java.util.List;

public class Main {

    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Иван", "Иваныч", (byte) 41);
        userService.saveUser("Иван", "Степаныч", (byte) 42);
        userService.saveUser("Иван", "Фомич", (byte) 43);
        userService.saveUser("Иван", "Кузьмич", (byte) 44);

        userService.removeUserById(3);

        List<User> userList = userService.getAllUsers();

        userList.stream().forEach(e -> System.out.println(e));

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
