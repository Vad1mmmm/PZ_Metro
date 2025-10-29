package menu;
import java.util.Locale;
import java.util.Scanner;


public class Menu {
    public static void startSystem(){
        System.out.println(Greetings());
        firstVariant();
    }

    private static String Greetings(){
        return """
                Доброго дня!
                Ви перебуваєте в головному меню системи контролю доступу в метро
                Ви готові почати працювати?(Так/ні)""";
    }

    private static void firstVariant() {
        Scanner input = new Scanner(System.in);
        System.out.print("> ");
        String answer = input.nextLine().trim().toLowerCase(Locale.ROOT);

        switch (answer) {
            case "yes", "так" -> {
                System.out.println("Чудово, тоді турнікет запущено!");
                WorkTourniket.start();
            }
            case "admin1234" -> {
                MenuAdmin.StartMenuAdmin();
            }
            case "no", "ні" -> {
                System.out.println("Sorry, you can't go work!");
            }
            default -> {
                System.out.println("Не правильно введені дані! Спробуйте ще раз.\n");
                startSystem(); // рекурсивний повтор
            }
        }
    }




}
