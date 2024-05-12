package cloud.stepintoiot.ProductService.service;

import cloud.stepintoiot.ProductService.entity.Product;
import cloud.stepintoiot.ProductService.exception.ProductServiceCustomException;
import cloud.stepintoiot.ProductService.model.ProductRequest;
import cloud.stepintoiot.ProductService.model.ProductResponse;
import cloud.stepintoiot.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product...");
        Product product = Product.builder()
                .productName(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Added Product with ID..."+product.getProductID());
        return product.getProductID();
    }

    @Override
    public ProductResponse getProductByID(long productId) {
        Product product=productRepository.findById(productId)
                .orElseThrow(()-> new ProductServiceCustomException("Product with ID not found","PRODUCT_NOT_FOUND"));
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(product,productResponse);
        return productResponse;
    }
}
