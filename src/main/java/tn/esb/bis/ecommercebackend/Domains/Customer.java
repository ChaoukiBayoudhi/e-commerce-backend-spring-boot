package tn.esb.bis.ecommercebackend.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tn.esb.bis.ecommercebackend.Enumerations.CustomerType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name="client_tab")//introduit des modifications sur la table lors
//de sa creation par l'ORM
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    @EqualsAndHashCode.Include
    @NonNull
    private String firstName;
    @EqualsAndHashCode.Include
    @NonNull
    private String lastName;
    private CustomerType type;
    @ManyToMany
    //création de la table association
    @JoinTable(name="customerProducts",
    joinColumns=@JoinColumn(name="idCustomer",referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name="idProduct",referencedColumnName="id")
    )
    private List<Product> products=new ArrayList<>();//Les produits achetés par le customer
    @OneToOne
    @JoinColumn(name="idAddress",referencedColumnName="id")
    //ceci est equivalent en SQL :
    //constraint fk_1 foreignkey references Address(id)
    private  Address customerAddress;
}
