package org.personal.danner;

import org.junit.Test;
import org.assertj.core.api.Assertions;
import static org.assertj.swing.launcher.ApplicationLauncher.*;

public class MainTest {

    @Test
    public void mainLinux() {
        System.setProperty("os.name", "Linux");
        application(Main.class).start();
    }

    @Test
    public void mainWindows() {
        application(Main.class).start();
        application(Main.class).withArgs("").start();
    }

}