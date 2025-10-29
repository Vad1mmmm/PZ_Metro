package menu;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class StudentTicket extends Ticket {

    private int numberOfStudentTick;

    public StudentTicket(String name, String  subName, int id, int countRides, LocalDateTime timeUse, int numberOfStudentTick) {
        super(name, subName, id, countRides, timeUse);
        this.numberOfStudentTick = numberOfStudentTick;
    }

    @Override
    public String toString() { return super.toString() + ", studentNumber: " + numberOfStudentTick ; }
}
