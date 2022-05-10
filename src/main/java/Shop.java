import lombok.Data;

import java.util.*;

@Data
public class Shop {
    private List<Product> products = new ArrayList<>();


    public void create(char a, int i, double v, double vPromotional) throws IllegalArgumentException {
        if (!(a == 'A' || a == 'B' || a == 'C' || a == 'D'))
            throw new IllegalArgumentException("Name should be letter A, B, C, D only");
        if (i < 0)
            throw new IllegalArgumentException("PromotionalItemQuality should be zero or integer positive number only");
        if (v <= 0)
            throw new IllegalArgumentException("Price should be positive number only");
        if (vPromotional < 0)  throw new IllegalArgumentException("PromotionalPrice should be positive number only");
        if (vPromotional != 0) {
            if (i == 0) throw new IllegalArgumentException("PromotionalPrice should be zero if  PromotionalItemQuality is equal zero");
        }

        if (Math.abs(v-vPromotional) <= 0.01)
            throw new IllegalArgumentException("PromotionalPrice should different from Price more then 1 cent");

        for (Product product : this.getProducts()) {
            if (product.getName() == a)
                throw new IllegalArgumentException("Name should be unique. This name is exist already.");
        }
        this.getProducts().add(
                new Product.Builder().withName(a).withPromotionalItemQuality(i).withPrice(v).withPromotionalPrice(vPromotional).build()
        );
    }

    public Product findProductByName (char name) throws  IllegalArgumentException, RuntimeException {
        if (!(name == 'A' || name == 'B' || name == 'C' || name == 'D'))
            throw new IllegalArgumentException("Name should be letter A, B, C, D only");
        boolean isExist = false;
        ListIterator<Product> it = this.getProducts().listIterator();
        int index=0;
        while(it.hasNext()) {
            if (it.next().getName() == name) {
                index = it.previousIndex();
                isExist = true;
            }
        }
        if (isExist) {
            return this.getProducts().get(index);
        }
        else throw new RuntimeException("Attemption find absent Product");
    }

    public double getProductCost(char name, int quantity) throws  IllegalArgumentException {
        double result = 0;
        if (!(name == 'A' || name == 'B' || name == 'C' || name == 'D'))
            throw new IllegalArgumentException("Name should be letter A, B, C, D only");
        if (quantity < 0)
            throw new IllegalArgumentException("Quantity should be positive");
        Product current = this.findProductByName(name);
        if ( quantity > current.getPromotionalItemQuantity()) {
            result = current.getPrice()*(quantity-current.getPromotionalItemQuantity())
                        +  current.getPromotionalPrice();
        } else  result = current.getPromotionalPrice()*quantity;
        return result;
    }
    public char[] getProductsNames(String str) {
        char[] rightLetter = {'A', 'B', 'C', 'D'};
        try {
            for (char c : str.toCharArray()) {
                if (!(c == 'A' || c == 'B' || c == 'C' || c == 'D'))
                    throw new IllegalArgumentException("input should be letter A, B, C, D only");
            }
            if (str.toCharArray().length == 0)  throw new IllegalArgumentException("input should be letter A, B, C, D only");
        }
        catch (Exception ex) {
            throw new IllegalArgumentException ("input should be letter A, B, C, D only");
        }
        return str.toCharArray();
    }

    public Map<Character, Integer> getProductsQuantity(char[] actual) {
        Map<Character, Integer> quantityMap = new HashMap<>();
        Character[] productName = {'A', 'B', 'C', 'D'};
        Integer[] productQuantity = {0, 0, 0, 0};
        for (int i = 0; i < actual.length; i++) {
            switch (actual[i]) {
                case 'A': {
                    productQuantity[0]++;
                    break;
                }
                case 'B': {
                    productQuantity[1]++;
                    break;
                }
                case 'C': {
                    productQuantity[2]++;
                    break;
                }
                case 'D': {
                    productQuantity[3]++;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
             quantityMap.put(productName[i], productQuantity[i]);
        }
        return quantityMap;
    }

    double calculateTotalCost( String str) throws IllegalArgumentException {
        double result = 0;
        char[] names = getProductsNames(str);
        Map<Character, Integer> products = getProductsQuantity(names);
        for (Product product : this.getProducts()) {
            char name = product.getName();
            result += getProductCost(name, products.get(name));
        }
        return result;
    }



    public static void main(String[] args) {
        Shop shop = new Shop();
        try {
            shop.create('A', 3, 1.25, 3);
            shop.create('B', 0, 4.25, 0);
            shop.create('C', 6, 1., 5);
            shop.create('D', 0, 0.75, 0);
            double totalCost = shop.calculateTotalCost("ABCDABA");
            System.out.println(totalCost);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
