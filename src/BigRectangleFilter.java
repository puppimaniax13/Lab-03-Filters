import java.awt.Rectangle;

public class BigRectangleFilter implements Filter {

    @Override
    public boolean accept(Object object) {
        if (object instanceof Rectangle rectangle) {
            int perimeter = 2 * (rectangle.width + rectangle.height);
            return perimeter > 10;
        }
        return false;
    }
}
