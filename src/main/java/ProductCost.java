import java.util.ListIterator;

public class ProductCost {

    public double getProductCost(char name, int quantity) throws IllegalArgumentException {
        if (!(name == 'A' || name == 'B' || name == 'C' || name == 'D'))
            throw new IllegalArgumentException("Name should be letter A, B, C, D only");
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity should be positive");
        Product current = findProductByName(name);
        if (current.getPromotionalItemQuantity() == 0 ) return current.getPrice() * quantity;
        if (quantity%current.getPromotionalItemQuantity() == 0 ) {
            return current.getPromotionalPrice()*(quantity/current.getPromotionalItemQuantity());
        } else return  current.getPrice() * quantity;
    }

    public Product findProductByName(char name) throws IllegalArgumentException, RuntimeException {
        if (!(name == 'A' || name == 'B' || name == 'C' || name == 'D'))
            throw new IllegalArgumentException("Name should be letter A, B, C, D only");
        boolean isExist = false;
        ListIterator<Product> iterator = Shop.getInstance().getProducts().listIterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (iterator.next().getName() == name) {
                index = iterator.previousIndex();
                isExist = true;
            }
        }
        if (isExist) {
            return Shop.getInstance().getProducts().get(index);
        } else throw new RuntimeException("Attemption find absent Product");
    }

}
