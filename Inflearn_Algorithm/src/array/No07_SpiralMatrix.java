package array;

import java.util.ArrayList;
import java.util.List;

/*
 * matrix 배열을 달팽이처럼 출력하기
 */
class SpiralMatrix {
	public List<Integer> solve(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return result;
		}
		int rowStart = 0;
		int rowEnd = matrix.length - 1;
		int colStart = 0;
		int colEnd = matrix[0].length - 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {
			// right
			for (int i = colStart; i <= colEnd; i++) {
				result.add(matrix[rowStart][i]);
			}
			rowStart++;

			// down
			for (int i = rowStart; i <= rowEnd; i++) {
				result.add(matrix[i][colEnd]);
			}
			colEnd--;

			// left
			if (rowStart <= rowEnd) {	// while문 안 right에서 rowStart++ 되니까
				for (int i = colEnd; i >= colStart; i--) {
					result.add(matrix[rowEnd][i]);
				}
			}
			rowEnd--;

			// up
			if (colStart <= colEnd) {	// down에서 colEnd-- 되니까 체크 한번 더
				for (int i = rowEnd; i >= rowStart; i--) {
					result.add(matrix[i][colStart]);
				}
			}
			colStart++;
		}

		return result;
	}
}

public class No07_SpiralMatrix {
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		SpiralMatrix sol = new SpiralMatrix();
		System.out.println(sol.solve(matrix));
	}
}
