package org.personal.danner;

import org.personal.danner.validate.ValidateRectangles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class TestPane extends JPanel {

    private Point startPoint;
    private Rectangle2D rectangleOne;
    private Rectangle2D rectangleTwo;
    private Point currentPoint;

    public TestPane() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(Objects.isNull(rectangleOne)) {
                    rectangleOne = eventRectangle(e, rectangleOne);
                }
                else if(Objects.nonNull(rectangleOne)) {
                    rectangleTwo = eventRectangle(e, rectangleTwo);
                }
                repaint();

                if(Objects.nonNull(rectangleOne) && Objects.nonNull(rectangleTwo)) {
                    System.out.println("Rectangle 1: X=" + rectangleOne.getX() + " Y=" + rectangleOne.getY() + " Width=" + rectangleOne.getWidth() + " Height=" + rectangleOne.getHeight());
                    System.out.println("Rectangle 2: X=" + rectangleTwo.getX() + " Y=" + rectangleTwo.getY() + " Width=" + rectangleTwo.getWidth() + " Height=" + rectangleTwo.getHeight());
                    evaluateRectangles();
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                currentPoint = e.getPoint();
                repaint();
            }
        };
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    private Rectangle2D eventRectangle(MouseEvent e, Rectangle2D rectangle) {
        if (Objects.nonNull(startPoint) && Objects.nonNull(rectangle)) {
            startPoint = e.getPoint();
            rectangle = null;
        } else if (Objects.isNull(startPoint)) {
            startPoint = e.getPoint();
        } else {
            Point endPoint = e.getPoint();
            rectangle = makeRectangle(startPoint, endPoint);
            startPoint = null;
        }
        return rectangle;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    protected Rectangle2D makeRectangle(Point startPoint, Point endPoint) {
        int minX = Math.min(startPoint.x, endPoint.x);
        int minY = Math.min(startPoint.y, endPoint.y);
        int maxX = Math.max(startPoint.x, endPoint.x);
        int maxY = Math.max(startPoint.y, endPoint.y);
        return new Rectangle2D.Double(minX, minY, maxX - minX, maxY - minY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        if (Objects.nonNull(rectangleOne) && Objects.isNull(rectangleTwo)) {
            g2d.draw(rectangleOne);
        } else if(Objects.nonNull(rectangleTwo)) {
            g2d.draw(rectangleOne);
            g2d.draw(rectangleTwo);
            if (Objects.nonNull(startPoint) && Objects.nonNull(currentPoint)) {
                g2d = paintLines(g2d);
            }
        }
        else if (Objects.nonNull(startPoint) && Objects.nonNull(currentPoint)) {
            g2d = paintLines(g2d);
        }
        g2d.dispose();
    }

    private Graphics2D paintLines(Graphics2D g2d) {
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.drawLine(startPoint.x, startPoint.y, currentPoint.x, currentPoint.y);
        g2d.draw(makeRectangle(startPoint, currentPoint));
        return g2d;
    }

    private void evaluateRectangles() {
        String message = ValidateRectangles.validate(rectangleOne.getBounds(), rectangleTwo.getBounds());

        if(!"".equals(message)) {
            JOptionPane.showMessageDialog(this, message);
            rectangleOne = null;
            rectangleTwo = null;
        }
    }

}
