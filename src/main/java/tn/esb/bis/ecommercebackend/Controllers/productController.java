package tn.esb.bis.ecommercebackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("get-product/{id}")
    //{id} est une variable passée comme paramètre dans le path
    //@PathVariable -->cette annotation informe le serveur qu'il trouvera
    //la valeur de l'id dans le path
    public ResponseEntity<?> productById(@PathVariable Long id)
    {
        return productServ.getProductById(id);
    }
}
