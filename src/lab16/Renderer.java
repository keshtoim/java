package lab16;

public class Renderer {
    public static void render(Drawable d) {
        System.out.println("Рендеринг: " + d.getDescription());
        d.draw();
    }

    public static void showArea(Shape s) {
        s.display();
        System.out.println("Площадь: " + s.calculateArea());
    }
}
