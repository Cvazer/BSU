package lab1;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static int[][] matrix;

    public static void main(String[] args) {
        System.out.println("Введите n:");
        int n = new Scanner(System.in).nextInt();
        matrix = new int[n][n];

        Random r = new Random();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = r.nextInt((2*n)+1) - n;
            }
        }

        printMatrix(matrix);

        System.out.println("Введите k:");
        int k = new Scanner(System.in).nextInt();

        System.out.println("---Сортировка по k-му элементу стобца---");
        Arrays.asList(matrix).stream().sorted((r1, r2) -> r1[k]-r2[k]).forEach(row -> {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i]+((i==n-1)?"\n":" "));
            }
        });

        System.out.println("---Сортировка по k-му элементу строки---");
        int[][] matrixT = transposeMatrix(matrix);
        int[][] tmp = new int[n][n];
        List<int[]> rows = Arrays.asList(matrixT).stream().sorted((r1, r2) -> r1[k]-r2[k]).collect(Collectors.toList());
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = rows.get(i);
        }
        printMatrix(transposeMatrix(tmp));
    }

    private static boolean isZero(int[] ints) {
        boolean zero = true;
        for (int num: ints){
            zero = (num!=0) ? true : false;
        }
        return zero;
    }

    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] transposeMatrix(int [][] m){
        for (int i = 0; i < m.length; i++) {
            for (int j = i+1; j < m[0].length; j++) {
                int temp = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = temp;
            }
        }

        return m;
    }
}
