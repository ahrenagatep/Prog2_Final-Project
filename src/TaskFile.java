class Task {
    String title;
    String date;
    Task(String title, String date){
        this.title = title;
        this.date = date;
    }
    // POLYMORPHISM YIPPEE!
    public void displayTaskDetails() {
        System.out.println("Title: " + title);
        System.out.println("Date: " + date);
    }
}
class Work extends Task{
    String department;
    int quarter;
    public Work(String title, String date, String department, int quarter) {
        super(title, date);
        this.department = department;
        this.quarter = quarter;
    }
    @Override // METHOD OVERRIDING!!
    public void displayTaskDetails() {
        super.displayTaskDetails(); // Call superclass method
        System.out.println("Department: " + department);
        System.out.println("Quarter: " + "Q"+quarter);
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
}
