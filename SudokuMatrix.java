import java.util.Arrays;
public class SudokuMatrix{
	int [][] board = new int [9][9];

	public SudokuMatrix(int [][] matrixBoard){
		this.board = matrixBoard;
	}

	public int[][] getBoard(){
		return board;
	}

	public void setBoard(int[][] matrixBoard){
		this.board = matrixBoard;
	}

	public void setCoordinates(int column, int row, int value){
		this.board[row][column] = value;
	}


	public void displayBoard(){
		System.out.println("____________________________________");
		for(int [] row : board ){
			System.out.print("| ");
			for(int i : row){
				System.out.print(i+" | ");
			}
			System.out.print("\n");
			System.out.println("____________________________________");
		}
	}


	private boolean validRows(){
		int [] temp = new int[9];
		
		//checking if each row is valid
		for(int [] row : board){
	
			//  Copying the array
			for(int i = 0; i<row.length;i++ ){
				temp[i] = row[i];
			}
			Arrays.sort(temp);
			
	
			// Checking for duplicates 
			for(int i = 1; i<temp.length;i++){
				if(temp[i] == temp[i-1] && temp[i] != 0){
					return false;
				}
			}

		}
		return true;
	}

	private boolean validColumns(){
		int [] temp = new int[9];
		for(int column = 0; column< board.length; column++){
			for(int row = 0; row< board.length;row++){
				temp[row] = board[row][column];
			}

			Arrays.sort(temp);
	
			// Checking for duplicates 
			for(int i = 1; i<temp.length;i++){
				if(temp[i] == temp[i-1] && temp[i] != 0){
					return false;
				}
			}

		}
		return true;
	}

	private boolean validBoxes(){
		int [] temp = new int[9];
		for(int rowBox = 0; rowBox< temp.length; rowBox = rowBox+3){
			for(int columnBox = 0; columnBox < temp.length; columnBox =  columnBox+3){
				temp[0] = board[rowBox][columnBox];
				temp[1] = board[rowBox][columnBox+1];
				temp[2] = board[rowBox][columnBox+2];
				temp[3] = board[rowBox+1][columnBox];
				temp[4] = board[rowBox+1][columnBox+1];
				temp[5] = board[rowBox+1][columnBox+2];
				temp[6] = board[rowBox+2][columnBox];
				temp[7] = board[rowBox+2][columnBox+1];
				temp[8] = board[rowBox+2][columnBox+2];

				Arrays.sort(temp);
	
				// Checking for duplicates 
				for(int i = 1; i<temp.length;i++){
					if(temp[i] == temp[i-1] && temp[i] != 0){
						return false;
					}
			}
			}
		}

		return true;

	}

	public boolean valid(){
		return validBoxes()&& validColumns()&& validRows();
	}



	public static void main(String[] args) {	
		
		int [] []  array2D	=  {{5,3,0,0,7,0,0,0,0},
								{6,0,0,1,9,5,0,0,0},
								{0,9,8,0,0,0,0,6,0},
								{8,0,0,0,6,0,0,0,3},
								{4,0,0,8,0,3,0,0,1},
								{7,0,0,0,2,0,0,0,6},
								{1,6,0,0,0,0,2,8,0},
								{0,0,0,4,1,9,0,0,5},
								{0,0,0,0,8,0,0,7,9}};
		SudokuMatrix matrix = new SudokuMatrix(array2D);

		for(int i = 0; i<1000000;i++){
			matrix.valid();
		}
		System.out.println(matrix.valid());
		matrix.displayBoard();
	}


}