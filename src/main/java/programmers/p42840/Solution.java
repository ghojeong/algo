package programmers.p42840;

// https://programmers.co.kr/learn/courses/30/lessons/42840

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    class Student {
        final int number;
        final int corrected;

        Student(int number, int corrected) {
            this.number = number;
            this.corrected = corrected;
        }
    }

    int getCorrected(int[] answers, int[] pattern) {
        int corrected = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == pattern[i % pattern.length]) {
                corrected++;
            }
        }
        return corrected;
    }

    int getMax(List<Student> students) {
        int max = 0;
        for (Student student : students) {
            max = Math.max(max, student.corrected);
        }
        return max;
    }

    public int[] solution(int[] answers) {
        List<Student> students = Arrays.asList(
                new Student(1, getCorrected(answers, new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5})),
                new Student(2, getCorrected(answers, new int[]{2, 1, 2, 3, 2, 4, 2, 5})),
                new Student(3, getCorrected(answers, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}))
        );
        int max = getMax(students);

        List<Student> answer = new LinkedList<>();
        for (Student student : students) {
            if (student.corrected >= max) {
                answer.add(student);
            }
        }

        return answer.stream()
                .mapToInt(student -> student.number)
                .toArray();
    }
}
