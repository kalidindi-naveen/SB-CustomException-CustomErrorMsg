package cloud.stepintoiot.ProductService.model;

import lombok.Data;

@Data
public class ProductResponse {
    private long productID;
    private String productName;
    private long price;
    private long quantity;
}
