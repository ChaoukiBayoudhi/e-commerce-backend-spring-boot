package tn.esb.bis.ecommercebackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tn.esb.bis.ecommercebackend.Services.ProductService;

@RestController
@RequestMapping("/products")
//url="http://localhost:8080/products
public class productController {
    @Autowired
    private ProductService productServ;
    @GetMapping("/all")
    //url pour recuperer tous les produits dans un front-end(Angular, reactjs,...)
    // ="http://localhost:8080/products/all
    //ou bien
   // @RequestMapping(value="/all",method= RequestMethod.GET)
    public ResponseEntity<?> allProducts()
    {
        return productServ.getAllProducts();
    }
}
