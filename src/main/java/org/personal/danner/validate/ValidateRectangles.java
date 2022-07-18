package org.personal.danner.validate;

import java.awt.*;

public class ValidateRectangles {

    public static String validate(Rectangle rectangleOne, Rectangle rectangleTwo) {
        String message = "";

        if(rectangleOne.contains(rectangleTwo)) {
            return "Rectangle 1 contains Rectangle 2.";
        }

        if(rectangleTwo.contains(rectangleOne)) {
            return "Rectangle 2 contains Rectangle 1.";
        }

        if(isAdjacentSubLine(rectangleOne, rectangleTwo)) {
            return "Rectangles are Adjacent (Sub-Line).";
        }

        if(isAdjacentProper(rectangleOne, rectangleTwo)) {
            return "Rectangles are Adjacent (Proper).";
        }

        if(isAdjacentPartial(rectangleOne, rectangleTwo)) {
            return "Rectangles are Adjacent (Partial).";
        }

        if(rectangleOne.contains(rectangleTwo.getX(), rectangleTwo.getY()) ||
                rectangleTwo.contains(rectangleOne.getX(), rectangleOne.getY())) {
            if(rectangleOne.intersects(rectangleTwo.getX(), rectangleTwo.getY(), rectangleTwo.getWidth(), rectangleTwo.getHeight())) {
                message = "Rectangles have an intersection";
                if(rectangleOne.getHeight() > rectangleTwo.getHeight()) {
                    message += " - No containment.";
                }
            }
            else if(rectangleTwo.intersects(rectangleOne.getX(), rectangleTwo.getY(), rectangleTwo.getWidth(), rectangleTwo.getHeight())) {
                message = "Rectangles have an intersection";
                if(rectangleTwo.getHeight() > rectangleOne.getHeight()) {
                    message += " - No containment.";
                }
            }
            else if(rectangleTwo.contains(rectangleOne.getX(), rectangleOne.getY())) {
                if (rectangleOne.getX() < rectangleTwo.getX() + rectangleTwo.getWidth() && rectangleTwo.getWidth() > rectangleOne.getX() && rectangleOne.getY() < rectangleTwo.getY() + rectangleTwo.getHeight() && rectangleOne.getY() + rectangleOne.getHeight() > rectangleTwo.getY()) {
                    message = "Rectangles have an intersection (overlap)!";
                }
                else {
                    message = "2nd Rectangle contains 1st Rectangle!";
                }
            }
            else {
                message = "1st Rectangle contains 2nd Rectangle!";
            }
        }
        else {
            message = "The rectangles are not adjacent, nor do they contain each other, nor do they have an intersection.";
        }
        return message;
    }

    private static boolean isAdjacentSubLine(Rectangle rectangleOne, Rectangle rectangleTwo) {
        if(rectangleOne.getX() < rectangleTwo.getX() && (rectangleOne.getX() + rectangleOne.getWidth() == rectangleTwo.getX()) &&
                rectangleOne.getY() < rectangleTwo.getY()) {
            return true;
        }
        return false;
    }

    private static boolean isAdjacentProper(Rectangle rectangleOne, Rectangle rectangleTwo) {
        if(rectangleOne.getY() == rectangleTwo.getY() && rectangleOne.getHeight() == rectangleTwo.getHeight() &&
            rectangleTwo.getX() > rectangleOne.getX() && rectangleOne.getWidth() > rectangleTwo.getWidth()) {
            return true;
        }
        if(rectangleTwo.getY() == rectangleOne.getY() && rectangleTwo.getHeight() == rectangleOne.getHeight() &&
                rectangleOne.getX() > rectangleTwo.getX() && rectangleTwo.getWidth() > rectangleOne.getWidth()) {
            return true;
        }
        return false;
    }

    private static boolean isAdjacentPartial(Rectangle rectangleOne, Rectangle rectangleTwo) {
        if(rectangleOne.getX() + rectangleOne.getWidth() == rectangleTwo.getX() && rectangleOne.getY() > rectangleTwo.getY()) {
            return true;
        }
        return false;
    }

}
