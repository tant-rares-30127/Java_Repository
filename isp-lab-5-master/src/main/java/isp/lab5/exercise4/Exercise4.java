package isp.lab5.exercise4;

public class Exercise4 {
    
        public static void main(String[] args) {
        AbstractShapeFactory roundedShapeFactory = ShapeFactoryProvider.getShapeFactory("rounded");
        AbstractShapeFactory normalShapeFactory = ShapeFactoryProvider.getShapeFactory("normal");
        AbstractShapeFactory roundedShapeFactory2 = ShapeFactoryProvider.getShapeFactory("rounded");
        AbstractShapeFactory normalShapeFactory2 = ShapeFactoryProvider.getShapeFactory("normal");

        // create instances
        Shape rectangle = roundedShapeFactory.getShape("roundedRectangle");
        Shape shape = normalShapeFactory.getShape("rectangle");
        Shape square = roundedShapeFactory2.getShape("roundedSquare");
        Shape shape2 = normalShapeFactory2.getShape("square");

        rectangle.draw();
        shape.draw();
        square.draw();
        shape2.draw();
    }
}
