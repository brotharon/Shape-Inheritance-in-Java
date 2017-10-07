import java.awt.*;
import java.awt.geom.Path2D;

/**
 * My dog is named Falkor and he is an American Eskimo Dog. While Falkor is
 * my dog, and he is a little white dog, now you can have your own Falkor and
 * yours can be of any color you desire. Create an instance of this class
 * using one of the included constructors and watch as your very own Falkor
 * comes to life.
 *
 * @author Calvin Evans
 * @version 7/18/2017
 */
public class FalkorTheDog extends Shape {
    private int width;
    private int height;
    private Color color;
    private final int CENTER = (this.getX() + this.getY()) / 2; // used for
    // spatial alignment of body parts of the object

    /**
     * Pre: Default constructor
     * Post: Takes no arguments and creates a FalkorTheDog Object with a
     * width of 50, height of 75, located at 100, 100, and colored white.
     */
    protected FalkorTheDog() {
        super(100, 100);
        this.width = 50;
        this.height = 75;
        this.color = Color.white;
    }

    /**
     * Pre: Takes in 2 ints as the x and y coords, 2 ints as the width and
     * height of the object, and a Color object from java.awt.*
     * Post: Creates a FalkorTheDog object using the given parameters. Size
     * limits placed on width and height are in place to ensure the Object
     * fits within the jPanel.
     *
     * @param x     the x coordinate of the Object. Passed to parent
     *              (Shape) object.
     * @param y     the y coordinate of the Object. Passed to parent
     *              (Shape) object.
     * @param width an int between 25 and 125 for the width of the Object.
     *              Widths less than 25 will be set to 25 and widths greater
     *              than 125 will be set to 125.
     * @param c     a Color object which is used to color in many of the body
     *              parts of the FalkorTheDog object (body, head, legs, feet,
     *              ears, tail)
     */
    protected FalkorTheDog(int x, int y, int width, Color c) {
        super(x, y);
        setWidth(width);
        setHeight();
        setColor(c);
    }

    /**
     * Pre: Copy constructor, takes in a non-null FalkorTheDog Object
     * Post: Makes a deep copy of the input FalkorTheDog Object
     *
     * @param f a non-null FalkorTheDog Object. If a null object is passed in
     *          this could result in a null pointer exception and a crash.
     */
    protected FalkorTheDog(FalkorTheDog f) {
        super(f.getX(), f.getY());
        this.width = f.getWidth();
        this.height = f.getHeight();
        this.color = f.getColor();
    }

    /**
     * Pre: Takes in a Color object.
     * Post: Sets the stored Color in this object to the input Color
     *
     * @param c a non-null Color Object. If a null object is passed in the
     *          stored Color will not be changed.
     */
    protected void setColor(Color c) {
        if (c != null) {
            this.color = c;
        }
    }

    /**
     * Pre: Takes in an int for the desired width
     * Post: Verifies that the input int is between 25 and 125 and sets this
     * .width to the input value. If the input value is less than 25 this
     * .width will be set to 25, and if the input is greater than 125 this
     * .width will be set to 125.
     *
     * @param w an int value between 25 and 125
     */
    protected void setWidth(int w) {
        if (w < 25) {
            this.width = 25;
        } else if (w > 125) {
            this.width = 125;
        } else {
            this.width = w;
        }
    }

    /**
     * Pre: none
     * Post: Sets height to 1.25 times width;
     */
    protected void setHeight() {
        this.height = this.width + (int) (this.width * .25);
    }

    /**
     * Pre: none
     * Post: Calculates the combined area of the Objects head and body. Head
     * is calculated as an equilateral triangle (first one line segment is
     * calculated, and then that line segment is squared and finally divided
     * by 2 to get the triangle's area.) and the body calculated as area of
     * an ellipse.
     *
     * @return returns a double that is the sum of the areas of the head and
     * body of the FalkorTheDog Object.
     */
    @Override
    public double getArea() {
        //formula for line segment length (SQRT((x2 - x1)^2 + (y2 - y1)^2)
        // set to the length of a line segment of the head of this FalkorTheDog
        double headLineSegment = Math.sqrt(Math.pow((CENTER + this.width *
                .17) - (CENTER + this.width / 3), 2) + Math.pow((CENTER -
                this.width / 3) - (CENTER + this.width * .15), 2)) / 2;
        //calculating the head height using pythagorean theorem
        double headHeight = Math.sqrt(Math.pow(headLineSegment / 2, 2) +
                Math.pow(headLineSegment, 2));
        //area of a triangle
        double headArea = (headHeight * headLineSegment) / 2;
        double bodyArea = Math.PI * this.width * this.height;
        return headArea + bodyArea;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns the width of this FalkorTheDog as an int
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns the height of this FalkorTheDog as an int
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a deep copy of the Color of this FalkorTheDog Object
     */
    public Color getColor() {
        int red = this.color.getRed();
        int green = this.color.getGreen();
        int blue = this.color.getBlue();
        return new Color(red, blue, green);
    }

    /**
     * Pre: Takes in a Graphics Object
     * Post: Calls all of the methods that draw the individual parts of the
     * FalkorTheDog Object.
     *
     * @param g a non-null Graphics Object
     */
    public void draw(Graphics g) {
        this.drawTail(g);
        this.drawTailCutout(g);
        this.drawLeftRearFoot(g);
        this.drawRightRearFoot(g);
        this.drawLeftHindLeg(g);
        this.drawRightHindLeg(g);
        this.drawBody(g);
        this.drawFrontLegBackground(g);
        this.drawLeftLegOuter(g);
        this.drawCenterLegLine(g);
        this.drawRightLegOuter(g);
        this.drawRightFrontFoot(g);
        this.drawLeftFrontFoot(g);
        this.drawHead(g);
        this.drawNose(g);
        this.drawLeftEar(g);
        this.drawRightEar(g);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the body of the
     * FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawBody(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER - (this.width / 5), CENTER - (this.width / 2),
                this.width, this.height);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER - (this.width / 5), CENTER - (this.width / 2),
                this.width, this.height);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the left hind
     * leg of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawLeftHindLeg(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER - (this.width / 3), CENTER + (int) (this
                .height / 4.5), this.width / 2, this.height / 2);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER - (this.width / 3), CENTER + (int) (this.height /
                4.5), this.width / 2, this.height / 2);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the right hind
     * leg of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawRightHindLeg(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER + (int) (this.width / 2.3), CENTER + (this
                .width / 4), this.width / 2, this.height / 2);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER + (int) (this.width / 2.3), CENTER + (this.width /
                4), this.width / 2, this.height / 2);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws the left outer leg line of
     * the front legs of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawLeftLegOuter(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating line as a polygon
        Path2D.Double line = new Path2D.Double();
        line.moveTo(CENTER + this.width / 10, CENTER + this.width);
        line.lineTo(CENTER + this.width / 10, CENTER + this.width / 5);
        line.closePath();

        g2d.setColor(Color.black);//set outline color
        g2d.draw(line);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws the center line of the front
     * legs of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawCenterLegLine(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating line as a polygon
        Path2D.Double line = new Path2D.Double();
        line.moveTo(CENTER + this.width / 3.3, CENTER + this.width);
        line.lineTo(CENTER + this.width / 3.3, CENTER + this.width / 5);
        line.closePath();

        g2d.setColor(Color.black);//set outline color
        g2d.draw(line);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws the right outer leg line of
     * the front legs of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawRightLegOuter(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating line as a polygon
        Path2D.Double line = new Path2D.Double();
        line.moveTo(CENTER + this.width / 2, CENTER + this.width);
        line.lineTo(CENTER + this.width / 2, CENTER + this.width / 5);
        line.closePath();

        g2d.setColor(Color.black);//set outline color
        g2d.draw(line);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the left rear
     * foot of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawLeftRearFoot(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER - (int) (this.width / 2.5), CENTER + (int) (this
                        .width * .85),
                this.height / 4, this.width / 4);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER - (int) (this.width / 2.5), CENTER + (int) (this
                        .width
                        * .85),
                this.height / 4, this.width / 4);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the right rear
     * foot of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawRightRearFoot(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER + (int) (this.width / 1.6), CENTER + (int) (this
                        .width * .85),
                this.height / 4, this.width / 4);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER + (int) (this.width / 1.6), CENTER + (int) (this
                        .width
                        * .85),
                this.height / 4, this.width / 4);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the right front
     * foot of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawRightFrontFoot(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER + (int) (this.width / 3.3), CENTER + (int) (this
                        .width * .85),
                this.height / 4, this.width / 4);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER + (int) (this.width / 3.3), CENTER + (int) (this
                        .width
                        * .85),
                this.height / 4, this.width / 4);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the left front
     * foot of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawLeftFrontFoot(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER - (this.width / 200), CENTER + (int) (this
                        .width * .85),
                this.height / 4, this.width / 4);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER - (this.width / 200), CENTER + (int) (this
                        .width
                        * .85),
                this.height / 4, this.width / 4);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the tail of the
     * FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawTail(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(this.color); //set fill color
        g2d.fillOval(CENTER - (int) (this.width / 1.25), CENTER - (int) (this
                .width / 4), this.width, this.width);

        g2d.setColor(Color.black);//set outline color

        g2d.drawOval(CENTER - (int) (this.width / 1.25), CENTER - (int) (this
                .width / 4), this.width, this.width);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in a white circle
     * that creates the shape of the tail of the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawTailCutout(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.white); //set fill color
        g2d.fillOval(CENTER - (int) (this.width / 1.75), CENTER - (int) (this
                .width / 4), this.width, this.width);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the head of the
     * FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawHead(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(CENTER + width / 3, CENTER - this.width * .15);
        triangle.lineTo(CENTER - this.width * .2, CENTER - this.width);
        triangle.lineTo(CENTER + this.width * .8, CENTER - this.width);
        triangle.closePath();

        g2d.setColor(this.color);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the nose of the
     * FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawNose(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(CENTER + width / 3, CENTER - this.width * .15);
        triangle.lineTo(CENTER + this.width * .22, CENTER - this.width / 3);
        triangle.lineTo(CENTER + this.width * .43, CENTER - this.width / 3);
        triangle.closePath();

        g2d.setColor(Color.black);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the left ear of
     * the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawLeftEar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(CENTER - this.width / 7, CENTER - this.width * 1.5);
        triangle.lineTo(CENTER - this.width / 4.5, CENTER - this.width);
        triangle.lineTo(CENTER + this.width / 10, CENTER - this.width);
        triangle.closePath();

        g2d.setColor(this.color);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    /**
     * Pre: Is passed Graphics Object from calling method
     * Post: Using the stored parameters, draws and colors in the right ear of
     * the FalkorTheDog Object.
     *
     * @param g the non-null Graphics Object passed from calling method
     */
    private void drawRightEar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        //creating triangle as a polygon
        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(CENTER + this.width / 1.4, CENTER - this.width * 1.5);
        triangle.lineTo(CENTER + this.width / 1.25, CENTER - this.width);
        triangle.lineTo(CENTER + this.width / 2, CENTER - this.width);
        triangle.closePath();

        g2d.setColor(this.color);//set fill color
        g2d.fill(triangle);

        g2d.setColor(Color.black);//set outline color
        g2d.draw(triangle);
    }

    private void drawFrontLegBackground(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(color);
        g2d.fillRect(CENTER + this.width / 10, CENTER, (int) (this
                .width / 2.4), (int) (this.width * .95));
    }

    /**
     * Pre: none
     * Post: none
     *
     * @return returns a String that gives the stored information about the
     * width, height and color of the FalkorTheDog object.
     */
    @Override
    public String toString() {
        return "This Falkor The Dog has a width of " + this.width + ", a " +
                "height of " + this.height + " and is colored" + this.color
                .toString();
    }

    /**
     * Pre Takes in any Object
     * Post: Checks if the input Object is a FalkorTheDog object and if so
     * all of the variables of the FalkorTheDog Objects are compared to see if
     * they are the same.
     *
     * @param obj takes in any Object
     * @return returns true if the input Object is a FalkorTheDog and all of the
     * variables are them same between both FalkorTheDog Objects. Returns false
     * otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != this.getClass() || obj == null) {
            return false;
        } else {
            FalkorTheDog check = new FalkorTheDog((FalkorTheDog) obj);
            if (this.height == check.getHeight()) {
                if (this.width == check.getWidth()) {
                    if (this.color.equals(check.color)) {
                        if (this.getX() == check.getX()) {
                            if (this.getY() == check.getY()) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
