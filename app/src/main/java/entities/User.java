package entities;

import java.util.List;

public class User {
    private String name;
    private String password;
    private String hashedPassword;
    private List<Ticket> ticketBookings;
    private String userId;

    public User(String name, String password, String hashedPassword, List<Ticket> ticketBookings, String userId){
        this.name = name;
        this.password = password;
        this.hashedPassword = hashedPassword;
        this.ticketBookings = ticketBookings;
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword(){
        return password;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public List<Ticket> getTicketBookings() {
        return ticketBookings;
    }

    public void printTickets(){
        for (Ticket ticketBooking : ticketBookings) {
            System.out.println(ticketBooking.getTicketInfo());
        }
    }

    public String getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public void setTicketBookings(List<Ticket> ticketBookings) {
        this.ticketBookings = ticketBookings;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
