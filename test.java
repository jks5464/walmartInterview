import java.io.*;
import java.util.*;

class test {
    public static int[][] seats = new int[10][20];

    public static void main(String args[]){
        try {
        File myObj = new File("filename.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String[] data = myReader.nextLine().split(" ");
            int numRes = data[1];
            System.out.println(data[1]);

            boolean available = true;
            for(int i = 0; i < seats.length; i++){
                for(int j = 0; j < seats[i].length; j++){
                    available = true;
                    for(int k = 0; k < numRes; k++){
                        if(seats[i][j] != 0){
                            available = false;
                        }
                    }
                    if(available){
                        for(int k = 0; k < numRes; k++){
                            seats[i][j] = 1;
                        }
                    }
                }
            }
        }
        print();
        myReader.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
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
}