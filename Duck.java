import java.awt.*;
import java.awt.geom.Path2D;

/**
 * This class draws a duck of any color you want between sizes 50 and 200.
 * Only a size for the duck's body is needed, the program does the rest of
 * the scaling of the duck for you. Have fun drawing ducks!
 *
 * @author Calvin Evans
 * @version 07/14/2017
 */
public class Duck extends Shape {
    private int diameter;
    private Color color;
    private final int CENTER = (this.getX() + this.getY()) / 2;//anchor point
    // for duck

    /**
     * Pre: none, default constructor.
     * Post: Draws a yellow duck with a size of 100.
     */
    protected Duck() {
        super(100, 100);
        this.color = Color.yellow;
        this.diameter = 100;
    }

    /**
     * Pre: Constructor takes in 2 parameters as an int and a color.
     * Post: Draws a duck scaled to the desired size from int diameter, and
     * of the chosen color from Color c.
     *
     * @param diameter an int value between 50 and 200. Values larger than
     *                 200 will be set to 200 and values smaller than 50 will
     *                 be set to 50.
     * @param c        can be set to any color within the java.awt.* package.
     */
    protected Duck(int x, int y, int diameter, Color c) {
        super(x, y);
        this.color = c;
        setDiameter(diameter);
    }

    /**
     * Pre: clone constructor
     * Post: Makes a deep copy of another Duck
     *
     * @param d a non-null Duck. If you pass in a null Duck you may encounter
     *         a crash.
     */
    protected Duck(Duck d) {
        super(d.getX(), d.getY());
        this.color = d.getColor();
        this.diameter = d.getDiameter();
    }

    /**
     * Pre: takes in an integer for the Duck's diameter
     * Post: Ensures the input value is between 50 and 200. Sets this
     * .diameter to the input value if between 50 and 200, to 200 if greater
     * than 200, or to 50 is less than 50.
     * @param d any integer. Input value outside of the 50-200 range will be
     *          set to the indicated value in the post instructions.
     */
    protected void setDiameter(int d) {
        if (d > 200) {
            this.diameter = 200;
        } else if (d < 50) {
            this.diameter = 50;
        } else {
            this.diameter = d;
        }
    }

    /**
     * Pre: none
     * Post: none
     * @return returns a deep copy of stored Color as RGB value
     */
    protected Color getColor() {
        return new Color(this.color.getRGB());
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns this.diameter int value
     */
    protected int getDiameter() {
        return this.diameter;
    }

    /**
     * Pre: takes in a Graphics object
     * Post: Calls all of the internal private methods that draw the various
     * parts of the duck in accordance with the stored diameter for scale and
     * color.
     *
     * @param g a Graphics object that gives the duck a place to be drawn.
     */
    public void draw(Graphics g) {
        this.drawBody(g);
        this.drawHead(g);
        this.drawLeftEye(g);
        this.drawRightEye(g);
        this.drawBeak(g);
        this.drawLeftFoot(g);
        this.drawRightFoot(g);
        this.drawLeftPupil(g);
        this.drawRightPupil(g);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the body portion of the duck in the desired size, from
     * diameter, and color, from color.
     *
     * @param g the Object passed internally from draw
     */
    private void drawBody(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color); //set fill color
        g2d.fillOval(CENTER - (diameter / 2), CENTER - (diameter / 2),
                diameter, diameter);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER - (diameter / 2), CENTER - (diameter / 2),
                diameter, diameter);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the head portion of the duck in the desired size scaled
     * 75% of diameter, and color, from color.
     *
     * @param g the Object passed internally from draw
     */
    private void drawHead(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int headDiameter = (int) ((double) diameter * .75); //set head scale

        g2d.setColor(color);//set fill color
        g2d.fillOval(CENTER - (headDiameter / 2), CENTER - (diameter),
                headDiameter, headDiameter);

        g2d.setColor(Color.black);//set outline color
        g2d.drawOval(CENTER - (headDiameter / 2), CENTER - (diameter),
                headDiameter, headDiameter);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the right eye portion of the duck in white scaled to 25%
     * of diameter.
     *
     * @param g the Object passed internally from draw
     */
    private void drawRightEye(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int eyeDiameter = (int) ((double) diameter * .25);//set eye scale

        g2d.setColor(Color.white);//set fill color
        g2d.fillOval(CENTER + (eyeDiameter / 4), CENTER - (diameter -
                eyeDiameter), eyeDiameter, eyeDiameter);

        g2d.setColor(Color.black);//set outline color
        g2d.drawOval(CENTER + (eyeDiameter / 4), CENTER - (diameter -
                eyeDiameter), eyeDiameter, eyeDiameter);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the left eye portion of the duck in white scaled to 25%
     * of diameter.
     *
     * @param g the Object passed internally from draw
     */
    private void drawLeftEye(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int eyeDiameter = (int) ((double) diameter * .25);//set eye scale

        g2d.setColor(Color.white);//set fill color
        g2d.fillOval(CENTER - (eyeDiameter), CENTER - (diameter -
                eyeDiameter), eyeDiameter, eyeDiameter);

        g2d.setColor(Color.black);//set outline color
        g2d.drawOval(CENTER - (eyeDiameter), CENTER - (diameter -
                eyeDiameter), eyeDiameter, eyeDiameter);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the beak portion of the duck in orange scaled
     * automatically to fit the size of duck input from diameter.
     *
     * @param g the Object passed internally from draw
     */
    private void drawBeak(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(CENTER, CENTER - diameter * .15);
        triangle.lineTo(CENTER - diameter * .18, CENTER - (diameter * .45));
        triangle.lineTo(CENTER + diameter * .2, CENTER - diameter * .45);
        triangle.closePath();

        g2d.setColor(Color.orange);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the left foot portion of the duck in orange scaled
     * automatically to fit the size of duck input from diameter.
     *
     * @param g the Object passed internally from draw
     */
    private void drawLeftFoot(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(CENTER - diameter * .22, CENTER + diameter * .45);
        triangle.lineTo(CENTER - diameter * .38, CENTER + (diameter * .75));
        triangle.lineTo(CENTER - diameter * .05, CENTER + diameter * .75);
        triangle.closePath();

        g2d.setColor(Color.orange);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the right foot portion of the duck in orange scaled
     * automatically to fit the size of duck input from diameter.
     *
     * @param g the Object passed internally from draw
     */
    private void drawRightFoot(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(CENTER + diameter * .22, CENTER + diameter * .45);
        triangle.lineTo(CENTER + diameter * .38, CENTER + (diameter * .75));
        triangle.lineTo(CENTER + diameter * .05, CENTER + diameter * .75);
        triangle.closePath();

        g2d.setColor(Color.orange);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the left eye pupil portion of the duck in black scaled to
     * 12.5% of diameter.
     *
     * @param g the Object passed internally from draw
     */
    private void drawLeftPupil(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int eyeDiameter = (int) ((double) diameter * .125);//set pupil scale

        final int x = getX();
        final int y = getY();

        g2d.setColor(Color.black);//set fill color
        g2d.fillOval(CENTER - (int) (eyeDiameter * 1.8), CENTER - (diameter -
                eyeDiameter * 2), eyeDiameter, eyeDiameter);
    }

    /**
     * Pre: internal method is passed Graphics object from draw method
     * Post: draws the right eye pupil portion of the duck in black scaled to
     * 12.5% of diameter.
     *
     * @param g the Object passed internally from draw
     */
    private void drawRightPupil(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int eyeDiameter = (int) ((double) diameter * .125);//set pupil scale

        final int x = getX();
        final int y = getY();

        g2d.setColor(Color.black);//set fill color
        g2d.fillOval(CENTER + (int) (eyeDiameter * .9), CENTER - (diameter -
                eyeDiameter * 2), eyeDiameter, eyeDiameter);
    }

    /**
     * Pre: none
     * Post: Calculates the area of a duck based off of the size of the body
     * and the head of the duck.
     *
     * @return returns the sum of the areas of the body and head of the duck.
     */
    @Override
    public double getArea() {
        double output;
        output = (Math.PI / 4) * (Math.pow(diameter, 2));
        output += .75 * (Math.PI / 4) * (Math.pow(diameter, 2));
        return output;
    }

    /**
     * Pre Takes in any Object
     * Post: Checks if the input Object is a Duck object and if so all of the
     * variables of the Ducks are compared to see if they are the same.
     *
     * @param obj takes in any Object
     * @return returns true if the input Object is a Duck and all of the
     * variables are them same between both Ducks. Returns false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass() || obj == null) {
            return false;
        } else {
            Duck check = new Duck((Duck) obj);
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
     * the Duck body and the color of the Duck.
     */
    @Override
    public String toString() {
        return "This duck's body has a diameter of " + this.diameter + " and " +
                "is colored " + this.color.toString();
    }
}
