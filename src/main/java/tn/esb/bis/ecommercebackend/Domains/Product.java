package tn.esb.bis.ecommercebackend.Domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Data
//@ToString //==>redifinition de la methode String toString() de la classe Object
//retourne les valeurs de tous les attributs
//@ToString(exclude = {"id","photo"})//retourne les valeurs de tous les champs sauf id et photo
@ToString(exclude = "photo")
//@EqualsAndHashCode //redefinit les deux méthodes boolean equals() et
//hashCode() déjà definis dans la classe Object
//cette option compare les objets en se basant sur tous les champs
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity //La classe Product sera transformée en table par l'ORM
//ORM: Object Relationnal Mapper
public class Product {
    @Id //primary key
    //@GeneratedValue //une valeur de clé auto-incrimentée (par defaut identité)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NonNull  //L'attribut "label" est obligatoire
    @EqualsAndHashCode.Include //Label va être prise en consideration pour comparer deux produits
    @Column(unique = true,length=100)
    private String label;
    @NonNull
    @Column(precision=3)
    //price est une colonne sans repetition et avec 3 chiffres après la virgule
    private double price;
    @NonNull
    @EqualsAndHashCode.Include
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endConsumeDate;
    @NonNull
    @EqualsAndHashCode.Include
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate fabricationDate;
    private String description;
    private int quantity;
    @Lob
    private byte[] photo;
    @ManyToMany(mappedBy="products")
    private List<Customer> customers=new ArrayList<>();//Le client qui ont acheté le produit
    @ManyToOne
    @JoinColumn(name="id_provider", referencedColumnName = "id")
    private Provider productProvider;

}
