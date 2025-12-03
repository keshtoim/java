package lab15;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Tesla Model S", 10.0);

        Car.Engine engine = car.new Engine();
        engine.printModels();
        engine.start();
        System.out.println("Уровень топлива: " + car.getFuelLevel());

        Car.DiagnosticTool.runDiagnostics();
    }
}