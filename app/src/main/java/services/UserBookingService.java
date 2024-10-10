package services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import utils.UserServiceUtils;

public class UserBookingService {
    private User user;
    private List<User> usersList;
    private static final String USERS_PATH= "app/src/main/java/localDB/users.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        loadUsersFromFile();
    }

    public UserBookingService() throws  IOException {
        loadUsersFromFile();
    }

    public void loadUsersFromFile() throws IOException{
        usersList = objectMapper.readValue(new File(USERS_PATH), new TypeReference<List<User>>() {});
    }

    public Boolean loginUser() {
        Optional<User> foundUser = usersList.stream().filter(user1  -> {
            return user1.getName().equalsIgnoreCase(user.getName()) && UserServiceUtils.checkPassword(user.getPassword(), user1.getHashedPassword());
        }).findFirst();
        return foundUser.isPresent();
    }

    public Boolean signupUser(User user1) {
        try{
            usersList.add(user1);
            saveUserToList();
            return Boolean.FALSE;
        }catch (IOException e){
            return Boolean.FALSE;
        }
    }

    private void saveUserToList() throws IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, usersList);
    }

    public void fetchBookings() {
        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId) {
//        TODO !!!
        return Boolean.FALSE;
    }
}
