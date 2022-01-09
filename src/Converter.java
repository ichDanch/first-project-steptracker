public class Converter {

    public double stepsToKilometers(int steps) {
        return (steps * 75) / 100000.0;
    }

    public double stepsToKiloCalories(int steps) {
        return (steps * 50) / 1000.0;
    }
}
