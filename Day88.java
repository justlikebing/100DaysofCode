public class Day88 {
    public static int getXOR(int a, int b) {
        return a ^ b;
    }
    public static int getBit(int c, int d) {
        int mask = 1 << c;
        return (d & mask) == 0 ? 0 : 1;
    }
    public static int setBit(int e, int f) {
        int mask = 1 << e;
        return f | mask;
    }

    public static void main(String[] args) {
        int a = 1, b = 2, c = 1, d = 3, e = 2, f = 3;
        
        System.out.print(getXOR(a, b) + " ");
        
        
        System.out.print(getBit(c, d) + " ");
        
        System.out.println(setBit(e, f));
    }
}

