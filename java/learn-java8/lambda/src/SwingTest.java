import javax.swing.*;
import java.awt.event.ActionEvent;

public class SwingTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My Frame");
        JButton button = new JButton("My Button");
        button.addActionListener(e -> System.out.println("Hello!"));

//        button.addActionListener((ActionEvent e) -> System.out.println("Hello!"));

        frame.add(button);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
