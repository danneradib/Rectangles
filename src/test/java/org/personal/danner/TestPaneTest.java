package org.personal.danner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.geom.Rectangle2D;

class TestPaneTest {

    TestPane testPane = new TestPane();

    @Test
    void getPreferredSize() {
        Dimension d = testPane.getPreferredSize();

        Dimension dimension = new Dimension(400, 400);

        Assertions.assertThat(d)
                .isNotNull()
                .isEqualTo(dimension);
    }

    @Test
    void makeRectangle() {
        Rectangle2D rect = testPane.makeRectangle(new Point(1, 2), new Point(3, 4));

        Assertions.assertThat(rect)
                .isNotNull()
                .isInstanceOf(Rectangle2D.class);

        Assertions.assertThat(rect)
                .hasFieldOrProperty("x")
                .hasFieldOrProperty("y")
                .hasFieldOrProperty("width")
                .hasFieldOrProperty("height");

        Assertions.assertThat(rect)
                .extracting("x", "y", "width", "height")
                .contains(1.0, 2.0, 2.0, 2.0);
    }
}