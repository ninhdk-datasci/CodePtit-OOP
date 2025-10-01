
package j05018;

import java.util.*; 

class Student {
    private String code, name, rank;
    private float avgScore; 

    public Student(String code, String name, String rank, float avgScore) {
        this.code = code;
        this.name = name;
        this.rank = rank;
        this.avgScore = avgScore;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public String getCode() {
        return code;
    }
    
    
    @ Override 
    public String toString(){
        return code + " " + name + " " + String.format("%.1f", avgScore + 1e-3) + " " + rank; 
    }
}


public class J05018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        int n = Integer.parseInt(sc.nextLine()); 
        ArrayList<Student> stus = new ArrayList<>(); 
        for(int i=0; i<n ; i++) { 
            String code = "HS" + String.format("%02d", i+1); 
            String name = sc.nextLine().trim();
            String[] scores = sc.nextLine().trim().split("\\s+"); 
            float sum = 0; 
            for(int j=0; j<10; j++) {
                sum += (Float.parseFloat(scores[j])); 
            }
            sum += (Float.parseFloat(scores[0])); 
            sum += (Float.parseFloat(scores[1])); 
            sum = sum/12; 
            String rank = ""; 
            if(sum >= 9) rank = "XUAT SAC"; 
            else if(sum >= 8 && sum < 8.9) rank = "GIOI"; 
            else if(sum >= 7 && sum < 7.9) rank = "KHA"; 
            else if(sum >= 5 && sum < 6.9) rank = "TB"; 
            else rank = "YEU";
            Student s = new Student(code, name, rank, sum);
            stus.add(s); 
        }
        Collections.sort(stus, new Comparator<Student>(){
            @ Override 
            public int compare(Student s1, Student s2){
                if(s1.getAvgScore() > s2.getAvgScore()) return -1; 
                else if(s1.getAvgScore() < s2.getAvgScore()) return 1; 
                return s1.getCode().compareTo(s2.getCode()); 
            }
        });
        for(Student s : stus){
            System.out.println(s);
        }
    }
}
