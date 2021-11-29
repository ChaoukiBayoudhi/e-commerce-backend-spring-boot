package tn.esb.bis.ecommercebackend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esb.bis.ecommercebackend.Domains.Product;
import tn.esb.bis.ecommercebackend.Services.ProductService;

import javax.validation.Valid;

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
    //Pour appeler cette méthode
    //url="http://localhost:8080/products/get-product/5
    //==>dand ce cas la valeur de l'id est passée dans le path, d'où l'utilisation
    //de @PathVariable
    //on peut aussi utiliser @PathParam
    // comme dans le cas ci-dessous
    //url="http://localhost:8080/products/get-product?id=5

    public ResponseEntity<?> productById(@PathVariable Long id)
    {
        return productServ.getProductById(id);
    }
    //Pour appeler cette méthode
    //url="http://localhost:8080/products/add-product/
    //La requête du client contient un header(une entête) et un body(corps de la requête
    //Le header contient des informations génerales : comme l'ackitement, le numéro,...
    //Le body contient les données à transmettre
    //@RequestBody -->permet d'informer le serveur qu'il trouvera le produit dans le body de la requête
    //@Valid permet de verifier la validité des données transmises
    //est-ce que p fait l'objet d'un produit ou non.
    //et est-ce que toutes les contraintes sont verifiées ou non.
    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@Valid @RequestBody Product p)
    {
        return productServ.addProduct(p);
    }
    @DeleteMapping("/remove-product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id)
    {
        return productServ.getProductById(id);
    }
    @PutMapping("/update-product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestBody Product p)
    {
        return productServ.updateProduct(id,p);
    }
}
