import java.util.HashMap;

public class StepTracker {
    public int stepTarget = 10000;
    HashMap<Integer, MonthData> monthToData = new HashMap<>();

    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToData.put(i, new MonthData());
        }
    }

    public void saveStepsForDay(int month, int day, int steps) {

        try {
            if (steps > 0) {
                monthToData.get(month - 1).stepsAllDaysOfMonth[day - 1] = steps;
            } else {
                System.out.println("Шаги не могут быть отрицательными");
            }
        } catch (Exception e) {
            System.out.println("Неправильно введен месяц или день");
        }
    }

    public void monthlyStatistics(int month) {
        MonthData monthData = monthToData.get(month - 1);
        Converter converter = new Converter();
        try {

            for (int i = 1; i <= monthData.stepsAllDaysOfMonth.length; i++) {
                System.out.print(i + " день: " + monthData.stepsAllDaysOfMonth[i - 1] + ", ");
            }

            System.out.println();

            int sumStepsForMonth = 0;

            for (int i = 1; i <= monthData.stepsAllDaysOfMonth.length; i++) {
                sumStepsForMonth += monthData.stepsAllDaysOfMonth[i - 1];

            }
            System.out.println("Общее количество шагов за месяц: " + sumStepsForMonth);

            int maxStepsForMonth = 0;
            for (int i = 1; i <= monthData.stepsAllDaysOfMonth.length; i++) {
                if (monthData.stepsAllDaysOfMonth[i - 1] > maxStepsForMonth) {
                    maxStepsForMonth = monthData.stepsAllDaysOfMonth[i - 1];
                }
            }
            System.out.println("Максимальное пройденное количество шагов в месяце: " + maxStepsForMonth);

            int averageNumberOfSteps = 0;
            for (int i = 1; i <= monthData.stepsAllDaysOfMonth.length; i++) {
                averageNumberOfSteps = sumStepsForMonth / monthData.stepsAllDaysOfMonth.length;
            }
            System.out.println("Среднее количество шагов за месяц: " + averageNumberOfSteps);

            System.out.println("Пройденная дистанция за месяц: " + converter.stepsToKilometers(sumStepsForMonth) + " км");

            System.out.println("Количество соженных килокалорий за месяц : " + converter.stepsToKiloCalories(sumStepsForMonth) + " ккал");

            int currentSequence = 0;
            int maxSequence = 0;

            for (int steps : monthData.stepsAllDaysOfMonth) {
                if (steps > stepTarget) {
                    currentSequence++;
                } else {
                    currentSequence = 0;
                }
                if (currentSequence > maxSequence) {
                    maxSequence = currentSequence;
                }
            }
            System.out.println("Лучшая серия: " + maxSequence);
        } catch (Exception NullPointerException) {
            System.out.println("Неправильно введен месяц");
        }
    }

    public void setStepTarget(int stepTarget) {
        if (stepTarget > 0) {
            this.stepTarget = stepTarget;
        } else
            System.out.println("Шаги не могут быть отрицательными");
    }

    class MonthData {
        int[] stepsAllDaysOfMonth = new int[30];
    }
}





