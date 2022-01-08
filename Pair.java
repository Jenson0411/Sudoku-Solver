public class Pair{
	private int column;
	private int row;
	
	public Pair(int column, int row){
		this.column = column;
		this.row = row;
	}

	public int getColumn(){
		return column;
	}

	public int getRow(){
		return row;
	}

	public void setColumn(int column){
		this.column = column;
	}

	public void setRow(int row){
		this.row = row;
	}

}