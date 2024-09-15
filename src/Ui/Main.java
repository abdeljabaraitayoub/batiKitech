package Ui;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Main {


    public static void  clear() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_COMMA);
            robot.keyRelease(KeyEvent.VK_COMMA);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(100); // Small delay to ensure the clear command is processed
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void pause() {
        System.out.println("Press enter to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
