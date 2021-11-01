package tn.esb.bis.ecommercebackend.Domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;


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
    private String label;
    @NonNull
    private double price;
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDate endConsumeDate;
    @NonNull
    @EqualsAndHashCode.Include
    private LocalDate fabricationDate;
    private String description;
    @Lob
    private byte[] photo;

}
