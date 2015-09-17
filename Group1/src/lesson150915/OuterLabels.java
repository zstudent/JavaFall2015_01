package lesson150915;

public class OuterLabels {

	public static void main(String[] args) {

		int[][] matrix = { 
				{ 1, 2, 3,}, 
				{ 4, 5, 6,}, 
				{ 7, 8, 9,},
				{ 10, 11, 12,},
				};
		
		OUTER: 
			for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
				if (matrix[i][j] >= 5) {
					break OUTER;
				}
			}
			System.out.println();
		}
		//  OUTER exit point
	}
}
