public class Point {
    double x;
    double y;

    public Point(){
        this.x = 0;
        this.y = 0;
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}

abstract class Shape{
    //centroid position
    double area;
    Point point;

    public Point position(double x, double y){
        Point newPos = new Point(x, y);
        this.point = newPos;
        return newPos;
    }

    public Point position(double x1, double y1, double x2, double y2){
        double new_x = ((x2-x1)/2);
        double new_y = ((y2-y1)/2);
        Point newPos = new Point(new_x, new_y);
        this.point = newPos;
        return newPos;
    }

    public Point position(double x1, double y1, double x2, double y2, double x3, double y3){
        double new_x = ((x1 + x2 + x3)/3);
        double new_y = ((y1 + y2 + y3)/3);
        Point newPos = new Point(new_x, new_y);
        this.point = newPos;
        return newPos;
    }

    public abstract double area();
}

class Triangle extends Shape{
    double x1;
    double y1;
    double x2;
    double y2;
    double x3;
    double y3;
    public Triangle(){
        super();
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
        Point p = position(x1, y1, x2, y2, x3, y3);
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.point = p;
        area();

    }

    @Override public double area(){
        double l_a = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
        double l_b = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3), 2));
        double l_c = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1), 2));
        double s = ((l_a + l_b + l_c)/2);
        double area = Math.sqrt((s * (s - l_a) * (s - l_b) * (s - l_c)));
        this.area = area;
        return area;
    }
}

class Rectangle extends Shape{
    double x1;
    double y1;
    double x2;
    double y2;
    public Rectangle(){
        super();
    }

    public Rectangle(double x1, double y1, double x2, double y2){
        Point p = position(x1, y1, x2, y2);
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.point = p;
        area();
    }
    @Override public double area(){
        double area = ((x2-x1) * (y2-y1));
        this.area = area;
        return area;
    }
}

class Circle extends Shape{
    double radius;
    public Circle(){
        super();
    }

    public Circle(double x, double y, double r){
        Point p = position(x, y);
        this.point = p;
        this.radius = r;
        area();
    }
    @Override public double area(){
        double area = (Math.PI * radius * radius);
        this.area = area;
        return area;
    }
}

class AreaCalculator{
    public static double calculate(Shape[] shapes){
        int i = 0;
        double area = 0;
        while(i < shapes.length){
            area += shapes[i].area();
        }
        return area;
    }
}

class Main{
    public static void main(String[] args){
        Shape shape[] = new Shape[args.length];
        int i = 0;
        while(i<args.length){
            String [] s = args[i].split(" ");
            if(s[0].equals("c")){
                Circle circle = new Circle(Double.valueOf(s[1]), Double.valueOf(s[2]), Double.valueOf(s[3]));
                shape[i] = circle;
            }else if(s[0].equals("t")){
                Triangle triangle = new Triangle(Double.valueOf(s[1]), Double.valueOf(s[2]), Double.valueOf(s[3]), Double.valueOf(s[4]), Double.valueOf(s[5]), Double.valueOf(s[6]));
                shape[i] = triangle;
            }else if(s[0].equals("r")){
                Rectangle rectangle = new Rectangle(Double.valueOf(s[1]), Double.valueOf(s[2]), Double.valueOf(s[3]), Double.valueOf(s[4]));
                shape[i] = rectangle;
            }
            i++;
        }
        System.out.printf("The total area for the %d objects is %1.2f units squared.\n", shape.length, AreaCalculator.calculate(shape));
    }
}