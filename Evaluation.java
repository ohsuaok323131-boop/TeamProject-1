
/**
 * Evaluation 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Evaluation
{
    private String itemName;
    private double maxScore;
    private double weight;
    
    public Evaluation(String name, double max, double weight){
        this.itemName = name;
        this.maxScore = max;
        this.weight = weight;
    }
    
    public String getItemName(){return itemName;}
    public double getMaxScore(){return maxScore;}
    public double getWeight(){return weight;}
    
    public void printInfo(){
        System.out.println("항목: " + itemName + ", 만점: " + maxScore
            + ", 가중치" + (weight * 100) + "%");
        }
}