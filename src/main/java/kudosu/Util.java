package kudosu;

public class Util {

	private Util() {}
	
	public static void printBoard(int[][] bla) {
		for (int i = 0; i < bla.length; i++) {
			System.out.print("|");
			int[] row=bla[i];
			for (int j = 0; j < row.length; j++) {
				System.out.print(row[j] + " ");
				if(j%3==2)System.out.print("|");
			}
			
			 System.out.println("");
			 
		}
		
	}
	
	public static void silentSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
