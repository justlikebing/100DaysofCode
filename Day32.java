public class Day32 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originalColor = image[sr][sc];
        if (originalColor == newColor) {
            return image;
        }
        fill(image, sr, sc, originalColor, newColor);
        return image;
    }
    private static void fill(int[][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != originalColor) {

            return;
        }
        image[row][col] = newColor;


        fill(image, row - 1, col, originalColor, newColor); // Up
        fill(image, row + 1, col, originalColor, newColor); // Down
        fill(image, row, col - 1, originalColor, newColor); // Left
        fill(image, row, col + 1, originalColor, newColor); // Right
    }

    public static void main(String[] args) {
        int[][] image1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr1 = 1, sc1 = 1, color1 = 2;
        int[][] result1 = floodFill(image1, sr1, sc1, color1);
        printImage(result1);

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        int sr2 = 0, sc2 = 0, color2 = 0;
        int[][] result2 = floodFill(image2, sr2, sc2, color2);
        printImage(result2);
    }

    private static void printImage(int[][] image) {
        for (int[] row : image) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
