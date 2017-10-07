import java.awt.*;
import java.awt.geom.Path2D;

/**
 * Stores a diameter and color and draws PacMen of the desired size and color.
 * @author Calvin Evans
 * @version 7/19/2017
 */
public class PacMan extends Shape {

    private int diameter;
    private Color color;

    /**
     * Pre: default constructor
     * Post: Creates a PacMan at (100, 100) with a diameter of 100 and
     * colored yellow.
     */
    public PacMan() {
        super(100, 100);
        this.diameter = 100;
        this.color = Color.yellow;
    }

    /**
     * Pre: Main constructor, takes in 2 ints as x and y coords, 1 int as the
     * diameter of the PacMan, and a Color for the color of the PacMan
     * Post: creates a PacMan object at coords (x,y) with a diameter of
     * (diameter) and a color of (c).
     *
     * @param x        an int that is passed to the parent class for the x axis
     * @param y        an int that is passed to the parent class for the y axis
     * @param diameter an int that is used to initialize this.diameter
     * @param c        a Color that is used to initialize this.color
     */
    public PacMan(int x, int y, int diameter, Color c) {
        super(x, y);
        setDiameter(diameter);
        setColor(c);
    }

    /**
     * Pre: Copy constructor, takes in a PacMan object p
     * Post: Creates a deep copy of the input PacMan Object p as a new PacMan
     * Object
     *
     * @param p a non-null PacMan. If a null object is passed into this
     *          constructor it may cause an exception.
     */
    public PacMan(PacMan p) {
        super(p.getX(), p.getY());
        this.diameter = p.getDiameter();
        this.color = p.getColor();
    }

    /**
     * Pre: takes in an int d for diameter
     * Post: If d is less than 50 this.diameter is set to 50. If d is greater
     * than 150, this.diameter is set to 150. Otherwise this.diameter is set
     * to the input value d.
     *
     * @param d an int between 50 and 150. If d is outside of this range this
     *          .diameter will be set to the closest extreme value.
     */
    public void setDiameter(int d) {
        if (d < 50) {
            this.diameter = 50;
        } else if (d > 150) {
            this.diameter = 150;
        } else {
            this.diameter = d;
        }
    }

    /**
     * Pre takes in a java.awt Color
     * Post: Checks if c is a null Object. If c is null, this.color is set to
     * yellow(default PacMan color). If c is not null, this.color is set to c.
     *
     * @param c a non-null Color
     */
    public void setColor(Color c) {
        if (c != null) {
            this.color = c;
        } else {
            this.color = Color.yellow;
        }
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
     * @return returns an int of the value stored in this.diameter.
     */
    public int getDiameter() {
        return this.diameter;
    }

    /**
     * Pre: none
     * Post: Calculates and returns the area of the PacMan. Calculates the
     * circle area of the PacMan and then subtracts the triangular cutout for
     * the mouth. Triangle calculations are done using pythagorean theorem to
     * get the height of the cutout at the opening of the mouth and the
     * radius is used for the other length to calculate the area of the
     * triangle.
     *
     * @return returns a double for the area of the circular body of the
     * PacMan less the triangular cutout.
     */
    @Override
    public double getArea() {
        double circleArea = (Math.PI / 4) * Math.pow(this.diameter, 2);
        //pythagorean theorem for height
        double triangleHeight = Math.sqrt(Math.pow((double) (this.diameter / 2)
                / 2, 2) + Math.pow((double) (this.diameter / 2), 2));
        //area of a triangle
        return circleArea - (triangleHeight * (this.diameter / 2) / 2);
    }

    /**
     * Pre: takes in a Graphics object
     * Post: Calls all of the internal private methods that draw the various
     * parts of the PacMan in accordance with the stored diameter for scale and
     * color.
     *
     * @param g a Graphics object that gives the PacMan a place to be drawn.
     */
    public void draw(Graphics g) {
        this.drawBody(g);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the body portion of the PacMan in the desired size, from
     * diameter, and color, from color.
     *
     * @param g the Object passed internally from draw
     */
    private void drawBody(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color); //set fill color
        g2d.fillArc(this.getX(), this.getY(), diameter, diameter, 30, 290);

        g2d.setColor(Color.black);//set outline color

        g2d.drawArc(this.getX(), this.getY(), diameter, diameter, 30, 290);
    }

    /**
     * Pre Takes in any Object
     * Post: Checks if the input Object is a PacMan object and if so all of the
     * variables of the PacMen are compared to see if they are the same.
     *
     * @param obj takes in any Object
     * @return returns true if the input Object is a PacMan and all of the
     * variables are them same between both PacMen. Returns false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass() || obj == null) {
            return false;
        } else {
            PacMan check = new PacMan((PacMan) obj);
            if (this.diameter == check.getDiameter()) {
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
     * @return returns a String that gives information about the diameter of
     * the PacMan and the color of the PacMan.
     */
    @Override
    public String toString() {
        return "This PacMan has a diameter of " + this.diameter + " and " +
                "is colored " + this.color.toString();
    }
}
