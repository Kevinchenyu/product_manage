package com.sample.manager.service;

import com.sample.manager.model.ProductRepository;
import com.sample.manager.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //查詢所有產品列表
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    //以id搜尋產品
    public Product getProduct(long id){ return productRepository.findById(id); }

    //刪除指定id的產品
    public void deleteById(long id){
        productRepository.deleteById(id);
    }

    //儲存產品
    public Product save(Product product) { return productRepository.save(product);}
}
