package studentscore;

import java.util.Scanner;

/**
 * 学生成绩管理程序。
 * 用于录入学生成绩、计算平均分、降序排列成绩并获取最高分。
 *
 * @author 你的姓名
 */
public class StudentScoreManager {

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
            int[] scores = inputScores(scanner);
            if (scores.length == 0) {
                return;
            }
            double average = calculateAverage(scores);
            System.out.println("平均分是" + average);
            sortScores(scores);
            printScores(scores);
            System.out.println("\n最高分：" + findMaxScore(scores));
        }
    }

    /**
     * 输入学生人数及所有学生成绩。
     *
     * @param scanner 输入扫描器
     * @return 学生成绩数组
     */
    private static int[] inputScores(Scanner scanner) {
        System.out.println("请输入学生人数");
        int studentCount = scanner.nextInt();

        if (studentCount < MIN_STUDENT_COUNT) {
            System.out.println("学生人数必须大于等于1！");
            return new int[0];
        }

        int[] scores = new int[studentCount];

        for (int i = 0; i < studentCount; i++) {
            System.out.println("输入第" + (i + 1) + "个学生成绩");
            int score = scanner.nextInt();

            while (score < MIN_SCORE || score > MAX_SCORE) {
                System.out.println("成绩必须在0到100之间，请重新输入：");
                score = scanner.nextInt();
            }

            scores[i] = score;
        }

        return scores;
    }

    /**
     * 计算学生平均分。
     *
     * @param scores 学生成绩数组
     * @return 平均分
     */
    private static double calculateAverage(int[] scores) {
        long totalScore = 0;

        for (int score : scores) {
            totalScore += score;
        }

        return (double) totalScore / scores.length;
    }

    /**
     * 使用冒泡排序将成绩降序排列。
     *
     * @param scores 学生成绩数组
     */
    private static void sortScores(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            for (int j = 0; j < scores.length - 1 - i; j++) {
                if (scores[j] < scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 输出降序排列后的成绩。
     *
     * @param scores 学生成绩数组
     */
    private static void printScores(int[] scores) {
        System.out.println("成绩降序排列：");

        for (int score : scores) {
            System.out.print(score + " ");
        }
    }

    /**
     * 查找学生中的最高分。
     *
     * @param scores 学生成绩数组
     * @return 最高分
     */
    private static int findMaxScore(int[] scores) {
        int maxScore = scores[0];

        for (int score : scores) {
            if (score > maxScore) {
                maxScore = score;
            }
        }

        return maxScore;
    }
}
