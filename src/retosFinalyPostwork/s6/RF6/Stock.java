package retosFinalyPostwork.s6.RF6;

public class Stock {
    protected static int stock = 0;

    public static void restock(int nuevoStock) {
        stock += nuevoStock;
    }
    public static void menosStock() {
        stock --;
    }

    public static int getStock(){
        return stock;
    }

}
