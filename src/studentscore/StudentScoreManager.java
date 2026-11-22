package studentscore;

import java.util.Scanner;

/**
 * 学生成绩管理程序。
 * 用于录入学生成绩、计算平均分、降序排列成绩并获取最高分。
 */
public class StudentScoreManager {

    // 学生人数和成绩范围常量
    private static final int MIN_STUDENT_COUNT = 1;
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;

    /**
     * 程序入口方法。
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("请输入学生人数");
            int studentCount = scanner.nextInt();

            // 检查学生人数是否合法
            if (studentCount < MIN_STUDENT_COUNT) {
                System.out.println("学生人数必须大于等于1！");
                return;
            }

            int[] scores = new int[studentCount];
            long totalScore = 0;

            for (int i = 0; i < studentCount; i++) {
                System.out.println("输入第" + (i + 1) + "个学生成绩");
                int score = scanner.nextInt();

                // 检查成绩是否在合法范围内
                while (score < MIN_SCORE || score > MAX_SCORE) {
                    System.out.println("成绩必须在0到100之间，请重新输入：");
                    score = scanner.nextInt();
                }

                scores[i] = score;
                totalScore += scores[i];
            }

            // 计算平均分，避免整数除法
            double averageScore = (double) totalScore / studentCount;
            System.out.println("平均分是" + averageScore);

            // 使用冒泡排序，将成绩按照降序排列
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
            for (int score : scores) {
                System.out.print(score + " ");
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
}
