class Day2{
    public static void main(String[] args){

    }
    class solution{
        public void rotate(int [][] matrix){
            for(int i = 0; i < matrix.length ; i++){
                for(int j = i; j < matrix[0].length ; j++){
                    int temp = 0;
                    temp = matrix[i][j];
                }

            }
            for(int i = 0; i < matrix.length ; i++){
                for(int j = 0; j < matrix.length/2 ; j++){
                    int temp = 0;
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[i][matrix.length - i - j];
                    matrix[i][matrix.length - 1 - j] = temp;
                }
            }
        
        }
    }
}