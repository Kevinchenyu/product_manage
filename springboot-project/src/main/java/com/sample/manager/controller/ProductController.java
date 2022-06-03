package com.sample.manager.controller;

import com.sample.manager.model.Product;
import com.sample.manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class ProductController {

    private ProductService productService ;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //全部產品
    @GetMapping("/")
    public String list(Model model){
        List<Product> productList = productService.getAllProduct();
        model.addAttribute("productList" , productList);
        return "productList";
    }

    //查詢指定產品
    @GetMapping("/product/{id}")
    public String product(@PathVariable long id , Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product" , product);

        return "product";
    }

    //新增一個產品
    @GetMapping("/addProductPage")
    public String postProduct(Model model){
        Product product =new Product();
        model.addAttribute("product" , product);
        return "input";
    }

    //儲存至資料庫
    @PostMapping("/addProduct")
    public String post(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    //刪除一個產品
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id){
        productService.deleteById(id);
        return "redirect:/";
    }

    //更新
    @GetMapping("/updateProduct/{id}")
    public String updateProduct(@PathVariable(name = "id") long id , Model model){
        Product product = productService.getProduct(id);
        model.addAttribute("product" , product);
        return "input";
    }
}
