/**
 * 
 */
package paralelo;

import base.Matrix;

/**
 * @author Manuel
 *
 */
public class ParallelMatrix extends Matrix {

	/* (non-Javadoc)
	 * @see base.Matrix#multiply(base.Matrix)
	 */
	
	/**
	 * Constructor parametrizado
	 * 
	 * @param rDimension
	 * @param cDimension
	 */
	public ParallelMatrix(int rDimension, int cDimension)
	{
		super(rDimension, cDimension);
	}
	
	public ParallelMatrix(int rDimension, int cDimension, double[][] data) {
		super(rDimension,cDimension,data);
	}
	
	@Override
	public double[][] multiply(Matrix secondMatrix) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		int rows= this.getRowDimension();
		int columns = secondMatrix.getColumnDimension();
		int number_of_threads = rows * columns;
		
		double[][] result = new double[rows][columns];
		
		MultiplierThread[] threads  = new MultiplierThread[number_of_threads];
		
		
		int y = 0;
		for(int i = 0; i < this.getRowDimension(); i++) {
			for(int j = 0; j < secondMatrix.getColumnDimension(); j++) {
				
				threads[y] = new MultiplierThread(this.getRowVector(i),secondMatrix.getColumnVector(j));
				y++;
				
			}
			
		}
		
		for(int i= 0; i< number_of_threads; i++) {
			threads[i].start();
		}
		
		for(int i= 0; i< number_of_threads; i++) {
			threads[i].join();
		}
		
		
		int x = 0;
		for(int i=0; i<rows; i++) {
			for(int j=0; j< columns; j++) {
				result[i][j] = threads[x].getResult();
				x++;
			}
		
		}
		
		
		
		return result;
	}

}
