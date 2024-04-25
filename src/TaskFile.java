import javax.swing.*;
class Task { // INHERITANCE!!
    String title;
    String date;
    Task(String title, String date){
        this.title = title;
        this.date = date;
    }
    // SUPER METHOD!!
    public void displayTaskDetails() {
        System.out.println("Title: " + title);
        System.out.println("Date: " + date);
    }
}
class Work extends Task{
    String department;
    String quarter;
    public Work(String title, String date, String department, String quarter) {
        super(title, date);
        this.department = department;
        this.quarter = quarter;
    }
    @Override // METHOD OVERRIDING!! POLYMORPHISM!!
    public void displayTaskDetails() {
        super.displayTaskDetails(); // Call superclass method
        System.out.println("Department: " + department);
        System.out.println("Quarter: " + quarter);
    }
    public String askDepartment(){
        String department = JOptionPane.showInputDialog(null, "Enter department (ex. HR):");
        this.department = department;
        return department;
    }
    public String askQuarter(){
        String quarter = JOptionPane.showInputDialog(null, "Enter quarter (ex. Q4):");
        this.quarter = quarter;
        return quarter;
    }
}
class School extends Task{
    String subject;
    String club;
    public School(String title, String date, String subject, String club){
        super(title, date);
        this.subject = subject;
        this.club = club;
    }
    @Override
    public void displayTaskDetails() {
        super.displayTaskDetails(); // Call superclass method
        System.out.println("Subject: " + subject);
        System.out.println("Club: " + club);
    }
    public String askSubject(){
        String subject = JOptionPane.showInputDialog(null, "Enter subject (ex. Calculus):");
        this.subject = subject;
        return subject;
    }
    public String askClub(){
        String club = JOptionPane.showInputDialog(null, "Enter club name (ex. S.A.S.E.):");
        this.club = club;
        return club;
    }
}
class Personal extends Task{
    String chore;
    String errand;
    public Personal(String title, String date, String chore, String errand){
        super(title, date);
        this.chore = chore;
        this.errand = errand;
    }
    @Override
    public void displayTaskDetails() {
        super.displayTaskDetails(); // Call superclass method
        System.out.println("Chore: " + chore);
        System.out.println("Errand: " + errand);
    }
    public String askChore(){
        String chore = JOptionPane.showInputDialog(null, "Enter chore (ex. Wash dishes):");
        this.chore = chore;
        return chore;
    }
    public String askErrand(){
        String errand = JOptionPane.showInputDialog(null, "Enter errand (ex. Get milk):");
        this.errand = errand;
        return errand;
    }
}
