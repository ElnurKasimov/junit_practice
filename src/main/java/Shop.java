import lombok.*;

import java.util.*;

@Data
public class Shop {
    private static Shop instance;
    List<Product> products = new ArrayList<>();

    private Shop() {}

    public static synchronized Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    public void create(char name, int promotionalItemQuantity, double price, double promotionalPrice) throws IllegalArgumentException {
        if (!(name == 'A' || name == 'B' || name == 'C' || name == 'D'))
            throw new IllegalArgumentException("Name should be letter A, B, C, D only");
        if (promotionalItemQuantity < 0)
            throw new IllegalArgumentException("PromotionalItemQuality should be zero or integer positive number only");
        if (price <= 0)
            throw new IllegalArgumentException("Price should be positive number only");
        if (promotionalPrice < 0) throw new IllegalArgumentException("PromotionalPrice should be positive number only");
        if (promotionalPrice != 0) {
            if (promotionalItemQuantity == 0)
                throw new IllegalArgumentException("PromotionalPrice should be zero if  PromotionalItemQuality is equal zero");
        }
        if (Math.abs(price - promotionalPrice) <= 0.01)
            throw new IllegalArgumentException("PromotionalPrice should different from Price more then 1 cent");

        for (Product product : this.getProducts()) {
            if (product.getName() == name)
                throw new IllegalArgumentException("Name should be unique. This name is exist already.");
        }
        this.getProducts().add(Product.builder().
                        name(name).
                        promotionalItemQuantity(promotionalItemQuantity).
                        price(price).
                        promotionalPrice(promotionalPrice).
                        build()
        );
    }
}
