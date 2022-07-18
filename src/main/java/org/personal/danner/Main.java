package org.personal.danner;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {

        String os = System.getProperty("os.name");
        log.info("OS: {}", os);

        if(os.contains("Windows")) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JFrame frame = new JFrame();
                    frame.add(new TestPane());
                    frame.setTitle("Rectangles!");
                    frame.pack();

                    frame.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                            if (JOptionPane.showConfirmDialog(frame,
                                    "Are you sure you want to close this window?", "Close Window?",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                                System.exit(0);
                            }
                        }
                    });

                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        }
        else {
            TestConsole testConsole = new TestConsole();
            log.info(testConsole.evaluateRectangles());
        }
    }

}
