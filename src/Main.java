import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
 
public class Main {
	
    public static void main(String[] args) {
    	
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        while (sc.hasNext()) {       	
            int N = sc.nextInt(); //number of books
            int[] P = new int[N];
            
            for (int i = 0; i < N; i++) {
            	 P[i] = sc.nextInt(); //price of each book
            }
            Arrays.sort(P);
            
            int M = sc.nextInt(); //amount of money Peter has
            int x = -1;
            int y = -1;
            
            for (int i = 0; i < N; i++) {
                int T = M - P[i];
                int Q = Arrays.binarySearch(P,i+1,N,T);
                
                if (Q >= 0 && (P[Q] - P[i] < y - x || (y == -1 && x == -1))) {
                    x = P[i];
                    y = P[Q];                    
                }
            }
            pw.println("Peter should buy books whose prices are " +x+ " and "+y+".\n");
            pw.flush();
        }
        pw.close();
    }
}