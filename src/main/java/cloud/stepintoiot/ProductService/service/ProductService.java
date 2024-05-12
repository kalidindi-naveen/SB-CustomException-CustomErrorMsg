package cloud.stepintoiot.ProductService.service;

import cloud.stepintoiot.ProductService.model.ProductRequest;
import cloud.stepintoiot.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductByID(long productId);
}
