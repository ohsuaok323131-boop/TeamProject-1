
/**
 * Student 학생 한명의 정보와 점수 저장
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Student
{
    // 필드 
    private String studentId;
    private String name;
    private String department;

    private int year;

    private double midExam;
    private double finalExam;
    private double homework;
    private double attendance;

    /**
     * Student 클래스의 객체 생성자
     */
    public Student(String id, String name,String department, int year)
    {
        this.studentId=id;
        this.name=name;
        this.department=department;
        this.year=year;

        this.midExam=0.0;
        this.finalExam=0.0;
        this.homework=0.0;
        this.attendance=0.0;
    }

    //메소드 set

    public void setMidExam(double score)
    {
        this.midExam=score;
    }

    public void setFinalExam(double score)
    {
        this.finalExam=score;
    }

    public void setHomework(double score)
    {
        this.homework=score;
    }

    public void setAttendance(double score)
    {
        this.attendance=score;
    }

    //메소드 get

    public String getId(){
        return studentId;
    }

    public String getName(){
        return name;
    }

    public String getDepartment(){
        return department;
    }

    public int getYear(){
        return year;
    }

    public double getHomework(){
        return homework;
    }

    public double getAttendance(){
        return attendance;
    }

    public double getMidExam(){
        return midExam;
    }

    public double getFinalExam(){
        return finalExam;
    }

    public void showStudent(){
        System.out.println("-------학생정보-------");
        
        System.out.println("학번: "+studentId+"이름: "+name+
            "학과: "+department+"학년: "+year);
            
        System.out.println();
            
        System.out.println("과제 점수: "+homework);
        System.out.println("출석 점수: "+attendance);
        System.out.println("중간고사: "+midExam);
        System.out.println("기말고사: "+finalExam);
        
        System.out.println("---------------------");

    }
}