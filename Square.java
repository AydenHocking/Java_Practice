import java.util.Scanner;

public class Square {

    private int[][] square;

    //--------------------------------------
    //create new square of given size
    //--------------------------------------
    public Square(int size) {
        square = new int[size][size];

    }
    
    //--------------------------------------
    //create new square using given 2D array
    //--------------------------------------
    public Square(int[][] matrix) {
        square = matrix;

    }

    //--------------------------------------
    //return the square 2D array
    //--------------------------------------
    public int[][] getSquare() {
        return square;
    }

    //--------------------------------------
    //return the sum of the values in the given row
    //--------------------------------------
    public int sumRow(int row) {
        int totalSR = 0;
        for (int col = 0; col < square.length; col++){
            totalSR = totalSR + square[row][col];
        }       
        return totalSR;
    }

    //--------------------------------------
    //return the sum of the values in the given column
    //--------------------------------------
    public int sumColumn(int col) {
        int totalSC = 0;
        for (int row = 0; row < square.length; row++){
            totalSC = totalSC + square[row][col];
        }
        return totalSC;
    }

    //--------------------------------------
    //return the sum of the values in the main diagonal
    //--------------------------------------
    public int sumMainDiag() {
        int totalSMD = 0;
        for (int col = 0; col < square.length; col++){
            for (int row = 0; row < square.length; row++){
                if ((row)==(col)){
                    totalSMD = totalSMD + square[row][col];
                }

            }
        }

        return totalSMD;
    }

    //--------------------------------------
    //return the sum of the values in the other ("reverse") diagonal
    //--------------------------------------
    public int sumOtherDiag() {
        int totalSOD = 0;
        for (int row = 0; row < square.length; row++){
            for (int col = (square.length-1); col >= 0; col--){
                if ((row)==(col)){
                    totalSOD = totalSOD + square[row][square.length -(col+1)];
                }

            }
        }

        return totalSOD;
        

    }
    //--------------------------------------
    //return true if the square is magic (all rows, cols, and diags have
    //same sum), false otherwise
    //--------------------------------------
    public boolean isMagic() {
        int totalSMD = 0;
        int totalSOD = 0;
        for (int i = 0; i < square.length; i++)
        {
            totalSMD += square[i][i];
            totalSOD += square[i][square.length-(i+1)];
        }
        if(totalSMD != totalSOD)
            return false;

        for (int i = 0; i < square.length; i++) 
        {
            if(this.sumColumn(i) != totalSMD || this.sumRow(i) != totalSMD) 
                return false;
            
            // int totalR = 0, totalC = 0;
            // for (int j = 0; j < square.length; j++){
            //     totalR += square[i][j];
            //     totalC += square[j][i];
            // }
            // if (totalR == totalC && totalC == totalSMD)
            //     return true;
            // if (totalR != totalC || totalC != totalSMD)
            //     return false;
        }
        return true;
    }

    //--------------------------------------
    //read info into the square from the standard input.
    //--------------------------------------
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.println("Enter an integer number");
                square[row][col] = scan.nextInt();
            }
        }
    }

    //--------------------------------------
    //print the contents of the square, neatly formatted
    //--------------------------------------
    public void printSquare() {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.print(square[row][col] + "  ");
            }
            System.out.println("");
        }

    }
}