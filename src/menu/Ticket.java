package menu;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Ticket {
    private String name;
    private String subName;
    private int id;
    private int countRides;
    private LocalDateTime timeUse;
    public static ArrayList<Ticket> tickets =  new ArrayList<>();

    public Ticket() {}

    public Ticket(String name, String subName, int id, int countRides, LocalDateTime timeUse) {
        this.name = name;
        this.subName = subName;
        this.id = id;
        this.countRides = countRides;
        this.timeUse = timeUse;
        tickets.add(this);
    }

    public int getId() {
        return id;
    }

    public void WorkCountRides() {
        this.countRides = countRides-1;
    }
    public int getCountRides() {
        return this.countRides;
    }
    public LocalDateTime getLoadingDate(){
        return timeUse;
    }
    public void changeName(String name) { this.name = name; }
    public void changeSubName(String subName) { this.subName = subName; }
    public void changeId(int id) { this.id = id; }
    public void changeCountRides(int count) { this.countRides = count; }




    @Override
    public String toString() {

        String formattedTime = timeUse != null
                ? timeUse.format(java.time.format.DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"))
                : "—";

        return "Ім'я: " + name + ", Прізвище: " + subName + ", ID: " +  id + ", Кількість поїздок: " + countRides + ", Дата реєстрації: " + formattedTime;
    }
}
