public class Main {

    public static void main(String[] args) {
        Shop shop = Shop.getInstance();
        try {
            shop.create('A', 3, 1.25, 3);
            shop.create('B', 0, 4.25, 0);
            shop.create('C', 6, 1., 5);
            shop.create('D', 0, 0.75, 0);
            double totalCost = new BasketPrice().calculateTotalCost("ABCDABA");
           System.out.println(totalCost);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
