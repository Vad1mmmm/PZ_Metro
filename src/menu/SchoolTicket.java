package menu;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SchoolTicket extends Ticket {
    public SchoolTicket(String name, String  subName,int id, int countRides, LocalDateTime timeUse) {
        super(name, subName, id, countRides, timeUse);
    }
}
