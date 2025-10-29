package menu;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;
import static menu.Ticket.tickets;

public class MenuAdmin {
    public static void StartMenuAdmin() {
        adminMenu();
    }
    private static void adminMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println(
                """
                
                Ви ввійшли в режим адміністратора метро :)
                Оберіть вашу наступну дію
                1. Додати пропуск
                2. Видалити пропуск
                3. Редагувати дані
                4. Показати список усіх користувачів метрополітену
                5. Повернутися в користувацький режим
                Оберіть дію:""");
        System.out.print("> ");
        try {
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                newTicket();
                adminMenu();
                break;
            case 2:
                deleteTicket();
                adminMenu();
                break;

            case 3:

                changesTicket();
                adminMenu();
                break;
            case 4:
                for (Ticket onetapcik : tickets) {
                    System.out.println(onetapcik);
                    if(tickets.size() == 0) System.out.println("Список порожній!");
                }
                adminMenu();
                break;
            case 5:
                Menu.startSystem();
                break;
        }
        }
        catch (InputMismatchException e) {
            System.out.println("Не правильно обрана дія");
        }
    }

    private static Ticket newTicket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Ви обрали режим додавання користувачів");
        System.out.print("""
                Оберіть тип майбутнього квитка
                1. Класичний
                2. Шкільний
                3. Студентський
                >\s""");
        try{
        int choiceType = input.nextInt();
        input.nextLine();

            switch (choiceType) {
                case 1, 2 -> {
                    AddTicket data = addTicket();
                    return new Ticket(
                            data.name(),
                            data.subName(),
                            data.id(),
                            data.countRides(),
                            data.timeUse()
                    );
                }
                case 3 -> {
                    try {
                        AddTicket data = addTicket();
                        System.out.print("Введіть номер студентського квитка: ");
                        int numStudentBook = input.nextInt();
                        return new StudentTicket(
                                data.name(),
                                data.subName(),
                                data.id(),
                                data.countRides(),
                                data.timeUse(),
                                numStudentBook

                        );
                    } catch (InputMismatchException e) {
                        System.out.println("Не правильно введено формат даних");
                        return null;
                    }
                }
                default -> {
                    System.out.println("Невірний вибір типу квитка!");
                    adminMenu();
                    return null;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Не вірний формат вводу даних");
            return null;
        }
    }

    private record AddTicket(String name, String subName, int id, int countRides, LocalDateTime timeUse) {}

    private static AddTicket addTicket() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Введіть ім'я: ");
            String name = input.nextLine();
            System.out.print("Введіть прізвище: ");
            String subName = input.nextLine();
            System.out.print("Присвойте ID: ");
            int id = input.nextInt();
            System.out.print("Вкажіть кількість поїздок: ");
            int countRides = input.nextInt();
            LocalDateTime time = LocalDateTime.now();

            return new AddTicket(name, subName, id, countRides, time);
        } catch (InputMismatchException e) {
            System.out.println("Не првильно введено формат даних");
            return null;
        }
    }
    private static void deleteTicket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть ID картки");
        System.out.print("> ");
        int id = input.nextInt();
        for  (Ticket onetapcik : tickets) {
            if(onetapcik.getId() == id){
                tickets.remove(onetapcik);
                System.out.println(onetapcik + " - успішно видалений");
                break;
            }
            else System.out.println("За даним id нікого не знайдено");
        }
    }

    private static void changesTicket() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть ID картки");
        System.out.print("> ");
        int id = input.nextInt();
        input.nextLine();
        for (Ticket onetapcik : tickets) {
            if(onetapcik.getId() == id){
                System.out.print("""
                        Виберіть, що саме ви хочете змінити
                        1. Ім'я
                        2. Прізвище
                        3. ID
                        4. Оновити кількість доступних поїздок
                        5. Зробіть вибір:\s"""
                        );
                int choise = input.nextInt();
                input.nextLine();

                switch (choise){
                    case 1 -> {
                        System.out.print("Введіть нове ім'я: ");
                        String name = input.nextLine();
                        onetapcik.changeName(name);
                        System.out.println("Зміни успішно збережено!");
                    }
                    case 2 -> {
                        System.out.print("Введіть нове прізвище: ");
                        String subName = input.nextLine();
                        onetapcik.changeSubName(subName);
                        System.out.println("Зміни успішно збережено!");
                    }
                    case 3 -> {
                        System.out.println("Введіть новке ID: ");
                        int newId = input.nextInt();
                        onetapcik.changeId(newId);
                        System.out.println("Зміни успішно збережено!");
                    }
                    case 4 -> {
                        System.out.println("Введіть нову кількість поїздок: ");
                        int newCount = input.nextInt();
                        onetapcik.changeCountRides(newCount);
                        System.out.println("Зміни успішно збережено!");
                    }
                }
                break;
            }

        }
    }

}
