package tn.esb.bis.ecommercebackend.Domains;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Address {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Exclude
    private Long id;
    @NonNull
    private int number;
    @NonNull
    private String street;
    @NonNull
    private String province;
    private int postalCode;
    @OneToOne(mappedBy="customerAddress",cascade= CascadeType.ALL)
    private Customer customer;
}
