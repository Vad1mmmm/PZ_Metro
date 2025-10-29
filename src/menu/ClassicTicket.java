package menu;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class ClassicTicket extends Ticket {
    public ClassicTicket(String name, String subName, int id, int countRides, LocalDateTime timeUse) {
        super(name, subName, id, countRides, timeUse);
    }
}
