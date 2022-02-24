package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Baekjoon_2822 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] score = new int[8][2];
		int sum = 0;
		
		for (int i = 0; i < 8; i++) {
			score[i][0] = Integer.parseInt(br.readLine());
			score[i][1] = i+1;
		}
		
		Arrays.sort(score, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		int[] seq = new int[5];
		for (int i = 0; i < 5; i++) {
			sum += score[7-i][0];
			seq[i] = score[7-i][1];
		}
		Arrays.sort(seq);
		
		System.out.println(sum);
		for (int i = 0; i < 5; i++) {
			System.out.print(seq[i]+" ");
		}
		
	}

}
