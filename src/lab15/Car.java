package lab15;

public class Car {
    private String model;
    private double fuelLevel;

    public Car(String model, double initialFuel) {
        this.model = model;
        this.fuelLevel = initialFuel;
    }

    public class Engine {
        private boolean isRunning = false;

        public void start() {
            if (fuelLevel > 0) {
                isRunning = true;
                System.out.println("Двигатель " + Car.this.model + " запущен.");
                fuelLevel -= 0.5;
            } else {
                System.out.println("Невозможно запустить двигатель: нет топлива.");
            }
        }

        public void stop() {
            isRunning = false;
            System.out.println("Двигатель остановлен.");
        }

        private String model = "EngineModel_X";

        public void printModels() {
            System.out.println("Модель двигателя: " + this.model);
            System.out.println("Модель автомобиля: " + Car.this.model);
        }
    }

    public static class DiagnosticTool {
        public static void runDiagnostics() {
            System.out.println("Запуск диагностики автомобиля... Все системы в норме.");
        }
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public String getModel() {
        return model;
    }
}
