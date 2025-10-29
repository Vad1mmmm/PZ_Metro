package menu;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import static menu.Ticket.tickets;

public class WorkTourniket {

    public static void start() {
        StartWorking();
    }
    private static void StartWorking() {
        Scanner input = new Scanner(System.in);
        int idScan = -1;
        String adminMode = " ";

        while (true) {
            System.out.println("Введіть ID картки");
            System.out.print("> ");
            String line = input.nextLine();

            try {
                idScan = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                adminMode = line.trim();
            }

            try {
                if (adminMode.equals("admin1234")) {
                    MenuAdmin.StartMenuAdmin();
                }

                if (idScan == 0) {
                    System.out.println("Завершення роботи системи.");
                    break; // вихід з циклу
                }

                boolean found = false;

                for (Ticket onetapcik : tickets) {
                    if (onetapcik.getId() == idScan) {
                        System.out.println(onetapcik);
                        if(onetapcik.getCountRides() > 0 || onetapcik.getLoadingDate().plusMonths(1).isAfter(LocalDateTime.now())) {
                            onetapcik.WorkCountRides();
                        }
                        else{
                            System.out.println("В даного користувача закінчився допуче до поїздок");
                        }
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Картку з таким ID не знайдено!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Не правильно введений формат id, спробуйте ще раз!");
                input.nextLine();
            }
        }
    }
}
