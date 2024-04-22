class Task { //op
    String title;
    String date;
    Task(String title, String date){
        this.title = title;
        this.date = date;
    }
}
class Work extends Task{
    String project;
    String meeting;
    public Work(String title, String date, String project, String meeting) {
        super(title, date);
        this.project = project;
        this.meeting = meeting;
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
}
class Personal extends Task{
    String chore;
    String errand;
    public Personal(String title, String date, String chores, String errands){
        super(title, date);
        this.chore = chores;
        this.errand = errands;
    }
}
