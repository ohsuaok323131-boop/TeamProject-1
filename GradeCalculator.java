
/**
 * GradeCalculator 점수를 받아서 총점계산, 학점부여, 등수계산 담당 
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class GradeCalculator
{
    // 인스턴스 변수 - 다음의 예제를 사용자에 맞게 변경하세요.
    private String gradePolicy;

    /**
     * GradeCalculator 클래스의 객체 생성자
     */
    public GradeCalculator(String policy)
    {
        // 인스턴스 변수 초기화
        this.gradePolicy=policy;
    }

    public double calcTotalScore(double mid, double fin, double hw, double att)
    {
        double total=(mid*0.3)+(fin*0.4)+(hw*0.2)+(att*0.1);

        return total;
    }

    //학점 부여 메소드(절대평가)

    public String assignGrade(double total){
        if(total>=95){
            return "A+";
        }
        else if(total>=90){
            return "A0";
        }
        else if(total>=85){
            return "A-";
        }
        else if(total>=80){
            return "B+";
        }
        else if(total>=75){
            return "B0";
        }
        else if(total>=70){
            return "B-";
        }
        else if(total>=65){
            return "C+";
        }
        else if(total>=60){
            return "C0";
        }
        else if(total>=55){
            return "C-";
        }
        else if(total>=50){
            return "D+";
        }
        else if(total>=45){
            return "D0";
        }
        else if(total>=40){
            return "D-";
        }
        else {
            return "F";
        }
    }

    public int calcRank(double total,double[] score){
        int rank=1;
        
        for(int i=0;i<score.length;i++){
            if(score[i]>total){
                rank++;
            }
        }
        return rank;
    }
}