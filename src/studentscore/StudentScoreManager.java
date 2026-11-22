
package studentscore;

import java.util.*;

public class StudentScoreManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentCount;

        System.out.println("请输入学生人数");
        studentCount = scanner.nextInt();

        int[] scores = new int[studentCount];
        int totalScore = 0;

        for (int i = 0; i < studentCount; i++) {
            System.out.println("输入第" + i + "个学生成绩");
            scores[i] = scanner.nextInt();
            totalScore = totalScore + scores[i];
        }

        double averageScore = totalScore / studentCount;
        System.out.println("平均分是" + averageScore);

        for (int i = 0; i < scores.length - 1; i++) {
            for (int j = 0; j < scores.length - 1 - i; j++) {
                if (scores[j] < scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                }
            }
        }

        System.out.println("成绩降序排列：");
        for (int i = 0; i < scores.length; i++) {
            System.out.print(scores[i] + " ");
        }

        int maxScore = scores[0];
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                maxScore = scores[i];
            }
        }

        System.out.println("\n最高分：" + maxScore);
    }
}
