
/**
 * Student 학생 한명의 정보와 성적 데이터를 저장하고, 관리하는 클래스
 * 학번, 이름, 학과, 학년 등 기본 정보와 과목별 평가항목 점수를 2차원 배열(scores[6][4])로 관리한다.
 * 점수 입력 시 유효범위(0~100점)검증 기능을 포함한다. 
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Student{
    private String studentId;
    private String name;
    private String department;
    private int year;

    private String[] subjectName = new String[6];
    private String[] itemName = new String[4];

    private double[] maxScore = new double[4];
    private double[] weight = new double[4];

    private double[][] scores = new double[6][4];

    private int subjectCount = 0;
    private int itemCount = 0;

    private static final int MAX_STUDENTS = 100;

    
    public Student(String id, String name, String department, int year){
        this.studentId = id;
        this.name = name;
        this.department = department;
        this.year = year;
    }

    
    public void addSubject(String subjectName){
        if (subjectCount < 6){
            this.subjectName[subjectCount] = subjectName;
            subjectCount++;
        } else{
            System.out.println("과목은 최대 6개까지 등록 가능합니다.");
        }
    }

    
    public void addItem(String itemName, double max, double weight){
        if (itemCount < 4){
            this.itemName[itemCount] = itemName;
            this.maxScore[itemCount] = max;
            this.weight[itemCount] = weight;
            itemCount++;
        } else{
            System.out.println("항목은 최대 4개까지 등록 가능합니다.");
        }
    }

    
    public void setScore(int subjectIdx, int itemIdx, double score){
        if (checkScore(score, maxScore[itemIdx])){
            scores[subjectIdx][itemIdx] = score;
        } else{
            System.out.println("경고: 점수가 범위를 벗어났습니다. 0으로 저장합니다.");
            scores[subjectIdx][itemIdx] = 0;
        }
    }

    
    public boolean checkScore(double score, double max){
        return score >= 0 && score <= max;
    }

    
    public String getId(){return studentId;}
    public String getName(){return name;}
    public String[] getSubjectName(){return subjectName;}
    public double[][] getScores(){return scores;}
    public double[] getWeight(){return weight;}
    public int getSubjectCount(){return subjectCount;}
    public int getItemCount(){return itemCount;}

    
    public void showStudent(){
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("학번: " + studentId);
        System.out.println("이름: " + name);
        System.out.println("학과: " + department);
        System.out.println("학년: " + year);
        System.out.println("..............................................");

        System.out.print("과목");
        for (int item = 0; item < itemCount; item++){
            System.out.print(itemName[item]);
        }
        System.out.println();

        for (int s = 0; s < subjectCount; s++){
            System.out.print(subjectName[s]);
            for (int item = 0; item < itemCount; item++){
                System.out.print(scores[s][item]);
            }
            System.out.println();
        }

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }
}