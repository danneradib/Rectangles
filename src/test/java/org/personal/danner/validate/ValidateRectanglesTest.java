package org.personal.danner.validate;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.awt.*;

public class ValidateRectanglesTest {

    @Test
    public void validateContainsOneToTwo() {
        Rectangle one = new Rectangle(66, 78, 175, 111);
        Rectangle two = new Rectangle(91, 103, 114, 47);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Rectangle 1 contains Rectangle 2.");
    }

    @Test
    public void validateContainsTwoToOne() {
        Rectangle one = new Rectangle(91, 103, 114, 47);
        Rectangle two = new Rectangle(66, 78, 175, 111);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Rectangle 2 contains Rectangle 1.");
    }

    @Test
    public void validateIntersection() {
        Rectangle one = new Rectangle(71, 80, 214, 128);
        Rectangle two = new Rectangle(127, 168, 133, 80);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Rectangles have an intersection - No containment.");
    }

    @Test
    public void validateNoIntersection() {
        Rectangle one = new Rectangle(81, 89, 176, 117);
        Rectangle two = new Rectangle(274, 91, 89, 113);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("The rectangles are not adjacent, nor do they contain each other, nor do they have an intersection.");
    }

    @Test
    public void validateIntersectionNoContainment() {
        Rectangle one = new Rectangle(41, 79, 139, 172);
        Rectangle two = new Rectangle(120, 134, 151, 68);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Rectangles have an intersection - No containment.");
    }

    @Test
    public void validateAdjacentSubLine() {
        Rectangle one = new Rectangle(27, 58, 120, 132);
        Rectangle two = new Rectangle(147, 83, 100, 66);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Rectangles are Adjacent (Sub-Line).");
    }

    @Test
    public void validateAdjacentProper() {
        Rectangle one = new Rectangle(60, 73, 99, 132);
        Rectangle two = new Rectangle(159, 73, 22, 132);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Rectangles are Adjacent (Proper).");
    }

    @Test
    public void validateAdjacentPartial() {
        Rectangle one = new Rectangle(58, 98, 89, 147);
        Rectangle two = new Rectangle(147, 74, 87, 154);

        String message = ValidateRectangles.validate(one, two);

        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank()
                .isEqualTo("Rectangles are Adjacent (Partial).");
    }

}