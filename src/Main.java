import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        /*
         Если ввести букву, получаю Exception. Не получилось сделать так, чтобы при вводе не числа,
         программа выдавала сообщение "Нужно ввести целое число"
         и продолжила работу. Пробовал через try-catch и do-while.
         */
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            if (userInput == 1) {
                System.out.println("Введите месяц от 1 до 12: ");
                int month = scanner.nextInt();
                System.out.println("Введите день от 1 до 30: ");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов: ");
                int steps = scanner.nextInt();
                stepTracker.saveStepsForDay(month, day, steps);
            } else if (userInput == 2) {
                System.out.println("Введите месяц от 1 до 12: ");
                int month = scanner.nextInt();
                stepTracker.monthlyStatistics(month);
            } else if (userInput == 3) {
                System.out.println("Введите желаемое количество шагов: ");
                int stepTarget = scanner.nextInt();
                stepTracker.setStepTarget(stepTarget);
            } else if (userInput == 0) {
                break;
            } else {
                System.out.println("Такой команды нет");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}


