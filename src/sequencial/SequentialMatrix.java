package sequencial;

import base.Matrix;

public class SequentialMatrix extends Matrix 
{
	
	public SequentialMatrix(int rDimension, int cDimension) 
	{
		super(rDimension, cDimension);
		// TODO Auto-generated constructor stub
	}
	public SequentialMatrix(int rDimension, int cDimension, double[][] data) {
		super(rDimension,cDimension,data);
	}

	@Override
	public double[][] multiply(Matrix secondMatrix) 
	{
		double[][] resultMatrix = new double[this.columnDimension][secondMatrix.getRowDimension()];
		
		int aRows = super.rowDimension;
		int aColumns = super.columnDimension;
		int bRows = secondMatrix.getRowDimension();
		int bColumns = secondMatrix.getColumnDimension();
		
		for(int i = 0 ; i< aRows; i++) {
			for(int j =0; j< bColumns; j++) {
				for(int k=0; k < aColumns; k++) {
					resultMatrix[i][j]+= super.getEntry(i,k)*secondMatrix.getEntry(k,j);
				}
			}
		}
	
		return resultMatrix;
	}
	
	public Matrix inverse(){
		double[][] matrix = this.matrixData;
		double[][] inverse = new double[this.rowDimension][this.columnDimension];
		int dimension = this.rowDimension;
		
		

	    for (int i = 0; i < this.rowDimension; i++)
	        for (int j = 0; j < this.columnDimension; j++)
	            inverse[i][j] = 0;
	    
	    for (int i = 0; i < this.rowDimension; i++)
	        inverse[i][i] = 1;
	    
	    
	    for (int k = 0; k < dimension; k++)
	    {
	        for (int i = k; i < dimension; i++)
	        {
	            double valInv = 1 / matrix[i][k];
	            for (int j = k; j < dimension; j++)
	                matrix[i][j] *= valInv;
	            for (int j = 0; j < dimension; j++)
	                inverse[i][j] *= valInv;
	        }
	        for (int i = k + 1; i < dimension; i++)
	        {
	            for (int j = k; j < dimension; j++)
	                matrix[i][j] -= matrix[k][j];
	            for (int j = 0; j < dimension; j++)
	                inverse[i][j] -= inverse[k][j];
	        }
	    }
	 
	    for (int i = dimension - 2; i >= 0; i--)
	    {
	        for (int j = dimension - 1; j > i; j--)
	        {
	            for (int k = 0; k < dimension; k++)
	                inverse[i][k] -= matrix[i][j] * inverse[j][k]; 
	            for (int k = 0; k < dimension; k++)
	                matrix[i][k] -= matrix[i][j] * matrix[j][k]; 
	        }
	    }
	    
	    

	    Matrix result = new SequentialMatrix(dimension,dimension,inverse);
	    return result;
	  
	    
	    
	}
	
}