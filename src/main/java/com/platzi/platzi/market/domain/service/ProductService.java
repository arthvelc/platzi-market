package com.platzi.platzi.market.domain.service;

import com.platzi.platzi.market.domain.Product;
import com.platzi.platzi.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int idProduct){
        return productRepository.getProduct(idProduct);
    }

    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public Boolean delete(int idProduct){
        if(getProduct(idProduct).isPresent()){
            productRepository.delete(idProduct);
            return true;
        }else{
            return false;
        }
    }
}
