package cloud.stepintoiot.ProductService.controller;

import cloud.stepintoiot.ProductService.entity.Product;
import cloud.stepintoiot.ProductService.model.ProductRequest;
import cloud.stepintoiot.ProductService.model.ProductResponse;
import cloud.stepintoiot.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        long productId=productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductByID(@PathVariable("id") long productId ){
        ProductResponse productResponse = productService.getProductByID(productId);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
}
