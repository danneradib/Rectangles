package org.personal.danner;

import lombok.extern.slf4j.Slf4j;
import org.personal.danner.validate.ValidateRectangles;

import java.awt.*;
import java.util.Random;

@Slf4j
public class TestConsole {

    private Rectangle rect1;
    private Rectangle rect2;

    public TestConsole() {
        rect1 = new Rectangle(random(), random(), random(), random());
        rect2 = new Rectangle(random(), random(), random(), random());
    }

    private Integer random() {
        Random random = new Random();
        return random.nextInt(300 - 1) + 1;
    }

    public String evaluateRectangles() {
        log.info("Rectangle 1: X={} - Y={} - Width={} - Height={} ", rect1.x, rect1.y, rect1.width, rect1.height);
        log.info("Rectangle 2: X={} - Y={} - Width={} - Height={} ", rect2.x, rect2.y, rect2.width, rect2.height);

        return ValidateRectangles.validate(rect1, rect2);
    }

    public Rectangle getRect1() {
        return rect1;
    }

    public Rectangle getRect2() {
        return rect2;
    }
}
