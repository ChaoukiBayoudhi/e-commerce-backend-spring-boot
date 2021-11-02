package tn.esb.bis.ecommercebackend.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import tn.esb.bis.ecommercebackend.Enumerations.CustomerType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
