package lab16;

public class Main {
    public static void main(String[] args) {
        //region анонимный класс, реализующий интерфейс Drawable
        Drawable circle = new Drawable() {
            @Override
            public void draw() {
                System.out.println("Рисуем круг (через анонимный класс)");
            }

            @Override
            public String getDescription() {
                return "Анонимный круг";
            }
        };
        //endregion

        //region анонимный класс, наследующий от абстрактного класса Shape
        Shape rectangle = new Shape("Прямоугольник (анонимный)") {
            @Override
            public double calculateArea() {
                return 5.0 * 3.0;
            }
        };
        //endregion

        //region передача анонимных объектов в методы
        Renderer.render(circle);
        System.out.println();
        Renderer.showArea(rectangle);
        System.out.println();
        //endregion

        //region сравнение с обычной реализацией интерфейса
        class RegularSquare implements Drawable {
            @Override
            public void draw() {
                System.out.println("Рисуем квадрат (обычный класс)");
            }

            @Override
            public String getDescription() {
                return "Обычный квадрат";
            }
        }

        Drawable square = new RegularSquare();
        Renderer.render(square);
        System.out.println();
        //endregion

        //region замена анонимного класса лямбда-выражением
        @FunctionalInterface
        interface SimpleAction {
            void execute();
        }
        //endregion

        //region анонимный класс
        SimpleAction anonAction = new SimpleAction() {
            @Override
            public void execute() {
                System.out.println("Выполнение через анонимный класс");
            }
        };
        //endregion

        SimpleAction lambdaAction = () -> System.out.println("Выполнение через лямбда");

        anonAction.execute();
        lambdaAction.execute();
    }
}