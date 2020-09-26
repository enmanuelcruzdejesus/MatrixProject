/**
 * 
 */
package base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Random;


/**
 * @author Manuel
 *
 */
public abstract class Matrix 
{
	protected double [][] matrixData;
	protected int columnDimension;
	protected int rowDimension;
	protected Random rObject;
	protected static final int RANDOM_SCALE = 100;
	
	/**
	 * Default constructor
	 */
	public Matrix()
	{
	}
	
	/**
	 * Constructor #1 - El contenido de la matriz se genera aleatoriamente
	 * @param rDimension
	 * @param cDimension
	 */
	public Matrix(int rDimension, int cDimension)
	{
		rObject = new Random(System.currentTimeMillis());
		this.rowDimension = rDimension;
		this.columnDimension = cDimension;
		
		matrixData = new double[this.rowDimension][this.columnDimension];
				
		for(int i = 0; i < rowDimension; i++)
		{
			for(int j = 0; j < columnDimension; j++)
			{
				matrixData[i][j] = RANDOM_SCALE*rObject.nextInt();
			
			}//end-for(1)
		
		}//end-for(2)
	}
	
	/**
	 * Constructor #2 - Se asume que el contenido de la matriz se pasa como parametro
	 * @param rDimension
	 * @param cDimension
	 * @param mData
	 */
	public Matrix(int rDimension, int cDimension, double[][] mData)
	{
		this.rowDimension = rDimension;
		this.columnDimension = cDimension;
		this.matrixData = mData;
	}
	
	/**
	 * Se accede a una entrada en particular de la matriz
	 * 
	 * @param rowPosition
	 * @param columnPosition
	 * @return
	 */
	public double getEntry(int rowPosition, int columnPosition)
	{
		return this.matrixData[rowPosition][columnPosition];
	}
	
	/**
	 * Se obtiene una copia del vector fila cuyo indice se pasa como parametro
	 * @param i
	 * @return
	 */
	public double[] getRowVector(int i)
	{
		return this.matrixData[i].clone();
	}
	
	public double[] getColumnVector(int i)
	{
		double[] columnVector = new double[this.columnDimension];
		
		for(int k = 0; k < this.rowDimension; k++)
			columnVector[k] = matrixData[k][i];
		
		return columnVector.clone();
	}
	
	/**
	 * Devuelve el numero de filas 
	 * @return
	 */
	public int getRowDimension()
	{
		return this.rowDimension;
	}
	
	/**
	 * Devuelve el numero de columnas
	 * @return
	 */
	public int getColumnDimension()
	{
		return this.columnDimension;
	}
	
	public String toString()
	{		
		StringBuffer returnValue = new StringBuffer();
		
		for(int i = 0; i < this.rowDimension; i++)
		{
			returnValue.append(Arrays.toString(this.matrixData[i]) + "\n");
		}
		
		return returnValue.toString();
	}
	
	/**
	 * genera txt con tiempo de ejecucion en relacion a la dimension de la matrix  */
	public static void createDataset(long time, int rows, int columns) 
	{
		   File file =  new File("dataset.txt");
		    FileWriter fw  = null;
	        BufferedWriter bw = null;
	        Boolean exist = true;
			
	        try
	        {
	        	
	        	if(!file.exists()) {
	        		file.createNewFile();
	        		exist = false;
	        		
	        	}
	        		
	        		
	        	fw = new FileWriter(file,true);
	        	bw = new BufferedWriter(fw);
	        	if(exist)
	        	  bw.newLine();
	        	bw.write(time+","+rows+"x"+columns);
	        //	bw.write("matrix["+Integer.toString(m.getRowDimension())+"]"+"["+Integer.toString(m.columnDimension)+"]="+Long.toString(time));
	        	System.out.println("Time taken "+time);
	        	bw.close();
	           
	    				
	    		
	        } 
	        
	        catch (Exception e) {
	        	e.printStackTrace();
	        } 
	        
	        finally {
	        	
	        	
	        	try {
	        		
	        		
	        		if(bw!=null)
	        		 bw.close();
	        			

	        	} 
	        	catch (Exception e2) {
	        		e2.printStackTrace();
	        	}
	        }
	}
	
	/**
	 * Declaracion abstracta del metodo cuya implementacion sera 
	 * el algoritmo de multiplicacion de matrices
	 * 
	 * @param secondMatrix
	 * @return
	 * @throws InterruptedException 
	 */
	public abstract double [][] multiply(Matrix secondMatrix) throws InterruptedException;
	
	

}
