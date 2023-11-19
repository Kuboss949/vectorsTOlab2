import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

public class Main {
    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(1, 2);
        Polar2DAdapter v2 = new Polar2DAdapter(new Vector2D(1, 1));
        Vector3DDecorator v3 = new Vector3DDecorator(new Vector2D(2, 2), 1);

        System.out.println("Coordinates:");
        Arrays.stream(v1.getComponents()).forEach(n -> System.out.println(n + " "));
        Arrays.stream(v2.getComponents()).forEach(n -> System.out.println(n + " "));
        Arrays.stream(v3.getComponents()).forEach(n -> System.out.println(n + " "));
        System.out.println("Angles:");
        System.out.println(new Polar2DAdapter(v1).getAngle());
        System.out.println(v2.getAngle());
        System.out.println("Cdot:");
        System.out.println(v1.cdot(v2));
        System.out.println(v1.cdot(v3));
        System.out.println(v2.cdot(v3));
        System.out.println("Cross product:");
        Arrays.stream(v3.cross(v1).getComponents()).forEach(n -> System.out.println(n + " "));
        Arrays.stream(new Vector3DDecorator(v1, 0).cross(v3).getComponents()).forEach(n -> System.out.println(n + " "));
        Arrays.stream(v3.cross(v2).getComponents()).forEach(n -> System.out.println(n + " "));
        Arrays.stream(new Vector3DDecorator(v2, 0).cross(v3).getComponents()).forEach(n -> System.out.println(n + " "));
        Arrays.stream(new Vector3DDecorator(v1, 0).cross(v2).getComponents()).forEach(n -> System.out.println(n + " "));
        Arrays.stream(new Vector3DDecorator(v2, 0).cross(v1).getComponents()).forEach(n -> System.out.println(n + " "));




    }
}