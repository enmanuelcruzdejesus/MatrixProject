package paralelo;

public class MultiplierThread extends Thread 
{

	private double[] rowVector;
	private double[] columnVector;
	private double result;
	
	/**
	 * Constructor parametrizado 
	 * 
	 * @param rowVector
	 * @param columnVector
	 */
	public MultiplierThread(double[] rowVector, double[] columnVector)
	{
		this.setRowVector(rowVector);
		this.setColumnVector(columnVector);
	}

	public double[] getRowVector() {
		return rowVector;
	}

	public void setRowVector(double[] rowVector) {
		this.rowVector = rowVector;
	}

	public double[] getColumnVector() {
		return columnVector;
	}

	public void setColumnVector(double[] columnVector) {
		this.columnVector = columnVector;
	}

	public double getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
	/**
	 * 
	 */
	public void run()
	{
         int rows = this.getRowVector().length;
		
		for(int i =0; i < rows; i++ ) {
			result += this.rowVector[i] * this.columnVector[i];
			
		}
		
		
		
	}
	
	
}
