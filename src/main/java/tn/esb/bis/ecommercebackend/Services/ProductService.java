package tn.esb.bis.ecommercebackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bis.ecommercebackend.Domains.Product;
import tn.esb.bis.ecommercebackend.Repositories.productRepository;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    //faire le necessaire pour instancier l'objet poductRepos dans le serveur
    //c'est l'injection
    private productRepository  productRepos;
    public ResponseEntity<?> getAllProducts()
    {
        List<Product> products=productRepos.findAll();
        if(products.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body("There is no products");
        return ResponseEntity.status(HttpStatus.OK)
                .body(products);
    }
}
