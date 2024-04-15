import javax.swing.*;

public class TaskForm extends JFrame{
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JPanel taskPanel;
    private JTable table1;
    private JButton addTask;
    private JButton exportButton;
    // hello

    TaskForm(){
        this.setContentPane(this.taskPanel);
        this.setTitle("To Do");
        this.setBounds(600, 200, 400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
