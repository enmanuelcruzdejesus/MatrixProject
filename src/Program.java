import base.Matrix;
import paralelo.ParallelMatrix;
import sequencial.SequentialMatrix;

public class Program {

	static final int ROWS = 2000;
	static final int COLUMNS = 2000;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		  double A[][] = { { 1, -1,- 1 }, 
                  { -1, 2,3}, 
                  { 1, 1, 4 } }; 

        int B[][] = { { 5, 4, -3 }, 
                  { 0, -6, 10 }, 
                  { -2, 8, 11 }};
//        
//    	SequentialMatrix x = new SequentialMatrix(ROWS,COLUMNS);
//    	final long startTime = System.currentTimeMillis();
//    	x.inverse();
//     	final long endTime = System.currentTimeMillis();
//     	long timeElapsed = (endTime-startTime);
//   	
//     	Matrix.createDataset(timeElapsed,ROWS,COLUMNS);
//     	
     	

    
    
   Matrix a = new SequentialMatrix(ROWS,COLUMNS);
   	Matrix b  = new SequentialMatrix(ROWS,COLUMNS);

//
//	System.out.println(a.toString());
//	System.out.println(b.toString());
//	
	final long startTime = System.currentTimeMillis();
		double[][] c;
		c = a.multiply(b);
      final long endTime = System.currentTimeMillis();
//	
	long timeElapsed = (endTime-startTime);
//		
		
//	
//		//generating dataset
		Matrix.createDataset(timeElapsed,ROWS,COLUMNS);
		Matrix result = new SequentialMatrix(ROWS,COLUMNS,c);
//		
		//showing result matrix
		System.out.println(result.toString());

	

	System.out.println("Time taken = "+timeElapsed+" in milliseconds");
		
	
	}
}
