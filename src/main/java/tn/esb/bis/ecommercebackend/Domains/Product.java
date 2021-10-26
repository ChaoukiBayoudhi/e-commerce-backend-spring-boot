package tn.esb.bis.ecommercebackend.Domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //La classe Product sera transformée en table par l'ORM
//ORM: Object Relationnal Mapper
public class Product {
    @Id //primary key
    //@GeneratedValue //une valeur de clé auto-incrimentée (par defaut identité)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String label;
    
}
