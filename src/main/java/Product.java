public class Product {
    String name;
    int promotionalItemQuality;
    double price;
    double promotionalPrice;

    public static class Builder {
        private static Product newProduct;

        public Builder () {
            newProduct = new Product();
        }

        public Product.Builder withName(String name) {
            newProduct.name = name;
            return this;
        }

        public Product.Builder promotionalItemQuality(int quality) {
            newProduct.promotionalItemQuality = quality;
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
