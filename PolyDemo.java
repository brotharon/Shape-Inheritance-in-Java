import java.util.*;
import javax.swing.*;
import java.awt.*;

/*
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 * 
 * Author: Rob Nash
 * Modification made by Calvin Evans
 */


class PolyDemo extends JFrame {


    public PolyDemo() {
        getContentPane().add(new PolyDemoPanel());
        //just some windowing stuff that must happen for all Frames
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String args[]) {
        PolyDemo myApp = new PolyDemo();
    }


    //this is our first "inner" or internal class
    //the purpose of this class is solely to support the JFrame class above, and I don't want it reused in arbitrary contexts, so by nesting this class here
    //I can indicate the intent a bit more clearly that this class "goes with" the class above it
    //In general, each class is a separate entity that should be contained in a separate file
    public class PolyDemoPanel extends JPanel {
        Shape[] myShapes = new Shape[20];

        public PolyDemoPanel() {

            /*********************************************************************************************************************
             * Code for populating our myShapes changes minimally when new classes are introduced (only in getRandShape())
             *********************************************************************************************************************/
            for (int i = 0; i < myShapes.length; i++) {
                myShapes[i] = getRandShape();
            }
        }

        /*********************************************************************************************************************
         * Code for drawing our shapes doesn't change at all! Since we intended to take advantage of polymorphism, we coded
         * this "in general" with respect to the superclass, and not specific to any subclass.
         *********************************************************************************************************************/
        public void paint(Graphics g) {
            super.paint(g);  //don't remove - required for GUI widgets to draw correctly
            /************************
             * Late Binding Demo
             ************************/
            for (int i = 0; i < myShapes.length; i++) {
                //which draw method is invoked here? There are many forms of the method (polymorphic), so which is chosen?
                //Java has RTTI about every object, and it uses this info to choose the correct method to invoke!
                myShapes[i].draw(g);
            }
        }


        public int getRandInt() {
            return ((int) (Math.random() * 200));
        }

        /**
         * Pre: none
         * Post: generates a random RGB value and uses that to create a Color
         * Object
         *
         * @return returns a Color object created using the randomly
         * generated RGB value
         */
        public Color getRandColor() {
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            return new Color(red, green, blue);
        }

        /**
         * Pre: none
         * Post: Gets random x and y values for the shape, generates a random
         * Color and attributes, randomly picks a Shape Object and assigns
         * random parameters
         * generated variables to the Object
         *
         * @return returns the randomly generated object
         */
        public Shape getRandShape() {
            Shape retVal = null;
            final int x = getRandInt();
            final int y = getRandInt();

            /********************************
             * Polymorphic extensibility demo
             *
             *******************************/
            switch ((int) (Math.random() * 4)) {
                case 0:
                    retVal = new Duck(x, y, getRandInt(), getRandColor());
                    break;
                case 1:
                    retVal = new FalkorTheDog(x, y, getRandInt(), getRandColor());
                    break;
                case 2:
                    retVal = new Triangle(x, y, getRandInt(), getRandColor());
                    break;
                case 3:
                    retVal = new PacMan(x, y, getRandInt(), getRandColor());
                    break;
            }

            return retVal;
        }
    }

}











