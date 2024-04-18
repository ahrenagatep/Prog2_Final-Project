import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
        String[] columnNames = {"Task","Type","Due"};
        String[][] rowsOfData = {{"Prog. 2 Final","School","9-24-2024"},{"Take out trash","Personal","3-4-24"}};
        tableModel = new DefaultTableModel(rowsOfData,columnNames);
        this.taskTable.setModel(tableModel);
    }
    private void setAddTaskButton(){
        addTask.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* grabs selection from typeCB and text from taskTA
                creates a new class object of task to run super add to taskTable */
                try {
                    String type = typeCB.getSelectedItem().toString();
                    String taskfromTA = taskTA.getText();
                    String date = JOptionPane.showInputDialog(TaskForm.this, "Enter due date (MM-dd-yyyy):");
                    String[] newRow ={taskfromTA,type,date};
                    tableModel.addRow(newRow);
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Failed to create task.\nPlease try again");
                }
            }
        });
    }
    private void setExportButton(){
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* gets information from taskTable to export into
                 user's home directory, pop up saying successful */
                try{
                    int rowCount = tableModel.getRowCount();
                    int columnCount = tableModel.getColumnCount();

                    StringBuilder content = new StringBuilder();

                    // Iterate over each row
                    for (int i = 0; i < rowCount; i++) {
                        // Iterate over each column
                        for (int j = 0; j < columnCount; j++) {
                            // Append cell value to the export string
                            content.append(tableModel.getValueAt(i, j));
                            // Separate values by tab ('\t') or any other delimiter as needed
                            content.append("\t");
                        }
                        // Add newline character ('\n') after each row
                        content.append("\n");
                    }

                    // Display the export string
                    System.out.println(content.toString());

                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
    }
}
