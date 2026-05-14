
/**
 * GradeCalResult 학생 1명 x 과목 1개 단위의 성적 결과를 산출하고 저장,출력하는 클래스.
 * 총점 계산(가중치 반영), 절대평가 기반으로 학점 부여, 결과 출력 기능을 담당한다. 
 * main 에서 GradeCalResult[100][6]으로 관리한다. 
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class GradeCalResult
{
    // 인스턴스 변수 
    private String studentId;
    private String studentName;
    private double totalScore;
    private String grade;

    private String subjectName;
    
    
    /**
     * GradeCalResult 클래스의 객체 생성자
     */
    public GradeCalResult(String id,String name)
    {
        this.studentId=id;
        this.studentName=name;
        this.totalScore=0.0;
        this.grade="";
    }

    /**
     * 총점계산(가중치 반영)
     * 총점 = (점수1*가중치1)+(점수2*가중치2)+....
     *
     * @param scores(항목별 점수 배열 -중간,기말,과제,출석)
     * @param weights(항목별 가중치 배열-30,40,20,10)
     * @return    가중치가 반영 된 총점 반환 
     */
    public double calcTotalScore(double[]scores, double[]weights)
    {
        double total=0.0;

        for(int i=0;i<scores.length;i++){
            total+=(scores[i]*weights[i])/100;
        }
        this.totalScore=total;
        return this.totalScore;
    }

    /**
     * 절대평가 학점 부여
     * A+:95이상,A0:90이상,A-:85이상,B+:80이상,...F
     * 
     * @param  total (가중치가 반영된 총점)
     * @return    학점 반환 
     */
    public String assignAbsoluteGrade(double total)
    {
        if(total>=95){
            this.grade="A+";
        }
        else if(total>=90){
            this.grade="A0";
        }
        else if(total>=85){
            this.grade="A-";
        }
        else if(total>=80){
            this.grade="B+";
        }
        else if(total>=75){
            this.grade="B0";
        }
        else if(total>=70){
            this.grade="B-";
        }
        else if(total>=65){
            this.grade="C+";
        }
        else if(total>=60){
            this.grade="C0";
        }
        else if(total>=55){
            this.grade="C-";
        }
        else if(total>=50){
            this.grade="D+";
        }
        else if(total>=45){
            this.grade="D0";
        }
        else if(total>=40){
            this.grade="D-";
        }
        else{
            this.grade="F";
        }
        return this.grade;
    }
    
    public void setSubjectName(String subjectName){
        this.subjectName=subjectName;
    }
    
    /**
     * 총점 반환 
     * @return   가중치가 반영 된 총점 반환
     */
    public double getTotalScore()
    {
        return this.totalScore;
    }

    /**
     * 학점 반환
     * @return    학점 반환 
     */
    public String getGrade()
    {
        return this.grade;
    }

    /**
     * 결과 출력 : 총점,학점 출력 
     */
    public void display()
    {
        System.out.println("======결과 출력======");
        System.out.println("학번 : " + studentId+" "+"이름 : "+studentName);
        System.out.println("과목 : " + subjectName); 
        System.out.printf("총점 : %.1f" ,totalScore);
        System.out.println("학점 : " + grade);
        System.out.println();
    }

}