import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private Character name;
    private int promotionalItemQuantity;
    private double price;
    private double promotionalPrice;
}
