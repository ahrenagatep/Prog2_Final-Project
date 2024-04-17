public class TaskFile {
 // what
}
class Task {
 int time;
 int date;

 Work work;
 School school;
 Personal personal;

 Task( int time, int date, Work work, School school, Personal personal){
  this.time = time;
  this.date = date;
  this.work = work;
  this.school = school;
  this.personal = personal;
 }
}
class Work {
 String projects;
 String meeting;

 Work(String projects, String meeting) {
     this.projects = projects;
     this.meeting = meeting;
 }
}
class School {
 String subject;
 String clubs;

 School(String subject, String clubs){
    this.subject = subject;
    this.clubs = clubs;
 }
}
class Personal{
String chores;
String errands;

Personal(String chores, String errands){
     this.chores = chores;
     this.errands = errands;
}
}
