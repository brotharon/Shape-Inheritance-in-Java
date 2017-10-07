import java.awt.*;
import java.awt.geom.Path2D;

/**
 * Takes in an input side length and color and draws triangles of the desired
 * size and color.
 * @author Calvin Evans
 * @version 7/19/2017
 */
public class Triangle extends Shape {

    private int length;
    private Color color;

    /**
     * Pre: default constructor
     * Post: Creates a triangle at (100, 100) with a side length of 100 and
     * colored red.
     */
    protected Triangle() {
        super(100, 100);
        this.length = 100;
        this.color = Color.red;
    }

    /**
     * Pre: Main constructor, takes in 2 ins for x and y coords, one in for
     * side length, and a java.awt color
     * Post: Creates a triangle at (x, y) with a side length of (length) and
     * colored (c).
     *
     * @param x      an int that is passed to the parent class for the x axis
     * @param y      an int that is passed to the parent class for the y axis
     * @param length an int that is used to initialize this.length
     * @param c      a Color that is used to initialize this.color
     */
    protected Triangle(int x, int y, int length, Color c) {
        super(x, y);
        setLength(length);
        setColor(c);
    }

    /**
     * Pre: Copy constructor, takes in a non-null Triangle
     * Post: Creates a deep copy of the input Triangle
     *
     * @param t a non-null Triangle. A null object passed into this
     *          constructor may cause an exception.
     */
    protected Triangle(Triangle t) {
        super(t.getX(), t.getY());
        this.length = t.getLength();
        this.color = t.getColor();
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a deep copy of this.color
     */
    public Color getColor() {
        return new Color(this.color.getRGB());
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns an int of the value in this.length
     */
    public int getLength() {
        return this.length;
    }

    /**
     * Pre:none
     * Post:none
     *
     * @return returns the area of the triangle using formula Area = Base *
     * Height / 2. Height is calculated using the pythagorean theorem.
     */
    @Override
    public double getArea() {
        //pythagorean theorem for height
        double height = Math.sqrt(Math.pow((double) this.length / 2, 2) +
                Math.pow((double) this.length, 2));
        //area of a triangle
        return (height * this.length) / 2;
    }

    /**
     * Pre: takes in an int to be set as the side length
     * Post: Checks to see if the input l is between 50 and 150. If it is,
     * this.length is set to l. If l is less than 50, this.length is set to
     * 50. If l is greater than 150, this.length is set to 150.
     *
     * @param l an int between 50 and 150. Values outside of that range will
     *          be set to the closest extreme value.
     */
    public void setLength(int l) {
        if (l > 50 && l < 150) {
            this.length = l;
        } else if (l < 50) {
            this.length = 50;
        } else {
            this.length = 150;
        }
    }

    /**
     * Pre: takes in a Color to be set to this.color
     * Post: check to ensure that c is not null. If c is not null, this.color
     * is set to c.
     *
     * @param c a non-null Color
     */
    public void setColor(Color c) {
        if (c != null) {
            this.color = c;
        } else {
            this.color = Color.red;
        }
    }

    /**
     * Pre: takes in a Graphics object
     * Post: Calls all of the internal private methods that draw the Triangle
     * in accordance with the stored variables length and color.
     *
     * @param g a Graphics object that gives the triangle a place to be drawn.
     */
    public void draw(Graphics g) {
        this.drawTriangle(g);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the Triangle using the length variable for the side length.
     *
     * @param g the Object passed internally from draw
     */
    private void drawTriangle(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(length, 0);
        triangle.lineTo(length * 2, length * 2);
        triangle.lineTo(0, length * 2);
        triangle.closePath();

        g2d.setColor(color);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    /**
     * Pre Takes in any Object
     * Post: Checks if the input Object is a Triangle object and if so all of
     * the variables of the Triangles are compared to see if they are the same.
     *
     * @param obj takes in any Object
     * @return returns true if the input Object is a Triangle and all of the
     * variables are them same between both Triangles. Returns false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass() || obj == null) {
            return false;
        } else {
            Triangle check = new Triangle((Triangle) obj);
            if (this.length == check.getLength()) {
                if (this.color.equals(check.getColor())) {
                    if (this.getX() == check.getX()) {
                        if (this.getY() == check.getY()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a String that gives information about the side length
     * and color of the Triangle.
     */
    @Override
    public String toString() {
        return "This Triangle has a side length of " + this.length + " " +
                "and is colored " + this.color.toString();
    }
}
