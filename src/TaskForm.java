import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class TaskForm extends JFrame{
    private JComboBox typeCB, categoryCB;
    private JTextArea taskTA;
    private JPanel taskPanel;
    private JTable taskTable;
    private JButton addTask;
    private JButton exportButton;
    private DefaultTableModel tableModel, schoolModel, workModel, personalModel;
    private DefaultComboBoxModel schoolCBM, workCBM, personalCBM;

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
        this.setTypeCB();

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
        String[] columnNames = {"Task","Category","Due"};
        String[][] rowsOfData = {{"task here","category here","date here"}};
        tableModel = new DefaultTableModel(rowsOfData,columnNames);
        this.taskTable.setModel(tableModel);

        String[][] schoolRows = {{"Prog. 2 final","Programming II","9-24-2024"}};
        String[][] workRows = {{"Finish Q2 report","Q2","6-17-2024"}};
        String[][] personalRows = {{"Get milk and eggs","Groceries","4-20-2024"}};
        schoolModel = new DefaultTableModel(schoolRows,columnNames);
        workModel = new DefaultTableModel(workRows,columnNames);
        personalModel = new DefaultTableModel(personalRows,columnNames);

        String[] schoolCBR = {"Subject","Club"};
        String[] workCBR = {"Department","Quarter"};
        String[] personalCBR = {"Chore","Errand"};
        schoolCBM = new DefaultComboBoxModel(schoolCBR);
        workCBM = new DefaultComboBoxModel(workCBR);
        personalCBM = new DefaultComboBoxModel(personalCBR);
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
                    String date = JOptionPane.showInputDialog(TaskForm.this, "Enter due date (mm-dd-yyyy):");
                    String category = categoryCB.getSelectedItem().toString();
                    switch (type){
                        case "Personal"->{
                            Personal newTask = new Personal(taskfromTA,date,null,null);
                            switch (category){
                                case "Chore"->{category = newTask.askChore();}
                                case "Errand"->{category = newTask.askErrand();}
                            }
                            newTask.displayTaskDetails();
                            String[] newRow = {taskfromTA,category,date};
                            personalModel.addRow(newRow);
                        }
                        case "School"->{
                            School newTask = new School(taskfromTA,date,null,null);
                            switch (category){
                                case "Subject"->{category = newTask.askSubject();}
                                case "Club"->{category = newTask.askClub();}
                            }
                            String[] newRow = {taskfromTA,category,date};
                            newTask.displayTaskDetails();
                            schoolModel.addRow(newRow);
                        }
                        case "Work"->{
                            Work newTask = new Work(taskfromTA,date,null,null);
                            switch (category){
                                case "Department"->{category = newTask.askDepartment();}
                                case "Quarter"->{category = newTask.askQuarter();}
                            }
                            String[] newRow = {taskfromTA,category,date};
                            newTask.displayTaskDetails();
                            workModel.addRow(newRow);
                        }
                        default ->{
                            JOptionPane.showMessageDialog(null,"Please select from\n"+
                                    "school/work/personal tasks.");
                        }
                    }
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

                    // Had to learn StringBuilder for this.
                    StringBuilder content = new StringBuilder();
                    for (int i = 0; i < rowCount; i++) {
                        // For each row, gets string value n then indents \t
                        for (int j = 0; j < columnCount; j++) {
                            content.append(tableModel.getValueAt(i, j));
                            content.append("\t");
                        }
                        // Adds \n after each row
                        content.append("\n");
                    }
                    String contentStr = content.toString();
                    String filePath = JOptionPane.showInputDialog(TaskForm.this, "Enter file location:\n" +
                            "(ex. C:/Users/Ahren/Documents/)");
                    String name = JOptionPane.showInputDialog("Enter file name (exclude .txt):");
                    String fileName = name+".txt";
                    try{
                        filePath+=fileName;
                        fileOutput(filePath,contentStr);
                    } catch (NullPointerException ex){
                        String homeDir = System.getProperty("user.home");
                        filePath = homeDir+"/Documents/"+fileName;
                        fileOutput(filePath,contentStr);
                    }
                } catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
    }
    private void fileOutput(String filePath, String message){
        try {
            OutputStream os = new FileOutputStream(filePath+".txt");
            byte[] b = message.getBytes();
            os.write(b);
            os.close();
            JOptionPane.showMessageDialog(null,"File successfully created!\n"
                    +filePath);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Failed to create file,\n"
            +"please put valid file path.");
        }
    }
    private void setTypeCB(){
        typeCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String type = typeCB.getSelectedItem().toString();
                switch (type){
                    case "Personal"->{
                        taskTable.setModel(personalModel);
                        categoryCB.setModel(personalCBM);
                    }
                    case "School"->{
                        taskTable.setModel(schoolModel);
                        categoryCB.setModel(schoolCBM);
                    }
                    case "Work"->{
                        taskTable.setModel(workModel);
                        categoryCB.setModel(workCBM);
                    }
                    default ->{
                        JOptionPane.showMessageDialog(null,"Please select from\n"+
                                "school/work/personal tasks.");
                    }
                }
            }
        });
    }
}
