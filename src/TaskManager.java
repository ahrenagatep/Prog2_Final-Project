import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManager extends JFrame {
    private JButton startButton;
    private JPanel panel;


    public static void main(String[] args) {
        TaskManager welcomePage = new TaskManager();
        welcomePage.setContentPane(welcomePage.panel);
        welcomePage.setTitle("Sign in page");
        welcomePage.setBounds(600, 200, 200, 200);
        welcomePage.setVisible(true);
        welcomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        welcomePage.setUpStartButton();
    }
    public TaskManager(){
        setUpStartButton();
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
        new TaskForm();
    }
}
