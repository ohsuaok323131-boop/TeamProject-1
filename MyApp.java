import java.util.Scanner;
/**
 * MyApp : 성적처리 소프트웨어 메인 클래스.
 * 100명의 학생 데이터를 처리하고 6과목별 절대평가로 학점을 산출/출력한다.
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class MyApp
{
    public static void main(String[] args)
    {
        final int NUM_STUDENTS = 100;
        final int SUBJECT_COUNT = 6;
        final int ITEM_COUNT = 4;
        Scanner sc = new Scanner(System.in);
        
        Student[] students = new Student[NUM_STUDENTS];
        GradeCalResult[][] results = new GradeCalResult[NUM_STUDENTS][SUBJECT_COUNT];
        
        String[] subjectNames = {
            "소프트웨어공학개론", "데이터사이언스개론", "프로그래밍응용",
            "컴퓨터 데이터구조", "읽기와 토론", "English listening and speaking"
        };
        String[] itemNames = {"중간", "기말", "과제", "출석"};
        double[] maxScores = {100, 100, 100, 100};
        double[] weights = {30, 40, 20, 10};
        
        for (int i = 0; i < NUM_STUDENTS; i++) {
            String id;
            String name;
            String department;
            int year;
            
            if (i == 0) {
                System.out.println("첫 학생 정보 입력");
                System.out.print("학번: ");
                id = sc.next();
                System.out.print("이름: ");
                name = sc.next();
                System.out.print("학과: ");
                department = sc.next();
                System.out.print("학년: ");
                year = sc.nextInt();
            } else {
                id = "" + (20260001 + i);
                name = "학생" + (i + 1);
                department = "AI소프트웨어학과";
                year = 1;
            }
            
            Student student = new Student(id, name, department, year);
            
            for (int s = 0; s < SUBJECT_COUNT; s++) {
                student.addSubject(subjectNames[s]);
            }
            
            for (int it = 0; it < ITEM_COUNT; it++) {
                student.addItem(itemNames[it], maxScores[it], weights[it]);
            }
            
            if (i == 0) {
                double[] inputScores = new double[ITEM_COUNT];
                System.out.println("점수 입력 (0~100, 4개 항목 -> 6과목 동일하게 적용)");
                for (int it = 0; it < ITEM_COUNT; it++) {
                    double score;
                    do {
                        System.out.print(itemNames[it] + " 점수: ");
                        score = sc.nextDouble();
                        if (!student.checkScore(score, maxScores[it])) {
                            System.out.println("경고: 0~" + maxScores[it] + " 범위 안에 입력하세요.");
                        }
                    } while (!student.checkScore(score, maxScores[it]));
                    inputScores[it] = score;
                }
                
                for (int s = 0; s < SUBJECT_COUNT; s++) {
                    for (int it = 0; it < ITEM_COUNT; it++) {
                        student.setScore(s, it, inputScores[it]);
                    }
                }
            } else {
                for (int s = 0; s < SUBJECT_COUNT; s++) {
                    for (int it = 0; it < ITEM_COUNT; it++) {
                        double score = (i * 7 + s * 11 + it * 13) % 71 + 30;
                        student.setScore(s, it, score);
                    }
                }
            }
            
            students[i] = student;
        }
        
        for (int i = 0; i < NUM_STUDENTS; i++) {
            for (int j = 0; j < SUBJECT_COUNT; j++) {
                GradeCalResult result = new GradeCalResult(students[i].getId(), students[i].getName());
                
                double[] subjectScores = students[i].getScores()[j];
                double[] studentWeights = students[i].getWeight();
                
                double total = result.calcTotalScore(subjectScores, studentWeights);
                result.assignAbsoluteGrade(total);
                
                results[i][j] = result;
            }
        }
        
        System.out.println("\n전체 학생 성적 결과\n");
        for (int i = 0; i < NUM_STUDENTS; i++) {
            students[i].showStudent();
            for (int j = 0; j < SUBJECT_COUNT; j++) {
                results[i][j].display();
            }
        }
        
        sc.close();
    }
}