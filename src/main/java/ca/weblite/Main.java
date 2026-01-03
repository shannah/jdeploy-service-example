package ca.weblite;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@QuarkusMain
public class Main {

    public static final String MODE_GUI = "gui";
    public static final String PROP_MODE = "jdeploy.mode";

    public static void main(String... args) {
        // Check for Swing mode system property
        String mode = System.getProperty(PROP_MODE);

        if (MODE_GUI.equalsIgnoreCase(mode)) {
            // Launch Swing application
            launchSwingApp(args);
        } else {
            // Launch Quarkus normally
            Quarkus.run(args);
        }
    }

    private static void launchSwingApp(String... args) {
        System.out.println("Launching Swing application...");

        javax.swing.SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("jDeploy + Quarkus");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            JLabel label = new JLabel("Hello jDeploy + Quarkus", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));

            frame.add(label);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            System.out.println("Swing mode activated");
        });
    }
}