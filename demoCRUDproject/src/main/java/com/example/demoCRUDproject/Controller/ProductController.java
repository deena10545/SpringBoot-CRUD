package com.example.demoCRUDproject.Controller;

import com.example.demoCRUDproject.Service.ProductService;
import com.example.demoCRUDproject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }
    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> findAllProducts(){
        return service.getProducts();
    }
    @GetMapping("/product/{id}")
    public Product findByID(@PathVariable Integer id){
        return service.getProductById(id);
    }
    @GetMapping("/product/{name}")
    public Product findByName(@PathVariable String name){
        return service.getProductByName(name);
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        return service.deleteProduct(id);
    }
}
