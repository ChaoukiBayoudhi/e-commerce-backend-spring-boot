package tn.esb.bis.ecommercebackend.Domains;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Entity //La classe Product sera transformée en table par l'ORM
//ORM: Object Relationnal Mapper
public class Product {
    @Id //primary key
    //@GeneratedValue //une valeur de clé auto-incrimentée (par defaut identité)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NonNull
    private String label;
    @NonNull
    private double price;
    private LocalDate endConsumeDate;
    private LocalDate fabricationDate;
    private String description;
    @Lob
    private byte[] photo;

    
}
