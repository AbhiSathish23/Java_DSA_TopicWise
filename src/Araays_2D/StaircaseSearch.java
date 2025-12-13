package Araays_2D;

public class StaircaseSearch {
    public static void main(String[] args) {
        int[][] matrix = {{10,20,30,40},
                {15,25,35,45},
                {20,30,40,50},
                {22,33,43,53}};
        int key = 100;
        searchKey(key,matrix);
    }

    private static Boolean searchKey(int key, int[][] matrix) {
        int row = 0; int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0 ){
            if (matrix[row][col] == key){
                System.out.println("Key fond at row: "+ row + " column: "+col);
                return true;
            }else if (matrix[row][col] > key){
                col--;
            }else {
                row++;
            }
        }
        System.out.println("Key not found!!");
        return false;
    }
}
