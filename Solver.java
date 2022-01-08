import java.util.Stack;
public class Solver {
	private SudokuMatrix board;
	private Stack previousCoordinate = new Stack();

	public Solver(int [][] array2D){
		this.board = new SudokuMatrix(array2D);
		board.displayBoard();
		solve();
		board.displayBoard();
	}

	private void solve(){
		int row = 0;
		int column = 0 ;
		int value;
		Pair pair;
		boolean flag = false;
		boolean flag1 = true;
		while(row != 9 || column != 9){
			if(column == 9 && row == 8){
				break;
			}

			if(row == 9){
				break;
			}
			value = board.getCoordinates(column,row);
			if(value == 0 || flag){
				flag1 = true;
				// imcrement  value of the sudoku
				for(int i = value +1; i< 11;i++){
					board.setCoordinates(column, row, i%10);

					if(board.valid()){

						previousCoordinate.push(new Pair(column, row));
						break;
					}
					
				}

				if(board.getCoordinates(column, row) == 0){
					previousCoordinate.pop();
				  	pair = (Pair)previousCoordinate.pop();
				  	column = pair.getColumn();
				  	row = pair.getRow();
				  	flag = true;
				  	flag1 = false;
				}
				// 5
			}
			if(flag1){
				column = (column + 1) %9;

				if(column == 0){
					row = row+ 1;
				}
				flag = false;				
			}
			
			
		}

	}


	public static void main(String[] args) {
		int [] []  array2D	=  {{3,0,0,0,0,0,0,2,0},
								{4,0,0,0,9,0,0,0,0},
								{0,9,2,6,0,0,8,0,0},
								{9,0,0,0,0,0,0,0,0},
								{0,5,1,0,6,0,0,4,0},
								{0,0,0,8,0,0,0,0,7},
								{0,0,0,0,0,1,4,0,0},
								{0,0,3,0,0,0,0,0,0},
								{0,2,6,0,5,0,0,1,0}};
		Solver solver = new Solver(array2D);
	}
}