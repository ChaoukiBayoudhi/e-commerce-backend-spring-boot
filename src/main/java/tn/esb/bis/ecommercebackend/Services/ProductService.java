package tn.esb.bis.ecommercebackend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.esb.bis.ecommercebackend.Domains.Product;
import tn.esb.bis.ecommercebackend.Repositories.productRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    //faire le necessaire pour instancier l'objet poductRepos dans le serveur
    //c'est l'injection de dependences
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
    //La méthode suivante est equivalente en sql à
    //select * from Product where id=productId;
    public ResponseEntity<?> getProductById(Long productId)
    {
        Optional<Product> result=productRepos.findById(productId);
        if(result.isPresent())
            return ResponseEntity.status(HttpStatus.OK)
            .body(result.get());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Bad id value");
    }

    //en sql :
    //Product p;
    //insert into Product(label,price,....) values(p.label,p.price,...)
    public ResponseEntity<?> addProduct(Product p)
    {
        List<Product> lstproducts=productRepos.findAll();
        if(lstproducts.contains(p))
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                                 .body("This Product already exists");
        Product result=productRepos.save(p);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(result);
    }

    public ResponseEntity<?> deleteProduct(Long id)
    {
        Optional<Product> result=productRepos.findById(id);
        if(result.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Bad id value");

        productRepos.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body("Product successufly deleted");
    }

    public ResponseEntity<?> updateProduct(Long id,Product pNew)
    {
        //verifier que le produit dont l'id est passé en paramètre existe
        Optional<Product> result=productRepos.findById(id);
        if(result.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Bad id value");
        //recuperer la reference du produit
        Product pOld= result.get();
        //mettre à jour toutes les colonnes de produit
        pOld.setLabel(pNew.getLabel());
        pOld.setDescription(pNew.getDescription());
        pOld.setPrice(pNew.getPrice());
        pOld.setEndConsumeDate(pNew.getEndConsumeDate());
        pOld.setFabricationDate(pNew.getFabricationDate());
        pOld.setPhoto(pNew.getPhoto());
        //appeler la méthode save() pour mettre à jour le produit dans la base de données
        Product p1=productRepos.save(pOld);
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(p1);
    }
}
