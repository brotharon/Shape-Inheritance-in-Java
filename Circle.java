import java.awt.*;

/**
 * Created by Owner on 7/13/2017.
 */
public class Circle extends Shape {
    private int radius;
    private double area;
    private int xOffset;
    private int yOffset;
    private Color color;

    public Circle() {
        super(100, 100);
        this.radius = 1;
        setArea(this.radius);
    }

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
        setArea(this.radius);
    }

    public Circle(int x, int y, int radius, int xOffset, int yOffset, Color c) {
        super(x, y);
        this.radius = radius;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        this.color = c;
    }

    public void setArea(int radius) {
        this.area = Math.pow((double) radius, 2) * Math.PI;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        final int x = getX();
        final int y = getY();
        g2d.setColor(color);
        g2d.fillOval(xOffset, yOffset, radius, radius);

        g2d.setPaint(new GradientPaint(x, y, Color.BLACK, x + radius / 4, y +
                radius / 4, Color.BLACK, true));

        g2d.drawOval(xOffset, yOffset, radius, radius);
    }
}
