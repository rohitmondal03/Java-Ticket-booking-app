package services;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;

public class UserBookingService {
    private User user;
    private List<User> usersList;
    private static final String USERS_PATH= "../localDB/users.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public UserBookingService(User user1) throws  IOException {
        this.user = user1;
        File users = new File(USERS_PATH);
        usersList= objectMapper.readValue(users, new TypeReference<List<User>>() {});
    }
}
