package com.example.demoCRUDproject.Service;

import com.example.demoCRUDproject.Repository.ProductRepository;
import com.example.demoCRUDproject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public Product saveProduct(Product product)  //post
    {
        return repo.save(product);
    }
    public List<Product> saveProducts(List<Product> products){
        return repo.saveAll(products);
    }
    public List<Product> getProducts()
    {
        return repo.findAll();
    }
    public Product getProductById(Integer id)
    {
        return repo.findById(id).orElse(null);
    }
    public Product getProductByName(String name){
        return repo.findByName(name);
    }
    public String deleteProduct(Integer id)
    {
        repo.deleteById(id);
        return "Product is deleted "+ id;
    }
    public Product updateProduct(Product product)
    {
        Product existingProduct=repo.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repo.save(existingProduct);
    }
}
