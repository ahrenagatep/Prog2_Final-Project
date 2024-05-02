import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JButton startButton;
    private JPanel panel;

    public static void main(String[] args) {
        MainMenu welcomePage = new MainMenu();
        welcomePage.setContentPane(welcomePage.panel);
        welcomePage.setTitle("Welcome!");
        welcomePage.setBounds(600, 200, 625, 500);
        welcomePage.setResizable(true);
        welcomePage.setVisible(true);
        welcomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcomePage.setUpStartButton();
    }
    public MainMenu(){
        try {
            ImageIcon backgroundImage = new ImageIcon("src/resources/background.jpg");

            JLabel backgroundLabel = new JLabel(backgroundImage);
            backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());

            panel.add(backgroundLabel);
        } catch (Exception e){
            /*
            Outputs an exception, but code does
            what it's intended to do so
             */
        }
    }
    public void setUpStartButton(){
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToTaskPage();
            }
        });
    }
    public void goToTaskPage(){
        //close current window
        this.setVisible(false);
        this.dispose();
        //create an object of 'DataPage' and show its window
        new TaskManager();
    }
}
