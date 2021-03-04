
package theater;
import java.io.*;
import java.util.*;

public class theater {
		public static int[][] seats = new int[10][20];

	    public static void main(String args[]) {
	        try {
	        	//Scanner input = new Scanner(System.in);
	        	//String filename = input.nextLine();
		        File myObj = new File("filename.txt");
		        Scanner myReader = new Scanner(myObj);
		        while (myReader.hasNextLine()) {
		            String[] data = myReader.nextLine().split(" ");
		            String reservationNum = data[0];
		            int numReserved = Integer.parseInt(data[1]);
		            reserveSeats(reservationNum, numReserved);
		        }
		        print();
		        myReader.close();
		        //input.close();
	        } 
	        catch (FileNotFoundException e) {
	            System.out.println("File not found.");
	            e.printStackTrace();
	        } 
	        
	    }

	    public static void print(){
	        for(int i = 0; i < seats.length; i++){
	            for(int j = 0; j < seats[i].length; j++){
	                System.out.print(seats[i][j] + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void reserveSeats(String reservationNum, int numReserved){
	        boolean available = true;
	        for(int i = 0; i < 10; i++){
	            for(int j = 0; j <= 20; j++){
	                available = true;
	                if(j + numReserved <= 20) {
		                for(int k = 0; k < numReserved; k++){
		                    if((j+k < 20) && (seats[i][j+k] != 0)){
		                        available = false;
		                    }
		                }
		                if(available){
		                	System.out.print(reservationNum + " ");
		                	char c = (char)(i + 65);
		                    for(int k = 0; k < numReserved; k++){
		                        if(j+k < 20){
		                            seats[i][j+k] = 1;
		                            System.out.print(c);
		                            System.out.print((j+k) + ", ");
		                        }
		                    }
		                    System.out.println();
		                    j = j + numReserved;
		                    int buffer = 0;
		                    while((buffer < 3) && (j+buffer < 20)){
		                        seats[i][j+buffer] = 2;
		                        buffer++;
		                    }
		                    return;
		                }
	                }
	            }
	        }
	    }
}

