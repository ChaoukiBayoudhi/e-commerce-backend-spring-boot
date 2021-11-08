package tn.esb.bis.ecommercebackend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esb.bis.ecommercebackend.Domains.Product;
@Repository
public interface productRepository extends JpaRepository<Product,Long> {
}
