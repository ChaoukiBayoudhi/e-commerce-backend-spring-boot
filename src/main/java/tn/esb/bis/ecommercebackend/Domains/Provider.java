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
public class Provider {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //et aussi equivalente à simplement
    @GeneratedValue
    private Long id;
    @NonNull
    @Column(name="provider_name",length=50, unique = true )//sert à personaliser les attributs
    //lors de leur création dans la BD par l'ORM
    @EqualsAndHashCode.Include
    private String name;
    @NonNull
    private String email;
    private String telephone;
    private String siteUrl;
}
