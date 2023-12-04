package petstore.common.create;

import petstore.models.User;

public class UserCreate {

    public static User userCreate() {
        User user = new User();
        user.setId(1);
        user.setUsername("Afonia");
        user.setFirstName("Afonia");
        user.setLastName("Aboba");
        user.setEmail("ABC@soap.co");
        user.setPassword("password");
        user.setPhone("+7 (499) 134-94-27");
        user.setUserStatus(0);
        return user;
    }

    public static User minUserCreate() {
        User user = new User();
        user.setId(1);
        user.setUsername("Afonia");
        user.setFirstName("Afonia");
        user.setLastName("Aboba");
        user.setUserStatus(0);
        return user;
    }
}
