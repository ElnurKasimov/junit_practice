import lombok.Data;

@Data
public class Product {
    private Character name;
    private int promotionalItemQuantity;
    private double price;
    private double promotionalPrice;

    //if you already use lombok you can also use @Builder annotation
    public static class Builder {
        private static Product newProduct;

        public Builder () {
            newProduct = new Product();
        }

        public Product.Builder withName(Character name) {
            newProduct.name = name;
            return this;
        }

        public Product.Builder withPromotionalItemQuality(int quality) {
            newProduct.promotionalItemQuantity = quality;
            return this;
        }

        public Product.Builder withPrice(double price) {
            newProduct.price = price;
            return this;
        }

        public Product.Builder withPromotionalPrice(double promotionalPrice) {
            newProduct.promotionalPrice = promotionalPrice;
            return this;
        }

        public Product build() {
            return newProduct;
        }
    }
}
