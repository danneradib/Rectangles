package org.personal.danner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

class TestConsoleTest {

    private TestConsole testConsole = new TestConsole();

    @Test
    void evaluateRectangles() {
        Assertions.assertThat(testConsole.getRect1())
                        .isNotNull()
                        .isInstanceOf(Rectangle.class);

        Assertions.assertThat(testConsole.getRect2())
                .isNotNull()
                .isInstanceOf(Rectangle.class);

        String message = testConsole.evaluateRectangles();
        Assertions.assertThat(message)
                .isNotNull()
                .isNotBlank();
    }



}