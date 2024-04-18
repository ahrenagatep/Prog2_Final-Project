import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskForm extends JFrame{
    private JComboBox typeCB;
    private JTextArea taskTA;
    private JPanel taskPanel;
    private JTable taskTable;
    private JButton addTask;
    private JButton exportButton;
    private DefaultTableModel tableModel;

    TaskForm(){
        this.setContentPane(this.taskPanel);
        this.setTitle("To Do");
        this.setBounds(600, 200, 625, 500);
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setAddTaskButton();
        this.setExportButton();
        this.defaultPopulateTable();

        try {
            ImageIcon backgroundImage = new ImageIcon("src/resources/background.jpg");

            JLabel backgroundLabel = new JLabel(backgroundImage);
            backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());

            taskPanel.add(backgroundLabel);
        } catch (Exception e){
            // let's pretend nothing even happened i guess
        }   // man this code bugs out but it works.
    }
    private void defaultPopulateTable(){
        String[] columnNames = {"Task","Type","Category"};
        String[][] rowsOfData = {{"Prog. 2 Final","School","Programming"},{"Take out trash","Personal","Chores"}};
        tableModel = new DefaultTableModel(rowsOfData,columnNames);
        this.taskTable.setModel(tableModel);
    }
    private void setAddTaskButton(){
        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* grabs selection from typeCB and text from taskTA
                creates a new class object of task to run super add to taskTable */
                int type = typeCB.getSelectedIndex();

            }
        });
    }
    private void setExportButton(){
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* gets information from taskTable to export into
                 user's home directory, pop up saying successful */
            }
        });
    }
}
