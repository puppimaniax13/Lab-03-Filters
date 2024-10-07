import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(new Rectangle(2, 3));
        objects.add(new Rectangle(5, 5));
        objects.add(new Rectangle(3, 3));
        objects.add(new Rectangle(4, 5));
        objects.add(new Rectangle(1, 3));
        objects.add(new Rectangle(32, 5));
        objects.add(new Rectangle(2, 7));
        objects.add(new Rectangle(5, 1));
        objects.add(new Rectangle(2, 9));
        objects.add(new Rectangle(1, 1));


        BigRectangleFilter filter = new BigRectangleFilter();

        for (Object object : objects) {
            if (filter.accept(object)) {
                System.out.println(object);
            }
        }


// bigRectangles will contain only the Rectangle with perimeter > 10

    }
}
